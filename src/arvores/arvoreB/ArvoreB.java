package arvores.arvoreB;

import arvores.Arvore;

public class ArvoreB extends Arvore {
    private static final int ORDEM = 4;
    private No raiz;


    public ArvoreB() {
        raiz = new No();
    }

    public void Buscar(int chave) {
        System.out.println(buscaInterna(raiz, chave));
    }

    private No buscaInterna(No x, int chave) {
        int i = 0;
        while (i < x.numChaves && chave > x.chaves[i]) {
            i++;
        }
        if (i < x.numChaves && chave == x.chaves[i]) {
            return x;
        } else if (x.folha) {
            return null;
        } else {
            return buscaInterna(x.filhos[i], chave);
        }
    }

    public void Inserir(int chave) {
        if (raiz == null) {
            raiz = new No();
        }
        No r = raiz;
        if (r.numChaves == 2*ORDEM-1) {
            No s = new No();
            raiz = s;
            s.folha = false;
            s.numChaves = 0;
            s.filhos[0] = r;
            splitChild(s, 1, r);
            insereNaoCompleto(s, chave);
        } else {
            insereNaoCompleto(r, chave);
        }
    }

    private void insereNaoCompleto(No x, int chave) {
        int i = x.numChaves-1;
        if (x.folha) {
            x.numChaves++;
            while (i >= 0 && chave < x.chaves[i]) {
                x.chaves[i+1] = x.chaves[i];
                i--;
            }
            x.chaves[i+1] = chave;
        } else {
            while (i >= 0 && chave < x.chaves[i]) {
                i--;
            }
            i++;
            if (x.filhos[i].numChaves == 2*ORDEM-1) {
                splitChild(x, i+1, x.filhos[i]);
                if (chave > x.chaves[i]) {
                    i++;
                }
            }
            insereNaoCompleto(x.filhos[i], chave);
        }
    }

    private void splitChild(No x, int i, No y) {
        No z = new No();
        z.folha = y.folha;
        z.numChaves = ORDEM - 1;
        for (int j = 0; j < ORDEM-1; j++) {
            z.chaves[j] = y.chaves[j+ORDEM];
        }
        if (!y.folha) {
            for (int j = 0; j < ORDEM; j++) {
                z.filhos[j] = y.filhos[j+ORDEM];
            }
        }
        y.numChaves = ORDEM - 1;
        for (int j = x.numChaves; j >= i; j--) {
            x.chaves[j] = x.chaves[j-1];
            x.filhos[j+1] = x.filhos[j];
        }
        x.chaves[i-1] = y.chaves[ORDEM-1];
        x.filhos[i] = z;
        x.numChaves++;
    }
    
    public void Imprimir_Valores() {
        imprimirEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void imprimirEmOrdemRecursivo(No x) {
        if (x == null) {
            return;
        }

        int i;
        for (i = 0; i < x.numChaves; i++) {
            // Se este nó não é uma folha, imprima o subárvore do filho[i] antes de imprimir a chave x[i]
            if (!x.folha) {
                imprimirEmOrdemRecursivo(x.filhos[i]);
            }
            System.out.print(x.chaves[i] + " ");
        }

        // Imprima o subárvore do último filho, se o nó não for uma folha
        if (!x.folha) {
            imprimirEmOrdemRecursivo(x.filhos[i]);
        }
    }
    
    
    public void Remover(int chave) {
        removerRecursivo(raiz, chave);

        // Reduzir a altura se a raiz ficar vazia
        if (raiz.numChaves == 0) {
            No tmp = raiz;
            if (raiz.folha) {
                raiz = null;
            } else {
                raiz = raiz.filhos[0];
            }
            tmp = null; // Ajudar no GC, liberar o nó
        }
    }

    private void removerRecursivo(No x, int chave) {
        int idx = 0;
        while (idx < x.numChaves && chave > x.chaves[idx]) {
            idx++;
        }

        if (idx < x.numChaves && chave == x.chaves[idx]) {
            // A chave está no nó x
            if (x.folha) {
                // Caso 1: Se x é folha
                for (int j = idx; j < x.numChaves - 1; j++) {
                    x.chaves[j] = x.chaves[j + 1];
                }
                x.numChaves--;
            } else {
                // Caso 2: Se x é nó interno
                // (aqui, você deve implementar os métodos getPredecessor e getSucessor para obter o predecessor ou sucessor da chave, e então fazer as operações de remoção/combinação adequadas)
                // ... (omitted for brevity)
            }
        } else {
            // A chave não está no nó x, desça
            if (x.folha) {
                return; // A chave não está na árvore
            }

            boolean flag = ((idx == x.numChaves) ? true : false);

            if (x.filhos[idx].numChaves < ORDEM) {
                ajustarNó(x, idx);
            }

            if (flag && idx > x.numChaves) {
                removerRecursivo(x.filhos[idx - 1], chave);
            } else {
                removerRecursivo(x.filhos[idx], chave);
            }
        }
    }

    // Método para tratar o caso quando o filho filhos[idx] tem ORDEM-1 chaves
    private void ajustarNó(No x, int idx) {
        if (idx != 0 && x.filhos[idx - 1].numChaves >= ORDEM) {
            pegarAnterior(x, idx);
        } else if (idx != x.numChaves && x.filhos[idx + 1].numChaves >= ORDEM) {
            pegarProximo(x, idx);
        } else {
            if (idx != x.numChaves) {
                combinar(x, idx);
            } else {
                combinar(x, idx - 1);
            }
        }
    }
    private void pegarProximo(No x, int idx) {
        No filho = x.filhos[idx];
        No irmão = x.filhos[idx+1];

        filho.chaves[(filho.numChaves)] = x.chaves[idx];

        if (!(filho.folha)) {
            filho.filhos[(filho.numChaves)+1] = irmão.filhos[0];
        }

        x.chaves[idx] = irmão.chaves[0];

        for (int i = 1; i < irmão.numChaves; ++i) {
            irmão.chaves[i-1] = irmão.chaves[i];
        }

        if (!irmão.folha) {
            for (int i = 1; i <= irmão.numChaves; ++i) {
                irmão.filhos[i-1] = irmão.filhos[i];
            }
        }

        filho.numChaves += 1;
        irmão.numChaves -= 1;
    }

    
    private void combinar(No x, int idx) {
        No filho = x.filhos[idx];
        No irmão = x.filhos[idx+1];

        filho.chaves[ORDEM-1] = x.chaves[idx];

        for (int i = 0; i < irmão.numChaves; ++i) {
            filho.chaves[i+ORDEM] = irmão.chaves[i];
        }

        if (!filho.folha) {
            for (int i = 0; i <= irmão.numChaves; ++i) {
                filho.filhos[i+ORDEM] = irmão.filhos[i];
            }
        }

        for (int i = idx + 1; i < x.numChaves; ++i) {
            x.chaves[i-1] = x.chaves[i];
        }

        for (int i = idx + 2; i <= x.numChaves; ++i) {
            x.filhos[i-1] = x.filhos[i];
        }

        filho.numChaves += irmão.numChaves + 1;
        x.numChaves--;

        irmão = null;  // Liberar o irmão para coleta de lixo
    }

    private void pegarAnterior(No x, int idx) {
        No filhoAtual = x.filhos[idx];
        No irmãoEsquerdo = x.filhos[idx - 1];

        // Mover todos os elementos do filhoAtual uma posição à direita
        for (int i = filhoAtual.numChaves - 1; i >= 0; i--) {
            filhoAtual.chaves[i + 1] = filhoAtual.chaves[i];
        }

        // Se filhoAtual não é folha, mover todos os ponteiros de filho uma posição à direita
        if (!filhoAtual.folha) {
            for (int i = filhoAtual.numChaves; i >= 0; i--) {
                filhoAtual.filhos[i + 1] = filhoAtual.filhos[i];
            }
        }

        // Copiando a chave do nó pai para a posição [0] do filhoAtual
        filhoAtual.chaves[0] = x.chaves[idx - 1];

        // Movendo a última chave do irmãoEsquerdo para o nó pai
        x.chaves[idx - 1] = irmãoEsquerdo.chaves[irmãoEsquerdo.numChaves - 1];

        // Movendo o último filho do irmãoEsquerdo para a primeira posição de filhos de filhoAtual
        if (!filhoAtual.folha) {
            filhoAtual.filhos[0] = irmãoEsquerdo.filhos[irmãoEsquerdo.numChaves];
        }

        filhoAtual.numChaves++;
        irmãoEsquerdo.numChaves--;
    }


}
