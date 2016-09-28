package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.apache.avro.reflect.AvroDefault;

import lombok.Builder;
import lombok.Data;

/**
 * 地理位置信息消息
 *
 * Created by wangchunye on 9/26/16.
 */
@Data
@Builder
@JsonDeserialize(builder=MessageBodyLoc.MessageBodyLocBuilder.class)
public class MessageBodyLoc implements MessageBody{
    @AvroDefault("\"\"")
    private final String addr;
    @AvroDefault("\"\"")
    private final float lat;
    @AvroDefault("\"\"")
    private final float lng;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class MessageBodyLocBuilder{}
}
