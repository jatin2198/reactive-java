package com.reactive.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("novel_details")
public class NovelEntity {

	@Id
	@Column("novel_id")
	private int novelId;
	
	@Column("novel_name")
	private String novelName;
	
	@Column("novel_desc")
	private String description;
	
	@Column("author")
	private String author;
}
