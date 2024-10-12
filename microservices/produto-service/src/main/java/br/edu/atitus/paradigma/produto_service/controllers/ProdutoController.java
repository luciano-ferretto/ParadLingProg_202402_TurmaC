package br.edu.atitus.paradigma.produto_service.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.paradigma.produto_service.clients.CambioClient;
import br.edu.atitus.paradigma.produto_service.clients.CambioResponse;
import br.edu.atitus.paradigma.produto_service.entities.ProdutoEntity;
import br.edu.atitus.paradigma.produto_service.repositories.ProdutoRepository;

@RestController
@RequestMapping("produto-service")
public class ProdutoController {
	private final ProdutoRepository repository;
	private final CambioClient client;
	
	public ProdutoController(ProdutoRepository repository,
			CambioClient client) {
		super();
		this.repository = repository;
		this.client = client;
	}
	
	@Value("${server.port}")
	private int porta;


	@GetMapping("/{idProduto}/{moeda}")
	public ResponseEntity<ProdutoEntity> getProduto(
			@PathVariable Integer idProduto,
			@PathVariable String moeda) throws Exception{
		// Busca no BD o produto com o Id informado na URL
		ProdutoEntity produto = repository.findById(idProduto)
				.orElseThrow(() -> new Exception("Produto não encontrado"));
		
		CambioResponse cambio = client.getCambio(produto.getValor(), "USD", moeda);
		
		produto.setValorConvertido(cambio.getValorConvertido());
		produto.setAmbiente("Produto-service rodando na porta: " + porta + " - " + cambio.getAmbiente());
		return ResponseEntity.ok(produto);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handler(Exception e){
		String message = e.getMessage().replaceAll("[\\r\\n]", "");
		return ResponseEntity.badRequest().body(message);
	}

}
