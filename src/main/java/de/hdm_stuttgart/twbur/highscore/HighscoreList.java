package de.hdm_stuttgart.twbur.highscore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hdm_stuttgart.twbur.App;
import javafx.scene.control.TextArea;

/**
 * Highscore Daten
 */

public class HighscoreList {

	private static final Logger log = LogManager.getLogger(App.class);

	File file = new File("hs.txt");
	ArrayList<Highscore> highscoreList = new ArrayList<>();

	/**
	 * Wenn keine Datei existiert, schreibt er Beispieleinträge rein
	 */
	public void getList() {
		if (file.exists()) {
			try {
				// Wenn sie existiert, wird der FileReader ausgelesen
				log.debug("File does exist.");
				FileReader fileReader = new FileReader(file);

				// FileReader liest ein array of char und keinen String
				char[] c = new char[(int) file.length()];

				// und in das erstellte char-array einlesen
				fileReader.read(c);

				// aus dem char-array einen string erzeugen, der dann den
				// Datei-Inhalt enthält
				String s = new String(c);

				// Den String bei Zeilenumbruch teilen und die einzelnen
				// Teile (=Zeilen) in ein array of string schreiben
				String[] entrys = s.split("\n");

				// jede Zeile der Datei abarbeiten
				for (int i = 0; i < 10; i++) {
					// Jede einzelene Zeile bei : trennen
					// dieser wurde als Trennzeichen zwischen Spieler und
					// Punktestand gewählt
					if (i < 10) {
						String[] entry = entrys[i].split(": ");

						// einen neuen Highscoreeintrag mit den eingelesenen
						// Erzeugen, an der entsprechenden stelle im oben
						// definierten Array
						highscoreList.add(new Highscore(entry[0], Integer.parseInt(entry[1].substring(0, entry[1].length()-1))));
					}
				}
				// den FileReader wieder schließen
				log.debug("FileReader closed.");
				fileReader.close();
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				log.error("File wrong number format", nfe);
			} catch (FileNotFoundException e) { // falls Fehler beim
				e.printStackTrace(); // Einlesen auftreten,
				log.error("File not found", e); //diese ausgeben
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else{
			// wenn die Datei nicht existiert werden Beispieleinträge angelegt
			log.debug("File does not exist.");

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

			writeFile(file);
		}
	}

	Comparator<Highscore> byScore = new Comparator<Highscore>() {

		@Override
		public int compare(Highscore o1, Highscore o2) {
			if (o1.getHighscore() >= o2.getHighscore()) {
				return o1.getHighscore();
			} else {
				return o2.getHighscore();
			}
		}
	};

	/**
	 * fügt den Highscore aus hs.txt in die textArea der GUI ein
	 */
	public void showHighscore(TextArea ta) {
		getList();
		ta.appendText("Rangliste\n" + "═════════════════════════════════════════════\n");
		ta.appendText("#\tName:\t \tScore:\n" + "═════════════════════════════════════════════\n");

		highscoreList
		.stream()
		.sorted(byScore)
		.forEach(s -> ta.appendText(s.writeOut( ) + "\n"));
	}

	/**
	 * vergleicht den Highscore des Spielers mit den vorherigen Einträgen, wenn er
	 * mehr Punkte hat, wird er ein Platz nach oben rutschen
	 */
	public void checkHighscore(Highscore score) {
		try {
			getList();
			for (int i = 0; i < 10; i++) {
				int score1 = highscoreList.get(i).getHighscore();
				int score2 = highscoreList.get(i + 1).getHighscore();
				if (score.getHighscore() <= highscoreList.get(9).getHighscore()) {
					break;
				} else if (score.getHighscore() > score1) {
					highscoreList.add(i, score);
					break;
				} else if (score.getHighscore() <= score1 && score.getHighscore() > score2) {
					highscoreList.add(i + 1, score);
					break;
				} else {

				}
			} writeFile(file);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			log.error("wrong number format", nfe);
		}
	}

	/**
	 * schreibt in der File rein
	 */
	public void writeFile(File file) {
		PrintWriter printWriter = null;
		log.debug("Write in File.");
		try {
			printWriter = new PrintWriter(new FileWriter(file));
			Iterator<Highscore> iter = highscoreList.iterator();
			int i = 0;
			while (iter.hasNext() && i < 10) {
				Object o = iter.next();
				printWriter.println(o);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null)
				printWriter.close();
		}
	}
}