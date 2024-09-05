package br.edu.atitus.paradigma.saudacao_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("saudacao-service")
public class SaudacaoController {
	
	@GetMapping({"", "/", "/{nomePath}"})
	public ResponseEntity<String> getSaudacao(
			@RequestParam(required = false) String nome,
			@PathVariable(required = false) String nomePath){
		String template = "%s %s!";
		if (nome == null) nome 
		        = nomePath == null ? "World" : nomePath;
		return ResponseEntity.ok(
				String.format(template, "Hello", nome));
	}
}
