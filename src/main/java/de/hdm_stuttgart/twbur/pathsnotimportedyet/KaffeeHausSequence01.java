/**
 * KaffeeHaus, bei drei Kaffee-Bestellungen = Buff, um einen Boss zu besiegen
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class KaffeeHausSequence01 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public KaffeeHausSequence01(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	public void kaffeeauswahl() {
		ArrayList<String> coffees = new ArrayList<>();

		coffees.add("Kapuziner, 'Ein doppelter Mokka mit Schlagobers und obendrauf wird Kakaopulver und Orangenschalen serviert.'");
		coffees.add("Einspänner, 'Ein Mokka mit aufgesetztem Schlagobers wird in einem Einspännerglas mit Staubzucker extra serviert.'");
		coffees.add("Franziskaner, 'Eine Melange mit Schlagobers – statt Milchschaumhaube wird mit Schokostreusel serviert.'");
		coffees.add("Melange, 'Ein Mokka, etwas verlängert, mit warmer Milch versetzt und Milchschaumhaube, wird in einer großen Schale serviert.'");
		coffees.add("Kleine Schale Gold, 'Ein Mokka mit heißer Milch aufgegossen und Milchschaumhaube wird in einer kleinen Schale serviert.'");
		coffees.add("Kaffee verkehrt, 'Ein Mokka mit sehr viel Milch, ist ein heller Milchkaffee und wird mit einem Schuss Espresso serviert.'");

		Collections.sort(coffees);

		for (String coffee : coffees) {
			System.out.println(coffee);
		}
	}

	public void tortenauswahl() {
		ArrayList<String> tortee = new ArrayList<>();

		tortee.add("Dobostorte, 'Die Dobostorte besteht aus acht Schichten Biskuit und Schokoladen-Creme sowie einer Karamell-Glasur.'");
		tortee.add("Linzertorte, 'Auf einem Boden aus Linzer Teig wird Ribiselmarmelade (Rote-Johannisbeer-Marmelade)\nund ein Gitter aus Linzer Masse aufgetragen. Nach dem Backen wird das Gebäck heiß aprikotiert.'");
		tortee.add("Sachertorte, 'Die Sachertorte ist eine Schokoladentorte mit Marillenmarmelade und Schokoladenglasur.'");

		Collections.sort(tortee);

		for (String torte : tortee) {
			System.out.println(torte);
		}	
	}

	@Override
	public void initSequence() {

		System.out.println("Befehl :„Die Karte bitte“.");
		System.out.println("Befehl :Doch lieber nichts.");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich?");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			//			if (option.matches("1") || option.matches("01") || option.matches("001")) {
			if (option.matches("Karte") || option.matches("karte")) {
				System.out.println("„Hier die Karte. Wir servieren Ihnen gerne einen Kaffee und ein Tortenstück." + System.lineSeparator()
				+ "Klicken Sie auf den jeweiligen Namen, um die Beschreibung zu lesen.“" + System.lineSeparator());

				System.out.println("Die Karte für verschiedene Kaffeesorten:" + System.lineSeparator());

				kaffeeauswahl();
				System.out.println("Gute Auswahl. Nun werfen Sie einen Blick auf die herrlich selbstgemachten Torten unseres Hauses." + System.lineSeparator());
				option = scanner.nextLine();

				if (option != null) {
					System.out.println("Hier ist nun die Karte für die verschiedenen Torten:" + System.lineSeparator());

					tortenauswahl();
					option = scanner.nextLine();

					System.out.println("Dir wurde .. serviert. Du fühlst dich gestärkt." + System.lineSeparator());
					this.initSequence();
				}

			} else if (option.matches("nichts")) {

				System.out.println("Du verlässt das Kaffeehaus, um zur Stadt zurück zu kehren." + System.lineSeparator());

				StadtSequence01 kaffeehaussequence01 = new StadtSequence01(01, playerName, player);
				kaffeehaussequence01.initSequence();

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Versuch es doch noch einmal.");
			}
		} while (option == null);
	}
}