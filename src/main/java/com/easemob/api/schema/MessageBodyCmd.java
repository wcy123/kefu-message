package com.easemob.api.schema;

import org.apache.avro.reflect.AvroDefault;

/**
 * 命令消息
 *
 * Created by wangchunye on 9/26/16.
 */
public class MessageBodyCmd implements MessageBody{
    @AvroDefault("\"\"")
    private String action;
}
