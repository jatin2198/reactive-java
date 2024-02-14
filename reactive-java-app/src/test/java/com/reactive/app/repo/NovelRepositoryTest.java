package com.reactive.app.repo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactive.app.entities.NovelEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class NovelRepositoryTest {

	@Autowired
	private NovelRepository novelRepository;
	
	@Test
	void findByNovelName() {
		Mono<NovelEntity> result=novelRepository.findByNovelName("Digital Minimalis").log();
		
		StepVerifier.create(result).expectNextCount(1).verifyComplete();
	}

	@Test
	void findByNovelNameAndAuthor() {
		Flux<NovelEntity> result=novelRepository.findByNovelNameAndAuthor("Digital Minimalis","portman").log();
		
		StepVerifier.create(result).expectNextCount(1).verifyComplete();
	}
	
	@Test
	void getByAuthor() {
		Flux<NovelEntity> result=novelRepository.getByAuthor("portman").log();
		
		StepVerifier.create(result).expectNextCount(1).verifyComplete();
	}
	
	@Test
	void searchByName() {
		novelRepository.searchByName("%Di%")
		.log().as(StepVerifier::create).expectNextCount(1).verifyComplete();
		
		
	}
}
