package arvores.arvoreBinaria;

class No {
	public int chave;
	public No dir, esq;

    public No(int item) {
        this.chave = item;
        dir = esq = null;
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
