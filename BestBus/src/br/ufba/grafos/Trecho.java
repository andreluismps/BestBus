package br.ufba.grafos;

public class Trecho {
	private int tempo;
	private ParadaOnibus origem;
	private ParadaOnibus destino;
	
	public Trecho(int tempo, ParadaOnibus origem, ParadaOnibus destino) {
		super();
		this.tempo = tempo;
		this.origem = origem;
		this.destino = destino;
	}
	
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public ParadaOnibus getOrigem() {
		return origem;
	}
	public void setOrigem(ParadaOnibus origem) {
		this.origem = origem;
	}
	public ParadaOnibus getDestino() {
		return destino;
	}
	public void setDestino(ParadaOnibus destino) {
		this.destino = destino;
	}
	
	
}
