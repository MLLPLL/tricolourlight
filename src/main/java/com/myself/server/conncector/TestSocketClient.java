package com.myself.server.conncector;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TestSocketClient {
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
    	System.out.println("Client Start --------------");
        Socket client=new Socket("127.0.0.1", 9000);
        PrintWriter pw=new PrintWriter(client.getOutputStream());  
        pw.write("ALERT1");
        pw.flush();
        
        new Thread(){
        	public void run(){
                while(true){
                	try{
                		//System.out.println("3333333333333");
	                	this.sleep(5000);                			
            	        String message = "ALERT2";
            	        pw.write(message);
            	        pw.flush();
                	}catch(Exception e){
                		
                	}
                }
        		
        		
//                try {
//					this.sleep(10000);
//        	        String message = "TEST,2----------"+TestServerHandler.channel.id();
//        	        ByteBuf resp = Unpooled.copiedBuffer(message.getBytes());
//        			TestServerHandler.channel.writeAndFlush(resp);
//					this.sleep(10000);
//        	        String message1 = "TEST,3----------"+TestServerHandler.channel.id();
//        	        ByteBuf resp1 = Unpooled.copiedBuffer(message1.getBytes());
//        			TestServerHandler.channel.writeAndFlush(resp);
//					this.sleep(10000);
//        	        String message2 = "TEST,4----------"+TestServerHandler.channel.id();
//        	        ByteBuf resp2 = Unpooled.copiedBuffer(message2.getBytes());
//        			TestServerHandler.channel.writeAndFlush(resp);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
        		
        		

//        		try {
//        			this.sleep(10000);
//        			if(null!=TestServerHandler.channel){
//                		String message = "TEST,1----------"+TestServerHandler.channel.id();
//                		ByteBuf resp = Unpooled.copiedBuffer(message.getBytes());
//                		ByteBuf resp1 = Unpooled.copiedBuffer(message.getBytes());
//                		ByteBuf resp2 = Unpooled.copiedBuffer(message.getBytes());
//                		ByteBuf resp3 = Unpooled.copiedBuffer(message.getBytes());
//                		ByteBuf resp4 = Unpooled.copiedBuffer(message.getBytes());
//                		ByteBuf resp5 = Unpooled.copiedBuffer(message.getBytes());
//                		ByteBuf resp6 = Unpooled.copiedBuffer(message.getBytes());
//                		ByteBuf resp7 = Unpooled.copiedBuffer(message.getBytes());
//                		ByteBuf resp8 = Unpooled.copiedBuffer(message.getBytes());
//                		ByteBuf resp9 = Unpooled.copiedBuffer(message.getBytes());
//                		
//					TestServerHandler.channel.writeAndFlush(resp);
//					this.sleep(10000);
//					TestServerHandler.channel.writeAndFlush(resp1);
//					this.sleep(10000);
//					TestServerHandler.channel.writeAndFlush(resp2);
//					this.sleep(10000);
//					TestServerHandler.channel.writeAndFlush(resp3);
//					this.sleep(10000);
//					TestServerHandler.channel.writeAndFlush(resp4);
//					this.sleep(10000);
//					TestServerHandler.channel.writeAndFlush(resp5);
//					this.sleep(10000);
//					TestServerHandler.channel.writeAndFlush(resp6);
//					this.sleep(10000);
//					TestServerHandler.channel.writeAndFlush(resp7);
//					this.sleep(60000);
//					TestServerHandler.channel.writeAndFlush(resp8);
//					this.sleep(3000);
//					TestServerHandler.channel.writeAndFlush(resp9);
//        			}
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
    			
        	}
        }.start();       
    }
}
