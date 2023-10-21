package arvores.arvoreAVL;

import arvores.Arvore;

public class ArvoreAVL extends Arvore {
    No raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    public void Inserir(int dado) {
        raiz = inserirDado(raiz, dado);
    }

    private No inserirDado(No raiz, int dado) {
        if (raiz == null) {
            raiz = new No(dado);
            return raiz;
        }
        if (dado < raiz.dado) {
            raiz.esq = inserirDado(raiz.esq, dado);
        } else if (dado > raiz.dado) {
            raiz.dir = inserirDado(raiz.dir, dado);
        }
        raiz.alte = altura(raiz.esq);
        raiz.altd = altura(raiz.dir);
        return balanceamento(raiz);
    }

    private int altura(No No) {
        if (No == null) {
            return 0;
        }
        return Math.max(No.alte, No.altd) + 1;
    }

    public No balanceamento(No raiz) {
        if (raiz == null) {
            return null;
        }
        
        int diff = altura(raiz.dir) - altura(raiz.esq);

        if (diff > 1) {
            int subArv = altura(raiz.dir.dir) - altura(raiz.dir.esq);
            if (subArv < 0) {
                raiz.dir = rotacao_direita(raiz.dir);
            }
            return rotacao_esquerda(raiz);
        } else if (diff < -1) {
            int subArv = altura(raiz.esq.dir) - altura(raiz.esq.esq);
            if (subArv > 0) {
                raiz.esq = rotacao_esquerda(raiz.esq);
            }
            return rotacao_direita(raiz);
        }

        return raiz;
    }

    private No rotacao_esquerda(No raiz) {
    	No aux1 = raiz.dir;
    	No aux2 = aux1.esq;
        raiz.dir = aux2;
        aux1.esq = raiz;
        raiz.alte = Math.max(altura(raiz.esq), altura(raiz.dir)) + 1;
        aux1.altd = Math.max(altura(aux1.dir), altura(aux1.esq)) + 1;
        return aux1;
    }

    private No rotacao_direita(No raiz) {
    	No aux1 = raiz.esq;
    	No aux2 = aux1.dir;
        raiz.esq = aux2;
        aux1.dir = raiz;
        raiz.alte = Math.max(altura(raiz.esq), altura(raiz.dir)) + 1;
        aux1.altd = Math.max(altura(aux1.dir), altura(aux1.esq)) + 1;
        return aux1;
    }

    public void Imprimir_Valores() {
        mostrandoOrdenado(raiz);
    }

    public void mostrandoOrdenado(No raiz) {
        if (raiz != null) {
            mostrandoOrdenado(raiz.esq);
            System.out.print(raiz.dado + "; ");
            mostrandoOrdenado(raiz.dir);
        }
    }
    
    
    
    public void Buscar(int dado) {
        System.out.println(buscarNaArvore(raiz, dado));
    }

    private No buscarNaArvore(No raiz, int dado) {
        if (raiz == null) {
            return null; // O elemento não foi encontrado na árvore.
        }

        if (dado == raiz.dado) {
            return raiz; // Retorna o No onde o elemento foi encontrado.
        }

        if (dado < raiz.dado) {
            return buscarNaArvore(raiz.esq, dado); // Buscar na subárvore esquerda.
        } else {
            return buscarNaArvore(raiz.dir, dado); // Buscar na subárvore direita.
        }
    }
    
    public void Remover(int dado) {
        raiz = removerDado(raiz, dado);
    }

    private No removerDado(No raiz, int dado) {
        if (raiz == null) return raiz;

        if (dado < raiz.dado) {
            raiz.esq = removerDado(raiz.esq, dado);
        } else if (dado > raiz.dado) {
            raiz.dir = removerDado(raiz.dir, dado);
        } else {
            if (raiz.esq == null || raiz.dir == null) {
                No temp = (raiz.esq != null) ? raiz.esq : raiz.dir;
                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else {
                    raiz = temp;
                }
            } else {
                No temp = NoMinimo(raiz.dir);
                raiz.dado = temp.dado;
                raiz.dir = removerDado(raiz.dir, temp.dado);
            }
        }
        if (raiz == null) return raiz;
        raiz.alte = altura(raiz.esq);
        raiz.altd = altura(raiz.dir);
        return balanceamento(raiz);
    }

    private No NoMinimo(No No) {
        No atual = No;
        while (atual.esq != null) {
            atual = atual.esq;
        }
        return atual;
    }

}
