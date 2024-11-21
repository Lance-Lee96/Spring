package com.korea.board.dto;

import com.korea.board.model.BoardEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	private Long id;
	private String title;
	private String author;
	private String writingTime;
	private String content;
		
	public BoardDTO(BoardEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.author = entity.getAuthor();
		this.writingTime = entity.getWritingTime();
		this.content = entity.getContent();
	}
	
}
