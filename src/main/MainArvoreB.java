package main;

import java.util.ArrayList;
import java.util.Collections;

import arvores.Arvore;
import arvores.GeraArvores;
import arvores.arvoreB.ArvoreB;

public class MainArvoreB {
	public static void main(String[] args) {
		long inicio, fim, tempo;
        ArrayList<Integer> listaOrdenada = new ArrayList<>();
        ArrayList<Integer> listaEmbaralhada = new ArrayList<>();


		System.out.println("################################################################");
		System.out.println("Testes Arvore B Ordem 4");
		
		Arvore arvoreB = new ArvoreB();
		GeraArvores a1 = new GeraArvores(arvoreB);
        // Criar uma lista ordenada de 1 a 100000
        for (int i = 1; i <= 100000; i++) {
            listaOrdenada.add(i);
        }
        // Cria uma nova lista embaralhada
        listaEmbaralhada.addAll(listaOrdenada);
        Collections.shuffle(listaEmbaralhada);
        
		////////////////////////////////////////////////////////////////////////////////////////
		
		//inserindo 100.000 elementos ordenados sem repetição
		inicio = System.currentTimeMillis();		 
		for (int valor : listaOrdenada) {
            a1.InserirValor(valor);
        }

        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Tempo decorrido para inserção de 100.000 elementos ordenados: " + tempo + " ms");
        
      
        // Removendo todos os elementos inseridos anteriormente
		inicio = System.currentTimeMillis();		 
		for (int valor : listaOrdenada) {
            a1.RemoverValor(valor);
        }

        fim = System.currentTimeMillis();
        System.out.println("Tempo decorrido para remover os 100.000 elementos: " + tempo + " ms");
        

		////////////////////////////////////////////////////////////////////////////////////////

		//inserindo 100.000 elementos desordenados sem repetição
		inicio = System.currentTimeMillis();		 
		for (int valor : listaEmbaralhada) {
            a1.InserirValor(valor);
        }

        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Tempo decorrido para inserção de 100.000 elementos desordenados: " + tempo + " ms");
        
        
        // Removendo todos os elementos inseridos anteriormente
		inicio = System.currentTimeMillis();		 
		for (int valor : listaOrdenada) {
            a1.RemoverValor(valor);
        }

        fim = System.currentTimeMillis();
        System.out.println("Tempo decorrido para remover os 100.000 elementos: " + tempo + " ms");
        

		////////////////////////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////////////////////////
        listaOrdenada.clear();
        listaEmbaralhada.clear();
        
        // Criar uma lista ordenada de 1 a 100000
        for (int i = 1; i <= 1000000; i++) {
            listaOrdenada.add(i);
        }
        // Cria uma nova lista embaralhada
        listaEmbaralhada.addAll(listaOrdenada);
        Collections.shuffle(listaEmbaralhada);
        
		//inserindo 1.000.000 elementos ordenados sem repetição
		inicio = System.currentTimeMillis();		 
		for (int valor : listaOrdenada) {
            a1.InserirValor(valor);
        }

        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Tempo decorrido para inserção de 1.000.000 elementos ordenados: " + tempo + " ms");
        
        
        // Removendo todos os elementos inseridos anteriormente
		inicio = System.currentTimeMillis();		 
		for (int valor : listaOrdenada) {
            a1.RemoverValor(valor);
        }

        fim = System.currentTimeMillis();
        System.out.println("Tempo decorrido para remover os 1.000.000 elementos: " + tempo + " ms");
        

		////////////////////////////////////////////////////////////////////////////////////////

		//inserindo 1.000.000 elementos desordenados sem repetição
		inicio = System.currentTimeMillis();		 
		for (int valor : listaEmbaralhada) {
            a1.InserirValor(valor);
        }

        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Tempo decorrido para inserção de 1.000.000 elementos desordenados: " + tempo + " ms");
        
        
        // Removendo todos os elementos inseridos anteriormente
		inicio = System.currentTimeMillis();		 
		for (int valor : listaOrdenada) {
            a1.RemoverValor(valor);
        }

        fim = System.currentTimeMillis();
        System.out.println("Tempo decorrido para remover os 1.000.000 elementos: " + tempo + " ms");
        
	}
}
