package xadrez.peças;

import tabuleiro.Posição;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PeçaXadrez;

public class Rei extends PeçaXadrez{

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	private boolean podeMover(Posição posição) {
		PeçaXadrez p = (PeçaXadrez)getTabuleiro().peça(posição);
		return p == null || p.getCor() != getCor();
	}

	@Override
	public boolean[][] movimentoPossivel() {
		boolean[][] mat = new boolean [getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posição p = new Posição(0, 0);
		
		//testar acima
		p.setValues(posição.getLinha() - 1, posição.getColuna());
		if (getTabuleiro().posiçãoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar abaixo
		
		p.setValues(posição.getLinha() + 1, posição.getColuna());
		if (getTabuleiro().posiçãoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar a esquerda
		
		p.setValues(posição.getLinha(), posição.getColuna() - 1);
		if (getTabuleiro().posiçãoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar a direita
		
		p.setValues(posição.getLinha(), posição.getColuna() + 1);
		if (getTabuleiro().posiçãoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar o noroeste
		
		p.setValues(posição.getLinha() - 1, posição.getColuna() - 1);
		if (getTabuleiro().posiçãoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar nordeste
		
		p.setValues(posição.getLinha() - 1, posição.getColuna() + 1);
		if (getTabuleiro().posiçãoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar sudoeste
		
		p.setValues(posição.getLinha() + 1, posição.getColuna() - 1);
		if (getTabuleiro().posiçãoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//testar sudeste
		
		p.setValues(posição.getLinha() + 1, posição.getColuna() + 1);
		if (getTabuleiro().posiçãoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		return mat;
	}
	

}
