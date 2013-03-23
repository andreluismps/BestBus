package br.ufba.grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MelhorCaminhoDijkstraHeap implements IMelhorCaminho{

	@Override
	public List<ParadaOnibus> getMelhorCaminho(ParadaOnibus origem, ParadaOnibus destino) {
		System.out.println("MŽtodo de Dijkstra com Heap");
		calcularCaminhos(origem);
		
		List<ParadaOnibus> rota = new ArrayList<ParadaOnibus>();
		for (ParadaOnibus paradaOnibus = destino; paradaOnibus != null; paradaOnibus = paradaOnibus.getAnterior())
			rota.add(paradaOnibus);

		Collections.reverse(rota);
		return rota;
	}
	
	public void calcularCaminhos(ParadaOnibus origem){
		
		origem.setTempoMinimo(0);
		PriorityQueue<ParadaOnibus> vertexQueue = new PriorityQueue<ParadaOnibus>();
		vertexQueue.add(origem);

		while (!vertexQueue.isEmpty()) {
			ParadaOnibus paradaOnibus = vertexQueue.poll();

			// Visit each edge exiting u
			for (Trecho trecho : paradaOnibus.getTrechosSaida()) {
				ParadaOnibus v = trecho.getDestino();
				int tempo = trecho.getTempo();
				int tempoPercurso = paradaOnibus.getTempoMinimo() + tempo;
				if (tempoPercurso < v.getTempoMinimo()) {
					vertexQueue.remove(v);

					v.setTempoMinimo(tempoPercurso);
					v.setAnterior(paradaOnibus);
					vertexQueue.add(v);
				}
			}
		}
	}

}
