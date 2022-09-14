package com.marcelo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.bookstore.domain.Livro;import com.marcelo.bookstore.dtos.LivroDto;
import com.marcelo.bookstore.repositories.CategoriaRepository;
import com.marcelo.bookstore.repositories.LivroRepository;
import com.marcelo.bookstore.service.exception.ObjectNotFoundException;


@Service
public class LivroService {
	
	
	@Autowired
	LivroRepository repository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	public Livro findById (Integer id){
		  Optional<Livro> livro = repository.findById(id);
		  return livro.orElseThrow(()-> new ObjectNotFoundException("Não foi encontrado nenhum livro para o id : " + id + 
		  		 " e tipo " + Livro.class.getName()));
	}


	public List<Livro> findAllLivroByCategoria(Integer id_categoria) {
		categoriaRepository.findById(id_categoria);
		return repository.findAllLivroByCategoria(id_categoria);
		
	}
	
	
	
}
