/**
 * Bosslevel Bosshäschen
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;
import se2.theWorldBetweenUs.Enemy;
import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;
import se2.theWorldBetweenUs.monsterSet.BossHase;

public class BossSequence03 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);
	private Enemy bosshase = new Enemy(03, "Bosshäschen", 4);

	public BossSequence03(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Der Boden erschüttert, die Gräser erzittern. Die Tiere um dich herum laufen alle weg." + System.lineSeparator()
		+ "Es fühlt sich an wie ein Erdbeben, doch hinter den Bäumen taucht ein gewaltiger Schatten auf und" + System.lineSeparator()
		+ "dann springt es aus den Büschen auf dich zu. Es hoppelt langsam und jeder Schritt hinterlässt" + System.lineSeparator()
		+ "ein lautes Beben. Es ist ein " + bosshase.getEnemyName() + " und es schaut dich neugierig an." + System.lineSeparator());
		
		System.out.println("1 :angreifen");
		System.out.println("2 :flüchten");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich?");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			
			if (option.matches("1") || option.matches("angreifen")) {
				System.out.println("Du traust dich den Boss aller Hasen anzugreifen." + System.lineSeparator());

				BossHase bosssequence01 = new BossHase(3, playerName, player);
				bosssequence01.initSequence();

			} else if (option.matches("2") || option.matches("flüchten")) {
				System.out.println("Du läufst so schnell wie möglich dahin zurück, wo du hergekommen bist." + System.lineSeparator());

				Sequence99 bosssequence01 = new Sequence99(3, playerName, player);
				bosssequence01.initSequence();

			} else if (option.matches("inspect")) {

				bosshase.inspect();					
				option = null;

			} else { 
				option = null;
				System.out.println("Falsche Eingabe. Probiere es nochmal");
			}
		} while (option == null);
	}
}