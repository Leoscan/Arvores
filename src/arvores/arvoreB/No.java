package arvores.arvoreB;

import java.util.Vector;

public class No {

    private int n; 
    private Vector<Integer> chave;
    private Vector<No> filho;
    private boolean folha;
    private int larguraFilho;            
    final int DIFERENCA_ALTURA = 30;
    final int DIFERENCA_IRMAOS = 5;

    public No(int n) {
        this.chave = new Vector<Integer>(n - 1);
        for (int i = 0; i < n - 1; i++) {
            this.chave.add(null);
        }
        this.filho = new Vector<No>(n);
        for (int i = 0; i < n; i++) {
            this.filho.add(null);
        }
        this.folha = true;
        this.n = 0;
    }

    public Vector<Integer> getChave() {
        return chave;
    }

    public void setChave(Vector<Integer> chave) {
        this.chave = chave;
    }

    public Vector<No> getFilho() {
        return filho;
    }

    public void setFilho(Vector<No> filho) {
        this.filho = filho;
    }

    public boolean isFolha() {
        return folha;
    }

    public void setFolha(boolean folha) {
        this.folha = folha;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int computeSize() {
        return n * 28 + 12;
    }


     public int UpdateLFilho() {
        larguraFilho = 0;
        if (!folha) {
            for (int i = 0; i < n + 1; i++) {
                larguraFilho += filho.get(i).UpdateLFilho();
            }
        } else {
            larguraFilho = computeSize() + DIFERENCA_IRMAOS;
        }
        return larguraFilho;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("No [chave=");
		builder.append(chave);
		builder.append("]");
		return builder.toString();
	}
     
    
}