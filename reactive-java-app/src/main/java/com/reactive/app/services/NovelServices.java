package com.reactive.app.services;

import com.reactive.app.entities.NovelEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NovelServices {

	public Mono<NovelEntity> create(NovelEntity entity);
	
	public Flux<NovelEntity> getAll();
	
	public Mono<NovelEntity> getNovel(int noveId);
	
	public Mono<NovelEntity> updateNovelInfo(NovelEntity entity,int noveId);
	
	public Mono<Void> deleteNovel(int id);
	
	public Flux<NovelEntity> searchNovel(String query);
}
