package br.edu.atitus.paradigma.produto_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.paradigma.produto_service.entities.ProdutoEntity;

@RestController
@RequestMapping("produto-service")
public class ProdutoController {
	
	@GetMapping("/{idProduto}/{moeda}")
	public ResponseEntity<ProdutoEntity> getProduto(
			@PathVariable Integer idProduto,
			@PathVariable String moeda){
		ProdutoEntity produto = new ProdutoEntity();
		return ResponseEntity.ok(produto);
	}

}
