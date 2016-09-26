package com.easemob.api.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.avro.reflect.AvroDefault;

/**
 * 音频片段消息
 *
 * Created by wangchunye on 9/26/16.
 */
public class MessageBodyAudio implements MessageBody {
    private String url;
    @AvroDefault("\"\"")
    private String secret;
    @AvroDefault("\"\"")
    private String filename;
    @AvroDefault("0")
    private int length;
}
