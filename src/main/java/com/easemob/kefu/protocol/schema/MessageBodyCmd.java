package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.apache.avro.reflect.AvroDefault;

import lombok.Builder;
import lombok.Data;

/**
 * 命令消息
 *
 * TODO 我们真的需要这个扩展消息吗?
 *
 * Created by wangchunye on 9/26/16.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder=MessageBodyCmd.MessageBodyCmdBuilder.class)
public class MessageBodyCmd implements MessageBody{
    @AvroDefault("\"\"")
    private final String action;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class MessageBodyCmdBuilder{}
}
