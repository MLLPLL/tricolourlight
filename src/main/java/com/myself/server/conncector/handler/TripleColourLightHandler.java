package com.myself.server.conncector.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TripleColourLightHandler extends ChannelInboundHandlerAdapter{
    public static Channel channel = null ; 
	
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //与服务端建立连接后
    	channel = ctx.channel();
    	System.out.println("Cilent connected , Channel id is ---------"+channel.id());
    }
	
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("server channelRead..");
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        //service code here
        System.out.println("The server receive message:" + body);
        
        
//        String message = "TEST,1";
//        ByteBuf resp = Unpooled.copiedBuffer(message.getBytes());
//        ctx.write(resp); 
    }
    
    public void lightControlCall(int lightNumber){
        String message = "TEST,"+String.valueOf(lightNumber);
        ByteBuf resp = Unpooled.copiedBuffer(message.getBytes());
        channel.writeAndFlush(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channelReadComplete..");
        ctx.flush();//刷新后才将数据发出到SocketChannel
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.out.println("server exceptionCaught..");
        ctx.close();
    }
}
