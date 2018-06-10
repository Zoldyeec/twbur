/**
 * Ein Tod durch Ranken
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class Sequence08 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public Sequence08(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Nach den ersten Schlägen schreckst du zurück. Etwas hat sich bewegt." + System.lineSeparator()
				+ "Blitzschnell attackieren dich die Ranken. Sie schlingen sich um deine" + System.lineSeparator()
				+ "Beine und winden sich immer weiter um dich." + System.lineSeparator());
		
		System.out.println("1 :Aufgeben und nicht mehr weiterkämpfen.");
		System.out.println("2 :Weiterkämpfen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1' oder '2' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			if (option.matches("1")) {
				System.out.println("Ranken lockern ihren Griff und geben dir den Weg zum Tunneleingang frei." + System.lineSeparator());

				player.addPlayerHighScore(10);
				
				Sequence09 sequence08 = new Sequence09(8, playerName, player);
				sequence08.initSequence();

			} else if (option.matches("2")) {

				System.out.println("Der Griff der Ranken wird immer stärker. Bis sie dich zerquetschen und töten." + System.lineSeparator());

				player.addPlayerHighScore(-20);
				
				if (player.getPlayerSafepoint() == 0) {
					Sequence01 sequence08 = new Sequence01(8, playerName, player);
					sequence08.initSequence();
				} else {
					TaverneSequence00 sequence08 = new TaverneSequence00(8, playerName, player);
					sequence08.initSequence();
				}
			} else {
				option = null;
				System.out.println("Falsche Eingabe. Versuch es doch noch einmal.");
			}
		} while (option == null);
	}
}