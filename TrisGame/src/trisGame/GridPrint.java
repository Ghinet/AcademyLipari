package trisGame;

import java.util.Scanner;

public class GridPrint {

	public String[][] spotClear = new String[3][3];

	public void gridCreate() {
		for (int i = 0; i < 3; i++) { // popolo l'array con spazi vuoti
			for (int j = 0; j < 3; j++) {
				spotClear[i][j] = " ";
			}
		}
	}

	public void printGrid() {
		for (int i = 0; i < 5; i++) { // creo 5 righe tra cui quelle con 3 valori e 2 pezzi di griglia e
			// quelle con 6 liniette per la griglia
			if (i % 2 == 0) { // distinzione fra le righe pari e dispari

				for (int j = 0; j < 5; j++) { // ciclo i 5 elementi della riga pari e stampo i 3 spazi e i 2 pezzi di
					// griglia
					// distinguendo lew linee tra pari e dispari
					if (j % 2 == 0) {
						if (j != 4) {
							System.out.print(" " + spotClear[i / 2][j / 2] + " ");
						} else {
							System.out.println(" " + spotClear[i / 2][j / 2] + " ");// pritnln per andare accapo dopo
																					// aver stampato l'ultimo
						}
					} else {
						System.out.print("|");
					}
				}
			} else {
				for (int j = 0; j < 7; j++) {
					if (j != 6) {
						System.out.print("- ");
					} else {
						System.out.print("\n");
					}

				}
			}
		}
	}

	public void handleRound(String nickName, String sign) {

		int[] indexes = new int[2];
		Scanner scan = new Scanner(System.in);
        
		
		System.out.println(nickName + " "+ sign + " Inserisci le coordinate della tua mossa,\nRiga:");
		int i = scan.nextInt() - 1;
		if (i < 0 || i > 2) {
			System.out.println("Coordinata non valida, riprova.");
			this.handleRound(nickName, sign);  //richiamo la funzione per farla ripartire
		} else {
			indexes[0] = i;
			System.out.println(nickName + " - Colonna:");  //Inizio a riempire la colonna
			int j = scan.nextInt() - 1;
			if (j < 0 || j > 2) {
				System.out.println("Coordinata non valida, riprova.");
				this.handleRound(nickName, sign);  //richiamo la funzione per farla ripartire
			} else {   //Controllo che la cella selezionata, che stavolta è inserita correttamente, non sia già occupata

				if (!this.spotClear[i][j].equals(" ")) {

					System.out.println("ERR: Coordinata già occupata, seleziona una coordinata libera!\n");
					this.printGrid();
					this.handleRound(nickName, sign);

				} else{

					indexes[1] = j;
					this.spotClear[indexes[0]][indexes[1]] = sign;
					this.printGrid();

				}
			}	
	
		}
	}
	
	public boolean checkWin(String nickName, String sign, Boolean check) {
		for(int i=0; i<3; i++) {
			if(spotClear[i][0] == spotClear[i][1] && spotClear[i][0] ==spotClear[i][2] && spotClear[i][0] != " ") {
				check = false;
				System.out.println(nickName + ", hai vinto, tris di "+ sign +" nella riga "+ (i+1) +"!! ");
				
			}
		}
		for(int i=0; i<3; i++) {
			if(spotClear[0][i] == spotClear[1][i] && spotClear[0][i] == spotClear[2][i] && spotClear[0][i] != " ") {
				System.out.println(nickName + ", hai vinto, tris di "+ sign +" nella colonna "+ (i+1) +"!!");
				check = false;
			}
		}
		if (spotClear[0][0] == spotClear[1][1] && spotClear[0][0] == spotClear[2][2] && spotClear[0][0] != " ") {
			System.out.println(nickName + ", hai vinto, tris di "+ sign +" nella prima diagonale!!");
			check = false;
		}
		if (spotClear[2][0] == spotClear[1][1] && spotClear[2][0] == spotClear[0][2] && spotClear[2][0] != " ") {
			System.out.println(nickName + ", hai vinto, tris di "+ sign +" nella seconda diagonale!!");
			check = false;
		}
		return check;
	}
	
	
}
