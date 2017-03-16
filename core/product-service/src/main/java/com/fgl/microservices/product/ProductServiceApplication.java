package com.fgl.microservices.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

import zipkin.Span;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableAspectJAutoProxy
public class ProductServiceApplication {
	private static final Log log = LogFactory.getLog(ProductServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public CacheManager cacheManager() {
		ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("products");
		return cacheManager;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	@ConditionalOnProperty(value = "sample.zipkin.enabled", havingValue = "false")
	public ZipkinSpanReporter spanCollector() {
		return new ZipkinSpanReporter() {

			@Override
			public void report(Span span) {

				log.info(String.format("Reporting span [%s]", span));
			}
		};
	}

}
