/**
 * Eine Art Wirtshaus zum Speichern und Informationen sammeln Teil 2
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class SpelunkeSequence01 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public SpelunkeSequence01(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("1 :Sprich mit dem Barkeeper");
		System.out.println("2 :Sprich mit dem mysteriösen Mann");
		System.out.println("3 :Sprich mit einem der Gäste");
		System.out.println("4 :Spelunke verlassen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1','2' oder '3' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			if (option.matches("1") || option.matches("barkeeper")) {

				System.out.println("„Hey, du siehst aus, als könntest du etwas vertragen.“");
				scanner.nextLine();

				System.out.println("„Wie, du willst einen Kaffee? Dann bist du bei mir falsch. Hier gibt" + System.lineSeparator()
				+ "es nur hartes Zeug. Aber ich habe gehört, das Kaffeehaus sollte bald" + System.lineSeparator()
				+ "aufmachen. Solange kannst du hier bleiben und etwas bestellen.“");
				scanner.nextLine();

				System.out.println("„Nein? Komm dann wieder, wenn du bereit dafür bist.“" + System.lineSeparator());
				scanner.nextLine();
				this.initSequence();

			} else if (option.matches("2") || option.matches("mysteriöser mann")) {

				double random = Math.random();
				if (random < 0.25){
					System.out.println("Du gehst zu diesem mysteriösen Mann. Er macht einen netten Eindruck" + System.lineSeparator()
					+ "auf dich. Er mustert dich an und sagt dann: „Soll ich dir etwas verraten?“");
					scanner.nextLine();

					System.out.println("„Wenn du zu den Tavernen gehst, hast du jedes Mal die Möglichkeit ein" + System.lineSeparator()
					+ "Bossmonster zu besiegen. Diese geben besonders viele EXP und vor allem" + System.lineSeparator()
					+ "gibt es zusätzlich Punkte für den Highscore.“");
					scanner.nextLine();
					this.initSequence();

				} else if (random >= 0.25 && random <= 0.5) {

					System.out.println("Du gehst zu diesem mysteriösen Mann. Er macht einen netten Eindruck" + System.lineSeparator()
					+ "auf dich. Er mustert dich an und sagt dann: „Soll ich dir etwas verraten?“");
					scanner.nextLine();

					System.out.println("Um einen geköpften Trollkopf zu bekommen, musst du vorher zum Pfad ent-" + System.lineSeparator()
					+ "lang der Ruinen gehen, BEVOR diese  wieder versperrt wird. Du musst ein" + System.lineSeparator()
					+ "höheres Level sein als der Troll, sonst stirbst du. Er befindet sich in" + System.lineSeparator()
					+ "der Höhle hinter dem Brocken.“");
					scanner.nextLine();
					this.initSequence();

				} else if (random > 0.5 && random <= 0.75) {
					System.out.println("Du gehst zu diesem mysteriösen Mann. Er macht einen netten Eindruck" + System.lineSeparator()
					+ "auf dich. Er mustert dich an und sagt dann: „Soll ich dir etwas verraten?“");
					scanner.nextLine();

					System.out.println("„Du kannst eine Truhe nur mit einem Truhen-Aufspürer sichtbar machen." + System.lineSeparator()
							+ "Den bekommst du aber von Balian durch Tausch.“");
					scanner.nextLine();
					this.initSequence();

				} else {
					System.out.println("Du gehst zu diesem mysteriösen Mann. Er macht einen netten Eindruck" + System.lineSeparator()
					+ "auf dich. Er mustert dich an und sagt dann: „Soll ich dir etwas verraten?“");
					scanner.nextLine();

					System.out.println("„Wenn du zuerst zum Goldschmied gehst, bevor du Balian's ersten" + System.lineSeparator()
							+ "Auftrag erledigst, erhälst du eine verbesserte Waffe als Belohnung.“");
					scanner.nextLine();
					this.initSequence();				
				}
			} else if (option.matches("3") || option.matches("gast")) {
				if (player.getItem(05) != null) {

					System.out.println("„Oh, da bist du ja wieder. Sogar mit dem Silberschlüssel. Alle" + System.lineSeparator()
					+ "Achtung. Du hast echt Mumm. Also mit diesem Schlüssel kannst" + System.lineSeparator()
					+ "die Schatztruhe entriegeln, die irgendwo in der dunklen Gasse" + System.lineSeparator()
					+ "von Banditen versteckt wurde. Aber diese ist verborgen.“");
					scanner.nextLine();
					this.initSequence();

				} else {
					player.setSeitengasse(true);
					System.out.println("„Hey Fremder, hast du schon gehört? Es gibt ein verlassenes Haus," + System.lineSeparator()
					+ "denn die Besitzer haben sich dort selbst erhängt. Man munkelt," + System.lineSeparator()
					+ "dass sie einen Silberschlüssel im Haus aufbewahrt haben, der eine" + System.lineSeparator()
					+ "Schatztruhe entriegeln kann. Diese befindet sich ..“");
					scanner.nextLine();
					System.out.println("Er wurde von jemand anderes unterbrochen. Komme wieder, wenn du" + System.lineSeparator()
					+ "den Silberschlüssel besitzt.");
					option = scanner.nextLine();
					this.initSequence();
				}

			} else if (option.matches("4") || option.matches("verlassen")) {
				System.out.println("Du haust schleunigst ab und kehrst zur Einkaufspassage zurück.");

				StadtSequence01 spelunkesequence01 = new StadtSequence01(01, playerName, player);
				spelunkesequence01.initSequence();

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Wofür entscheidest du dich?");
			}
		} while (option == null);
	}
}