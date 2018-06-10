/**
 * Raetsellevel Intro
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class RaetselSequence00 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public RaetselSequence00(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {

		System.out.println("Du begibst dich auf die Suche nach Meko und untersuchst die dreckige" + System.lineSeparator()
		+ "Seitengasse. Diese führt zu einem leer stehendem Gebäude. Du hörst ein" + System.lineSeparator()
		+ "Miauen. Es kommt aus dem Gebäude. Die Eingangstür ist mit Brettern ver-" + System.lineSeparator()
		+ "rammelt." + System.lineSeparator());

		System.out.println("1 :an der Eingangstür klopfen");
		System.out.println("2 :zurück zur Stadt");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? Es gibt mehrere Möglichkeiten.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		String option2 = null;
		String option3 = null;

		do {
			option = scanner.nextLine();
			option.toLowerCase();

			if (option.matches("1") || option.matches("eingangstür") || option.matches("eingang")) {
				System.out.println("Du klopfst an der Tür und wartest eine Weile. Niemand antwortet.");
				option = null;

			} else if (option.matches("inspect")) {

				System.out.println("Du schaust genauer hin und entdeckst zwei 'Fenster' neben der Eingangstür." + System.lineSeparator() 
				+ "Ansonsten sehen die 'Bretter' an der Tür sehr alt aus.");
				option = null;

			} else if (option.matches("bretter")) {
				System.out.println("Du drückst dagegen und die Bretter zerbrechen im Nu. Die Tür springt auf.");
				
				System.out.println("Du dringst durch die offene Tür in das verlassene Gebäude ein. Du" + System.lineSeparator() 
				+ "horchst, ob jemand da ist. Ein lautes Knallen ertönt hinter dir und du" + System.lineSeparator() 
				+ "erschreckst dich. Das war nur der Wind, der wohl die Tür zugeknallt hat." + System.lineSeparator()
				+ "Du schaust dich in dem Eingangsbereich um. Es ist still und niemand zu" + System.lineSeparator()
				+ "sehen. Du machst das Licht an und entdeckst ein paar Gemälde an der Wand." + System.lineSeparator()
				+ "Eines hängt aber schief." + System.lineSeparator());

				RaetselSequence01 raetselsequence00 = new RaetselSequence01(00, playerName, player);
				raetselsequence00.initSequence();

			} else if (option.matches("fenster")) {
				System.out.println("Neben der Eingangstür ist ein linkes und ein rechtes Fenster. Für welches entscheidest du dich?");
				option2 = null;
				option2 = scanner.nextLine();

				if (option2.matches("linkes fenster") || option2.matches("links")) {

					System.out.println("Du gehst zum linken Fenster, du rüttelst daran. Es öffnet sich ein kleiner Spalt." + System.lineSeparator()
					+ "Versuche es nochmal, um es zu öffnen.");
					option3 = null;
					option3 = scanner.nextLine();

					if (option3.matches("linkes fenster") || option3.matches("links")) {

						System.out.println(
								"Du wackelst stärker daran bis das Fenster aufgeht. Das Fenster ist nun" + System.lineSeparator()
								+ "offen und du dringst in das verlassene Gebäude ein. Du horchst, ob je-" + System.lineSeparator() 
								+ "mand da ist. Ein lautes Knallen ertönt hinter dir und du erschreckst" + System.lineSeparator()
								+ "dich. Das war nur der Wind, der wohl die Fenster zugeknallt hat. Du" + System.lineSeparator()
								+ "schaust dich in dem Eingangsbereich um. Es ist still und niemand zu" + System.lineSeparator()
								+ "sehen. Du machst das Licht an und entdeckst ein paar Gemälde an der"  + System.lineSeparator()
								+ "Wand. Eines hängt aber schief." + System.lineSeparator());

						RaetselSequence01 raetselsequence00 = new RaetselSequence01(00, playerName, player);
						raetselsequence00.initSequence();

					} else {
						System.out.println("Nochmal von vorne. Wähle das 'Fenster' nochmal aus.");
						option = null;
					}

				} else if (option2.matches("rechtes fenster") || option2.matches("rechts")) {

					System.out.println("Du gehst zum rechten Fenster, du rüttelst daran. Es passiert nichts.");
					option = null;

				} else {
					System.out.println("Versuche es nochmal.");
					option = null;
				}

			} else if (option.matches("2") || option.matches("stadt") || option.matches("zurück") || option.matches("back")) {

				StadtSequence01 raetselsequence00 = new StadtSequence01(00, playerName, player);
				raetselsequence00.initSequence();

			} else { 
				option = null;
				System.out.println("Falsche Eingabe. Probiere es nochmal.");
			}
		} while (option == null);
	}
}