/**
 * Platzhalter
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class Sequence99 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public Sequence99(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du gehst weiter zum Kampf-Test." + System.lineSeparator()
		+ ".." + System.lineSeparator());
		System.out.println("1 :BossSequence01");
		System.out.println("2 :BossSequence03");
		System.out.println("3 :MonsterSequence01");
		System.out.println("4 :MonsterSequence02");
		System.out.println("5 :MonsterSequence03");
		System.out.println("6 :RaetselSequence00");
		System.out.println("7 :StadtSequence00");
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

				BossSequence01 sequence99 = new BossSequence01(99, playerName, player);
				sequence99.initSequence();
				
			} else if (option.matches("2")) {
					System.out.println("..." + System.lineSeparator());

					BossSequence03 sequence99 = new BossSequence03(99, playerName, player);
					sequence99.initSequence();
					
			} else if (option.matches("3")) {
				System.out.println("..." + System.lineSeparator());

				MonsterSequence01 sequence99 = new MonsterSequence01(99, playerName, player);
				sequence99.initSequence();

			} else if (option.matches("4")) {

				System.out.println("..." + System.lineSeparator());

				MonsterSequence01 sequence99 = new MonsterSequence01(99, playerName, player);
				sequence99.initSequence();

			} else if (option.matches("5")) {

				System.out.println("..." + System.lineSeparator());
			
				MonsterSequence02 sequence99 = new MonsterSequence02(99, playerName, player);
				sequence99.initSequence();
				
			} else if (option.matches("6")) {

				System.out.println("..." + System.lineSeparator());
			
				RaetselSequence01 sequence99 = new RaetselSequence01(99, playerName, player);
				sequence99.initSequence();
				
			} else if (option.matches("7")) {
				
				System.out.println("Nach einem langen Weg erreichst du eine unbekannte Stadt. Dies ist das Eingangstor zu 'Elysia'." + System.lineSeparator()
				+ "Am Tor steht jemand in einer eisernen Rüstung. Ein Wächter bewacht das Tor.");
			
				StadtSequence00 sequence99 = new StadtSequence00(99, playerName, player);
				sequence99.initSequence();

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Was willst du testen?");
			}
		} while (option == null);
	}
}