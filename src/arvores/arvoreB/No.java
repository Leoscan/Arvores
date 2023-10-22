package arvores.arvoreB;

import java.util.Arrays;

public class No {
private static final int ORDEM = 4;



        int numChaves = 0;
        int chaves[] = new int[2*ORDEM-1];
        No filhos[] = new No[2*ORDEM];
        boolean folha = true;

        public No() {
            for(int i = 0; i < 2*ORDEM; i++) {
                filhos[i] = null;
            }
        }

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("No [numChaves=");
			builder.append(numChaves);
			builder.append(", chaves=");
			builder.append(Arrays.toString(chaves));
			builder.append(", filhos=");
			builder.append(Arrays.toString(filhos));
			builder.append(", folha=");
			builder.append(folha);
			builder.append("]");
			return builder.toString();
		}
        
        
    }