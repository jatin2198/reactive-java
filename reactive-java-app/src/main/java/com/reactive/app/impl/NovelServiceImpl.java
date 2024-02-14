package com.reactive.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.app.entities.NovelEntity;
import com.reactive.app.repo.NovelRepository;
import com.reactive.app.services.NovelServices;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NovelServiceImpl implements NovelServices {

	@Autowired
	private NovelRepository novelRepository;
	@Override
	public Mono<NovelEntity> create(NovelEntity entity) {
		// TODO Auto-generated method stub
		return novelRepository.save(entity);
	}

	@Override
	public Flux<NovelEntity> getAll() {
		// TODO Auto-generated method stub
		return novelRepository.findAll();
	}

	@Override
	public Mono<NovelEntity> getNovel(int noveId) {
		// TODO Auto-generated method stub
		return novelRepository.findById(noveId);
	}

	@Override
	public Mono<NovelEntity> updateNovelInfo(NovelEntity entity, int noveId) {
	Mono<NovelEntity> oldnovel=	novelRepository.findById(noveId);
		
return	oldnovel.flatMap(book->{
		book.setAuthor(entity.getAuthor());
		book.setDescription(entity.getDescription());
		book.setNovelName(entity.getNovelName());
		return novelRepository.save(book);
	});
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mono<Void> deleteNovel(int id) {
		// TODO Auto-generated method stub
		return novelRepository.deleteById(id);
	}

	@Override
	public Flux<NovelEntity> searchNovel(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
