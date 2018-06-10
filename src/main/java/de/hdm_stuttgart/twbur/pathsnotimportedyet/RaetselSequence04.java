/**
 * Raetsellevel Teil 2 - Meko found
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class RaetselSequence04 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public RaetselSequence04(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Nun kannst du etwas erkennen. Du schaust dich um, dort steht ein Schreib-" + System.lineSeparator()
		+ "tisch aus massivem Mahagoniholz mit geschnitzten Verzierungen. Neben dem" + System.lineSeparator()
		+ "sehr großen Fenster, dessen lange Vorhänge aus weichem Satin zugezogen" + System.lineSeparator()
		+ " ist, steht ein Sessel, dessen Stoff aus goldenem Samt besteht. Dies muss" + System.lineSeparator()
		+ "wohl ein Arbeitszimmer sein. Ein dunkler Schatten befindet sich hinter" + System.lineSeparator()
		+ "einem Sessel. Du hörst ein Miauen. Das muss wohl Meko sein." + System.lineSeparator());

		System.out.println("Befehl :zu Meko gehen");
		System.out.println("Befehl :Schreibtisch anschauen");
		System.out.println("Befehl :zurück zum Gang");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich?");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();

			if (option.matches("katze") || option.matches("meko")) {
				player.setMekoFound(true);
				System.out.println("Sobald du dich dem Schatten näherst, springt es unter dem Schreibtisch." + System.lineSeparator()
				+ "Als du versuchst hinterher zu rennen, läuft es hinter den Sessel zurück," + System.lineSeparator()
				+ "wo es vorher war. Vielleicht solltest du dir etwas anderes überlegen.");
				scanner.nextLine();
				System.out.println("Da es aber erstmal nicht weitergeht, kommt Meko freiwillig zu dir und" + System.lineSeparator()
						+ "du kannst dieses Haus verlassen." + System.lineSeparator());
				StadtSequence01 raetselsequence03 = new StadtSequence01(04, playerName, player);
				raetselsequence03.initSequence();
//				option = null;

			} else if (option.matches("schreibtisch anschauen") || option.matches("schreibtisch")) {
				System.out.println(".. kommt noch." + System.lineSeparator());
				
				option = null;

			} else if (option.matches("gang") || option.matches("zurück") || option.matches("back")) {

				System.out.println("Du gehst zurück.");

				RaetselSequence03 raetselsequence03 = new RaetselSequence03(04, playerName, player);
				raetselsequence03.initSequence();

			} else if (option.matches("inspect")) {
				System.out.println("TEXT kommt noch");
				option = null;

			} else if (option.matches("pick up")) {
				System.out.println("TEXT kommt noch");
				option = null;


			} else {
				option = null;
				System.out.println("Falsche Eingabe. Versuch es doch noch einmal.");
			}
		} while (option == null);
	}
}