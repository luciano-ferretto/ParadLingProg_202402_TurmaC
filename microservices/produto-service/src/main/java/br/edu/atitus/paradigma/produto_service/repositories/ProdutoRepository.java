package br.edu.atitus.paradigma.produto_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.atitus.paradigma.produto_service.entities.ProdutoEntity;

public interface ProdutoRepository 
	extends JpaRepository<ProdutoEntity, Integer>{

}
