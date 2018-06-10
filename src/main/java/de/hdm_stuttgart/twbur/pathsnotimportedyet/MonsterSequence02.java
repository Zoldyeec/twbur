/**
 * Ruinen mit Gnomen 42%, Orcs 15%, Goblins 41% und Trolle 2%
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;
import se2.theWorldBetweenUs.interfaces.GameSequenceFactory;
import se2.theWorldBetweenUs.interfaces.IGameSequence;

import java.util.Scanner;

public class MonsterSequence02 extends GameSequence{

	static Scanner scanner = new Scanner(System.in);

	public MonsterSequence02(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	@Override
	public void initSequence() {
		int seq = rmMonster();
		IGameSequence rmMonster = GameSequenceFactory.getInstance(seq, player.getPlayerName(), player);
		
		System.out.println("Nach ein paar Minuten siehst du eine dunkle Gestalt, dass sich in den" + System.lineSeparator()
		+ "Schatten eines der zerfallenen Gebäuden versteckt." + System.lineSeparator());

		System.out.println("1 :angreifen");
		System.out.println("2 :flüchten");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1' oder '2' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();

			if (option.matches("1") || option.matches("angreifen")) {
				System.out.println("Du gehst ein paar" + System.lineSeparator()
				+ "Schritte auf diese Gestalt zu und dann..."+ System.lineSeparator());
				
				rmMonster.initSequence();

			} else if (option.matches("2") || option.matches("flüchten")) {
				System.out.println("Du flüchtest lieber und gehst zurück, um den Pfad vor dir weiter zu gehen." + System.lineSeparator());

				Sequence12 MonsterSequence02 = new Sequence12(02, playerName, player);
				MonsterSequence02.initSequence();

			} else if (option.matches("inspect")) {
				
				rmMonster.inspect();
				option = null;

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Bist du zu blöd zum Tippen??");
			}
		} while (option == null);
	}

	public int rmMonster(){

		double random = Math.random();
		if (random < 0.42){
			return 104;
			
		} else if (random >= 0.42 && random <= 0.67) {
			return 106;
			
		} else if (random > 0.67 && random <= 0.98) {
			return 107;

		} else {
			return 108;
		}
	}
}