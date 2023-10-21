package main;

import arvores.*;
import arvores.arvoreAVL.*;
import arvores.arvoreB.*;
import arvores.arvoreBinaria.*;

public class Main {
	public static void main(String[] args) {
	
		//Arvore arvore_binaria = new ArvoreB(3);
		Arvore arvore_binaria = new ArvoreAVL();
		GeraArvores a1 = new GeraArvores(arvore_binaria);
		
		a1.InserirValor(10);
		a1.InserirValor(12);
		a1.InserirValor(7);
		a1.InserirValor(3);
		a1.InserirValor(40);
		a1.InserirValor(41);
		a1.InserirValor(42);
		a1.Mostrar_Ordenado();
		a1.RemoverValor(10);
		a1.Mostrar_Ordenado();
		a1.BuscarValor(12);
	}
}
