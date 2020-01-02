package com.example.demo.repository;

import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.common.CacheObject;

@ViewIndexed(designDoc = "cachedObject")
@Repository
public interface CacheRepository extends CrudRepository<CacheObject, String>{

}
