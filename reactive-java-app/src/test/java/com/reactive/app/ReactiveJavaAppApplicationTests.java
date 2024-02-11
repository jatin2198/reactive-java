package com.reactive.app;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.concurrent.MonoToListenableFutureAdapter;

import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveJavaAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void workWithMono() {
		
		//mono--publisher whixh will return 0 or 1
		//created mono
		Mono<Object> monoErro=	Mono
				.error(new RuntimeException("Throwing an Error...."))
				.log();
		Mono<Object> mono= Mono
				.just("learning reactive java")
				.log().then(monoErro);
		
		/* Consumed Mono
		 * mono.subscribe(new Consumer<String>() {
		 * 
		 * 
		 * 
		 * @Override public void accept(String t) { // TODO Auto-generated method stub
		 * System.out.println("Consumed data= "+t); } });
		 */
		
		//doing same with lambda 
		
	mono.subscribe(data->System.out.println("Consumed data= "+data));
		//mono.subscribe(System.out::println);
	
	

	
	//monoErro.subscribe(System.out::println);
	}

}
