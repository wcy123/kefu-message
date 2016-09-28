package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.apache.avro.reflect.AvroDefault;

import lombok.Builder;
import lombok.Data;

/**
 * 命令消息
 *
 * Created by wangchunye on 9/26/16.
 */
@Data
@Builder
@JsonDeserialize(builder=MessageBodyCmd.MessageBodyCmdBuilder.class)
public class MessageBodyCmd implements MessageBody{
    @AvroDefault("\"\"")
    private final String action;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class MessageBodyCmdBuilder{}
}
