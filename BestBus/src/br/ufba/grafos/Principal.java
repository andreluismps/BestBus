package br.ufba.grafos;

import java.util.List;


public class Principal {
	public static void main(String[] args) {
		ParadaOnibus fimDeLinhaRibeira = new ParadaOnibus("Fim de linha da Ribeira");
		ParadaOnibus baixaDoBonfim = new ParadaOnibus("Baixa do Bonfim");
		ParadaOnibus montSerrat = new ParadaOnibus("Mont Serrat");
		ParadaOnibus boaViagem = new ParadaOnibus("Boa Viagem");
		ParadaOnibus hiperFrango = new ParadaOnibus("Hiper Frango - Caminho de Areia");
		ParadaOnibus largoRoma = new ParadaOnibus("Largo de Roma");
		
		//1 ribeira - largo de roma via boa viagem
		//ribeira-bonfim
		Trecho ribeiraBonfim = new Trecho(6, fimDeLinhaRibeira, baixaDoBonfim);
		//bonfim boa viagem 1
		Trecho bonfimBoaViagem = new Trecho(8, baixaDoBonfim, boaViagem);
		//bonfim boa viagem 2
		Trecho bonfimMontSerrat = new Trecho(7, baixaDoBonfim, montSerrat);
		Trecho montSerratBoaViagem = new Trecho(3, montSerrat, boaViagem);
		
		// fim 1
		Trecho boaViagemRoma = new Trecho(1, boaViagem, largoRoma);
		
		//2 ribeira - largo de roma via bonfim
		Trecho bonfimRoma = new Trecho(10, baixaDoBonfim, largoRoma);
		
		//3 ribeira - largo de roma via Caminho de Areia
		Trecho ribeiraHiperFrango = new Trecho(8, fimDeLinhaRibeira, hiperFrango);
		Trecho hiperFrangoRoma = new Trecho(7, hiperFrango, largoRoma);
		
		
		fimDeLinhaRibeira.getTrechosSaida().add(ribeiraBonfim);
		fimDeLinhaRibeira.getTrechosSaida().add(ribeiraHiperFrango);
		
		baixaDoBonfim.getTrechosSaida().add(bonfimBoaViagem);
		baixaDoBonfim.getTrechosSaida().add(bonfimMontSerrat);
		
		baixaDoBonfim.getTrechosSaida().add(bonfimRoma);
		
		montSerrat.getTrechosSaida().add(montSerratBoaViagem);
		
		boaViagem.getTrechosSaida().add(boaViagemRoma);
		
		hiperFrango.getTrechosSaida().add(hiperFrangoRoma);
				
		
		IMelhorCaminho melhorCaminhoDijkstraHeap = new MelhorCaminhoDijkstraHeap();
		List<ParadaOnibus> rota = melhorCaminhoDijkstraHeap.getMelhorCaminho(fimDeLinhaRibeira, largoRoma);
	
		System.out.print("In’cio");
		for(ParadaOnibus paradaOnibus : rota){
			
			System.out.print(" :: " + paradaOnibus + " :: ");
		}
		System.out.println("Fim");
		System.out.println("Menor tempo entre "+ fimDeLinhaRibeira +" e "+ largoRoma + ": " + largoRoma.getTempoMinimo() + " minuto(s)");
		
		IMelhorCaminho melhorCaminhoDijkstraArray = new MelhorCaminhoDijkstraArray();
		List<ParadaOnibus> rotaArray = melhorCaminhoDijkstraArray.getMelhorCaminho(fimDeLinhaRibeira, largoRoma);
		System.out.print("In’cio");
		for(ParadaOnibus paradaOnibus : rotaArray){
			
			System.out.print(" :: " + paradaOnibus + " :: ");
		}
		System.out.println("Fim");
		System.out.println("Menor tempo entre "+ fimDeLinhaRibeira +" e "+ largoRoma + ": " + largoRoma.getTempoMinimo() + " minuto(s)");
		
		
	}
}
