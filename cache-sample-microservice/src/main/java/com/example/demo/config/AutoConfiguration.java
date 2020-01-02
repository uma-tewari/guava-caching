package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.demo.Cache.ModelCache;

@Configuration
@Import({
	ModelCache.class
})

public class AutoConfiguration {

}
