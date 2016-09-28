package com.easemob.kefu.protocol.schema;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.apache.avro.reflect.AvroDefault;

import lombok.Builder;
import lombok.Data;

/**
 * webapp  <----> queue <-----> IMGateway
 *
 * 本文描述 webapp 和  IM Gateway 直接的通信消息格式定义
 */

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder=GatewayMessage.GatewayMessageBuilder.class)
public class GatewayMessage {
    /**
     * 唯一标识一个消息
     *
     * <ul>
     *     <li>和 IM message id 有什么不同</li>
     *     <li>是否是 uuid ?</li>
     *     <li>是否可以包含字母数字?</li>
     *     <li>默认值是空字符串</li>
     * </ul>
     */
    private final String id;
    /**
     * 时间戳, unix 时间, 基于 1970 年的那个  Epoch time , 单位毫秒
     *
     * https://en.wikipedia.org/wiki/Unix_time
     *
     * <ul>
     *     <li>服务器时间还是客户端时间</li>
     * </ul>
     *
     * 29227, 7026 年 12 月 4 号  15:30:08 星期天(也许不对) 64-bits 溢出.
     * 估计我们的服务用不到那一天
     *
     */
    @AvroDefault("0")
    private final long timestamp;
    /**
     * 消息体
     */
    private final MessageBody messageBody;


    /**
     * 信道信息
     */
    private final Channel channel;

    /**
     * 发送者
     *
     * 逻辑标识, 和具体具体业务渠道无关
     * TODO: 进一步明确这个字段的意义, 是否引入 User 类型?
     */
    private final String from;

    /**
     * 目的接收者
     *
     * 逻辑标识, 和具体具体业务渠道无关
     * TODO: 进一步明确这个字段的意义
     */
    private final String to;

    /**
     * 访客信息
     */
    private final Vistor visitor;

    /**
     * https://gist.github.com/pcarrier/14d3a8e249d804cfbdee
     *
     * JSON
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static final class GatewayMessageBuilder{}
}
