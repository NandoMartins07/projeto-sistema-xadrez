package tabuleiro;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peça[][] peças;
	
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroExceção("Erro criando tabuleiro: e necessario que haja pelo menos 1 linha e uma coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		peças = new Peça[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peça peça(int linha, int coluna) {
		if (!posiçãoExistente(linha, coluna)) {
			throw new TabuleiroExceção("Posicao nao existente");
		}
		return peças[linha][coluna];
	}
	
	public Peça peça(Posição posição) {
		if (!posiçãoExistente(posição)) {
			throw new TabuleiroExceção("Posicao nao existente");
		}
		return peças[posição.getLinha()][posição.getColuna()];
	}
	
	public void colocarPeça(Peça peça, Posição posição) {
		if (peçaExistente(posição)) {
			throw new TabuleiroExceção("Ja existe uma peca na posicao" + posição);
		}
		peças[posição.getLinha()][posição.getColuna()] = peça;
		peça.posição = posição;
	}
	
	public Peça removerPeça(Posição posição) {
		if(!posiçãoExistente(posição)) {
			throw new TabuleiroExceção("Posicao nao existente");
		}
		if (peça(posição) == null) {
			return null;
		}
		Peça aux = peça(posição);
		aux.posição = null;
		peças[posição.getLinha()][posição.getColuna()] = null;
		return aux;
	}
	
	private boolean posiçãoExistente(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas; 
	}
	
	public boolean posiçãoExistente(Posição posição) {
		return posiçãoExistente(posição.getLinha(), posição.getColuna());
		
	}
	
	public boolean peçaExistente(Posição posição) {
		if (!posiçãoExistente(posição)) {
			throw new TabuleiroExceção("Posicao nao existente");
		}
		return peça(posição) != null;
	}
	

}
