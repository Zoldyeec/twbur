/**
 * Ruinen Pfad 1
 * nach der Stadt
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class Sequence12 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public Sequence12(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du läufst einen Pfad entlang bis zu einer Kreuzung und entdeckst alte" + System.lineSeparator()
				+ "Ruinen zu deiner Linken." + System.lineSeparator());
		
		System.out.println("1 :gehe zu den alten Ruinen");
		System.out.println("2 :weitergehen");
		System.out.println("3 :zurück zur Stadt");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1' oder '2' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			
			if (option.matches("1") || option.matches("ruinen") || option.matches("alte ruinen")) {
				System.out.println("Du läufst den Pfad zu den alten Ruinen entlang." + System.lineSeparator());

				//schmeißt das alte Monster raus, was er nicht mehr benötigt
				try {
					this.finalize();
				} catch (Throwable e) {
					e.printStackTrace();
				}

				MonsterSequence02 sequence12 = new MonsterSequence02(12, playerName, player);
				sequence12.initSequence();

			} else if (option.matches("2") || option.matches("weitergehen") || option.matches("continue")) {

				System.out.println("Du gehst den Pfad vor dir weiter." + System.lineSeparator());
				
				Sequence13 sequence12 = new Sequence13(12, playerName, player);
				sequence12.initSequence();
				
			} else if (option.matches("3") || option.matches("zurück") || option.matches("stadt")) {

				System.out.println("Du kehrst zur Stadt zurück." + System.lineSeparator());

				StadtSequence00 sequence12 = new StadtSequence00(12, playerName, player);
				sequence12.initSequence();

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Gehst du zu den alten Ruinen, dann schreibe 'Ruinen'."
						+ System.lineSeparator() + "Gehe weiter, wenn du 'weitergehen' schreibst."
						+ System.lineSeparator() + "Wofür entscheidest du dich?");
			}
		} while (option == null);
	}
}
