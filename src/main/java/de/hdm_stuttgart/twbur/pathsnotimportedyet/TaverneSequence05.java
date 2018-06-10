/**
 * Die zweite Taverne Teil 2
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class TaverneSequence05 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public TaverneSequence05(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("1 :„Ich möchte lieber weitergehen.“");
		System.out.println("2 :„Zeige mir den Weg zum nächsten Boss.“");
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

				System.out.println("Du verlässt die Taverne und läufst weiter.");
				
				Sequence12 tavernesequence05 = new Sequence12(4, playerName, player);
				tavernesequence05.initSequence();

			} else if (option.matches("2") || option.matches("boss") || option.matches("wiese")) {
				System.out.println("Der Minotaurus zeigt in Richtung Norden und du merkst dir seine Wegbeschreibung." + System.lineSeparator());

				BossSequence03 tavernesequence05 = new BossSequence03(4, playerName, player);
				tavernesequence05.initSequence();
				
			} else if (option.matches("3") || option.matches("speichern") || option.matches("schlafen")) {
					player.setPlayerSafepoint(305);
					System.out.println("Der Minotaurus gibt dir den Schlüssel zu deinem Zimmer und zeigt nach oben." + System.lineSeparator()
					+ "Du läufst die Treppe hoch und legst dich hin bis zum nächsten Morgengrauen." + System.lineSeparator()
					+ "Nun bist du ausgeruht, um dein Abenteuer fortzusetzen." + System.lineSeparator());
					
					System.out.println("1 :„Ich möchte weitergehen.“");
					System.out.println("2 :„Zeige mir den Weg zum nächsten Boss.“");
					System.out.println(System.lineSeparator());
					System.out.println("════════════════════════════════════════════════════════════════════════");
					System.out.println("Wie entscheidest du dich? - Wähle 2 oder 3, um weiter zu kommen.");
					System.out.println("════════════════════════════════════════════════════════════════════════");
					
					option = null;

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Nochmal bitte.");
			}
		} while (option == null);
	}
}