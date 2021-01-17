package xadrez.pe�as;

import tabuleiro.Posi��o;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.Pe�aXadrez;

public class Peao extends Pe�aXadrez{

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] movimentoPossivel() {
			boolean[][] mat = new boolean [getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
			
			Posi��o p = new Posi��o(0, 0);
			
			if(getCor() == Cor.Branca) {
				p.setValues(posi��o.getLinha() - 1, posi��o.getColuna());
				if(getTabuleiro().posi��oExistente(p) && !getTabuleiro().pe�aExistente(p)){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
				
				p.setValues(posi��o.getLinha() - 2, posi��o.getColuna());
				Posi��o p2 = new Posi��o(posi��o.getLinha() - 1, posi��o.getColuna());
				if(getTabuleiro().posi��oExistente(p) && !getTabuleiro().pe�aExistente(p) && getTabuleiro().posi��oExistente(p2) && !getTabuleiro().pe�aExistente(p2) && getContarMovimento() == 0){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
				
				p.setValues(posi��o.getLinha() - 1, posi��o.getColuna() - 1);
				if(getTabuleiro().posi��oExistente(p) && pe�aOponente(p)){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
				
				p.setValues(posi��o.getLinha() - 1, posi��o.getColuna() + 1);
				if(getTabuleiro().posi��oExistente(p) && pe�aOponente(p)){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
			}
			else {
				p.setValues(posi��o.getLinha() + 1, posi��o.getColuna());
				if(getTabuleiro().posi��oExistente(p) && !getTabuleiro().pe�aExistente(p)){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
				
				p.setValues(posi��o.getLinha() + 2, posi��o.getColuna());
				Posi��o p2 = new Posi��o(posi��o.getLinha() + 1, posi��o.getColuna());
				if(getTabuleiro().posi��oExistente(p) && !getTabuleiro().pe�aExistente(p) && getTabuleiro().posi��oExistente(p2) && !getTabuleiro().pe�aExistente(p2) && getContarMovimento() == 0){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
				
				p.setValues(posi��o.getLinha() + 1, posi��o.getColuna() - 1);
				if(getTabuleiro().posi��oExistente(p) && pe�aOponente(p)){
					mat[p.getLinha()][p.getColuna()] = true;
					
				}
				
				p.setValues(posi��o.getLinha() + 1, posi��o.getColuna() + 1);
				if(getTabuleiro().posi��oExistente(p) && pe�aOponente(p)){
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
