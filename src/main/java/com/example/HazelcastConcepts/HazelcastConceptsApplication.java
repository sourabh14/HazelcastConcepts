package com.example.HazelcastConcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HazelcastConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazelcastConceptsApplication.class, args);
		/*
			https://docs.hazelcast.com/tutorials/caching-springboot

			https://www.baeldung.com/spring-cache-tutorial

			https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/cache.html#:~:text=Default%20Key%20Generation&text=Out%20of%20the%20box%2C%20the,the%20hashes%20of%20all%20parameters.

			https://youtu.be/X6KKjw8GAnU?list=PL12XW6i6zqKvW8EVUc99yF7ZVMcI9sB_G

			Key value pair:
				Caches are essentially key-value stores, each invocation of a cached method needs to be translated
				into a suitable key for cache access.

			Spring cache abstraction:
				the caching service is an abstraction (not a cache implementation) and requires the use of an actual
				storage to store the cache data - that is, the abstraction frees the developer from having to write
				the caching logic but does not provide the actual stores.

			Run two instances of server
				mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=8081'
				mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=8082'

				You will see logs like this during startup:
					Members {size:2, ver:2} [
						Member [192.168.14.245]:5701 - c63817c8-6146-4283-9f16-e3cf2e046f18
						Member [192.168.14.245]:5702 - 299b7ab2-dfdf-4d25-afa8-8f78b250ff4f this
]

		 */
	}

}
