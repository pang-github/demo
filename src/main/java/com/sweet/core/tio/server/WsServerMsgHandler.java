package com.sweet.core.tio.server;

import org.rockyang.tio.common.starter.TioServerMsgHandlerNotFoundException;
import org.rockyang.tio.common.starter.annotation.TioMsgHandler;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.websocket.common.WsRequest;
import org.tio.websocket.common.WsResponse;
import org.tio.websocket.server.handler.IWsMsgHandler;

/**
 * 和 Tio WebSocket 用法一致，需要实现 {@link IWsMsgHandler} 接口，
 * 通过加 {@link TioMsgHandler} 注解启用
 * 注意: handler 是必须要启用的，否则启动会抛出 {@link TioServerMsgHandlerNotFoundException} 异常
 *
 * @author yangjian
 */
@TioMsgHandler
public class WsServerMsgHandler implements IWsMsgHandler {


    @Override
    public HttpResponse handshake(HttpRequest httpRequest, HttpResponse httpResponse, ChannelContext channelContext) throws Exception
    {
        System.out.println("握手");
        return httpResponse;
    }

    @Override
    public void onAfterHandshaked(HttpRequest httpRequest, HttpResponse httpResponse, ChannelContext channelContext) throws Exception
    {
        System.out.println("关闭3");
    }

    @Override
    public Object onBytes(WsRequest wsRequest, byte[] bytes, ChannelContext channelContext) throws Exception
    {
        System.out.println("关闭2");
        return null;
    }

    @Override
    public Object onClose(WsRequest wsRequest, byte[] bytes, ChannelContext channelContext) throws Exception
    {
        System.out.println("关闭1");
        return null;
    }

    @Override
    public Object onText(WsRequest wsRequest, String message, ChannelContext channelContext) throws Exception
    {

        System.out.println("收到来自客户端的消息：" + message);
        // 回复消息
        return null;
    }
}
