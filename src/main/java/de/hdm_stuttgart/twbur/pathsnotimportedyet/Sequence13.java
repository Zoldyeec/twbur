/**
 * Ruinen Pfad 2
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class Sequence13 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public Sequence13(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du läufst weiter. Auf deiner Linken befindet sich ein großer Brocken," + System.lineSeparator()
				+ "hinter ihm ist etwas." + System.lineSeparator());
		
		System.out.println("1 :gehe zu dem großen Brocken");
		System.out.println("2 :weitergehen");
		System.out.println("3 :zurückgehen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1' oder '2' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			
			if (option.matches("1") || option.matches("brocken") || option.matches("großer brocken")) {
				System.out.println("Du läufst zum großen Broken." + System.lineSeparator());

				Sequence15 sequence13 = new Sequence15(13, playerName, player);
				sequence13.initSequence();

			} else if (option.matches("2") || option.matches("weitergehen") || option.matches("continue")) {

				System.out.println("Du gehst den Pfad vor dir weiter." + System.lineSeparator());

				Sequence14 sequence13 = new Sequence14(13, playerName, player);
				sequence13.initSequence();
				
			} else if (option.matches("3") || option.matches("zurückgehen") || option.matches("back")) {

				System.out.println("Du gehst zurück." + System.lineSeparator());

				Sequence12 sequence13 = new Sequence12(13, playerName, player);
				sequence13.initSequence();

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Gehst du zu den alten Ruinen, dann schreibe 'Ruinen'."
						+ System.lineSeparator() + "Gehe weiter, wenn du 'weitergehen' schreibst."
						+ System.lineSeparator() + "Wofür entscheidest du dich?");
			}
		} while (option == null);
	}
}
