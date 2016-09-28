package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.apache.avro.reflect.AvroDefault;

import lombok.Builder;
import lombok.Data;

/**
 * 文本消息
 *
 * Created by wangchunye on 9/26/16.
 */
@Data
@Builder
@JsonDeserialize(builder=MessageBodyTxt.MessageBodyTxtBuilder.class)
public class MessageBodyTxt implements MessageBody{
    /** 消息内容 */
    @AvroDefault("\"\"")
    private final String msg;


    @JsonPOJOBuilder(withPrefix = "")
    public static final class MessageBodyTxtBuilder{}
}
