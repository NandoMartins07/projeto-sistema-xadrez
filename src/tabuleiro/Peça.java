package tabuleiro;

public abstract class Peça {
	
	protected Posição posição;
	private Tabuleiro tabuleiro;
	
	public Peça(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posição = null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public abstract boolean[][] movimentoPossivel();
	
	public boolean movimentoPossivel(Posição posição) {
		return movimentoPossivel()[posição.getLinha()][posição.getColuna()];
	}
	
	//indica se existe algum movimento possivel, se a peça não estar travada
	public boolean movimentoPossivel2() {
		boolean [][] mat = movimentoPossivel();
		for (int i = 0; i <mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	

}
