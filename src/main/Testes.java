package main;

import arvores.*;
import arvores.arvoreAVL.*;
import arvores.arvoreB.*;
import arvores.arvoreBinaria.*;

public class Testes {
	public static void main(String[] args) {
		
		//Teste Arvore Binaria
		System.out.println("################################################################");
		System.out.println("Testes Arvore Binaria");
		Arvore arvore_binaria = new ArvoreBinaria();
		GeraArvores a1 = new GeraArvores(arvore_binaria);
		
		//Teste Inserção
		a1.InserirValor(10);
		a1.InserirValor(12);
		a1.InserirValor(7);
		
		//Teste Impressão
		System.out.print("Ordenado: "); a1.Mostrar_Ordenado();
		
		//Teste Remoção
		a1.RemoverValor(10);
		System.out.print("Removido o valor 10: ");a1.Mostrar_Ordenado();
		
		//Teste Busca
		a1.BuscarValor(12);
		
		//Teste Arvore AVL
		System.out.println("################################################################");
		System.out.print("Testes Arvore AVL");
		Arvore arvore_AVL = new ArvoreAVL();
		GeraArvores a2 = new GeraArvores(arvore_AVL);
		
		//Teste Inserção
		a2.InserirValor(10);
		a2.InserirValor(12);
		a2.InserirValor(7);
		
		//Teste Impressão
		System.out.print("\nOrdenado: "); a2.Mostrar_Ordenado();
		
		//Teste Remoção
		a2.RemoverValor(10);
		System.out.print("\nRemovido o valor 10: ");a2.Mostrar_Ordenado();
		System.out.println();
		//Teste Busca
		a2.BuscarValor(12);
		
		
		//Teste Arvore B
		System.out.println("################################################################");
		
		System.out.print("Testes Arvore B\n");
		Arvore arvore_B = new ArvoreB();
		GeraArvores a3 = new GeraArvores(arvore_B);
		
		//Teste Inserção
		a3.InserirValor(10);
		a3.InserirValor(12);
		a3.InserirValor(7);
		
		//Teste Impressão
		System.out.print("Ordenado: "); a3.Mostrar_Ordenado();
		
		//Teste Remoção
		a3.RemoverValor(10);
		System.out.print("Removido o valor 10: ");a3.Mostrar_Ordenado();
		//Teste Busca
		a3.BuscarValor(12);
		System.out.println("################################################################");
	}
}
