package arvores.arvoreAVL;

class No {
    public int dado, altd, alte;
    public No dir, esq;

    public No(int dado) {
        this.dado = dado;
        dir = esq = null;
        altd = alte = 0;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("No [dado=");
		builder.append(dado);
		builder.append("]");
		return builder.toString();
	}
    
    
}