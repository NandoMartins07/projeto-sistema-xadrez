package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tabuleiro.Pe�a;
import tabuleiro.Posi��o;
import tabuleiro.Tabuleiro;
import xadrez.pe�as.Rei;
import xadrez.pe�as.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	private int turno;
	private Cor jogadorAtual;
	private boolean check;
	
	private List<Pe�a> pe�aNoTabuleiro = new ArrayList<>();
	private List<Pe�a> pe�asCapituradas = new ArrayList<>();
	
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadorAtual = Cor.Branca;
		iniciarPartida();
	}
	
	public int getTurno() {
		return turno;
	}
	
	public Cor getJogadorAtual() {
		return jogadorAtual;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	
	
	public Pe�aXadrez[][] getPe�as(){
		Pe�aXadrez[][] mat = new Pe�aXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i=0; i<tabuleiro.getLinhas(); i++) {
			for (int j=0; j<tabuleiro.getColunas(); j++) {
				mat[i][j] = (Pe�aXadrez)tabuleiro.pe�a(i, j);
			}
		}
		return mat;
	}
	
	public boolean[][] movimentoPossivel(XadrezPosi��o origemPosi��o){
		Posi��o posi��o = origemPosi��o.toPosi��o();
		validarOrigemPosi��o(posi��o);
		return tabuleiro.pe�a(posi��o).movimentoPossivel();
	}
	
	public Pe�aXadrez executarMovXadrez(XadrezPosi��o origemPosi��o, XadrezPosi��o destinoPosi��o) {
		Posi��o origem = origemPosi��o.toPosi��o();
		Posi��o destino = destinoPosi��o.toPosi��o();
		validarOrigemPosi��o(origem);
		validarDestinoPosi��o(origem, destino);
		Pe�a capituraPe�a = fazerMover(origem, destino);
		
		if (testeCheck(jogadorAtual)) {
			desfazerMover(origem, destino, capituraPe�a);
			throw new XadrezExce��o("Voc� n�o pode se colocar em check");
		}
		
		check = (testeCheck(oponente(jogadorAtual))) ? true : false;
		
		proximoTurno();
		return (Pe�aXadrez)capituraPe�a;
	}
	
	private Pe�a fazerMover(Posi��o origem, Posi��o destino) {
		Pe�a p = tabuleiro.removerPe�a(origem);
		Pe�a capituraPe�a = tabuleiro.removerPe�a(destino);
		tabuleiro.colocarPe�a(p, destino);
		
		if (capituraPe�a != null) {
			pe�aNoTabuleiro.remove(capituraPe�a);
			pe�asCapituradas.add(capituraPe�a);
		}
		return capituraPe�a;
	}
	
	private void desfazerMover(Posi��o origem, Posi��o destino, Pe�a capituraPe�a) {
		Pe�a p = tabuleiro.removerPe�a(destino);
		tabuleiro.colocarPe�a(p,origem);
		
		if (capituraPe�a != null) {
			tabuleiro.colocarPe�a(capituraPe�a, destino);
			pe�asCapituradas.remove(capituraPe�a);
			pe�aNoTabuleiro.add(capituraPe�a);
		}
	}
	
	private void validarOrigemPosi��o(Posi��o posi��o) {
		if (!tabuleiro.pe�aExistente(posi��o)) {
			throw new XadrezExce��o("N�o existe pe�a na posi��o de origem");
		}
		
		if (jogadorAtual != ((Pe�aXadrez) tabuleiro.pe�a(posi��o)).getCor()){
			throw new XadrezExce��o("A pe�a escolhida n�o � sua");
		}
		if (!tabuleiro.pe�a(posi��o).movimentoPossivel2()){
			throw new XadrezExce��o("N�o existe movimento possivel para a pe�a escolhida");
		}
	}
	
	private void validarDestinoPosi��o(Posi��o origem, Posi��o destino) {
		if (!tabuleiro.pe�a(origem).movimentoPossivel(destino)) {
			throw new XadrezExce��o("A pe�a escolhida n�o pode se mover para a posi��o de destino");
		}
	}
	
	private void proximoTurno() {
		turno ++;
		jogadorAtual = (jogadorAtual == Cor.Branca) ? Cor.Preta: Cor.Branca;
	}
	
	private Cor oponente(Cor cor) {
		return (cor == cor.Branca) ? Cor.Preta : Cor.Branca;
	}
	
	private Pe�aXadrez rei(Cor cor) {
		List<Pe�a> list = pe�aNoTabuleiro.stream().filter(x ->((Pe�aXadrez)x).getCor() == cor).collect(Collectors.toList());
		for(Pe�a p : list) {
			if (p instanceof Rei) {
				return (Pe�aXadrez)p;
			}
		}
		throw new IllegalStateException("N�o existe o rei da" + cor + "no tabuleiro");
	}
	
	private boolean testeCheck(Cor cor) {
		Posi��o reiPosi��o = rei(cor).getXadrezPosi��o().toPosi��o();
		List<Pe�a> oponentePe�as = pe�aNoTabuleiro.stream().filter(x ->((Pe�aXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());
		for(Pe�a p : oponentePe�as) {
			boolean[][] mat = p.movimentoPossivel();
			if (mat[reiPosi��o.getLinha()][reiPosi��o.getColuna()]) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	private void colocarNovaPe�a(char coluna, int linha, Pe�aXadrez pe�a) {
		tabuleiro.colocarPe�a(pe�a, new XadrezPosi��o(coluna, linha).toPosi��o());
		pe�aNoTabuleiro.add(pe�a);
	}
	
	private void iniciarPartida() {
		
		colocarNovaPe�a('c', 1, new Torre(tabuleiro, Cor.Branca));
		colocarNovaPe�a('c', 2, new Torre(tabuleiro, Cor.Branca));
		colocarNovaPe�a('d', 2, new Torre(tabuleiro, Cor.Branca));
		colocarNovaPe�a('e', 2, new Torre(tabuleiro, Cor.Branca));
		colocarNovaPe�a('e', 1, new Torre(tabuleiro, Cor.Branca));
		colocarNovaPe�a('d', 1, new Rei(tabuleiro, Cor.Branca));

		colocarNovaPe�a('c', 7, new Torre(tabuleiro, Cor.Preta));
		colocarNovaPe�a('c', 8, new Torre(tabuleiro, Cor.Preta));
		colocarNovaPe�a('d', 7, new Torre(tabuleiro, Cor.Preta));
		colocarNovaPe�a('e', 7, new Torre(tabuleiro, Cor.Preta));
		colocarNovaPe�a('e', 8, new Torre(tabuleiro, Cor.Preta));
		colocarNovaPe�a('d', 8, new Rei(tabuleiro, Cor.Preta));
	}

}
