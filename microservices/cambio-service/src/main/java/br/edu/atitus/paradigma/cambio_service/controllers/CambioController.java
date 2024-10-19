package br.edu.atitus.paradigma.cambio_service.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.paradigma.cambio_service.clients.CotacaoClient;
import br.edu.atitus.paradigma.cambio_service.clients.CotacaoResponse;
import br.edu.atitus.paradigma.cambio_service.entities.CambioEntity;
import br.edu.atitus.paradigma.cambio_service.repositories.CambioRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

	private final CambioRepository cambioRepository;
	private final CotacaoClient cotacaoClient;
	private final CacheManager cacheManager;

	public CambioController(CambioRepository cambioRepository, CotacaoClient cotacaoClient, CacheManager cacheManager) {
		super();
		this.cambioRepository = cambioRepository;
		this.cotacaoClient = cotacaoClient;
		this.cacheManager = cacheManager;
	}

	@Value("${server.port}")
	private int porta;

	@GetMapping("/{valor}/{origem}/{destino}")
	@CircuitBreaker(name = "cotacaoClient", fallbackMethod = "getCambioFromLocal")
	public ResponseEntity<CambioEntity> getCambio(@PathVariable double valor, @PathVariable String origem,
			@PathVariable String destino) throws Exception {

		CambioEntity cambio = cacheManager.getCache("cambioCache")
				.get(origem + destino, CambioEntity.class);
		if (cambio == null) {
			cambio = getCambioFromBC(origem, destino);
			cacheManager.getCache("cambioCache").put(origem+destino, cambio);
		}

		cambio.setValorConvertido(valor * cambio.getFator());
		cambio.setAmbiente("Cambio-Service run in port: " + porta);
		return ResponseEntity.ok(cambio);
	}

	public ResponseEntity<CambioEntity> getCambioFromLocal(double valor, String origem, String destino, Throwable e) throws Exception {
		CambioEntity cambio = cambioRepository.findByOrigemAndDestino(origem, destino)
				.orElseThrow(() -> new Exception("Câmbio não encontrado para esta origem e destino"));
		cambio.setValorConvertido(valor * cambio.getFator());
		cambio.setAmbiente("Cambio-Service run in port: " + porta);
		return ResponseEntity.ok(cambio);
	}

	public CambioEntity getCambioFromBC(String origem, String destino) {
		// Aqui vamos criar um novo objeto "cambio" pois nesse momento não vamos buscar
		// do banco de dados
		CambioEntity cambio = new CambioEntity();
		cambio.setOrigem(origem);
		cambio.setDestino(destino);

		CotacaoResponse cotacaoOrigem = cotacaoClient.getCotacao(origem, "10-10-2024");
		double fator;
		if (destino.equals("BRL")) {
			fator = cotacaoOrigem.getValue().get(0).getCotacaoVenda();
		} else {
			// Se o destino NÃO é o Real (BRL), então temos que fazer o cálculo,
			// já que a API do Banco Central retorna sempre a cotação em relação a moeda
			// brasileira
			CotacaoResponse cotacaoDestino = cotacaoClient.getCotacao(destino, "10-10-2024");
			fator = cotacaoOrigem.getValue().get(0).getCotacaoVenda()
					/ cotacaoDestino.getValue().get(0).getCotacaoVenda();
		}

		cambio.setFator(fator);
		return cambio;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		String cleanMessage = e.getMessage().replaceAll("[\\r\\n]", " ");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cleanMessage);
	}

}
