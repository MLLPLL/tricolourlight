package com.myself.server.conncector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Alex.Chen on 2016/12/17.
 */
@Component
public class StartNettyBean implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartNettyBean.class);

    @Value(value = "${netty.port}")
    private String port;

    @Autowired
    private NettyConnectorImpl nettyConnector;


    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("nettyListener Startup!");
        new Thread(){
            @Override
            public  void run(){
                try {
                    nettyConnector.bind(9000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        System.err.println("nettyListener end!");
    }
}