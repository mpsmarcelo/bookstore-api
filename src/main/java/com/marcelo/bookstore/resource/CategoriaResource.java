package com.marcelo.bookstore.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.bookstore.domain.Categoria;
import com.marcelo.bookstore.dto.CategoriaDto;
import com.marcelo.bookstore.resource.exceptions.DataIntegrityConstraintViolationException;
import com.marcelo.bookstore.service.CategoriaService;

@CrossOrigin("*")
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
	public ResponseEntity<List<CategoriaDto>> findAll(){
		List<Categoria> listCategoria = categoriaService.findAll();
		List<CategoriaDto> categoriaDto = listCategoria.stream().map(c -> new CategoriaDto(c)).collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriaDto);
		
	}
	
	@PostMapping()
	public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria){
		 categoria = categoriaService.save(categoria);
		 URI  uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(categoria);
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<CategoriaDto> update(@Valid @PathVariable Integer id,   @RequestBody  CategoriaDto categoriaDTO){
		Categoria categoria = categoriaService.update(id , categoriaDTO);
		return ResponseEntity.ok().body(new CategoriaDto(categoria));
	}
	
	@DeleteMapping(value = "/{id}")
	public  ResponseEntity<Void> delete(@PathVariable Integer id) {
		try {
			categoriaService.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityConstraintViolationException("Categoria não pode ser deletada, Possui livros associados!");
		}
		
		return ResponseEntity.noContent().build();
	}
}
