package com.marcelo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}


	public Categoria save(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}
	
	
}
