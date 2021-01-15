package xadrez;

import tabuleiro.Peça;
import tabuleiro.Posição;
import tabuleiro.Tabuleiro;

public abstract class PeçaXadrez extends Peça {
	
	private Cor cor;

	public PeçaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	public XadrezPosição getXadrezPosição() {
		return XadrezPosição.fromPosição(posição);
	}
	
	protected boolean peçaOponente(Posição posição) {
		PeçaXadrez p = (PeçaXadrez)getTabuleiro().peça(posição);
		return p != null && p.getCor() != cor;
	}
	
	

}
