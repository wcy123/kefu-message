package com.easemob.api.schema;

import org.apache.avro.reflect.AvroDefault;

/**
 * 地理位置信息消息
 *
 * Created by wangchunye on 9/26/16.
 */
public class MessageBodyLoc implements MessageBody{
    @AvroDefault("\"\"")
    private String addr;
    @AvroDefault("\"\"")
    private float lat;
    @AvroDefault("\"\"")
    private float lng;
}
