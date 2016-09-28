package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import org.apache.avro.reflect.Union;

/**
 * 消息体格式
 *
 * 目前支持
 *
 * <ul>
 *     <li>文本消息</li>
 *     <li>图片消息</li>
 *     <li>音频片段</li>
 *     <li>视频片段</li>
 *     <li>附件消息</li>
 *     <li>地理坐标</li>
 *     <li>命令消息</li>
 * </ul>
 *
 * Created by wangchunye on 9/26/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({@JsonSubTypes.Type(
        value = MessageBodyTxt.class,
        name = "txt"
), @JsonSubTypes.Type(
        value = MessageBodyImage.class,
        name = "img"
), @JsonSubTypes.Type(
        value = MessageBodyVideo.class,
        name = "video"
), @Type(
        value = MessageBodyAudio.class,
        name = "audio"
), @Type(
        value = MessageBodyFile.class,
        name = "file"
), @Type(
        value = MessageBodyLoc.class,
        name = "loc"
), @Type(
        value = MessageBodyCmd.class,
        name = "cmd"
)})
@Union({
        MessageBodyTxt.class,
        MessageBodyImage.class,
        MessageBodyVideo.class,
        MessageBodyAudio.class,
        MessageBodyFile.class,
        MessageBodyLoc.class,
        MessageBodyCmd.class
}
)
public interface MessageBody {
    /**
     * 这里不包含 type
     */
}
