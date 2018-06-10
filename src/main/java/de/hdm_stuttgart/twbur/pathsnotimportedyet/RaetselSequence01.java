/**
 * Raetsellevel Teil 1
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.objectSet.ItemObject;
import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class RaetselSequence01 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);
	private ItemObject item01 = new ItemObject(01, "Gemälde" ,"Hinter dem Gemälde ist ein Zettel versteckt. Du nimmst das Gemälde von \nder Wand ab. Da drauf ist ein Zahlencode zu sehen.\nUm zu entziffern, tippe 'code' ein.");
	private ItemObject item02 = new ItemObject(02, "Zettel", "Ein Stück zerknülltes Papier.");
	static int randomNumber = (int)(Math.random() * 10000) + 1000;

	public RaetselSequence01(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	public static int getrandomNumber() {
		return randomNumber;
	}

	public void setrandomNumber(int randomNumber) {
		RaetselSequence01.randomNumber = randomNumber;
	}

	@Override
	public void initSequence() {
		System.out.println("Links von dir ist eine weitere Tür." + System.lineSeparator()
		+ "Vor dir siehst du eine Treppe, die nach oben führt. " + System.lineSeparator());
		
		System.out.println("Befehl: die Tür von links öffnen");
		System.out.println("Befehl: die Treppen nach oben benutzen");
		System.out.println("Befehl: zurück zur Einkaufspassage");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich?");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();

			if (option.matches("tür öffnen") || option.matches("links") || option.matches("tür") || option.matches("linke tür") || option.matches("tür links") || option.matches("tür von links öffnen")) {
				System.out.println("Du läufst nach links zur Tür.");

				RaetselSequence02 raetselsequence01 = new RaetselSequence02(01, playerName, player);
				raetselsequence01.initSequence();

			} else if (option.matches("treppen benutzen") || option.matches("treppe") || option.matches("treppen") || option.matches("nach oben") || option.matches("oben") || option.matches("treppen nach oben benutzen")) {
				System.out.println("Du läufst die Treppen hoch.");

				RaetselSequence03 raetselsequence01 = new RaetselSequence03(01, playerName, player);
				raetselsequence01.initSequence();
				
			} else if (option.matches("passage") || option.matches("einkaufspassage") || option.matches("zurück") || option.matches("back") || option.matches("verlassen")) {
				System.out.println("Du verlässt das Haus und kehrst zurück zur Einkaufspassage.");

				StadtSequence01 raetselsequence01 = new StadtSequence01(01, playerName, player);
				raetselsequence01.initSequence();

			} else if (option.matches("inspect")) {

				if (player.getItem(02) == null) {
					item01.inspect();					
					option = null;

				} else {
					System.out.println("Du siehst dich weiter um, kannst aber nichts Ungewöhnliches erkennen.");
					option = null;
				}

			} else if (option.matches("code")) {

				if (player.getItem(02) == null) {
					player.addItem(item02);
					this.setrandomNumber(randomNumber);

					System.out.println("'" + randomNumber + "'" + System.lineSeparator()
					+ "Du hängst das Gemälde wieder zurück zum Ursprungsplatz, behälst aber den " + player.getItem(02).getObjectName() + ". Was nun?" + System.lineSeparator()
					+ "[Du erhälst einen " + player.getItem(02).getObjectName() + ".]");
					option = null;

				} else {
					System.out.println("Du starrst das Gemälde an. Nichts passiert.");
					option = null;
				}

			} else { 
				option = null;
				System.out.println("Falsche Eingabe. Probiere es nochmal.");
			}
		} while (option == null);
	}
}