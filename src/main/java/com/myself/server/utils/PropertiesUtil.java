package com.myself.server.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取Properties综合类,默认绑定到classpath下的config.properties文件。
 * 
 */
public class PropertiesUtil {
    /**
     * 配置文件对象
     */
    private static Properties props=null;
    
    /**
     * 默认构造函数，用于sh运行，自动找到classpath下的config.properties。
     */
    static {
    	InputStream in = null;
        try {
        	 in = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");
             props = new Properties();
			 props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 //关闭资源
		     try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
       
    }
    
    /**
     * 根据key值读取配置的值
     * @param key key值
     * @return key 键对应的值
     */
    public static String readValue(String key) {
        return  props.getProperty(key);
    }
}