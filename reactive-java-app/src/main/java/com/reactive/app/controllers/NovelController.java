package com.reactive.app.controllers;

import java.awt.print.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.app.entities.NovelEntity;
import com.reactive.app.services.NovelServices;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/novels")
public class NovelController {
	
	@Autowired
	private NovelServices novelServices;
	
	
	@PostMapping("/create")
	public Mono<NovelEntity> createNovel(@RequestBody NovelEntity entity){
		return novelServices.create(entity);
		
	}
	
	@GetMapping("/getAll")
	public Flux<NovelEntity> getAllNovels(){
		return novelServices.getAll();
		
	}
	
	@GetMapping("/getNovelbyId/{id}")
	public Mono<NovelEntity> getNovelbyId(@PathVariable int id){
		return novelServices.getNovel(id);
		
	}
	
	@PutMapping("/update")
	public Mono<NovelEntity> updatenovelInfo(@RequestBody NovelEntity entity){
		return novelServices.updateNovelInfo(entity, entity.getNovelId());
		
	}
	
	@DeleteMapping("/deleteById/{id}")
	public Mono<Void> deletenovelInfo(@PathVariable int id){
		return novelServices.deleteNovel(id);
		
	}
	
	@GetMapping("/search")
	public Flux<NovelEntity> searchByNamePatter(@RequestParam("query") String name){
		return novelServices.searchNovel(name);
		
	}
}
