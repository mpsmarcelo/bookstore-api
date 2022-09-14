package com.marcelo.bookstore.dtos;

import com.marcelo.bookstore.domain.Categoria;

public class CategoriaDto {
	

	private Integer id;
	private String  nome;
	private String  descricao;
	
	
	public CategoriaDto() {

		// TODO Auto-generated constructor stub
	}


	public CategoriaDto(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
