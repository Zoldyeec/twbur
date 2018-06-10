/**
 * Gilde der Jäger - Teil 2b
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class JaegerSequence03 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);


	public JaegerSequence03(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Mit aller Kraft ziehst du den Bogen so weit wie möglich nach hinten und lässt den" + System.lineSeparator()
		+ "Bogen los. Der Pfeil schießt los durch die Frucht und bleibt im Stamm des Baumes" + System.lineSeparator()
		+ "stecken. Der Saft der Frucht tropft langsam zu Boden. „Sehr Gut. Das lief ja" + System.lineSeparator()
		+ "wunderbar. Aber ich glaube nicht, dass das allein an meinem Pfeil lag. Du musst" + System.lineSeparator()
		+ "wohl ein Naturtalent sein. Bist du vielleicht daran interessiert unserer Gemein-" + System.lineSeparator()
		+ "schaft beizutreten?“ Sie schenkt dir ein Lächeln. Du bedankst dich und meinst" + System.lineSeparator()
		+ "aber, dass du vorher noch den Lieferauftrag beenden musst." + System.lineSeparator()
		+ "„Na gut, falls du dich dafür entscheidest, weißt du, wo du uns findest.“" + System.lineSeparator());

		System.out.println("1 :Zurück zu Balian gehen");
		System.out.println("2 :Weiter zum Magierturm am Fluss gehen");
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

				Sequence04 jaegersequence03 = new Sequence04(03, playerName, player);
				jaegersequence03.initSequence();

			} else if (option.matches("2")) {
				System.out.println("Du läufst entlang des Flusses." + System.lineSeparator());

				MagierSequence01 jaegersequence03 = new MagierSequence01(03, playerName, player);
				jaegersequence03.initSequence();

			} else if (option.matches("3")) {
				System.out.println("Du läufst in Richtung des Tempels." + System.lineSeparator());

				KriegerSequence01 jaegersequence03 = new KriegerSequence01(03, playerName, player);
				jaegersequence03.initSequence();

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