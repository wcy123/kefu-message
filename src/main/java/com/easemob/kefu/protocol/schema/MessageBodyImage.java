package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.apache.avro.reflect.AvroDefault;

import lombok.Builder;
import lombok.Data;

/**
 * 图片消息
 *
 * Created by wangchunye on 9/26/16.
 */
@Data
@Builder
@JsonDeserialize(builder=MessageBodyImage.MessageBodyImageBuilder.class)
public class MessageBodyImage implements MessageBody {
    private final String url;
    @AvroDefault("\"\"")
    private final String secret;
    @AvroDefault("\"\"")
    private final String filename;
    @AvroDefault("0")
    private final int fileLength;
    @AvroDefault("{\n" +
            "  \"width\": 0,\n" +
            "  \"height\": 0\n" +
            "}")
    private final ImageSize size;
    @AvroDefault("\"\"")
    private final String thumb;
    @AvroDefault("\"\"")
    private final int thumbFileLength;
    @AvroDefault("\"\"")
    private final String thumbFilename;
    @AvroDefault("{\n" +
            "  \"width\": 0,\n" +
            "  \"height\": 0\n" +
            "}")
    private final ImageSize thumbSize;
    @AvroDefault("\"\"")
    private final String thumbSecret;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class MessageBodyImageBuilder{}
}
