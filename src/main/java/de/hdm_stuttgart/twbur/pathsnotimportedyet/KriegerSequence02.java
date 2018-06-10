/**
 * Gilde der Krieger - Teil 2a
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class KriegerSequence02 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public KriegerSequence02(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Er rollt vor deine Füße. Er schaut dich verwundert an. „Das war beeindruckend." + System.lineSeparator()
				+ "Ich sehe du hast sehr viel Kraft. Das hätte ich dir nicht zugetraut, um ehrlich" + System.lineSeparator()
				+ "zu sein. Ich bin übrigens Byron. Wenn du Interesse daran hast der Bruderschaft" + System.lineSeparator()
				+ "der Krieger beizutreten, melde dich bei mir.“ Du bedankst dich und gehst weiter." + System.lineSeparator()); 
		
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

				Sequence04 kriegersequence02 = new Sequence04(02, playerName, player);
				kriegersequence02.initSequence();
					
		} else if (option.matches("2")) {

				System.out.println("Du läufst entlang des Flusses." + System.lineSeparator());

				MagierSequence01 kriegersequence02 = new MagierSequence01(02, playerName, player);
				kriegersequence02.initSequence();

			} else if (option.matches("3")) {

				System.out.println("Du läufst zum großen Platz." + System.lineSeparator());
				JaegerSequence01 kriegersequence02 = new JaegerSequence01(02, playerName, player);
				kriegersequence02.initSequence();
				


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