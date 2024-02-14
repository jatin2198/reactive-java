package com.reactive.app.services;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@Service
public class FluxTutService {

	public void fluxTutmethod() {
		
		System.out.println("Just to test flux...");
	}
	
	public Flux<String> getFluxJust(){
		
		return Flux.just("Jatin","Shivam","Shiva","TheRock");
	
	}
	
	public Flux<String> getFluxIterable(){
		
		List<String> fruits=List.of("Mango","Apple","Kiwi");
		return Flux.fromIterable(fruits);
	}
	
	public Flux<Void> getBlankFlux(){
		return Flux.empty();
		
	}
	
	public Flux<String> getFluxWithMap(){
		return Flux.just("Jatin","Shivam","Shiva","TheRock")
				.log()
				.map(item->item.toUpperCase());
	}
	
	public Flux<String> getFliterFlux(){
		return getFluxJust().filter(item->item.length()>5).log();
		
	}
	
	public Flux<String> getFlatMapFlux(){
		return getFluxJust().flatMap(name->Flux.just(name.split(""))).delayElements(Duration.ofSeconds(2)).log();
		
		
		
	}
	
	public Flux tranfrmFlux(){
		
		Function<Flux<String>,Flux<String>> func=(fluxnames)->{
			return fluxnames.map(String::toUpperCase);
		};
		return getFluxJust().transform(func).log();
		}
	
	public Flux<String> defaultIfExmp(int len){
		return getFluxJust().filter(names->names.length()>len)
				//.defaultIfEmpty("TEST Element")
				.switchIfEmpty(getFluxIterable())
				.log();
		
	}
	
	public Flux<String> getConcat(){
		return getFluxJust().delayElements(Duration.ofSeconds(1)).concatWith(getFluxIterable().delayElements(Duration.ofSeconds(3))).log();
		//return Flux.concat(getFluxJust(),getFluxIterable()).log();
		
	}
	
	public Flux<String> getMerge(){
		return Flux.merge(getFluxJust().delayElements(Duration.ofSeconds(1)),getFluxIterable().delayElements(Duration.ofSeconds(3))).log();
		
	}
	
	public Flux<String>  getZip() {
		
	///Flux<Tuple2<String, Integer>> tuples=Flux.zip(getFluxJust(), Flux.just(1,2,3,4)).log();
	return	Flux.zip(getFluxJust(), Flux.just(1,2,3,4,9,0,11),
			(firstFlux,secondFlux)->{return firstFlux+" "+secondFlux;});
	
		}
	
	public Flux<String> sideEfflectMethod(){
		return getFluxJust()
				.doOnNext(item-> System.out.println(item+" On Next"))
				.doOnSubscribe(item-> System.out.println(item+" On Subscribe"))
				.doOnEach(item-> System.out.println(item+" On Each"))
				.doOnComplete(()->System.out.println("Finally Completed.."));
		
	}
	
}
