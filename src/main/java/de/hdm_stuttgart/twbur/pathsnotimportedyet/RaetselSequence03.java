/**
 * Raetsellevel Teil 1b, - Treppen nach oben - Tod oder ins nächste Level
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.objectSet.ItemObject;
import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class RaetselSequence03 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);
	private ItemObject item03 = new ItemObject(03, "Feuerzeug" ,"Eine kleine Flamme, die etwas Licht abgibt oder etwas anzündet.");

	public RaetselSequence03(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du stehst in einem Gang mit zwei Türen. Die linke Tür ist verschlossen." + System.lineSeparator());

		System.out.println("Befehl :linke Tür");
		System.out.println("Befehl :rechte Tür");
		System.out.println("Befehl :zurück zum Eingang");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich?");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		String option2 = null;
		String option3 = null;
		do {
			option = scanner.nextLine();

			if (option.matches("linke Tür") || option.matches("linke tür") || option.matches("links")) {
				System.out.println("Die Tür ist verschlossen, du brauchst einen Schlüssel.");

				option = null;

			} else if (option.matches("rechte Tür") || option.matches("rechte tür") || option.matches("rechts")) {
				if (player.getItem(03) != null) {

					System.out.println("Im Zimmer entdeckst du eine Kerze, du zündest sie mit dem " + item03.getObjectName() + " an.");

					RaetselSequence04 raetselsequence03 = new RaetselSequence04(4, playerName, player);
					raetselsequence03.initSequence();

				} else if (player.getItem(03) == null) {

					System.out.println("Es ist dunkel. Willst du weitergehen? [y/n]");

					// Du stirbst, wenn du das Licht nicht anmachst, aber weitergehst.
					// Beim Sterben verliert der Spieler alles, alle bisherigen gefundene Items im Haus löschen (bitte).
					option2 = scanner.nextLine();
					if (option2.matches("y") || (option2.matches("ja"))) {

						System.out.println("Du gehst in das Zimmer rein. Die Tür geht plötzlich zu. Es ist zu dunkel." + System.lineSeparator()
						+ "Es scheint keine gute Idee zu sein, ohne Licht in einen dunklen Ort zu gehen." + System.lineSeparator()
						+ "Du läufst in die Arme von einem grausamen Wesen mit blutrünstigen Reißzähnen." + System.lineSeparator()
						+ "Versuch' es nochmal, doch nächstes Mal bringst du etwas zum Beleuchten mit." + System.lineSeparator()
						+ "Dieses Level nochmal neu starten? [y/n]");
						player.deleteItem(01);
						player.deleteItem(02);
						player.deleteItem(03);
						player.deleteItem(04);
						player.deleteItem(05);

						option3 = scanner.nextLine();
						if (option3.matches("y") || (option3.matches("ja"))) {

							System.out.println("GAME OVER."+ System.lineSeparator()
							+ "Du wachst wieder in der Eingangshalle auf. Deine bisherigen gesammelten" + System.lineSeparator()
							+ "Items sind verschwunden." + System.lineSeparator());

							RaetselSequence01 raetselSequence03 = new RaetselSequence01(03, playerName, player);
							raetselSequence03.initSequence();

						} else if  (option3.matches("n") || (option3.matches("nein"))) {
							System.out.println("GAME OVER." + System.lineSeparator()
							+ "Du wachst in der Gosse auf. Deine bisherigen gesammelten Items sind ver-" + System.lineSeparator()
							+ "schwunden." + System.lineSeparator());
							player.setSeitengasse(false);

							StadtSequence01 raetselSequence03 = new StadtSequence01(03, playerName, player);
							raetselSequence03.initSequence();
						} else {
							System.out.println("GAME OVER." + System.lineSeparator()
							+ "Du wachst in der Gosse auf. Deine bisherigen gesammelten Items sind ver-" + System.lineSeparator()
							+ "schwunden." + System.lineSeparator());
							player.setSeitengasse(false);

							StadtSequence01 raetselSequence03 = new StadtSequence01(03, playerName, player);
							raetselSequence03.initSequence();
						}
					} else if (option2.matches("n") || (option2.matches("nein"))) {
						System.out.println("Du bleibst im Gang stehen. Wo willst du hin?");
						option = null;

					} else {
						option = null;
						System.out.println("Wähle nochmal.");
					}
				}
			} else if (option.matches("Eingang") || option.matches("eingang") || option.matches("zurück") || option.matches("back")) {

				System.out.println("Du gehst zurück.");

				RaetselSequence01 raetselsequence03 = new RaetselSequence01(02, playerName, player);
				raetselsequence03.initSequence();

			} else if (option.matches("inspect")) {
				System.out.println("Auf dem Teppich liegt etwas. Tippe 'pick up', um es aufzunehmen.");
				option = null;

			} else if (option.matches("pick up")) {
				player.addItem(item03);

				System.out.println("Du gehst näher ran und hebst den Gegenstand auf. Es ist ein Feuerzeug." + System.lineSeparator()
				+ "[" + player.getPlayerName() + " erhält ein " + item03.getObjectName() + ".]");
				//Feuerzeug ist das zweite Objekt, falls Silberschlüssel mitgenommen wurde.
				option = null;

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Versuch es doch noch einmal.");
			}
		} while (option == null);
	}
}