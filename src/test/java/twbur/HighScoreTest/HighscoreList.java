package twbur.HighScoreTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextArea;

/**
 * Highscore Daten
 */

public class HighscoreList {

	File file = new File("hstest.txt");
	ArrayList<Highscore> highscoreList = new ArrayList <>();

	public void getList() {
		if (file.exists()) {
			try {
				//Wenn sie existiert, wird der FileReader ausgelesen
				FileReader fileReader = new FileReader(file);

				//FileReader liest ein array of char und keinen String
				char[] c = new char[(int) file.length()];

				//und in das erstellte char-array einlesen
				fileReader.read(c);

				//aus dem char-array einen string erzeugen, der dann den
				//Datei-Inhalt enthält
				String s = new String(c);

				//Den String bei Zeilenumbruch teilen und die einzelnen
				//Teile (=Zeilen) in ein array of string schreiben
				String[] entrys = s.split("\n");

				//jede Zeile der Datei abarbeiten
				for (int i = 0; i < 10; i++) {
					//Jede einzelene Zeile bei : trennen
					//dieser wurde als Trennzeichen zwischen Spieler und
					//Punktestand gewählt
					if (i < 10) {
						String[] entry = entrys[i].split(": ");

						//einen neuen Highscoreeintrag mit den eingelesenen
						//Erzeugen, an der entsprechenden stelle im oben
						//definierten Array
						highscoreList.add(new Highscore(entry[0], Integer.parseInt(entry[1])));
					}
				}
				//den FileReader wieder schließen
				fileReader.close();
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			} catch (FileNotFoundException e) { //falls Fehler beim
				e.printStackTrace(); //Einlesen auftreten,
			} catch (IOException e) { //diese ausgeben
				e.printStackTrace();
			}

		} else {
			//wenn die Datei nicht existiert werden Beispieleinträge angelegt
			highscoreList.add(new Highscore("Horst", 90));
			highscoreList.add(new Highscore("Hanna", 80));
			highscoreList.add(new Highscore("Peter", 70));
			highscoreList.add(new Highscore("Marie", 55));
			highscoreList.add(new Highscore("Luise-Lena", 40));
			highscoreList.add(new Highscore("Franz", 30));
			highscoreList.add(new Highscore("Peter", 25));
			highscoreList.add(new Highscore("Sabine", 10));
			highscoreList.add(new Highscore("Sebastian", 5));
			highscoreList.add(new Highscore("Eva", 5));
		}
	}

	public void showHighscore(JTextArea highscoreText) {

		try {
			highscoreText.setText("Rangliste\n"
					+ "═══════════════════════════\n");
			highscoreText.append("# Name:\t      Score:\n"
					+ "═══════════════════════════\n");
			for (int i = 0; i < 10; i++) {
				if (i < 9) {
					highscoreText.append(i+1 + ": " + highscoreList.get(i).writeOut() + "\n");
				} else {
					highscoreText.append(i+1 + ": " + highscoreList.get(i).writeOut() + "\n");
				}
			}
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}

	public void checkHighscore(Highscore score) {
		try {
			getList();
			for (int i = 0; i < 10; i++) {
				int score1 = highscoreList.get(i).getHighscore();
				int score2 = highscoreList.get(i+1).getHighscore();
				if (score.getHighscore() <= highscoreList.get(9).getHighscore()) {
					break;
				} else if (score.getHighscore() > score1) {
					highscoreList.add(i, score);
					break;
				} else if (score.getHighscore() <= score1 && score.getHighscore() > score2) {
					highscoreList.add(i+1, score);
					break;
				} else {

				}
			}
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}

	//JUnit Testing
	public void writeFileTest(File file) {
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new FileWriter(file)); 
			Iterator<Highscore> iter = highscoreList.iterator(); 
			int i = 0;
			while(iter.hasNext() && i < 10) { 
				Object o = iter.next(); 
				printWriter.println(o); 
				i++;
			}
		} catch (IOException e) { 
			e.printStackTrace(); 
		} finally { 
			if (printWriter != null) printWriter.close(); 
		}
	}

}