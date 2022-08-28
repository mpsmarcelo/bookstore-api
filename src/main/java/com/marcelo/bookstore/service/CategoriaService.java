package com.marcelo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.bookstore.domain.Categoria;
import com.marcelo.bookstore.repositories.CategoriaRepository;
import com.marcelo.bookstore.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	 
	public Categoria findById(Integer id){
		Optional<Categoria> categoria =  categoriaRepository.findById(id);
		return categoria.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado : " + id + ", Tipo :" + Categoria.class.getName()));
	}
	
}
