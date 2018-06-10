/**
 * Bosslevel Schildkrötendrache Teil 2
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.Enemy;
import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class BossSequence02 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);
	private Enemy dragonturtle = new Enemy(100, "Schildkrötendrache", 4);

	public BossSequence02(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du springst noch rechtzeitig zur Seite bevor der Schildkrötendrache dich mit seinem" + System.lineSeparator()
		+ "feuerspuckenden Atem erwischen konnte. Aber was nun?" + System.lineSeparator());

		System.out.println("1 :Du verteidigst dich");
		System.out.println("2 :Du greifst ihn an");
		System.out.println(System.lineSeparator());
		System.out.println("══════════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1', '2' oder weitere Optionen auswählen.");
		System.out.println("══════════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();

			if (option.matches("1") || option.matches("verteidigen")){
				System.out.println("Du entdeckst einen großen Felsen zu deiner Linken und versteckst dich dahinter als der" + System.lineSeparator()
				+ "Schildkrötendrache sich wieder sammeln muss für eine erneute Attacke." + System.lineSeparator()
				+ "Möchtest du ihn doch angreifen oder lieber flüchten? Drücke 'hint' für weitere Optionen." + System.lineSeparator());
				option = null;

			} else if (option.matches("2") || option.matches("angreifen")) {

				if (player.getItem(100) != null) {
					player.refreshLevel(player.getPlayerExperience());
					player.setPlayerExperience(dragonturtle.getExpPoints());

					System.out.println("Du benutzt den "+ player.getItem(100).getObjectName() +" und zielst den Schaum direkt in sein Maul. Nun kann er kein" + System.lineSeparator()
					+ "Feuer mehr spucken und verzieht sich wieder ins Wasser. Gratuliere für den Sieg!" + System.lineSeparator()
					+ "Du erhälst " + dragonturtle.getExpPoints() + " EXP." + System.lineSeparator()
					+ System.lineSeparator()
					+ "Deine aktuelle EXP beträgt: " + player.getPlayerExperience() + System.lineSeparator()
					+ "Dein aktuelles Level beträgt: " + player.getPlayerLevel() + System.lineSeparator());

					player.addPlayerHighScore(50);

					System.out.println("Du kehrst siegessicher zurück zur Taverne, was nun?");

					System.out.println("1 :„Ich möchte lieber weitergehen.“");
					System.out.println("2 :„Ich nehme gerne ein Zimmer für eine Nacht.“ (Checkpoint)");

					System.out.println(System.lineSeparator());
					System.out.println("════════════════════════════════════════════════════════════════════════");
					System.out.println("Wie entscheidest du dich? - Du kannst '1' oder '2' wählen.");
					System.out.println("════════════════════════════════════════════════════════════════════════");

					String option2 = null;
					option2 = scanner.nextLine();
					option2.toLowerCase();

					if (option2.matches("1") || option.matches("weitergehen") || option.matches("verlassen")) {

						System.out.println("Du verlässt die Taverne und läufst weiter." + System.lineSeparator());

						Sequence07 tavernesequence03 = new Sequence07(2, playerName, player);
						tavernesequence03.initSequence();

					} else if (option2.matches("2") || option.matches("speichern") || option.matches("schlafen")) {
						player.setPlayerSafepoint(303);
						System.out.println("Der Minotaurus gibt dir den Schlüssel zu deinem Zimmer und zeigt nach oben." + System.lineSeparator()
						+ "Du läufst die Treppe hoch und legst dich hin bis zum nächsten Morgengrauen." + System.lineSeparator()
						+ "Nun bist du ausgeruht, um dein Abenteuer fortzusetzen." + System.lineSeparator());

						Sequence07 tavernesequence03 = new Sequence07(2, playerName, player);
						tavernesequence03.initSequence();

					} else {
						System.out.println("Falsche Eingabe. Du gehst trotzdem weiter.");

						Sequence07 tavernesequence03 = new Sequence07(2, playerName, player);
						tavernesequence03.initSequence();
					}
				} else {
					if (player.getPlayerSafepoint() == 0) {
						System.out.println("Du versuchst den Schildkrötendrachen mit bloßen Händen zu überwältigen," + System.lineSeparator()
						+ "aber er erwischt dich wieder mit seiner Feuerflamme." + System.lineSeparator()
						+ "Game Over." + System.lineSeparator());

						Sequence01 bossSequence02 = new de.hdm_stuttgart.twbur.pathsnotimportedyet.Sequence01(02, playerName, player);
						bossSequence02.initSequence();

					} else {
						System.out.println("Du versuchst den Schildkrötendrachen mit bloßen Händen zu überwältigen,"+ System.lineSeparator()
						+ "aber er erwischt dich wieder mit seiner Feuerflamme." + System.lineSeparator()
						+ "Game Over." + System.lineSeparator());

						TaverneSequence00 bossSequence02 = new TaverneSequence00(02, playerName, player);
						bossSequence02.initSequence();
					}
				}
			} else if (option.matches("flüchten")){
				System.out.println("Du entscheidest dich zu fliehen. Gute Entscheidung!" + System.lineSeparator());

				TaverneSequence03 bossSequenz02 = new de.hdm_stuttgart.twbur.pathsnotimportedyet.TaverneSequence03(02, playerName, player);
				bossSequenz02.initSequence();

			} else if (option.matches("hint") || option.matches("hinweis")){
				System.out.println( "Wenn du flüchten willst, schreibe 'flüchten' und wenn du ihn doch angreifen möchtest," + System.lineSeparator()
				+ "dann schreibe 'angreifen'." + System.lineSeparator());
				option = null;

			} else if (option.matches("inspect")){
				dragonturtle.inspect();

				System.out.println("Was hast du vor?" + System.lineSeparator());
				option = null;

			} else { 
				option = null;
				System.out.println("Das geht leider nicht. Möchtest du dich verteidigen, schreibe 'verteidigen'." + System.lineSeparator()
				+ "Möchtest du doch ihn angreifen, schreibe 'angreifen'." + System.lineSeparator()
				+ "Möchtest du Schildkrötendrache nochmal genauer betrachten, schreibe 'inspect'." + System.lineSeparator()
				+ "Wofür entscheidest du dich?");
			}
		} while (option == null);
	}
}