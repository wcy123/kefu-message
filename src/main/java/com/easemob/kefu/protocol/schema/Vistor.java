package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Data;

/**
 * 访客信息
 *
 * Created by wangchunye on 9/28/16.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder=Vistor.VistorBuilder
        .class)
public class Vistor {
    /**
     * 真实姓名
     */
    private final String trueName;
    /**
     * 昵称
     */
    private final String userNickName;
    /**
     * qq 号
     */
    private final String qq;
    /**
     * 电话号码
     */
    private final String phone;
    /**
     * 电子邮件
     */
    private final String email;
    /**
     * 公司名称
     */
    private final String companyName;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class VistorBuilder {
    }
}
