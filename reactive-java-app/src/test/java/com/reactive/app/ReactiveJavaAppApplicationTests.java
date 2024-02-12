package com.reactive.app;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.concurrent.MonoToListenableFutureAdapter;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@SpringBootTest
class ReactiveJavaAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void workWithMono() {

		/*
		 * //mono--publisher whixh will return 0 or 1 //created mono Mono<Object>
		 * monoErro= Mono .error(new RuntimeException("Throwing an Error....")) .log();
		 * Mono<Object> mono= Mono .just("learning reactive java")
		 * .log().then(monoErro);
		 * 
		 * Consumed Mono mono.subscribe(new Consumer<String>() {
		 * 
		 * 
		 * 
		 * @Override public void accept(String t) { // TODO Auto-generated method stub
		 * System.out.println("Consumed data= "+t); } });
		 * 
		 * 
		 * //doing same with lambda
		 * 
		 * mono.subscribe(data->System.out.println("Consumed data= "+data));
		 */
		// mono.subscribe(System.out::println);

		// monoErro.subscribe(System.out::println);
		
		Mono<String> m1=Mono.just("Jatin hi Shivam h");
		Mono<String> m2=Mono.just("Shivam hi Jatin h");
		
		Mono<Tuple2<String, String>> combined=Mono.zip(m1, m2).log();
		
	//	combined.subscribe(System.out::println);
		
		combined.subscribe(data->{
			System.out.println("Consumed from m1= "+data.getT1());
			System.out.println("Consumed from m2= "+data.getT2());
		});
		
		Mono<Tuple2<String, String>> combWithZip=m1.zipWith(m2);
		combWithZip.subscribe(data->{
			System.out.println("Consumed from m1= "+data.getT1());
			System.out.println("Consumed from m2= "+data.getT2());
		});
		
	}

}
