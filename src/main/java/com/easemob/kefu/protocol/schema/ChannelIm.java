package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Data;

/**
 * 环信 IM 通道
 *
 * Created by wangchunye on 9/28/16.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = ChannelIm.ChannelImBuilder.class)
public class ChannelIm implements Channel {
    /**
     * 信道标识
     */
    private final int id;
    /**
     * 信道名称
     */
    private final String name;

    /**
     * 环信集成 org 的名称, 用于拼接 JID
     */
    private final String orgName;

    /**
     * 环信集成 app 的名称, 用于拼接 JID
     */
    private final String appName;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class ChannelImBuilder {
    }
}

