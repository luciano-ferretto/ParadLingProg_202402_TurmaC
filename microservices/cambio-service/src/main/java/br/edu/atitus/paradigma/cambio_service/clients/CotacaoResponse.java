package br.edu.atitus.paradigma.cambio_service.clients;

import java.util.List;

public class CotacaoResponse {
	private List<Cotacao> value;
	
	public List<Cotacao> getValue() {
		return value;
	}

	public void setValue(List<Cotacao> value) {
		this.value = value;
	}

	public static class Cotacao{
		private double cotacaoVenda;

		public double getCotacaoVenda() {
			return cotacaoVenda;
		}

		public void setCotacaoVenda(double cotacaoVenda) {
			this.cotacaoVenda = cotacaoVenda;
		}
	}

}
