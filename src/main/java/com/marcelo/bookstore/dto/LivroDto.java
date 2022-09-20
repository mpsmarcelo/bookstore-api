package com.marcelo.bookstore.dto;

import java.io.Serializable;

import com.marcelo.bookstore.domain.Livro;

public class LivroDto implements Serializable {

	private static final long serialVersionUID = 1L;
		
	private Integer id;
	private String titulo;
		
	public LivroDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LivroDto(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
