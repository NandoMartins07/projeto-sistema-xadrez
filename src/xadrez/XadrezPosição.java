package xadrez;

import tabuleiro.Posição;

public class XadrezPosição {
	
	private char coluna;
	private int linha;
	public XadrezPosição(char coluna, int linha) {
		if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8 ){
			throw new XadrezExceção("Erro instanciando posicao. Valores validos de a1 ate h8");
		}
		this.coluna = coluna;
		this.linha = linha;
	}
	public char getColuna() {
		return coluna;
	}
	
	public int getLinha() {
		return linha;
	}
	
	protected Posição toPosição() {
		return new Posição(8 - linha, coluna - 'a');
	}
	
	protected static XadrezPosição fromPosição(Posição posição) {
		return new XadrezPosição((char)('a' + posição.getColuna()), 8 - posição.getLinha());
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
	 
	

}
