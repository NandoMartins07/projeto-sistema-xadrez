package xadrez;

import java.util.ArrayList;
import java.util.List;

import tabuleiro.Peça;
import tabuleiro.Posição;
import tabuleiro.Tabuleiro;
import xadrez.peças.Rei;
import xadrez.peças.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	private int turno;
	private Cor jogadorAtual;
	
	private List<Peça> peçaNoTabuleiro = new ArrayList<>();
	private List<Peça> peçasCapituradas = new ArrayList<>();
	
	
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
	
	public PeçaXadrez[][] getPeças(){
		PeçaXadrez[][] mat = new PeçaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i=0; i<tabuleiro.getLinhas(); i++) {
			for (int j=0; j<tabuleiro.getColunas(); j++) {
				mat[i][j] = (PeçaXadrez)tabuleiro.peça(i, j);
			}
		}
		return mat;
	}
	
	public boolean[][] movimentoPossivel(XadrezPosição origemPosição){
		Posição posição = origemPosição.toPosição();
		validarOrigemPosição(posição);
		return tabuleiro.peça(posição).movimentoPossivel();
	}
	
	public PeçaXadrez executarMovXadrez(XadrezPosição origemPosição, XadrezPosição destinoPosição) {
		Posição origem = origemPosição.toPosição();
		Posição destino = destinoPosição.toPosição();
		validarOrigemPosição(origem);
		validarDestinoPosição(origem, destino);
		Peça capituraPeça = fazerMover(origem, destino);
		proximoTurno();
		return (PeçaXadrez)capituraPeça;
	}
	
	private Peça fazerMover(Posição origem, Posição destino) {
		Peça p = tabuleiro.removerPeça(origem);
		Peça capituraPeça = tabuleiro.removerPeça(destino);
		tabuleiro.colocarPeça(p, destino);
		
		if (capituraPeça != null) {
			peçaNoTabuleiro.remove(capituraPeça);
			peçasCapituradas.add(capituraPeça);
		}
		return capituraPeça;
	}
	
	private void validarOrigemPosição(Posição posição) {
		if (!tabuleiro.peçaExistente(posição)) {
			throw new XadrezExceção("Não existe peça na posição de origem");
		}
		
		if (jogadorAtual != ((PeçaXadrez) tabuleiro.peça(posição)).getCor()){
			throw new XadrezExceção("A peça escolhida não é sua");
		}
		if (!tabuleiro.peça(posição).movimentoPossivel2()){
			throw new XadrezExceção("Não existe movimento possivel para a peça escolhida");
		}
	}
	
	private void validarDestinoPosição(Posição origem, Posição destino) {
		if (!tabuleiro.peça(origem).movimentoPossivel(destino)) {
			throw new XadrezExceção("A peça escolhida não pode se mover para a posição de destino");
		}
	}
	
	private void proximoTurno() {
		turno ++;
		jogadorAtual = (jogadorAtual == Cor.Branca) ? Cor.Preta: Cor.Branca;
	}
	
	private void colocarNovaPeça(char coluna, int linha, PeçaXadrez peça) {
		tabuleiro.colocarPeça(peça, new XadrezPosição(coluna, linha).toPosição());
		peçaNoTabuleiro.add(peça);
	}
	
	private void iniciarPartida() {
		
		colocarNovaPeça('c', 1, new Torre(tabuleiro, Cor.Branca));
		colocarNovaPeça('c', 2, new Torre(tabuleiro, Cor.Branca));
		colocarNovaPeça('d', 2, new Torre(tabuleiro, Cor.Branca));
		colocarNovaPeça('e', 2, new Torre(tabuleiro, Cor.Branca));
		colocarNovaPeça('e', 1, new Torre(tabuleiro, Cor.Branca));
		colocarNovaPeça('d', 1, new Rei(tabuleiro, Cor.Branca));

		colocarNovaPeça('c', 7, new Torre(tabuleiro, Cor.Preta));
		colocarNovaPeça('c', 8, new Torre(tabuleiro, Cor.Preta));
		colocarNovaPeça('d', 7, new Torre(tabuleiro, Cor.Preta));
		colocarNovaPeça('e', 7, new Torre(tabuleiro, Cor.Preta));
		colocarNovaPeça('e', 8, new Torre(tabuleiro, Cor.Preta));
		colocarNovaPeça('d', 8, new Rei(tabuleiro, Cor.Preta));
	}

}
