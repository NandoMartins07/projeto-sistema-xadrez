package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PeçaXadrez;
import xadrez.XadrezExceção;
import xadrez.XadrezPosição;

public class programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		List<PeçaXadrez> capturada = new ArrayList<>();
		
		
		while(!partidaXadrez.getCheckMate()) {
			try {
				IU.clearScreen();
				IU.printPartida(partidaXadrez, capturada);
				System.out.println();
				System.out.print("Origem: ");
				XadrezPosição origem = IU.lerXadrezPosição(sc);
				
				boolean [][] movimentoPossivel = partidaXadrez.movimentoPossivel(origem);
				IU.clearScreen();
				IU.printTabuleiro(partidaXadrez.getPeças(), movimentoPossivel);
				System.out.println();
				System.out.print("Destino: ");
				XadrezPosição destino = IU.lerXadrezPosição(sc);
				
				PeçaXadrez capituraPeça = partidaXadrez.executarMovXadrez(origem, destino);
				
				if (capituraPeça != null) {
					capturada.add(capituraPeça);
				}
			}
			catch(XadrezExceção e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				
			}
		}
		IU.clearScreen();
		IU.printPartida(partidaXadrez, capturada);

	}

}
