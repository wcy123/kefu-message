package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Data;

/**
 * 微博通道
 *
 * Created by wangchunye on 9/28/16.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder=ChannelWeibo.ChannelWeiboBuilder
        .class)
public class ChannelWeibo implements Channel {

    @JsonPOJOBuilder(withPrefix = "")
    public static final class ChannelWeiboBuilder {
    }
}
