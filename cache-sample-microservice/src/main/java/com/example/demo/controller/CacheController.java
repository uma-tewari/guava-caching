package com.example.demo.controller;


import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Cache.ModelCache;
import com.example.demo.common.CacheObject;
import com.example.demo.service.CacheService;


@RestController
public class CacheController {

	@Autowired
	ModelCache modelcache;
	@Autowired
	CacheService CacheService;

	
	@GetMapping("/getcachedata/{key}")
	public CacheObject getDataFromCache(@PathVariable String key, CacheObject cacheObject) throws ExecutionException {
		return modelcache.get(key);
	}
	
	@PostMapping("/putcachedata")
	public CacheObject putDataToCache(@RequestBody CacheObject cacheObject) {
		return CacheService.save(cacheObject);
	}
	
	@DeleteMapping("/evictfromcache/{key}")
	public boolean deleteDataFromCache(CacheObject key) {
		System.out.println("Eviction");
		return modelcache.evict(key);
	}
}