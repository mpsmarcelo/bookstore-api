package com.marcelo.bookstore.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	
	@PutMapping(value = "/{id}")
	ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro obj){
		Livro newLivro = service.update(id, obj);
		return ResponseEntity.ok().body(newLivro);
	}
	
	
	@PatchMapping(value = "/{id}")
	ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro obj){
		Livro newLivro = service.update(id, obj);
		return ResponseEntity.ok().body(newLivro);
	}
	
	@PostMapping
	ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue =  "0") Integer id_categoria, @RequestBody Livro livro){
		Livro newObj = service.create(id_categoria, livro);
		URI uri =  ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
