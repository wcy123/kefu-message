package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.apache.avro.reflect.AvroDefault;

import lombok.Builder;
import lombok.Data;

/**
 * 视频片段消息
 *
 * Created by wangchunye on 9/26/16.
 */
@Data
@Builder
@JsonDeserialize(builder=MessageBodyVideo.MessageBodyVideoBuilder.class)
public class MessageBodyVideo implements MessageBody {
    private final String url;
    @AvroDefault("0")
    private final Integer fileLength;
    @AvroDefault("\"\"")
    private final String secret;
    @AvroDefault("\"\"")
    private final String filename;
    @AvroDefault("{\n" +
            "  \"width\": 0,\n" +
            "  \"height\": 0\n" +
            "}")
    private final ImageSize size;
    @AvroDefault("\"\"")
    private final String thumb;
    @AvroDefault("\"0\"")
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
    @AvroDefault("\"\"")
    private final String title;
    @AvroDefault("\"\"")
    private final String description;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class MessageBodyVideoBuilder{}
}
