package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PeçaXadrez;
import xadrez.XadrezExceção;
import xadrez.XadrezPosição;

public class programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while(true) {
			try {
				IU.clearScreen();
				IU.printTabuleiro(partidaXadrez.getPeças());
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

	}

}
