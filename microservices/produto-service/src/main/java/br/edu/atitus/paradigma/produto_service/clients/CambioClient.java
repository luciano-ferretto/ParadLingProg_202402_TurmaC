package br.edu.atitus.paradigma.produto_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cambio-service")
public interface CambioClient {
	
	@GetMapping("/cambio-service/{valor}/{origem}/{destino}")
	CambioResponse getCambio(
			@PathVariable double valor,
			@PathVariable String origem,
			@PathVariable String destino);

}
