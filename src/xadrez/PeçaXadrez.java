package xadrez;

import tabuleiro.Peça;
import tabuleiro.Posição;
import tabuleiro.Tabuleiro;

public abstract class PeçaXadrez extends Peça {
	
	private Cor cor;
	private int contarMovimento;

	public PeçaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	public int getContarMovimento() {
		return contarMovimento;
	}
	
	public void increContarMovimento() {
		contarMovimento++;
	}
	
	public void decreContarMovimento() {
		contarMovimento--;
	}
	
	public XadrezPosição getXadrezPosição() {
		return XadrezPosição.fromPosição(posição);
	}
	
	protected boolean peçaOponente(Posição posição) {
		PeçaXadrez p = (PeçaXadrez)getTabuleiro().peça(posição);
		return p != null && p.getCor() != cor;
	}
	
	

}
