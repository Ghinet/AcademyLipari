package trisGame;

import java.util.Scanner;

public class trisMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		GridPrint game = new GridPrint();
		int round = 0;
		Boolean check = true;

		game.gridCreate();

		System.out.println("Benvenuto al gioco del tris!\n\nGiocatore X, inserisci il tuo nickname:\n");
		String nickX = scan.nextLine();
		System.out.println("\nGiocatore O, inserisci il tuo nickname:\n");
		String nickO = scan.nextLine();

		System.out.println("\nBen fatto, che vinca il migliore\n");
		game.printGrid();

		//TODO far chiudere il programma dopo un metodo checWin
		
		
		do {

			if (round % 2 == 0) {
				game.handleRound(nickX, "x");	
				
				game.checkWinLine(nickX, "x", check);
				game.checkWinColomn(nickX, "x", check);
				game.checkWinDiagonal1(nickX, "x", check);
				game.checkWinDiagonal2(nickX, "x", check);
				
				check = game.checkWinLine(nickX, "x", check);
				round++;
				
				
			} else {
				game.handleRound(nickO, "o");
				
				game.checkWinLine(nickO, "o", check);
				game.checkWinColomn(nickO, "o", check);
				game.checkWinDiagonal1(nickO, "o", check); 
				game.checkWinDiagonal2(nickO, "o", check);
				
				check = game.checkWinLine(nickX, "x", check);
				round++;
				
			}
		} while (check && round != 9);
		
		if(round == 9) {
			System.out.println("Partita conclusa");
		}

		
	}

}
