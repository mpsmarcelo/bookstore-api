package com.marcelo.bookstore.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.bookstore.domain.Livro;
import com.marcelo.bookstore.dtos.LivroDto;
import com.marcelo.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource{

	
	@Autowired
	LivroService service;
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro livro = service.findById(id);
		return ResponseEntity.ok().body(livro);
	}
	
	
	@GetMapping()
	ResponseEntity<List<LivroDto>> findAllLivroByCategoria(@RequestParam(value = "categoria", defaultValue = "0") Integer id_categoria){
		List<Livro> lista = service.findAllLivroByCategoria(id_categoria);
		List<LivroDto> livroDto = lista.stream().map(l-> new LivroDto(l)).collect(Collectors.toList());
		return ResponseEntity.ok().body(livroDto);
	}
}
