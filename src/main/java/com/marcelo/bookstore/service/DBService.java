package com.marcelo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.bookstore.domain.Categoria;
import com.marcelo.bookstore.domain.Livro;
import com.marcelo.bookstore.repositories.CategoriaRepository;
import com.marcelo.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	public void instanciaBancoDeDados() {
		Categoria categoria = new Categoria(null,"Informática", "Livros de TI");
		Livro livro = new Livro(null,"Clean code", "Rober Martin","Loren ipsum", categoria);
		categoria.getLivros().addAll(Arrays.asList(livro));
		
		this.categoriaRepository.saveAll(Arrays.asList(categoria));
		this.livroRepository.saveAll(Arrays.asList(livro));
	}

}
