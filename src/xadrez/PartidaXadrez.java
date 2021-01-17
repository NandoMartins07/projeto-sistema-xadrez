package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tabuleiro.Peça;
import tabuleiro.Posição;
import tabuleiro.Tabuleiro;
import xadrez.peças.Bispo;
import xadrez.peças.Cavalo;
import xadrez.peças.Dama;
import xadrez.peças.Peao;
import xadrez.peças.Rei;
import xadrez.peças.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	private int turno;
	private Cor jogadorAtual;
	private boolean check;
	private boolean checkMate;
	
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
	
	public boolean getCheck() {
		return check;
	}
	
	public boolean getCheckMate(){
		return checkMate; 
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
		
		if (testeCheck(jogadorAtual)) {
			desfazerMover(origem, destino, capituraPeça);
			throw new XadrezExceção("Voce nao pode se colocar em check");
		}
		
		check = (testeCheck(oponente(jogadorAtual))) ? true : false;
		
		if(testeCheckMate(oponente(jogadorAtual))) {
			checkMate = true;
		}
		else {
			proximoTurno();
		}
		
		return (PeçaXadrez)capituraPeça;
	}
	
	private Peça fazerMover(Posição origem, Posição destino) {
		PeçaXadrez p = (PeçaXadrez)tabuleiro.removerPeça(origem);
		p.increContarMovimento();
		Peça capituraPeça = tabuleiro.removerPeça(destino);
		tabuleiro.colocarPeça(p, destino);
		
		if (capituraPeça != null) {
			peçaNoTabuleiro.remove(capituraPeça);
			peçasCapituradas.add(capituraPeça);
		}
		return capituraPeça;
	}
	
	private void desfazerMover(Posição origem, Posição destino, Peça capituraPeça) {
		PeçaXadrez p = (PeçaXadrez)tabuleiro.removerPeça(destino);
		p.decreContarMovimento();
		tabuleiro.colocarPeça(p,origem);
		
		if (capituraPeça != null) {
			tabuleiro.colocarPeça(capituraPeça, destino);
			peçasCapituradas.remove(capituraPeça);
			peçaNoTabuleiro.add(capituraPeça);
		}
	}
	
	private void validarOrigemPosição(Posição posição) {
		if (!tabuleiro.peçaExistente(posição)) {
			throw new XadrezExceção("Nao existe peca na posicao de origem");
		}
		
		if (jogadorAtual != ((PeçaXadrez) tabuleiro.peça(posição)).getCor()){
			throw new XadrezExceção("A peça escolhida não é sua");
		}
		if (!tabuleiro.peça(posição).movimentoPossivel2()){
			throw new XadrezExceção("Nao existe movimento possivel para a peca escolhida");
		}
	}
	
	private void validarDestinoPosição(Posição origem, Posição destino) {
		if (!tabuleiro.peça(origem).movimentoPossivel(destino)) {
			throw new XadrezExceção("A peca escolhida nao pode se mover para a posicao de destino");
		}
	}
	
	private void proximoTurno() {
		turno ++;
		jogadorAtual = (jogadorAtual == Cor.Branca) ? Cor.Preta: Cor.Branca;
	}
	
	private Cor oponente(Cor cor) {
		return (cor == Cor.Branca) ? Cor.Preta : Cor.Branca;
	}
	
	private PeçaXadrez rei(Cor cor) {
		List<Peça> list = peçaNoTabuleiro.stream().filter(x ->((PeçaXadrez)x).getCor() == cor).collect(Collectors.toList());
		for(Peça p : list) {
			if (p instanceof Rei) {
				return (PeçaXadrez)p;
			}
		}
		throw new IllegalStateException("Nao existe o rei da" + cor + "no tabuleiro");
	}
	
	private boolean testeCheck(Cor cor) {
		Posição reiPosição = rei(cor).getXadrezPosição().toPosição();
		List<Peça> oponentePeças = peçaNoTabuleiro.stream().filter(x ->((PeçaXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());
		for(Peça p : oponentePeças) {
			boolean[][] mat = p.movimentoPossivel();
			if (mat[reiPosição.getLinha()][reiPosição.getColuna()]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean testeCheckMate(Cor cor) {
		if (!testeCheck(cor)) {
			return false;
		}
		List<Peça> list = peçaNoTabuleiro.stream().filter(x ->((PeçaXadrez)x).getCor() == cor).collect(Collectors.toList());
		for (Peça p : list) {
			boolean [][] mat = p.movimentoPossivel();
			for (int i = 0; i < tabuleiro.getLinhas(); i++) {
				for (int j = 0; j < tabuleiro.getColunas(); j++) {
					if (mat[i][j]) {
						Posição origem = ((PeçaXadrez)p).getXadrezPosição().toPosição();
						Posição destino = new Posição(i, j);
						Peça capituraPeça = fazerMover(origem, destino);
						boolean testeCheck = testeCheck(cor);
						desfazerMover(origem, destino, capituraPeça);
						if (!testeCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	
	
	
	private void colocarNovaPeça(char coluna, int linha, PeçaXadrez peça) {
		tabuleiro.colocarPeça(peça, new XadrezPosição(coluna, linha).toPosição());
		peçaNoTabuleiro.add(peça);
	}
	
	private void iniciarPartida() {
		
		
		colocarNovaPeça('a', 1, new Torre(tabuleiro, Cor.Branca));
		colocarNovaPeça('b', 1, new Cavalo(tabuleiro, Cor.Branca));
		colocarNovaPeça('c', 1, new Bispo(tabuleiro, Cor.Branca));
		colocarNovaPeça('d', 1, new Dama(tabuleiro, Cor.Branca));
		colocarNovaPeça('e', 1, new Rei(tabuleiro, Cor.Branca));
		colocarNovaPeça('f', 1, new Bispo(tabuleiro, Cor.Branca));
		colocarNovaPeça('g', 1, new Cavalo(tabuleiro, Cor.Branca));
		colocarNovaPeça('h', 1, new Torre(tabuleiro, Cor.Branca));
		colocarNovaPeça('a', 2, new Peao(tabuleiro, Cor.Branca));
		colocarNovaPeça('b', 2, new Peao(tabuleiro, Cor.Branca));
		colocarNovaPeça('c', 2, new Peao(tabuleiro, Cor.Branca));
		colocarNovaPeça('d', 2, new Peao(tabuleiro, Cor.Branca));
		colocarNovaPeça('e', 2, new Peao(tabuleiro, Cor.Branca));
		colocarNovaPeça('f', 2, new Peao(tabuleiro, Cor.Branca));
		colocarNovaPeça('g', 2, new Peao(tabuleiro, Cor.Branca));
		colocarNovaPeça('h', 2, new Peao(tabuleiro, Cor.Branca));
		

		colocarNovaPeça('a', 8, new Torre(tabuleiro, Cor.Preta));
		colocarNovaPeça('b', 8, new Cavalo(tabuleiro, Cor.Preta));
		colocarNovaPeça('c', 8, new Bispo(tabuleiro, Cor.Preta));
		colocarNovaPeça('d', 8, new Dama(tabuleiro, Cor.Preta));
		colocarNovaPeça('e', 8, new Rei(tabuleiro, Cor.Preta));
		colocarNovaPeça('f', 8, new Bispo(tabuleiro, Cor.Preta));
		colocarNovaPeça('g', 8, new Cavalo(tabuleiro, Cor.Preta));
		colocarNovaPeça('h', 8, new Torre(tabuleiro, Cor.Preta));
		colocarNovaPeça('a', 7, new Peao(tabuleiro, Cor.Preta));
		colocarNovaPeça('b', 7, new Peao(tabuleiro, Cor.Preta));
		colocarNovaPeça('c', 7, new Peao(tabuleiro, Cor.Preta));
		colocarNovaPeça('d', 7, new Peao(tabuleiro, Cor.Preta));
		colocarNovaPeça('e', 7, new Peao(tabuleiro, Cor.Preta));
		colocarNovaPeça('f', 7, new Peao(tabuleiro, Cor.Preta));
		colocarNovaPeça('g', 7, new Peao(tabuleiro, Cor.Preta));
		colocarNovaPeça('h', 7, new Peao(tabuleiro, Cor.Preta));
	}

}
