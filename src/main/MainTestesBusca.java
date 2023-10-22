package main;

import java.util.ArrayList;
import java.util.Collections;

import arvores.*;
import arvores.arvoreAVL.*;
import arvores.arvoreB.*;
import arvores.arvoreBinaria.*;

public class MainTestesBusca {
	public static void main(String[] args) {
		long inicio, fim; 
		double tempo;
        ArrayList<Integer> listaOrdenada = new ArrayList<>();
        ArrayList<Integer> listaEmbaralhada = new ArrayList<>();
        
        Arvore arvore_Binaria = new ArvoreBinaria();
		GeraArvores a1 = new GeraArvores(arvore_Binaria);
		
		Arvore arvore_AVL = new ArvoreAVL();
		GeraArvores a2 = new GeraArvores(arvore_AVL);
		
		Arvore arvore_B = new ArvoreB();
		GeraArvores a3 = new GeraArvores(arvore_B);
		
		
		// 100.000
        for (int i = 1; i <= 1000000; i++) {
            listaOrdenada.add(i);
        }
        // Cria uma nova lista embaralhada
        listaEmbaralhada.addAll(listaOrdenada);
        Collections.shuffle(listaEmbaralhada);
		
		// Arvore Binaria - Ordenada
		
		System.out.println("################################################################");
		System.out.println("Testes Arvore Binaria");
		for (int valor : listaOrdenada) {
            a1.InserirValor(valor);
        }
		
		inicio = System.nanoTime();		 
		a1.BuscarValor(1000001);
        fim = System.nanoTime();
        tempo = ( fim - inicio )/ 1000000.0;
        System.out.println("Tempo decorrido para Buscar o valor 1.000.001 na arvore ordenada: " + tempo + " ms");
		
		for (int valor : listaOrdenada) {
            a1.RemoverValor(valor);
        }
		for (int valor : listaEmbaralhada) {
            a1.InserirValor(valor);
        }
		inicio = System.nanoTime();		 
		a1.BuscarValor(1000001);
        fim = System.nanoTime();
        tempo = ( fim - inicio )/ 1000000.0;
        System.out.println("Tempo decorrido para Buscar o valor 1.000.001 na arvore desordenada: " + tempo + " ms");
		
		System.out.println("################################################################");
		System.out.println("Testes Arvore AVL");
		for (int valor : listaOrdenada) {
            a2.InserirValor(valor);
        }
		
		inicio = System.nanoTime();		 
		a2.BuscarValor(1000001);
        fim = System.nanoTime();
        tempo = ( fim - inicio )/ 1000000.0;
        System.out.println("Tempo decorrido para Buscar o valor 1.000.001 na arvore ordenada: " + tempo + " ms");
		
		for (int valor : listaOrdenada) {
            a2.RemoverValor(valor);
        }
		for (int valor : listaEmbaralhada) {
            a2.InserirValor(valor);
        }
		inicio = System.nanoTime();		 
		a2.BuscarValor(1000001);
        fim = System.nanoTime();
        tempo = ( fim - inicio )/ 1000000.0;
        System.out.println("Tempo decorrido para Buscar o valor 1.000.001 na arvore desordenada: " + tempo + " ms");
        
		System.out.println("################################################################");
		System.out.println("Testes Arvore B");
		for (int valor : listaOrdenada) {
            a3.InserirValor(valor);
        }
		
		inicio = System.nanoTime();		 
		a3.BuscarValor(1000001);
        fim = System.nanoTime();
        tempo = ( fim - inicio )/ 1000000.0;
        System.out.println("Tempo decorrido para Buscar o valor 1.000.001 na arvore ordenada: " + tempo + " ms");
		
		for (int valor : listaOrdenada) {
            a3.RemoverValor(valor);
        }
		for (int valor : listaEmbaralhada) {
            a3.InserirValor(valor);
        }
		inicio = System.nanoTime();		 
		a3.BuscarValor(1000001);
        fim = System.nanoTime();
        tempo = ( fim - inicio )/ 1000000.0;
        System.out.println("Tempo decorrido para Buscar o valor 1.000.001 na arvore desordenada: " + tempo + " ms");
		
	}
}
