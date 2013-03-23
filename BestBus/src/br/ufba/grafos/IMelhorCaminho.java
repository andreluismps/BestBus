package br.ufba.grafos;

import java.util.List;

public interface IMelhorCaminho {
	public List<ParadaOnibus> getMelhorCaminho(ParadaOnibus origem, ParadaOnibus destino);

}
