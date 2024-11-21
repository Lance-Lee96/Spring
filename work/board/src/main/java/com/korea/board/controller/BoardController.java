package com.korea.board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.board.dto.BoardDTO;
import com.korea.board.dto.ResponseDTO;
import com.korea.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
	public final BoardService boardService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllPosts(){
		List<BoardDTO> dtos = boardService.getAllposts();
		ResponseDTO<BoardDTO> response = ResponseDTO.<BoardDTO>builder().data(dtos).build();
		return ResponseEntity.ok().body(response);
		
	}
	
	
	
}

