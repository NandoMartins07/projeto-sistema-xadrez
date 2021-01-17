package xadrez;

import tabuleiro.Pe�a;
import tabuleiro.Posi��o;
import tabuleiro.Tabuleiro;

public abstract class Pe�aXadrez extends Pe�a {
	
	private Cor cor;
	private int contarMovimento;

	public Pe�aXadrez(Tabuleiro tabuleiro, Cor cor) {
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
	
	public XadrezPosi��o getXadrezPosi��o() {
		return XadrezPosi��o.fromPosi��o(posi��o);
	}
	
	protected boolean pe�aOponente(Posi��o posi��o) {
		Pe�aXadrez p = (Pe�aXadrez)getTabuleiro().pe�a(posi��o);
		return p != null && p.getCor() != cor;
	}
	
	

}
