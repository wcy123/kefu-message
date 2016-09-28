package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Data;

/**
 * Created by wangchunye on 9/28/16.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder=ChannelRest.ChannelRestBuilder
        .class)
public class ChannelRest implements Channel {
    // TODO: 这是什么通道?

    @JsonPOJOBuilder(withPrefix = "")
    public static final class ChannelRestBuilder{}
}
