package ReaderFile;

import java.io.File; // rappresenta il file
import java.io.FileNotFoundException; // rappresenta l'errore di file non trovato
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // rappresenta il "lettore" del file


public class CSVReader {
	public static void main(String[] args) {
		try {
			List<String> lines = new ArrayList<String>();//creo un array per le line

			int count = 0;
			File file = new File("C:\\Users\\cludi\\Desktop\\Lipari\\READERFILE\\file.csv");// definisci percorso del
																							// file
			Scanner fileReader = new Scanner(file); // apri il file
			while (fileReader.hasNextLine()) { // fino a che ci sono righe da leggere
				String line = fileReader.nextLine(); // leggi riga

				lines.add(line); //aggiungo le line nell'array lines
				System.out.println(lines.get(count));
				count++;
				// System.out.println(line); // stampa riga
			}
			fileReader.close(); // chiudi il file
			
			for (int i = 0; i < lines.size(); i++)
		    {
		        for (int j = i + 1; j < lines.size(); j++)
		        {
		            if (lines.get(i) != null && lines.get(i).equals(lines.get(j))) {
		            	System.out.println("La riga:\n" + lines.get(i) + "\nè uguale alla riga:\n" + lines.get(j));
		            }
		        }
		    }
			
		} catch (FileNotFoundException e) { // in caso di errore
			System.out.println("Cannot find file."); // stampa l'errore
			e.printStackTrace();
		}
		
		
		
		
		
	}

	
}
