package com.marcelo.bookstore.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.marcelo.bookstore.domain.Categoria;

public class CategoriaDTO {
	

	private Integer id;
	@NotEmpty(message = "Campo NOME é obrigatório")
	@Length(min = 1, max = 50, message = "Campo NOME deve ter de 0 ate 50 caracteres!")
	private String  nome;
	
	@NotEmpty(message = "Campo DESCRIÇÃO é obrigatório")
	@Length(min = 1, max = 50, message = "Campo DESCRIÇÃO deve ter de 0 ate 100 caracteres!")
	private String  descricao;
	
	
	public CategoriaDTO() {
		// TODO Auto-generated constructor stub
	}


	public CategoriaDTO(Categoria categoria) {
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
