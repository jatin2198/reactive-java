package com.reactive.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactive.app.services.FluxTutService;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

@SpringBootTest
class FluxTutorial {

	@Autowired
	private FluxTutService fluxTutService;
	
	@Test
	void fluxTutmethod() {
		
		fluxTutService.fluxTutmethod();
	}

	@Test
	void getFluxJust() {
		
		fluxTutService.getFluxJust().subscribe(System.out::println);
	}
	
	@Test
	void getFluxIterable() {
		
		fluxTutService.getFluxIterable().subscribe(System.out::println);
	}
	
	@Test
	void getBlankFlux() {
		
		fluxTutService.getBlankFlux().subscribe(System.out::println);
	}
	@Test
	void getFluxWithMap() {
		
		Flux<String> result=fluxTutService.getFluxWithMap();
		
		
		StepVerifier.create(result).expectNext("Jatin".toUpperCase(),"Shivam".toUpperCase(),"Shiva".toUpperCase(),"TheRock".toUpperCase())
		.verifyComplete();
	}
	
	@Test
	void getFliterFlux() {
		
		Flux<String> fliterFlux=fluxTutService.getFliterFlux();
		
		
		StepVerifier.create(fliterFlux).expectNextCount(2)
		.verifyComplete();
	}
	
	@Test
	void getFlatMapFlux() {
		
		Flux<String> flatFlux=fluxTutService.getFlatMapFlux();
		
		
		StepVerifier.create(flatFlux).expectNextCount(23)
		.verifyComplete();
	}
	
	@Test
	void tranfrmFlux() {
		
		Flux<String> flatFlux=fluxTutService.tranfrmFlux();
		
		
		StepVerifier.create(flatFlux).expectNextCount(4)
		.verifyComplete();
	}
	
	@Test
	void defaultIfExmp() {
		
		Flux<String> fliterFlux=fluxTutService.defaultIfExmp(10);
		
		
		StepVerifier.create(fliterFlux).expectNextCount(3)
		.verifyComplete();
	}
	
	@Test
	void getConcat() {
		
		Flux<String> conFlux=fluxTutService.getConcat();
		
		
		StepVerifier.create(conFlux).expectNextCount(7)
		.verifyComplete();
	}
	
	@Test
	void getMerge() {
		
		Flux<String> conFlux=fluxTutService.getMerge();
		
		
		StepVerifier.create(conFlux).expectNextCount(7)
		.verifyComplete();
	}
	
	@Test
	void getZip() {
		
		Flux<String> flux=fluxTutService.getZip().log();
		
		
		StepVerifier.create(flux).expectNextCount(4)
		.verifyComplete();
	}
	
	@Test
	void sideEfflectMethod() {
		
		Flux<String> flux=fluxTutService.sideEfflectMethod().log();
		
		//flux.subscribe(System.out::println);
		StepVerifier.create(flux).expectNextCount(4)
		.verifyComplete();
	}
}
