package com.reactive.app.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactive.app.entities.NovelEntity;

@Repository
public interface NovelRepository extends ReactiveCrudRepository<NovelEntity, Integer> {

}
