/**
 * Kein Tod, Enemy erscheint
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;
import se2.theWorldBetweenUs.interfaces.GameSequenceFactory;
import se2.theWorldBetweenUs.interfaces.IGameSequence;

public class Sequence09 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public Sequence09(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du kriechst immer weiter bis der Tunnel hoch genug ist, so dass du stehen kannst."+ System.lineSeparator()
				+ "Plötzlich stolperst du über etwas am Boden. Als du den Gegenstand näher betrachtest, erkennst"+ System.lineSeparator()
				+ "du, dass es sich um einen Umhang handelt. Er kommt dir von irgendwo bekannt vor. Da fällt es"+ System.lineSeparator()
				+ "dir wieder ein! Balian trug einen Umhang wie diesen. Womöglich gehörte dieser Godric. Aber was"+ System.lineSeparator()
				+ "ist mit ihm passiert? Du bemerkst einen fauligen Geruch, der in der Luft hängt. Am fernen Ende"+ System.lineSeparator()
				+ "des Tunnels siehst du eine Gestalt, die sich über etwas beugt. Bei näherer Betrachtung siehst"+ System.lineSeparator()
				+ "du, dass es ein Schuh ist. Zwischen dir und der Gestalt siehst du einen weiteren Gang, der scharf"+ System.lineSeparator()
				+ "nach links geht. Wenn du dich an der Wand entlang kriechst, könntest du an der Gestalt womöglich"+ System.lineSeparator()
				+ "unbemerkt vorbei schleichen. " + System.lineSeparator());
		
		System.out.println("1 :Geradeaus weitergehen");
		System.out.println("2 :Nach links vorbei schleichen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1' oder '2' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;		
		int seq = rmMonster();
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			if (option.matches("1") || option.matches("weitergehen")) {
				try {
					this.finalize();
				} catch (Throwable e) {
					e.printStackTrace();
				}
				IGameSequence rmMonster = GameSequenceFactory.getInstance(seq, player.getPlayerName(), player);
				rmMonster.initSequence();

			} else if (option.matches("2")) {
				
				player.addPlayerHighScore(10);
				
				Sequence10 sequence09 = new Sequence10(9, playerName, player);
				sequence09.initSequence();

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Versuch es doch noch einmal.");
			}
		} while (option == null);
	}

	public int rmMonster() {

		double random = Math.random();
		if (random < 0.5){
			return 110;

		} else {
			return 105;
		}
	}
}