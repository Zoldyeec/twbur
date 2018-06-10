/**
 * Wiesen mit giftgrüne Häschen und Wolftinger
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;
import se2.theWorldBetweenUs.interfaces.GameSequenceFactory;
import se2.theWorldBetweenUs.interfaces.IGameSequence;

import java.util.Scanner;

public class MonsterSequence01 extends GameSequence{

	static Scanner scanner = new Scanner(System.in);

	public MonsterSequence01(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	@Override
	public void initSequence() {
		int seq = rmMonster();
		System.out.println("Du bist auf einer Wiese gelandet." + System.lineSeparator()
		+ "Du entdeckst lauter Kleintiere um dich herum." + System.lineSeparator());

		System.out.println("1 :angreifen");
		System.out.println("2 :weitergehen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich?");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			
			if (option.matches("1") || option.matches("angreifen")) {
				System.out.println("Du versuchst das Tier anzugreifen. Dann ..." + System.lineSeparator());

				IGameSequence rmMonster = GameSequenceFactory.getInstance(seq, player.getPlayerName(), player);
				rmMonster.initSequence();

			} else if (option.matches("2") || option.matches("weitergehen")) {
				System.out.println("Du flüchtest lieber und gehst zurück, um den Pfad vor dir weiter zu gehen." + System.lineSeparator());

			Sequence98 MonsterSequence01 = new Sequence98(01, playerName, player);
				MonsterSequence01.initSequence();

			} else if (option.matches("inspect")) {
				
				IGameSequence rmMonster = GameSequenceFactory.getInstance(seq, player.getPlayerName(), player);
				rmMonster.inspect();
				option = null;

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Versuch's nochmal.");
			}
		} while (option == null);
	}

	public int rmMonster() {

		double random = Math.random();
		if (random < 0.5){
			return 101;

		} else {
			return 102;
		}
	}
}