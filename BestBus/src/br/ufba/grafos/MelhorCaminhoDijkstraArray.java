package br.ufba.grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MelhorCaminhoDijkstraArray implements IMelhorCaminho{

	@Override
	public List<ParadaOnibus> getMelhorCaminho(ParadaOnibus origem, ParadaOnibus destino) {
		System.out.println("MŽtodo de Dijkstra com Array");
		calcularCaminhos(origem);
		
		List<ParadaOnibus> rota = new ArrayList<ParadaOnibus>();
		for (ParadaOnibus paradaOnibus = destino; paradaOnibus != null; paradaOnibus = paradaOnibus.getAnterior())
			rota.add(paradaOnibus);

		Collections.reverse(rota);
		return rota;
	}
	
	public void calcularCaminhos(ParadaOnibus origem){
		
		origem.setTempoMinimo(0);
		List<ParadaOnibus> paradas = new ArrayList<ParadaOnibus>();
		paradas.add(origem);

		while (!paradas.isEmpty()) {
			ParadaOnibus paradaOnibus = retornaMaior(paradas);

			// Visit each edge exiting u
			for (Trecho trecho : paradaOnibus.getTrechosSaida()) {
				ParadaOnibus v = trecho.getDestino();
				int tempo = trecho.getTempo();
				int tempoPercurso = paradaOnibus.getTempoMinimo() + tempo;
				if (tempoPercurso < v.getTempoMinimo()) {
					paradas.remove(v);

					v.setTempoMinimo(tempoPercurso);
					v.setAnterior(paradaOnibus);
					paradas.add(v);
				}
			}
			paradas.remove(paradaOnibus);
		}
	}

	private ParadaOnibus retornaMaior(List<ParadaOnibus> paradas) {
		int tempoMinimo = -1;
		ParadaOnibus retorno = null;
		for(ParadaOnibus parada : paradas){
			if(parada.getTempoMinimo() >= tempoMinimo){
				retorno = parada;
			}
				
		}
		return retorno;
	}

}
