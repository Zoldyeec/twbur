/**
 * Platzhalter
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class Sequence98 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public Sequence98(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du gehst weiter" + System.lineSeparator()
		+ ".." + System.lineSeparator());
		System.out.println("1 :Auswahl");
		System.out.println("2 :Auswahl");
		System.out.println("3 :Auswahl");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1','2' oder '3' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
//			if (option.matches("1") || option.matches("01") || option.matches("001")) {
			if (option.matches("1")) {
				System.out.println("..." + System.lineSeparator());

				Sequence99 sequence98 = new Sequence99(98, playerName, player);
				sequence98.initSequence();

			} else if (option.matches("2")) {

				System.out.println("..." + System.lineSeparator());

				Sequence99 sequence98 = new Sequence99(98, playerName, player);
				sequence98.initSequence();

			} else if (option.matches("3")) {

				System.out.println("..." + System.lineSeparator());
			
				Sequence99 sequence98 = new Sequence99(98, playerName, player);
				sequence98.initSequence();

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Gehe 1, so schreibe '1'."
						+ System.lineSeparator() + "Gehe 2, so schreibe '2'."
						+ System.lineSeparator() + "Gehe 3, so schreibe '3'."
						+ System.lineSeparator() + "Wofür entscheidest du dich?");
			}
		} while (option == null);
	}
}
