package xadrez.peças;

import tabuleiro.Posição;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PeçaXadrez;

public class Peao extends PeçaXadrez{

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] movimentoPossivel() {
			boolean[][] mat = new boolean [getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
			
			Posição p = new Posição(0, 0);
			
			if(getCor() == Cor.Branca) {
				p.setValues(posição.getLinha() - 1, posição.getColuna());
				if(getTabuleiro().posiçãoExistente(p) && !getTabuleiro().peçaExistente(p)){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
				
				p.setValues(posição.getLinha() - 2, posição.getColuna());
				Posição p2 = new Posição(posição.getLinha() - 1, posição.getColuna());
				if(getTabuleiro().posiçãoExistente(p) && !getTabuleiro().peçaExistente(p) && getTabuleiro().posiçãoExistente(p2) && !getTabuleiro().peçaExistente(p2) && getContarMovimento() == 0){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
				
				p.setValues(posição.getLinha() - 1, posição.getColuna() - 1);
				if(getTabuleiro().posiçãoExistente(p) && peçaOponente(p)){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
				
				p.setValues(posição.getLinha() - 1, posição.getColuna() + 1);
				if(getTabuleiro().posiçãoExistente(p) && peçaOponente(p)){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
			}
			else {
				p.setValues(posição.getLinha() + 1, posição.getColuna());
				if(getTabuleiro().posiçãoExistente(p) && !getTabuleiro().peçaExistente(p)){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
				
				p.setValues(posição.getLinha() + 2, posição.getColuna());
				Posição p2 = new Posição(posição.getLinha() + 1, posição.getColuna());
				if(getTabuleiro().posiçãoExistente(p) && !getTabuleiro().peçaExistente(p) && getTabuleiro().posiçãoExistente(p2) && !getTabuleiro().peçaExistente(p2) && getContarMovimento() == 0){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
				
				p.setValues(posição.getLinha() + 1, posição.getColuna() - 1);
				if(getTabuleiro().posiçãoExistente(p) && peçaOponente(p)){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
				
				p.setValues(posição.getLinha() + 1, posição.getColuna() + 1);
				if(getTabuleiro().posiçãoExistente(p) && peçaOponente(p)){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
			}
		
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "p";
	}
	

}
