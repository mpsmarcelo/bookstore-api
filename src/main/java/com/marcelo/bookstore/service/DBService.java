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
		Categoria categoria0 = new Categoria(null,"Informática", "Livros de TI");
		Livro livro0 = new Livro(null,"Clean code", "Rober Martin","Loren ipsum", categoria0);
		
		Categoria categoria1 = new Categoria(null,"Culinária", "Livros de culinária");
		Livro livro1 = new Livro(null,"Doces + Doces", "Sônia maria","Aprendendo a fazer guloseimas", categoria1);
		
		Categoria categoria2 = new Categoria(null,"Agropecuária", "Livros de agropecuária");
		Livro livro2 = new Livro(null,"Gado nelore", "Manoel pereira","Vida no campo", categoria2);
		
		Categoria categoria3 = new Categoria(null,"Saúde", "Livros de saúde");
		Livro livro3 = new Livro(null,"Vida fitnes", "Marcelo Pereira","Melhorando a sáude com hábitos saudáveis", categoria3);
		
		Categoria categoria4 = new Categoria(null,"Finanças", "Livros de gestão financeira");
		Livro livro4 = new Livro(null,"Mentes milionárias", "Paul robert","Aprendendo o caminhos do sucesso", categoria4);
		
		categoria0.getLivros().addAll(Arrays.asList(livro0));
		categoria1.getLivros().addAll(Arrays.asList(livro1));
		categoria2.getLivros().addAll(Arrays.asList(livro2));
		categoria3.getLivros().addAll(Arrays.asList(livro3));
		categoria4.getLivros().addAll(Arrays.asList(livro4));
		
		this.categoriaRepository.saveAll(Arrays.asList(categoria0,categoria1,categoria2,categoria3,categoria4));
		this.livroRepository.saveAll(Arrays.asList(livro0,livro1,livro2,livro3,livro4));
	}

}
