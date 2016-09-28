package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Data;

/**
 * 图片长宽高, 单位像素
 *
 * Created by wangchunye on 9/26/16.
 */
@Data
@Builder
@JsonDeserialize(builder=ImageSize.ImageSizeBuilder.class)
public class ImageSize {
    /**
     * 图片宽度, 单位像素
     */
    private final int width;
    /**
     * 图片高度, 单位像素
     */
    private final int height;


    @JsonPOJOBuilder(withPrefix = "")
    public static final class ImageSizeBuilder{}
}
