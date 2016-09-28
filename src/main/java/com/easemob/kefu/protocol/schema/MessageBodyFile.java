package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.apache.avro.reflect.AvroDefault;

import lombok.Builder;
import lombok.Data;

/**
 *
 * Created by wangchunye on 9/26/16.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder=MessageBodyFile.MessageBodyFileBuilder.class)
public class MessageBodyFile implements MessageBody {
    private final String url;
    @AvroDefault("\"\"")
    private final String secret;
    @AvroDefault("\"\"")
    private final String filename;
    @AvroDefault("0")
    private final int fileLength;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class MessageBodyFileBuilder{}
}
