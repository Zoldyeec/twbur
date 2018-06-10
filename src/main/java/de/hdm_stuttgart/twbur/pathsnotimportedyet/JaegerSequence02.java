/**
 * Gilde der Jäger - Teil 2a
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class JaegerSequence02 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public JaegerSequence02(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du versuchst den Bogen so ruhig wie möglich zu halten und lässt los. Der Pfeil verfehlt das" + System.lineSeparator()
				+ "Auge nur um wenige Zentimeter. „Sehr Gut. Das lief ja sogar besser als ich gedacht habe. Mein" + System.lineSeparator()
				+ "Pfeil muss es dir erleichtert haben, aber du bist wohl auch ein Naturtalent. Wir sind immer" + System.lineSeparator()
				+ "auf der Suche nach Leuten mit besonderen Fähigkeiten. Wenn du daran interessiert bist uns bei-" + System.lineSeparator()
				+ "zutreten, bist du stets willkommen.“ Sie schenkt dir ein Lächeln. Du bedankst dich und meinst" + System.lineSeparator()
				+ "aber, dass du vorher noch den Lieferauftrag beenden musst. „Na gut, falls du dich dafür ent-" + System.lineSeparator()
				+ "scheidest, weißt du, wo du uns findest.“" + System.lineSeparator());
		
		System.out.println("1 :Zurück zu Balian gehen");
		System.out.println("2 :Weiter zum Magierturm am Fluss entlang gehen");
		System.out.println("3 :Weiter zur Bruderschaft der Krieger in die Nähe des Tempels gehen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1', '2' oder '3' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			if (option.matches("1")) {
				System.out.println("Du läufst zurück zu Balian." + System.lineSeparator());

				player.addPlayerHighScore(5);
				
				Sequence04 jaegersequence02 = new Sequence04(02, playerName, player);
				jaegersequence02.initSequence();
				
			} else if (option.matches("2")) {
				System.out.println("Du läufst entlang des Flusses." + System.lineSeparator());

				MagierSequence01 jaegersequence02 = new MagierSequence01(02, playerName, player);
				jaegersequence02.initSequence();
				
			} else if (option.matches("3")) {
				System.out.println("Du läufst in Richtung des Tempels." + System.lineSeparator());

				KriegerSequence01 jaegersequence02 = new KriegerSequence01(02, playerName, player);
				jaegersequence02.initSequence();

			} else { 
				option = null;
				System.out.println("Falsche Eingabe. Gehe zurück zu Balian, schreibe '1'."
						+ System.lineSeparator() + "Für weiter zum Magierturm, schreibe '2'."
						+ System.lineSeparator() + "Für weiter zur Bruderschaft der Krieger, schreibe '3'."
						+ System.lineSeparator() + "Wofür entscheidest du dich?");
			}
		} while (option == null);
	}
}