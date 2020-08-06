package com.sweet.core.tio.server;

import org.rockyang.tio.common.starter.annotation.TioAioListener;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.websocket.common.WsSessionContext;

/**
 * 消息监听，需要继承 {@link org.tio.websocket.server.WsServerAioListener} 类
 * 通过加 {@link TioAioListener} 注解启用，否则不会启用
 *
 * @author yangjian
 */
@TioAioListener
public class WsServerAioListener extends org.tio.websocket.server.WsServerAioListener {

    /**
     * 建链后触发本方法，注：建链不一定成功
     * @param channelContext
     * @param isConnected 是否连接成功,true:表示连接成功，false:表示连接失败
     * @param isReconnect 是否是重连, true: 表示这是重新连接，false: 表示这是第一次连接
     * @throws Exception
     */
    @Override
    public void onAfterConnected(ChannelContext channelContext, boolean isConnected, boolean isReconnect) throws Exception {
        WsSessionContext wsSessionContext = new WsSessionContext();
        channelContext.set(wsSessionContext);
        System.out.println("建立链接 是否连接成功"+isConnected+" 是否是重连"+isReconnect );
    }

    /**
     * 解码成功后触发本方法
     * @param channelContext
     * @param packet
     * @param packetSize
     * @throws Exception
     */
    @Override
    public void onAfterDecoded(ChannelContext channelContext, Packet packet, int packetSize) throws Exception {

    }

    /**
     * 消息包发送之后触发本方法
     * @param channelContext
     * @param packet
     * @param isSentSuccess true:发送成功，false:发送失败
     * @throws Exception
     */
    @Override
    public void onAfterSent(ChannelContext channelContext, Packet packet, boolean isSentSuccess) throws Exception {
        System.out.println("消息监听4");
    }

    /**
     * 连接关闭前触发本方法
     * @param channelContext
     * @param throwable the throwable 有可能为空
     * @param remark the remark 有可能为空
     * @param isRemove
     * @throws Exception
     */
    @Override
    public void onBeforeClose(ChannelContext channelContext, Throwable throwable, String remark, boolean isRemove) throws Exception {
        System.out.println("连接关闭");
        System.out.println("-------------------");
    }

    /**
     * 处理一个消息包后
     * @param channelContext
     * @param packet
     * @param cost 本次处理消息耗时，单位：毫秒
     * @throws Exception
     */
    @Override
    public void onAfterHandled(ChannelContext channelContext, Packet packet, long cost) throws Exception {

    }

    /**
     * 接收到TCP层传过来的数据后
     * @param channelContext
     * @param receivedBytes 本次接收了多少字节
     * @throws Exception
     */
    @Override
    public void onAfterReceivedBytes(ChannelContext channelContext, int receivedBytes) throws Exception {
    }
}
