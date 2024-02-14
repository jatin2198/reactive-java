package com.reactive.app.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactive.app.entities.NovelEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface NovelRepository extends ReactiveCrudRepository<NovelEntity, Integer> {

	 Mono<NovelEntity> findByNovelName(String name);
	 Flux<NovelEntity> findByAuthor(String name);
	 Mono<NovelEntity> findByDescription(String name);
	 Flux<NovelEntity> findByNovelNameAndAuthor(String novelname,String author);
	 
	 @Query("select * from novel_details where author=:name")
	 Flux<NovelEntity> getByAuthor(@Param(value = "name") String author);
	 
	 @Query("select * from novel_details where novel_name LIKE :name")
	 Flux<NovelEntity> searchByName(@Param(value = "name") String novelname);
	 
}
