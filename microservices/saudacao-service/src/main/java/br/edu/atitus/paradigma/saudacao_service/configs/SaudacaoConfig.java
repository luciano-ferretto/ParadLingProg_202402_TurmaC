package br.edu.atitus.paradigma.saudacao_service.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("saudacao-service")
public class SaudacaoConfig {

	private String saudacao;
	private String nomePadrao;
	
	public String getSaudacao() {
		return saudacao;
	}
	public void setSaudacao(String saudacao) {
		this.saudacao = saudacao;
	}
	public String getNomePadrao() {
		return nomePadrao;
	}
	public void setNomePadrao(String nomePadrao) {
		this.nomePadrao = nomePadrao;
	}
	
	
}
