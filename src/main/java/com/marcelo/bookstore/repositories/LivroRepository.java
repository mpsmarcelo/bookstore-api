package com.marcelo.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marcelo.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Integer>{

	
	@Query("select livro from Livro livro where livro.categoria.id =:id_categoria order by titulo ")
	List<Livro> findAllLivroByCategoria(@Param(value = "id_categoria") Integer id_categoria);

}
