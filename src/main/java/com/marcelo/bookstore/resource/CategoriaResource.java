package com.marcelo.bookstore.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.bookstore.domain.Categoria;
import com.marcelo.bookstore.dtos.CategoriaDTO;
import com.marcelo.bookstore.service.CategoriaService;


@RestController
@RequestMapping(value="/categoria")
public class CategoriaResource {
	
	@Autowired
	CategoriaService  categoriaService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		Categoria categoriaResponse = categoriaService.findById(id);
		return ResponseEntity.ok().body(categoriaResponse);
	}
	
	
	@GetMapping()
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> listCategoria = categoriaService.findAll();
		List<CategoriaDTO> categoriaDto = listCategoria.stream().map(c -> new CategoriaDTO(c)).collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriaDto);
		
	}
	
}
