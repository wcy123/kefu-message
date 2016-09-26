package com.easemob.maven.plugins.avro;

import org.apache.avro.Schema;
import org.apache.avro.compiler.specific.SpecificCompiler;
import org.apache.avro.generic.GenericData;
import org.apache.avro.reflect.ReflectData;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.SystemStreamLog;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import avro.shaded.com.google.common.collect.Lists;

/**
 * maven 扩展模块
 *
 * Created by wangchunye on 9/26/16.
 */
@Mojo(name = "schema")
public class Compiler extends AbstractMojo {
    private String[] testIncludes = new String[]{"**/*.avsc"};

    @Parameter(property = "schema.className",
            required = true,
            defaultValue = "com.easemob.api.schema.GatewayMessage")
    private String className;
    @Parameter(property = "schema.sourceDirectory", defaultValue = "${basedir}/src/main/avro")
    private File sourceDirectory;
    @Parameter(property = "schema.outputDirectory",
            defaultValue = "${project.builddirectory}/generated-sources/avro")
    private File outputDirectory;

    @Parameter(property = "schema.classPath",
            defaultValue = "${project.build.outputDirectory}")
    private List<File> classPath;

    public void execute() throws MojoExecutionException {
        final SystemStreamLog log = new SystemStreamLog();
        Class<?> clazz = null;
        try {
            List<URL> listUrl = Lists.newArrayList();
            classPath.stream()
                    .forEach(f -> {
                        try {
                            listUrl.add(f.toURI().toURL());
                        } catch (MalformedURLException e) {
                            log.warn("invalid classpath " + f, e);
                        }
                    });

            ClassLoader contextCL = Thread.currentThread().getContextClassLoader();
            final URL[] urls = new URL[listUrl.size()];
            listUrl.toArray(urls);
            ClassLoader urlCL = URLClassLoader.newInstance(urls, contextCL);
            Thread.currentThread().setContextClassLoader(urlCL);
            clazz = urlCL.loadClass(className);
        } catch (ClassNotFoundException e) {
            // AbstractAvroMojo signature does not throw MojoExecutionException
            throw new MojoExecutionException("cannot find class " + className, e);
        }

        final Schema schema = ReflectData.get().getSchema(clazz);

        Path path = Paths.get(sourceDirectory.toString(), clazz.getSimpleName() + ".avsc");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(schema.toString(true));
        } catch (IOException e) {
            throw new MojoExecutionException("IOException ", e);
        }


        String templateDirectory = "/org/apache/avro/compiler/specific/templates/java/classic/";
        ;
        String stringType = "CharSequence";
        boolean createSetters = true;
        SpecificCompiler compiler = new SpecificCompiler(schema);
        compiler.setTemplateDir(templateDirectory);
        compiler.setStringType(GenericData.StringType.valueOf(stringType));
        compiler.setFieldVisibility(getFieldVisibility());
        compiler.setCreateSetters(createSetters);
        compiler.setOutputCharacterEncoding("UTF-8");
        try {
            compiler.compileToDestination(sourceDirectory, outputDirectory);
        } catch (IOException e) {
            throw new MojoExecutionException("compilation error " + e);
        }
    }

    protected SpecificCompiler.FieldVisibility getFieldVisibility() {
        try {
            String fieldVisibility = "PUBLIC_DEPRECATED";
            String upper = fieldVisibility.trim().toUpperCase();
            return SpecificCompiler.FieldVisibility.valueOf(upper);
        } catch (IllegalArgumentException e) {
            return SpecificCompiler.FieldVisibility.PUBLIC_DEPRECATED;
        }
    }
}
