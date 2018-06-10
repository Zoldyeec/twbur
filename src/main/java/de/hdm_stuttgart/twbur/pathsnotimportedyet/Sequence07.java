/**
 * Ein Tod
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class Sequence07 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public Sequence07(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("In der Taverne hast du weitere Informationen bekommen über das mögliche verbleiben von Godric."+ System.lineSeparator()
		+ "Du folgst den Spuren zu einem schmalen Weg in den Wald entlang. Er führt dich immer weiter" + System.lineSeparator()
		+ "ins Unterholz. Es wird immer schwieriger den Pfad zu erkennen, bis du in einer scheinbaren Sackgasse" + System.lineSeparator()
		+ "endest. Auf der einen Seite wächst ein dichtes Gestrüpp aus immergrüne Ranken. Sie scheinen ein wenig" + System.lineSeparator()
		+ "mitgenommen und du erkennst Säbelspuren an ihnen. Bei näherem Hinschauen, erkennst du einen Tunnel, der" + System.lineSeparator()
		+ "nur wenige Fuß Durchmesser beträgt und von den Ranken verdeckt wird." + System.lineSeparator());

		System.out.println("1 :Eingang zum Tunnel freischlagen.");
		System.out.println("2 :Anderen Weg suchen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1' oder '2' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			if (option.matches("1") || option.matches("tunnel") || option.matches("freischlagen")) {
				System.out.println("Du versuchst mithilfe deiner Waffe die Ranken zu zerkleinern." + System.lineSeparator());

				player.addPlayerHighScore(10);
				
				Sequence08 sequence07 = new Sequence08(07, playerName, player);
				sequence07.initSequence();

			} else if (option.matches("2") || option.matches("anderen weg") || option.matches("weg")) {

				System.out.println("Du suchst nach einem niedrigen Ast um auf einen Baum zu klettern und so einen besseren "+ System.lineSeparator()
						+ "Überblick zu bekommen. Rechts scheint einer der Bäume kaum von den Ranken befallen zu sein."+ System.lineSeparator()
						+ "Du kletterst von Ast zu Ast weiter nach oben. Durch das dichte Laub des Baumes fällt es dir "+ System.lineSeparator()
						+ "schwer etwas zu sehen. Weiter oben gibt es eine Lücke im Laub, doch der Ast wirkt etwas morsch."+ System.lineSeparator()
						+ "Du gehst trotzdem weiter. Die Aussicht ist atemberaubend. Dir war nicht klar wie weit oben "+ System.lineSeparator()
						+ "du schon bist. Der ganze Wald erstreckt sich unter dir. Eine leichte Brise bringt den "+ System.lineSeparator()
						+ "würzigen Geruch des Waldes mit sich. Da hörst du plötzlich ein Knacken. Du schaust nach unten und"+ System.lineSeparator()
						+ "der Ast gibt nach. Du versuchst dich noch an irgendetwas in deiner Nähe festzuhalten, doch zu spät "+ System.lineSeparator()
						+ "Du stürzt in die Tiefe und bist tot." + System.lineSeparator());

				player.addPlayerHighScore(-20);
				
				if (player.getPlayerSafepoint() == 0) {
					Sequence01 sequence07 = new Sequence01(07, playerName, player);
					sequence07.initSequence();
				} else {
					TaverneSequence01 sequence07 = new TaverneSequence01(07, playerName, player);
					sequence07.initSequence();
				}
			} else {
				option = null;
				System.out.println("Falsche Eingabe. Versuch es doch noch einmal.");
			}
		} while (option == null);
	}
}