package arvores;

public class GeraArvores {
	protected Arvore arvore;
	
		public GeraArvores(Arvore arvore) {
			this.arvore = arvore;
		}
		
		public void Mostrar_Ordenado() {
			arvore.Imprimir_Valores();
		}
	
		public void InserirValor(int Valor) {
			arvore.Inserir(Valor);
		}
		
		public void RemoverValor(int Valor) {
			arvore.Remover(Valor);
		}
		
		public void BuscarValor(int Valor) {
			arvore.Buscar(Valor);
		}
}