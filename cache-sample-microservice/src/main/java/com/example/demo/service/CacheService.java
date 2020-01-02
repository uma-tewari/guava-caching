package com.example.demo.service;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.common.CacheObject;
import com.example.demo.repository.CacheRepository;

@Service
public class CacheService {

	@Autowired
	private CacheRepository repo;
	
	public CacheObject save(CacheObject cacheObject) {
		return repo.save(cacheObject);
	}

	public CacheObject getById(String key) throws ExecutionException {
		return repo.findById(key).get();
		
		}
}
