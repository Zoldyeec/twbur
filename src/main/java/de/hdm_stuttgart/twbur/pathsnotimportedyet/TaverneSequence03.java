/**
 * Die erste Taverne Teil 2
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class TaverneSequence03 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public TaverneSequence03(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("1 :„Ich möchte lieber weitergehen.“");
		System.out.println("2 :„Zeige mir den Weg zum Strand.“");
		System.out.println("3 :„Ich nehme gerne ein Zimmer für eine Nacht.“ (Checkpoint)");

		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1','2' oder '3' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			
			if (option.matches("1") || option.matches("weitergehen") || option.matches("verlassen")) {

				System.out.println("Du bedankst dich für den Krug, trinkst erstmal leer. Dann verlässt du die Taverne und" + System.lineSeparator()
				+ "läufst weiter." + System.lineSeparator());

				Sequence07 tavernesequence03 = new Sequence07(2, playerName, player);
				tavernesequence03.initSequence();

			} else if (option.matches("2") || option.matches("boss") || option.matches("strand")) {
				System.out.println("Der Minotaurus zeigt in Richtung Süden und du merkst dir seine Wegbeschreibung." + System.lineSeparator());

				BossSequence01 tavernesequence03 = new BossSequence01(2, playerName, player);
				tavernesequence03.initSequence();
				
			} else if (option.matches("3") || option.matches("speichern") || option.matches("schlafen")) {
					player.setPlayerSafepoint(303);
					System.out.println("Der Minotaurus gibt dir den Schlüssel zu deinem Zimmer und zeigt nach oben." + System.lineSeparator()
					+ "Du läufst die Treppe hoch und legst dich hin bis zum nächsten Morgengrauen." + System.lineSeparator()
					+ "Nun bist du ausgeruht, um dein Abenteuer fortzusetzen." + System.lineSeparator());

					Sequence07 tavernesequence03 = new Sequence07(2, playerName, player);
					tavernesequence03.initSequence();

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Erstelle einen Checkpoint und schreibe 'speichern'."
						+ System.lineSeparator() + "Willst du die Taverne schnell verlassen, dann schreibe 'verlassen'."
						+ System.lineSeparator() + "Frage nach dem Weg zum Strand, dann schreibe 'Strand'."
						+ System.lineSeparator() + "Wofür entscheidest du dich?");
			}
		} while (option == null);
	}
}