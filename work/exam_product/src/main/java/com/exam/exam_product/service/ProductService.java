package com.exam.exam_product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.exam.exam_product.dto.ProductDTO;
import com.exam.exam_product.model.ProductEntity;
import com.exam.exam_product.persistance.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	
	public List<ProductDTO> findAll(){
		List<ProductEntity> list = productRepository.findAll();
		List<ProductDTO> dtos = list.stream().map(ProductDTO::new).collect(Collectors.toList());
		return dtos;
	}
	
	public List<ProductDTO> create(ProductDTO dto){
		ProductEntity entity = ProductDTO.toEntity(dto);
		productRepository.save(entity);
		return findAll();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}




