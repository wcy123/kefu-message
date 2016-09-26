package com.easemob.api.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.avro.reflect.AvroDefault;
import org.apache.avro.reflect.Nullable;

import lombok.Data;

/**
 * 图片消息
 *
 * Created by wangchunye on 9/26/16.
 */
@Data
public class MessageBodyImage implements MessageBody {
    private String url;
    @AvroDefault("\"\"")
    private String secret;
    @AvroDefault("\"\"")
    private String filename;
    @AvroDefault("0")
    @JsonProperty("file_length")
    private int fileLength;
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
}
