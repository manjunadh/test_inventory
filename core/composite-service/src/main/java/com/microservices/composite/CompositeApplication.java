package com.microservices.composite;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import zipkin.Span;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableDiscoveryClient
@EnableAsync
@EnableCircuitBreaker
public class CompositeApplication {
	private static final Log log = LogFactory.getLog(CompositeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CompositeApplication.class, args);
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
