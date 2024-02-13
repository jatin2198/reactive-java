package com.reactive.app;

import java.util.Arrays;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.concurrent.MonoToListenableFutureAdapter;

import reactor.core.publisher.Flux;
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
		
		//Mono<Tuple2<String, String>> combined=Mono.zip(m1, m2).log();
		
	//	combined.subscribe(System.out::println);
		
	/*
	 * combined.subscribe(data->{
	 * System.out.println("Consumed from m1= "+data.getT1());
	 * System.out.println("Consumed from m2= "+data.getT2()); });
	 * 
	 * Mono<Tuple2<String, String>> combWithZip=m1.zipWith(m2);
	 * combWithZip.subscribe(data->{
	 * System.out.println("Consumed from m1= "+data.getT1());
	 * System.out.println("Consumed from m2= "+data.getT2()); });
	 */
			m1.map(item->item.toUpperCase()).subscribe(System.out::println);
			
			m1.flatMap(valueM1->Mono.just(valueM1.split(" "))).subscribe(item->{
				Arrays.asList(item).forEach(values->System.out.println(values));
			});
			
		Flux<String> f1=m1.flatMapMany(valueM1->Flux.just(valueM1.split(" "))).log();
		
		f1.subscribe(data->System.out.println("data from Flux----->"+data));
	}

}
