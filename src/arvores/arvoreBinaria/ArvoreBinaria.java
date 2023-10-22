package arvores.arvoreBinaria;

import arvores.Arvore;

public class ArvoreBinaria extends Arvore {
    No raiz = null;

    //public void Inserir(int chave) {
    //    raiz = inserirDado(raiz, chave);
    //}

    //private No inserirDado(No raiz, int chave) {
    //    if (raiz == null) {
    //        raiz = new No(chave);
    //        return raiz;
    //    }

    //    if (chave < raiz.chave)
    //        raiz.esq = inserirDado(raiz.esq, chave);
    //    else if (chave > raiz.chave)
    //        raiz.dir = inserirDado(raiz.dir, chave);

    //    return raiz;
    //}
    
    public void Inserir(int chave) {
        No novoNo = new No(chave);
        if (raiz == null) {
            raiz = novoNo;
            return;
        }

        No atual = raiz;
        while (true) {
            if (chave < atual.chave) {
                if (atual.esq == null) {
                    atual.esq = novoNo;
                    return;
                }
                atual = atual.esq;
            } else if (chave > atual.chave) {
                if (atual.dir == null) {
                    atual.dir = novoNo;
                    return;
                }
                atual = atual.dir;
            } else {
                // Caso a chave já exista, você pode escolher como lidar com isso (pular, substituir, etc.)
                // Neste exemplo, estamos apenas retornando sem fazer nada.
                return;
            }
        }
    }

    
     public int MaiorValor() {
        return MaiorValorRec(raiz);
    }

    private int MaiorValorRec(No raiz) {
        if (raiz == null) {
            System.out.print("Nenhum valor na Arvore");
        }

        while (raiz.dir != null) {
            raiz = raiz.dir;
        }

        return raiz.chave;
    }

    
    public int MenorValor() {
        return MenorValorRec(raiz);
    }

    private int MenorValorRec(No raiz) {
        if (raiz == null) {
            System.out.print("Nenhum valor na Arvore");
        }

        while (raiz.esq != null) {
            raiz = raiz.esq;
        }

        return raiz.chave;
    }

    
    
    
    

    public void NosFolhas() {
        NosFolhasRec(raiz);
    }
    
    
    private void NosFolhasRec(No node) {
        if (node == null) {
            return;
        }
        
        if (node.esq == null && node.dir == null) {
            System.out.print(node.chave + "; ");
        }
        
        NosFolhasRec(node.esq);
        NosFolhasRec(node.dir);
    }
    


    
        public void ancestrais(int valor) {
            if (!AncestraisRec(raiz, valor))
                System.out.println("Não foi possivel localizar o Valor: " + valor + " na árvore.");
        }
        
        private boolean AncestraisRec(No node, int valor) {
            if (node == null)
                return false;
            
            if (node.chave == valor)
                return true;
            
            if (AncestraisRec(node.esq, valor) || AncestraisRec(node.dir, valor)) {
                System.out.print(node.chave + "; ");
                return true;
            }
            
            return false;
        }
        
        
        public void Buscar(int chave) {
            System.out.println(buscarNaArvore(raiz, chave));
        }

        private No buscarNaArvore(No node, int chave) {
            if (node == null || node.chave == chave) {
                return node;
            }

            if (chave < node.chave) {
                return buscarNaArvore(node.esq, chave);
            } else {
                return buscarNaArvore(node.dir, chave);
            }
        }

        public void Descendentes(int valor) {
            No node = buscarNaArvore(raiz, valor);
            if (node == null) {
                System.out.println("Nó não encontrado na árvore");
            } else {
                DescendentesRec(node);
            }
        }
        
        private void DescendentesRec(No node) {
            if (node != null) {
                System.out.print(node.chave + "; ");
                DescendentesRec(node.esq);
                DescendentesRec(node.dir);
            }
        
        }
        
        //public void Imprimir_Valores() {
        //    imprimirArvoreRec(raiz);
        //    System.out.println();
        //}

        public void Imprimir_Valores() {
            No atual = raiz;
            No anterior;

            while (atual != null) {
                if (atual.esq == null) {
                    System.out.print(atual.chave + " ");
                    atual = atual.dir;
                } else {
                    anterior = atual.esq;
                    while (anterior.dir != null && anterior.dir != atual) {
                        anterior = anterior.dir;
                    }

                    if (anterior.dir == null) {
                        anterior.dir = atual;
                        atual = atual.esq;
                    } else {
                        anterior.dir = null;
                        System.out.print(atual.chave + " ");
                        atual = atual.dir;
                    }
                }
            }

            System.out.println();
        }


        
        private void imprimirArvoreRec(No node) {
            if (node != null) {
                imprimirArvoreRec(node.esq);
                System.out.print(node.chave + " ");
                imprimirArvoreRec(node.dir);
            }
        }
        
        // Subárvore da direita de um nó
        

        public void SubarvoreDireita(int chave) {
            No node = buscarNaArvore(raiz, chave);
            if (node == null) {
                System.out.println("Nó não encontrado na árvore");
            } else {
                SubarvoreRec(node.dir);
            }
        }

        
        private void SubarvoreRec(No node) {
            if (node != null) {
                System.out.print(node.chave + " ");
                SubarvoreRec(node.dir);
                SubarvoreRec(node.esq);
            }
        }
        public void SubarvoreEsquerda(int chave) {
            No node = buscarNaArvore(raiz, chave);
            if (node == null) {
                System.out.println("Nó não encontrado na árvore");
            } else {
                SubarvoreRec(node.esq);
            }
        }


        
         // Mostrar somente os números pares
        public void NumerosPares() {
            NumerosParesRec(raiz);
        }

        private void NumerosParesRec(No node) {
            if (node != null) {
                NumerosParesRec(node.esq);
                if (node.chave % 2 == 0) {
                    System.out.print(node.chave + "; ");
                }
                NumerosParesRec(node.dir);
            }
        }
        
        
        public int nivelDoNo(int valor) {
            return nivelDoNoRec(raiz, valor, 0);
        }

        private int nivelDoNoRec(No node, int valor, int nivelAtual) {
            if (node == null) {
              return -1;
            }

            if (node.chave == valor) {
                return nivelAtual;
            }

            int nivelEsquerda = nivelDoNoRec(node.esq, valor, nivelAtual + 1);
            if (nivelEsquerda != -1) {
                return nivelEsquerda;
            }

            return nivelDoNoRec(node.dir, valor, nivelAtual + 1);
        }

        
        
        
        public int altura() {
            return AlturaRec(raiz);
        }

        private int AlturaRec(No node) {
            if (node == null) return -1; 

            int alturaEsquerda = AlturaRec(node.esq);
            int alturaDireita = AlturaRec(node.dir);

            return Math.max(alturaEsquerda, alturaDireita) + 1;
        }


        
        
        public int tamanho() {
            return TamanhoRec(raiz);
        }

        private int TamanhoRec(No node) {
            if (node == null) return 0;

            return 1 + TamanhoRec(node.esq) + TamanhoRec(node.dir);
        }


        
        
        public void inserirNaoRecursivo(int chave) {
            No novoNo = new No(chave);
            if (raiz == null) {
                raiz = novoNo;
                return;
            }

            No atual = raiz;
            No anterior = null;

            while (atual != null) {
                anterior = atual;
                if (chave < atual.chave) {
                    atual = atual.esq;
                } else {
                    atual = atual.dir;
                }
            }

            if (chave < anterior.chave) {
                anterior.esq = novoNo;
            } else {
                anterior.dir = novoNo;
            }
        }
        
        public void Remover(int chave) {
            raiz = removerRec(raiz, chave);
        }

        private No removerRec(No raiz, int chave) {
            if (raiz == null) {
                return raiz; // Árvore vazia ou nó não encontrado.
            }

            if (chave < raiz.chave) {
                raiz.esq = removerRec(raiz.esq, chave);
            } else if (chave > raiz.chave) {
                raiz.dir = removerRec(raiz.dir, chave);
            } else {
                // Caso 1: Nó folha ou caso 2: Nó com um filho
                if (raiz.esq == null) {
                    return raiz.dir;
                } else if (raiz.dir == null) {
                    return raiz.esq;
                }

                // Caso 3: Nó com dois filhos
                raiz.chave = menorValor(raiz.dir);
                raiz.dir = removerRec(raiz.dir, raiz.chave);
            }

            return raiz;
        }

        private int menorValor(No No) {
            int valorMinimo = No.chave;
            while (No.esq != null) {
                valorMinimo = No.esq.chave;
                No = No.esq;
            }
            return valorMinimo;
        }

}
