package com.easemob.kefu.protocol.schema;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import org.junit.Test;

/**
 * 测试用例
 *
 * Created by wangchunye on 9/27/16.
 */
public class GatewayMessageTest {
    @Test
    public void testAudioMessage() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder().messageBody(
                        MessageBodyAudio.builder()
                                .url("http://unknown.host.com/unknown.png")
                                .secret("do not tell anyone")
                                .filename("sampleFileName")
                                .length(100)
                                .build()
                ).id("1").build();

        //language=JSON
        final String expectedJsonString = "{\"id\":\"1\",\"timestamp\":0,\"messageBody\":{\"type\":\"audio\",\"url\":\"http://unknown.host.com/unknown.png\",\"secret\":\"do not tell anyone\",\"filename\":\"sampleFileName\",\"length\":100}}";
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, expectedJsonString);
        Assert.assertTrue(gatewayMessageCloned.getMessageBody() instanceof MessageBodyAudio);
        Assert.assertEquals(gatewayMessage, gatewayMessageCloned);
    }

    @Test
    public void testCmdMessage() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder().messageBody(
                        MessageBodyCmd.builder()
                                .action("what?")
                                .build()
                ).id("1").build();

        //language=JSON
        final String expectedJsonString = "{\"id\":\"1\",\"timestamp\":0,\"messageBody\":{\"type\":\"cmd\",\"action\":\"what?\"}}";
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, expectedJsonString);
        Assert.assertTrue(gatewayMessageCloned.getMessageBody() instanceof MessageBodyCmd);
        Assert.assertEquals(gatewayMessage, gatewayMessageCloned);
    }

    @Test
    public void testFileMessage() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder().messageBody(
                        MessageBodyFile.builder()
                                .url("http://unknown.host.com/unknown.png")
                                .secret("do not tell anyone")
                                .filename("sampleFileName")
                                .fileLength(100)
                                .build()
                ).id("1").build();

        //language=JSON
        final String expectedJsonString = "{\"id\":\"1\",\"timestamp\":0,\"messageBody\":{\"type\":\"file\",\"url\":\"http://unknown.host.com/unknown.png\",\"secret\":\"do not tell anyone\",\"filename\":\"sampleFileName\",\"fileLength\":100}}";
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, expectedJsonString);
        Assert.assertTrue(gatewayMessageCloned.getMessageBody() instanceof MessageBodyFile);
        Assert.assertEquals(gatewayMessage, gatewayMessageCloned);
    }
    @Test
    public void testImageMessage() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder().messageBody(
                        MessageBodyImage.builder()
                                .fileLength(100)
                                .url("http://unknown.host.com/unknown.png")
                                .secret("do not tell anyone")
                                .filename("sampleFileName")
                                .fileLength(1000)
                                .size(new ImageSize(400, 600))
                                .thumb("thumb")
                                .thumbFileLength(100)
                                .thumbFilename("thumbFilename")
                                .thumbSize(new ImageSize(40, 60))
                                .thumbSecret("tell me")
                                .build()
                ).id("1").build();

        //language=JSON
        final String expectedJsonString = "{\"id\":\"1\",\"timestamp\":0,\"messageBody\":{\"type\":\"img\",\"url\":\"http://unknown.host.com/unknown.png\",\"secret\":\"do not tell anyone\",\"filename\":\"sampleFileName\",\"fileLength\":1000,\"size\":{\"width\":400,\"height\":600},\"thumb\":\"thumb\",\"thumbFileLength\":100,\"thumbFilename\":\"thumbFilename\",\"thumbSize\":{\"width\":40,\"height\":60},\"thumbSecret\":\"tell me\"}}";
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, expectedJsonString);
        Assert.assertTrue(gatewayMessageCloned.getMessageBody() instanceof MessageBodyImage);
        Assert.assertEquals(gatewayMessage, gatewayMessageCloned);
    }
    @Test
    public void testLocMessage() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder().messageBody(
                        MessageBodyLoc.builder()
                                .addr("nowhere")
                                .lat(1.0f)
                                .lng(2.0f)
                                .build())
                        .id("1").build();

        //language=JSON
        final String expectedJsonString = "{\"id\":\"1\",\"timestamp\":0,\"messageBody\":{\"type\":\"loc\",\"addr\":\"nowhere\",\"lat\":1.0,\"lng\":2.0}}";
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, expectedJsonString);
        Assert.assertTrue(gatewayMessageCloned.getMessageBody() instanceof MessageBodyLoc);
        Assert.assertEquals(gatewayMessage, gatewayMessageCloned);
    }
    @Test
    public void testTextMessage() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder().messageBody(
                        MessageBodyTxt.builder()
                                .msg("hello world")
                                .build())
                        .id("1").build();

        //language=JSON
        final String expectedJsonString = "{\"id\":\"1\",\"timestamp\":0,\"messageBody\":{\"type\":\"txt\"," +
                "\"msg\":\"hello world\"}}";
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, expectedJsonString);
        Assert.assertTrue(gatewayMessageCloned.getMessageBody() instanceof MessageBodyTxt);
        Assert.assertEquals(gatewayMessage, gatewayMessageCloned);
    }

    @Test
    public void testVideoMessage() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder().messageBody(
                        MessageBodyVideo.builder()
                                .url("http://unknown.host.com/unknown.png")
                                .fileLength(100)
                                .secret("do not tell anyone")
                                .filename("sampleFileName")
                                .fileLength(1000)
                                .size(new ImageSize(400, 600))
                                .thumb("thumb")
                                .thumbFileLength(100)
                                .thumbFilename("thumbFilename")
                                .thumbSize(new ImageSize(40, 60))
                                .thumbSecret("tell me")
                                .title("bad movie")
                                .description("you don't wanna know")
                                .build()
                ).id("1").build();

        //language=JSON
        String expectedJsonString = "{\"id\":\"1\",\"timestamp\":0,\"messageBody\":{\"type\":\"video\",\"url\":\"http://unknown.host.com/unknown.png\",\"fileLength\":1000,\"secret\":\"do not tell anyone\",\"filename\":\"sampleFileName\",\"size\":{\"width\":400,\"height\":600},\"thumb\":\"thumb\",\"thumbFileLength\":100,\"thumbFilename\":\"thumbFilename\",\"thumbSize\":{\"width\":40,\"height\":60},\"thumbSecret\":\"tell me\",\"title\":\"bad movie\",\"description\":\"you don't wanna know\"}}";
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, expectedJsonString);
        Assert.assertTrue(gatewayMessageCloned.getMessageBody() instanceof MessageBodyVideo);
    }

    @Test
    public void testEmptyMessage() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder().messageBody(
                        MessageBodyTxt.builder()
                                .build()
                ).build();

        //language=JSON
        String expectedJsonString = "{\"timestamp\":0,\"messageBody\":{\"type\":\"txt\"}}";
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, expectedJsonString);
        Assert.assertTrue(gatewayMessageCloned.getMessageBody() instanceof MessageBodyTxt);
    }
    @Test
    public void testMessageFromTo() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder()
                        .from("little Ming")
                        .to("little Li")
                        .id("1").build();
        //language=JSON
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, "{\"id\":\"1\",\"timestamp\":0,\"from\":\"little Ming\",\"to\":\"little Li\"}");
    }

    @Test
    public void testMessageChannnelIm() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder()
                        .channel(ChannelIm.builder()
                                .id(10)
                                .name("what?")
                                .orgName("easemob-demo")
                                .appName("chatdemoui")
                                .build())
                        .id("1").build();
        //language=JSON
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, "{\"id\":\"1\",\"timestamp\":0,\"channel\":{\"type\":\"easemob\",\"id\":10,\"name\":\"what?\",\"orgName\":\"easemob-demo\",\"appName\":\"chatdemoui\"}}");
        Assert.assertTrue(gatewayMessageCloned.getChannel() instanceof ChannelIm);
    }

    @Test
    public void testMessageChannnelRest() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder()
                        .channel(ChannelRest.builder()
                                .build())
                        .id("1").build();
        //language=JSON
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, "{\"id\":\"1\",\"timestamp\":0,\"channel\":{\"type\":\"rest\"}}");
        Assert.assertTrue(gatewayMessageCloned.getChannel() instanceof ChannelRest);
    }
    @Test
    public void testMessageChannnelCallCenter() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder()
                        .channel(ChannelCallCenter.builder()
                                .build())
                        .id("1").build();
        //language=JSON
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, "{\"id\":\"1\",\"timestamp\":0,\"channel\":{\"type\":\"callcenter\"}}");
        Assert.assertTrue(gatewayMessageCloned.getChannel() instanceof ChannelCallCenter);
    }
    @Test
    public void testMessageChannnelWeChat() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder()
                        .channel(ChannelWechat.builder()
                                .build())
                        .id("1").build();
        //language=JSON
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, "{\"id\":\"1\",\"timestamp\":0,\"channel\":{\"type\":\"wechat\"}}");
        Assert.assertTrue(gatewayMessageCloned.getChannel() instanceof ChannelWechat);
    }
    @Test
    public void testMessageChannnelWeChatOauth2() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder()
                        .channel(ChannelWechatOauth2.builder()
                                .build())
                        .id("1").build();
        //language=JSON
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, "{\"id\":\"1\",\"timestamp\":0,\"channel\":{\"type\":\"wechat_oauth2\"}}");
        Assert.assertTrue(gatewayMessageCloned.getChannel() instanceof ChannelWechatOauth2);
    }
    @Test
    public void testMessageChannnelWeibo() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder()
                        .channel(ChannelWeibo.builder()
                                .build())
                        .id("1").build();
        //language=JSON
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, "{\"id\":\"1\",\"timestamp\":0,\"channel\":{\"type\":\"weibo\"}}");
        Assert.assertTrue(gatewayMessageCloned.getChannel() instanceof ChannelWeibo);
    }
    @Test
    public void testMessageEmptyVistor() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder()
                        .visitor(Vistor.builder()
                                .build())
                        .id("1").build();
        //language=JSON
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, "{\"id\":\"1\",\"timestamp\":0,\"visitor\":{}}");
    }
    @Test
    public void testMessageVistor() throws Exception {
        final GatewayMessage gatewayMessage =
                GatewayMessage.builder()
                        .visitor(Vistor.builder()
                                .trueName("Tom Marvolo Riddle")
                                .userNickName("youKnowWho")
                                .qq("voldemort")
                                .phone("211314")
                                .email("goodbye@unknown.com")
                                .companyName("Hogwarts School of Witchcraft and Wizardry")
                                .build())
                        .id("1").build();
        //language=JSON
        final GatewayMessage gatewayMessageCloned = getGatewayMessage(gatewayMessage, "{\"id\":\"1\",\"timestamp\":0,\"visitor\":{\"trueName\":\"Tom Marvolo Riddle\",\"userNickName\":\"youKnowWho\",\"qq\":\"voldemort\",\"phone\":\"211314\",\"email\":\"goodbye@unknown.com\",\"companyName\":\"Hogwarts School of Witchcraft and Wizardry\"}}");
    }
    private static GatewayMessage getGatewayMessage(GatewayMessage gatewayMessage, String expectedJsonString) throws java.io.IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonDataString = mapper.writeValueAsString(gatewayMessage);
        Assert.assertEquals(expectedJsonString, jsonDataString);
        final GatewayMessage value = mapper.readValue(jsonDataString, GatewayMessage
                .class);
        Assert.assertEquals(gatewayMessage, value);
        return value;
    }
}