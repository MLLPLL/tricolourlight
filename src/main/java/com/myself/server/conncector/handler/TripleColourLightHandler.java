package com.myself.server.conncector.handler;

import com.myself.server.cache.LightCacheMapImpl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

@Component
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
        //System.out.println("The server receive message:" + body);

        String[] lightStatus = body.split(",");
        
       // System.out.println("LightNumber:" + lightStatus[1]);
        //System.out.println("LightStatus:" + lightStatus[2]);
        
        LightCacheMapImpl.setLightStatus(Integer.valueOf(lightStatus[1]).intValue(), Integer.valueOf(lightStatus[2]).intValue());
        
        System.out.println("Light:"+lightStatus[1]+" - status is "+LightCacheMapImpl.getLightStatusName(LightCacheMapImpl.getLightStatus(Integer.valueOf(lightStatus[1]).intValue())));
        
//        String message = "TEST,1";
//        ByteBuf resp = Unpooled.copiedBuffer(message.getBytes());
//        ctx.write(resp); 
    }
    
    public static void lightControlCall(int lightNumber){
        String message = "TEST,"+String.valueOf(lightNumber);
        ByteBuf resp = Unpooled.copiedBuffer(message.getBytes());
        System.out.println("lightControlCall Channel id is "+channel.id());
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
