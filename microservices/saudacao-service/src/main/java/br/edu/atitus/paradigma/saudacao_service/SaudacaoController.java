package br.edu.atitus.paradigma.saudacao_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.paradigma.saudacao_service.configs.SaudacaoConfig;

@RestController
@RequestMapping("saudacao-service")
public class SaudacaoController {

//	@Value("${saudacao-service.saudacao}")
//	private String saudacao;
//	@Value("${saudacao-service.nome-padrao}")
//	private String nomePadrao;

	private final SaudacaoConfig saudacaoConfig;

	public SaudacaoController(SaudacaoConfig saudacaoConfig) {
		super();
		this.saudacaoConfig = saudacaoConfig;
	}

	@GetMapping({ "", "/", "/{nomePath}" })
	public ResponseEntity<String> getSaudacao(@RequestParam(required = false) String nome,
			@PathVariable(required = false) String nomePath) {
		String template = "%s %s!";
		if (nome == null)
			nome = nomePath == null ? saudacaoConfig.getNomePadrao() : nomePath;
		return ResponseEntity.ok(String.format(template, saudacaoConfig.getSaudacao(), nome));
	}
}
