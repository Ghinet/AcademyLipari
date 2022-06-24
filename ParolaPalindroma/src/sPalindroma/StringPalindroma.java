package sPalindroma;

import java.util.Scanner;

public class StringPalindroma {

	public static void main(String[] args) {

		System.out.println("Benvenuto nel calotare delle parole palindrome, inserisci una parola:\n");
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();

		if (word.length() == 1) {
			System.out.println(word + " è una singola lettera, arrivederci.");
		} else {
			for (int i = 0; i < (word.length()) / 2;) { // falso i= 0, 1
				if (word.charAt(i) == word.charAt(word.length() - i - 1)) {
					i++;
				} else {
					System.out.println(word + " non è un palindromo, arrivederci.");
					break;
				}
				if (i == (word.length()) / 2) {
					System.out.println(word + " è un palindromo, arrivederci.");
				}

			}
		}

	}

}
