package xadrez.peças;

import tabuleiro.Posição;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PeçaXadrez;

public class Dama extends PeçaXadrez{

	public Dama(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "D";
	}
	
	@Override
	public boolean[][] movimentoPossivel() {
		boolean[][] mat = new boolean [getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posição p = new Posição(0, 0);
		
		//Pra Cima
		p.setValues(posição.getLinha() - 1, posição.getColuna());
		while(getTabuleiro().posiçãoExistente(p) && !getTabuleiro().peçaExistente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getTabuleiro().posiçãoExistente(p) && peçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Pra esquerda
		p.setValues(posição.getLinha(), posição.getColuna() - 1);
		while(getTabuleiro().posiçãoExistente(p) && !getTabuleiro().peçaExistente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if (getTabuleiro().posiçãoExistente(p) && peçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Pra direita
		p.setValues(posição.getLinha(), posição.getColuna() + 1);
		while(getTabuleiro().posiçãoExistente(p) && !getTabuleiro().peçaExistente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if (getTabuleiro().posiçãoExistente(p) && peçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Pra baixo
		p.setValues(posição.getLinha() + 1, posição.getColuna());
		while(getTabuleiro().posiçãoExistente(p) && !getTabuleiro().peçaExistente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if (getTabuleiro().posiçãoExistente(p) && peçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Noroeste
				p.setValues(posição.getLinha() - 1, posição.getColuna() - 1);
				while(getTabuleiro().posiçãoExistente(p) && !getTabuleiro().peçaExistente(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
					p.setValues(p.getLinha() - 1, p.getColuna() - 1);
				}
				if (getTabuleiro().posiçãoExistente(p) && peçaOponente(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
				
				//Nordeste
				p.setValues(posição.getLinha() - 1, posição.getColuna() + 1);
				while(getTabuleiro().posiçãoExistente(p) && !getTabuleiro().peçaExistente(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
					p.setValues(p.getLinha() - 1, p.getColuna() + 1);
				}
				if (getTabuleiro().posiçãoExistente(p) && peçaOponente(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
				
				//Sudeste
				p.setValues(posição.getLinha() + 1, posição.getColuna() + 1);
				while(getTabuleiro().posiçãoExistente(p) && !getTabuleiro().peçaExistente(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
					p.setValues(p.getLinha() + 1, p.getColuna() + 1);
				}
				if (getTabuleiro().posiçãoExistente(p) && peçaOponente(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
				
				//Sudoeste
				p.setValues(posição.getLinha() + 1, posição.getColuna() - 1);
				while(getTabuleiro().posiçãoExistente(p) && !getTabuleiro().peçaExistente(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
					p.setValues(p.getLinha() + 1, p.getColuna() - 1);
				}
				if (getTabuleiro().posiçãoExistente(p) && peçaOponente(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
		
		return mat;
	}

}
