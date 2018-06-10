/**
 * Raetsellevel Teil 1a - linke Tür
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;
import se2.theWorldBetweenUs.objectSet.ItemObject;
import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class RaetselSequence02 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);
	private ItemObject item04 = new ItemObject(04, "Foto", "Du schaust dir die Rückseite an: 'Folge dem weißen Kaninchen'.");
	private ItemObject item05 = new ItemObject(05, "Silberschlüssel", "Wofür er wohl gut ist?");

	
	public RaetselSequence02(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du trittst in den Raum ein." + System.lineSeparator()
		+ "Neben dem Sofa steht ein Safe, der mit einem Zahlenschloss versehen ist." + System.lineSeparator()
		+ "Auf dem Regal befinden sich Bücher, zwischen ihnen ragt etwas heraus." + System.lineSeparator());
		
		System.out.println("Befehl :Safe öffnen");
		System.out.println("Befehl :Regal anschauen");
		System.out.println("Befehl :zurück zum Eingang");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich?");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();

			if (option.matches("safe öffnen") || option.matches("öffnen") || option.matches("safe")) {
				if (player.getItem(05) == null) {

					System.out.println("Gebe die richtige Zahlenkombination ein:");
					option = scanner.nextLine();

					if (option.matches(String.valueOf(RaetselSequence01.getrandomNumber()))) {
						player.addItem(item05);
						System.out.println("Der Safe geht auf. Du findest einen kleinen silbernen Schlüssel." + System.lineSeparator()
						+ "[" + player.getItem(05).getObjectName() + " erhalten.]");
						option = null;

					} else {
						System.out.println("Leider falsch. Komme wieder, wenn du die richtige Kombination hast.");
						option = null;
					}

				} else  {
					System.out.println("Der Safe ist offen.");
					option = null;
				}

			} else if (option.matches("hint")) {

				if (player.getItem(02) != null) {
					System.out.println("Du kramst den " + player.getItem(02).getObjectName() + " nochmal heraus: '" + RaetselSequence01.getrandomNumber() + "'.");
					option = null;
				} else {
					System.out.println("Gehe zurück, um nach dem Code zu suchen.");
					option = null; 
				}
				
			} else if (option.matches("regal anschauen") || option.matches("regal")) {
				player.addItem(item04);

				System.out.println("Du ziehst etwas zwischen den Büchern heraus. Es ist ein Foto. Auf der Rückseite steht etwas.");
				System.out.println("[" + player.getItem(04).getObjectName() + " erhalten.]");
				option = null;

			} else if (option.matches("zurück zum eingang") || option.matches("eingang") || option.matches("zurück") || option.matches("back")) {

				System.out.println("Du gehst zurück.");

				RaetselSequence01 raetselsequence02 = new RaetselSequence01(02, playerName, player);
				raetselsequence02.initSequence();

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Versuch es doch noch einmal.");
			}
		} while (option == null);
	}
}