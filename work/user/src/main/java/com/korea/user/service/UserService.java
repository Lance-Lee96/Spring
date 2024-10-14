package com.korea.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.user.dto.UserDTO;
import com.korea.user.model.UserEntity;
import com.korea.user.persistence.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	//id 중복체크메서드
	//id를 db로 전달해서 조회가 되면 false, 조회가 안되면 true를 반환
	//true면 아이디 생성 가능, false면 아이디 생성 불가능
	
	public boolean isIdDuplicated(String id) {
		
		Optional<UserEntity> user = userRepository.findByUserId(id);
		return !user.isPresent();// 조회되면 true
	}
	
	public List<UserDTO> insert(UserDTO dto) {
		
		UserEntity entity = UserDTO.toEntity(dto);
		
		userRepository.save(entity);
		
		return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
		
	}
	
	//유저 전체조회
	public List<UserDTO> allUsers(){
		List<UserDTO> list = userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
		return list;
	}
	
	//로그인
	//아이디랑 비밀번호를 받는다.
	
	public UserEntity getByCredential(String userId, String pwd) {
		return userRepository.findByuserIdAndPwd(userId,pwd);
	}
	
}
