package xadrez.pe�as;

import tabuleiro.Posi��o;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.Pe�aXadrez;

public class Bispo extends Pe�aXadrez{

	public Bispo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] movimentoPossivel() {
		boolean[][] mat = new boolean [getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posi��o p = new Posi��o(0, 0);
		
		//Noroeste
		p.setValues(posi��o.getLinha() - 1, posi��o.getColuna() - 1);
		while(getTabuleiro().posi��oExistente(p) && !getTabuleiro().pe�aExistente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha() - 1, p.getColuna() - 1);
		}
		if (getTabuleiro().posi��oExistente(p) && pe�aOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Nordeste
		p.setValues(posi��o.getLinha() - 1, posi��o.getColuna() + 1);
		while(getTabuleiro().posi��oExistente(p) && !getTabuleiro().pe�aExistente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha() - 1, p.getColuna() + 1);
		}
		if (getTabuleiro().posi��oExistente(p) && pe�aOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Sudeste
		p.setValues(posi��o.getLinha() + 1, posi��o.getColuna() + 1);
		while(getTabuleiro().posi��oExistente(p) && !getTabuleiro().pe�aExistente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha() + 1, p.getColuna() + 1);
		}
		if (getTabuleiro().posi��oExistente(p) && pe�aOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Sudoeste
		p.setValues(posi��o.getLinha() + 1, posi��o.getColuna() - 1);
		while(getTabuleiro().posi��oExistente(p) && !getTabuleiro().pe�aExistente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha() + 1, p.getColuna() - 1);
		}
		if (getTabuleiro().posi��oExistente(p) && pe�aOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		
		return mat;
	}

}
