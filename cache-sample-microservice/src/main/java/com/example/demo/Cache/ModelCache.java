package com.example.demo.Cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.common.CacheObject;
import com.example.demo.service.CacheService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;


@Component
public class ModelCache implements CacheMethods{
	
	@Autowired
	private CacheService serv;
	
	
	
	LoadingCache<String, CacheObject>	cache=
			CacheBuilder.newBuilder()
	         .maximumSize(2000)                             
	         .expireAfterAccess(30, TimeUnit.MINUTES)
	         .build(new CacheLoader<String, CacheObject>() {
				
	        	 public CacheObject load(String key) throws Exception {
					System.out.println("Loading datafrom database.....");
					return serv.getById(key);
				}
	         });
	
	
	
	@Override
	public CacheObject get(String key) throws ExecutionException{
		return cache.get(key);
	}

	@Override
	public CacheObject put(String key, CacheObject value) {
		cache.put(key, value);
		return value;
	}

	@Override
	public boolean evict(CacheObject key) {
		cache.invalidate(key);
		return true;
	}
}
