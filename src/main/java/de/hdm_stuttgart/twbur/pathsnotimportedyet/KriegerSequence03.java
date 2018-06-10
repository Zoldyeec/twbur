/**
 * Gilde der Krieger - Teil 2b
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class KriegerSequence03 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);
	
	public KriegerSequence03(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Er beobachtet dich fasziniert dabei. „Sehr Schön, deine Haltung ist sehr gut." + System.lineSeparator()
				+ "Du hast eine gewisse Begabung zum Krieger. Ich bin übrigens Byron. Wenn du" + System.lineSeparator()
				+ "Interesse daran hast der Bruderschaft der Krieger beizutreten, melde dich bei" + System.lineSeparator()
				+ "mir.“ Du bedankst dich und gehst weiter." + System.lineSeparator());
		
		System.out.println("1 :Zurück zu Balian gehen");
		System.out.println("2 :Weiter zum Magierturm am Fluss gehen");
		System.out.println("3 :Weiter zur Jagdgemeinschaft am großen Platz gehen");
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

				Sequence04 kriegersequence03 = new Sequence04(03, playerName, player);
				kriegersequence03.initSequence();
					
		} else if (option.matches("2")) {

				System.out.println("Du läufst entlang des Flusses." + System.lineSeparator());

				MagierSequence01 kriegersequence03 = new MagierSequence01(03, playerName, player);
				kriegersequence03.initSequence();

			} else if (option.matches("3")) {

				System.out.println("Du läufst zum großen Platz." + System.lineSeparator());
				JaegerSequence01 kriegersequence03 = new JaegerSequence01(03, playerName, player);
				kriegersequence03.initSequence();

			} else { 
				option = null;
				System.out.println("Falsche Eingabe. Gehe zurück zu Balian, schreibe '1'."
						+ System.lineSeparator() + "Gehe zum Magierturm, schreibe '2'."
						+ System.lineSeparator() + "Gehe zur Jagdgemeinschaft, schreibe '3'."
						+ System.lineSeparator() + "Wofür entscheidest du dich?");
			}
		} while (option == null);
	}
}