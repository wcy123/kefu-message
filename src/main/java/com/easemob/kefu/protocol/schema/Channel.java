package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import org.apache.avro.reflect.Union;

/**
 * 信道信息
 *
 * Created by wangchunye on 9/28/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({@JsonSubTypes.Type(
        value = ChannelIm.class,
        name = "easemob"
), @JsonSubTypes.Type(
        value = ChannelWeibo.class,
        name = "weibo"
), @JsonSubTypes.Type(
        value = ChannelWechat.class,
        name = "wechat"
), @JsonSubTypes.Type(
        value = ChannelCallCenter.class,
        name = "callcenter"
), @JsonSubTypes.Type(
        value = ChannelWechatOauth2.class,
        // TODO: 命名风格不统一
        name = "wechat_oauth2"
), @JsonSubTypes.Type(
        // TODO: 这是什么类型, 似乎没有用到过
        value = ChannelRest.class,
        name = "rest"
)})
@Union({
        ChannelIm.class,
        ChannelWeibo.class,
        ChannelWechat.class,
        ChannelCallCenter.class,
        ChannelWechatOauth2.class,
        ChannelRest.class
})
public interface Channel {
}
