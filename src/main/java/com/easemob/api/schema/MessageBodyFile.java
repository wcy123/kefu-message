package com.easemob.api.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.avro.reflect.AvroDefault;

/**
 *
 * Created by wangchunye on 9/26/16.
 */
public class MessageBodyFile implements MessageBody {
    private String url;
    @AvroDefault("\"\"")
    private String secret;
    @AvroDefault("\"\"")
    private String filename;
    @AvroDefault("0")
    @JsonProperty("file_length")
    private int fileLength;
}
