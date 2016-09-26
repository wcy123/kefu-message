package com.easemob.api.schema;

import lombok.Data;

/**
 * webapp  <----> queue <-----> IMGateway
 *
 * 本文描述 webapp 和  IM Gateway 直接的通信消息格式定义
 */

@Data
public class GatewayMessage {
    /**
     * <ul>
     *     <li> 是否是 uuid ?</li>
     *     <li>是否可以包含字母数字?</li>
     *     <li>默认值是空字符串</li>
     * </ul>
     */
    private String id;

}
