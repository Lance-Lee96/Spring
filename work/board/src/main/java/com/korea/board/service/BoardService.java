package com.korea.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.board.dto.BoardDTO;
import com.korea.board.model.BoardEntity;
import com.korea.board.persistence.BoardRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BoardService {
	
	private final BoardRepository boardRepository;
	
	//1. 조회
	public List<BoardDTO> getAllposts (){
		List<BoardDTO> list = boardRepository.findAll().stream().map(BoardDTO::new).collect(Collectors.toList());
		return list;
	}
	//2. 추가
	
	//3. 수정
	
	//4. 삭제
	
	//Entity -> DTO
	
	//DTO -> Entity 변환함수
	
}
