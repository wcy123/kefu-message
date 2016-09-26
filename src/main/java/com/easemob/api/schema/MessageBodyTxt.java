package com.easemob.api.schema;

import org.apache.avro.reflect.AvroDefault;

import lombok.Data;

/**
 * 文本消息
 *
 * Created by wangchunye on 9/26/16.
 */
@Data
public class MessageBodyTxt implements MessageBody{
    /** 消息内容 */
    @AvroDefault("\"\"")
    private String msg;
}
