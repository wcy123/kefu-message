package com.easemob.api.schema;


import org.apache.avro.reflect.AvroDefault;
import org.apache.avro.reflect.Nullable;

import java.sql.Timestamp;

import lombok.Data;

/**
 * webapp  <----> queue <-----> IMGateway
 *
 * 本文描述 webapp 和  IM Gateway 直接的通信消息格式定义
 */

@Data
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
    private String id;
    /**
     * 时间戳
     *
     * <ul>
     *     <li>服务器时间还是客户端时间</li>
     * </ul>
     */
    @AvroDefault("0")
    private long timestamp;
    private MessageBody messageBody;

}
