package com.easemob.api.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.avro.reflect.AvroDefault;

/**
 * 视频片段消息
 *
 * Created by wangchunye on 9/26/16.
 */
public class MessageBodyVideo implements MessageBody {
    private String url;
    @JsonProperty("file_length")
    @AvroDefault("0")
    private Integer fileLength;
    @AvroDefault("\"\"")
    private String secret;
    @AvroDefault("\"\"")
    private String filename;
    @AvroDefault("{\n" +
            "  \"width\": 0,\n" +
            "  \"height\": 0\n" +
            "}")
    private ImageSize size;
    @AvroDefault("\"\"")
    private String thumb = "";
    @AvroDefault("\"\"")
    private String thumbFileLength = "";
    @AvroDefault("\"\"")
    private String thumbFilename = "";
    @AvroDefault("{\n" +
            "  \"thumbWidth\": 0,\n" +
            "  \"thumbHeight\": 0\n" +
            "}")
    private ThumbSize thumbSize = new ThumbSize();
    @AvroDefault("\"\"")
    private String thumbSecret = "";
    @AvroDefault("\"\"")
    private String title;
    @AvroDefault("\"\"")
    private String description;
}
