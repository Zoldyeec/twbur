/**
 * Gilde der Jäger - Teil 2b
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class MagierSequence03 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public MagierSequence03(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("„Faszinierend! Interessierst du dich möglicherweise für die Lehren der Magie?" + System.lineSeparator()
				+ "Du hast definitiv Talent dafür.“ Du bedankst dich, meinst aber, dass du vor-" + System.lineSeparator()
				+ "her noch den Lieferauftrag beenden musst. “Wenn du dich dafür entscheidest," + System.lineSeparator()
				+ "komm' zurück und wir werden dir helfen dein Talent richtig zu nutzen.“" + System.lineSeparator());
		
		System.out.println("1 :Zurück zu Balian gehen");
		System.out.println("2 :Weiter zur Jagdgemeinschaft zum großen Platz gehen");
		System.out.println("3 :Weiter zur Bruderschaft der Krieger in die Nähe des Tempels gehen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1', '2' oder '3' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			
			if (option.matches("1")) {

				System.out.println("Du läufst zurück zu Balian." + System.lineSeparator());
				
				player.addPlayerHighScore(5);

				Sequence04 magiersequence03 = new Sequence04(03, playerName, player);
				magiersequence03.initSequence();

			} else if (option.matches("2")) {

				System.out.println("Du läufst zum großen Platz." + System.lineSeparator());
				JaegerSequence01 magiersequence03 = new JaegerSequence01(03, playerName, player);
				magiersequence03.initSequence();
				
			} else if (option.matches("3")) {

				System.out.println("Du läufst in Richtung des Tempels." + System.lineSeparator());
				KriegerSequence01 magiersequence03 = new KriegerSequence01(03, playerName, player);
				magiersequence03.initSequence();

			} else { 
				option = null;
				System.out.println("Falsche Eingabe. Versuche es nochmal.");
			}
		} while (option == null);
	}
}