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
        
        new Thread(){
        	public void run(){
               while(true){
//                	try{
//                		//System.out.println("3333333333333");
//	                	this.sleep(5000);                			
//            	        String message = "ALERT,001,1";
//            	        pw.write(message);
//            	        pw.flush();
//                	}catch(Exception e){
//                		
//                	}
//                }
        		
        		
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
        		
        		

        		try {
        			this.sleep(10000);
        			String message = "ALERT,001,1";
        	        pw.write(message);
        	        pw.flush();
        			this.sleep(10000);
        			message = "ALERT,002,1";
        	        pw.write(message);
        	        pw.flush();
        			this.sleep(10000);
        			message = "ALERT,001,1";
        	        pw.write(message);
        	        pw.flush();
        			this.sleep(10000);
        			message = "ALERT,003,3";
        	        pw.write(message);
        	        pw.flush();
        			this.sleep(10000);
        			message = "ALERT,001,2";
        	        pw.write(message);
        	        pw.flush();
        			this.sleep(10000);
        			message = "ALERT,002,2";
        	        pw.write(message);
        	        pw.flush();
        			this.sleep(10000);
        			message = "ALERT,003,1";
        	        pw.write(message);
        	        pw.flush();
        			this.sleep(10000);
        			message = "ALERT,001,3";
        	        pw.write(message);
        	        pw.flush();
        			this.sleep(10000);
        			message = "ALERT,002,3";
        	        pw.write(message);
        	        pw.flush();        			
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               }
           }
        }.start();       
    }
}
