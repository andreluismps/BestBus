package br.ufba.grafos;

import java.util.ArrayList;
import java.util.List;

public class ParadaOnibus implements Comparable<ParadaOnibus>{
	private int tempoMinimo = Integer.MAX_VALUE;
	private String nome;
	private ParadaOnibus anterior;
	
	private List<Trecho> trechosSaida;
	
	public ParadaOnibus(String nome){
		this.trechosSaida = new ArrayList<Trecho>();
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}

	@Override
	public int compareTo(ParadaOnibus outro) {
		if (this.tempoMinimo < outro.tempoMinimo) {
            return -1;
        }
        if (this.tempoMinimo > outro.tempoMinimo) {
            return 1;
        }
        return 0;
	}

	
	public List<Trecho> getTrechosSaida() {
		return trechosSaida;
	}
	public void setTrechosSaida(List<Trecho> trechosSaida) {
		this.trechosSaida = trechosSaida;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTempoMinimo() {
		return tempoMinimo;
	}
	public void setTempoMinimo(int tempoMinimo) {
		this.tempoMinimo = tempoMinimo;
	}
	public ParadaOnibus getAnterior() {
		return anterior;
	}
	public void setAnterior(ParadaOnibus anterior) {
		this.anterior = anterior;
	}
	
}
