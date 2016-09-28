package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Data;

/**
 * 微信通道
 *
 * Created by wangchunye on 9/28/16.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder=ChannelWechat.ChannelWechatBuilder
        .class)
public class ChannelWechat implements Channel  {

    @JsonPOJOBuilder(withPrefix = "")
    public static final class ChannelWechatBuilder {
    }
}
