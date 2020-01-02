package com.example.demo.Cache;

import java.util.concurrent.ExecutionException;

import com.example.demo.common.CacheObject;


public interface CacheMethods {

	public CacheObject get(String key) throws ExecutionException;
	
	public CacheObject put(String key, CacheObject value);
	
	public boolean evict(CacheObject key);

}
