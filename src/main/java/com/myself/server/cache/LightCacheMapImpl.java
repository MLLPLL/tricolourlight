package com.myself.server.cache;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LightCacheMapImpl implements LightCache{
	
	private LightCacheMapImpl(){
		
	}
	
	private static ConcurrentHashMap<Integer,Integer> LIGHT_CACHE = new ConcurrentHashMap<Integer,Integer>();
	
	private static Queue RED_LIGHT_CACHE = new ConcurrentLinkedQueue();
	
	private static HashMap<Integer,String> LIGHT_STATUS_NAMES = new HashMap<Integer,String>();
	
	static{
		LIGHT_STATUS_NAMES.put(1, "GREEN");
		LIGHT_STATUS_NAMES.put(2, "YELLOW");
		LIGHT_STATUS_NAMES.put(3, "RED");
		
		LIGHT_CACHE.put(1, 1);
		LIGHT_CACHE.put(2, 1);
		LIGHT_CACHE.put(3, 1);
		LIGHT_CACHE.put(4, 1);
		LIGHT_CACHE.put(5, 1);
		LIGHT_CACHE.put(6, 1);
		LIGHT_CACHE.put(7, 1);
		LIGHT_CACHE.put(8, 1);
	}
	
	public static String getLightStatusName(int status){
		return LIGHT_STATUS_NAMES.get(status);
	}
	
	public static int getLightStatus(int lightNumber){
		return LIGHT_CACHE.get(lightNumber);
	}
	
	public static int setLightStatus(int lightNumber,int lightStatus){
		return LIGHT_CACHE.put(lightNumber,lightStatus);
	}
	
	public static HashMap getCurrentAllStatus(){
		HashMap map = new HashMap(LIGHT_CACHE);
		return map;
	}
	
	public static void resetAllStatus(){
		LIGHT_CACHE.put(1, 1);
		LIGHT_CACHE.put(2, 1);
		LIGHT_CACHE.put(3, 1);
		LIGHT_CACHE.put(4, 1);
		LIGHT_CACHE.put(5, 1);
		LIGHT_CACHE.put(6, 1);
		LIGHT_CACHE.put(7, 1);
		LIGHT_CACHE.put(8, 1);
	}
	
	public static void alert(int lightNumber){
		RED_LIGHT_CACHE.add(lightNumber);
	}
	
	public static int getRedCounts(){
		return RED_LIGHT_CACHE.size();
	}
	
	public static Queue getAllAlerts(){
		return RED_LIGHT_CACHE;
	}
}
