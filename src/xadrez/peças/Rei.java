package xadrez.pe�as;

import tabuleiro.Posi��o;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.Pe�aXadrez;

public class Rei extends Pe�aXadrez{

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	private boolean podeMover(Posi��o posi��o) {
		Pe�aXadrez p = (Pe�aXadrez)getTabuleiro().pe�a(posi��o);
		return p == null || p.getCor() != getCor();
	}

	@Override
	public boolean[][] movimentoPossivel() {
		boolean[][] mat = new boolean [getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posi��o p = new Posi��o(0, 0);
		
		//testar acima
		p.setValues(posi��o.getLinha() - 1, posi��o.getColuna());
		if (getTabuleiro().posi��oExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar abaixo
		
		p.setValues(posi��o.getLinha() + 1, posi��o.getColuna());
		if (getTabuleiro().posi��oExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar a esquerda
		
		p.setValues(posi��o.getLinha(), posi��o.getColuna() - 1);
		if (getTabuleiro().posi��oExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar a direita
		
		p.setValues(posi��o.getLinha(), posi��o.getColuna() + 1);
		if (getTabuleiro().posi��oExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar o noroeste
		
		p.setValues(posi��o.getLinha() - 1, posi��o.getColuna() - 1);
		if (getTabuleiro().posi��oExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar nordeste
		
		p.setValues(posi��o.getLinha() - 1, posi��o.getColuna() + 1);
		if (getTabuleiro().posi��oExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar sudoeste
		
		p.setValues(posi��o.getLinha() + 1, posi��o.getColuna() - 1);
		if (getTabuleiro().posi��oExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar sudeste
		
		p.setValues(posi��o.getLinha() + 1, posi��o.getColuna() + 1);
		if (getTabuleiro().posi��oExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		return mat;
	}
	

}
