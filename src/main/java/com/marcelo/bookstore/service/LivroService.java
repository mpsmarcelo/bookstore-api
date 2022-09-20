package com.marcelo.bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.bookstore.domain.Categoria;
import com.marcelo.bookstore.domain.Livro;import com.marcelo.bookstore.dtos.LivroDTO;
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
		  return livro.orElseThrow(()-> new ObjectNotFoundException("Não foi encontrado nenhum livro para o id : " + id + " e tipo " + Livro.class.getName()));
	}


	public List<Livro> findAllLivroByCategoria(Integer id_categoria) {
		categoriaRepository.findById(id_categoria);
		return repository.findAllLivroByCategoria(id_categoria);
	}


	public Livro update(Integer id, Livro obj) {
		 Livro livro =  findById(id);
		 livro = setPropriedadesLivro(livro, obj);
		 return livro;
	}


	private Livro setPropriedadesLivro(Livro livro, Livro obj) {
		 livro.setTitulo(obj.getTitulo());
		 livro.setNome_autor(obj.getNome_autor());
		 livro.setTexto(obj.getTexto());
		 return repository.save(livro);
	}


	public Livro create(Integer id_categoria, Livro livro) {
		livro.setId(null);
		livro.setCategoria(categoriaRepository.findById(id_categoria).orElse(new Categoria()));
		return repository.save(livro);
	}


	public void delete(Integer id) {
		Optional<Livro> livro = Optional.ofNullable(findById(id));
		repository.delete(livro.get());
	    	
	}
	
	
	
}
