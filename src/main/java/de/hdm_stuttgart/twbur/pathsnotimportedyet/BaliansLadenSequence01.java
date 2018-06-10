/**
 * Balian's Zaubererladen
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;
import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class BaliansLadenSequence01 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public BaliansLadenSequence01(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.printf("Du kannst mit mir tauschen, dafür gehe ins Hinterzimmer oder du kannst" + System.lineSeparator()
		+ "für mich einen Auftrag erledigen.“");

		System.out.println(System.lineSeparator());
		System.out.println("1 :Tauschhandel eingehen");
		System.out.println("2 :Auftrag annehmen");
		System.out.println("3 :Laden verlassen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1', '2' oder '3' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			if (option.matches("1")) {

				BaliansLadenSequence02 balianssadensequence01 = new BaliansLadenSequence02(01, playerName, player);
				balianssadensequence01.initSequence();

			} else if (option.matches("2")) {

				if (player.isAuftrag01() == false) {
					System.out.println("„Dein neuer Auftrag besteht darin 3 Goblins zu besiegen. Sie sind eine" + System.lineSeparator()
					+ "Plage geworden. Ständig überfallen sie meine Kutsche mit meinen Liefer-" + System.lineSeparator()
					+ "rungen. Diese treiben sich in den Ruinen rum. Wenn du fertig bist, kehre" + System.lineSeparator()
					+ "zu mir zurück. Nun mach' dich auf dem Weg.“" + System.lineSeparator()
					+ System.lineSeparator()
					+ "Er verschwindet wieder hinter seinem Hinterzimmer und du kehrst zurück" + System.lineSeparator()
					+ "in die Stadt." + System.lineSeparator());

					player.setGoblinCount(0);
					player.setAuftrag01(true);

					StadtSequence01 balianssadensequence01 = new StadtSequence01(01, playerName, player);
					balianssadensequence01.initSequence();

				} else {
					System.out.println("„Du scheinst noch nicht den Auftrag erledigt zu haben. Komme erst wieder," + System.lineSeparator()
					+ "wenn du fertig bist.“" + System.lineSeparator()
					+ System.lineSeparator()
					+ "Er verschwindet wieder hinter seinem Hinterzimmer und du kehrst zurück" + System.lineSeparator()
					+ "in die Stadt." + System.lineSeparator());

					StadtSequence01 balianssadensequence01 = new StadtSequence01(01, playerName, player);
					balianssadensequence01.initSequence();
				}

			} else if (option.matches("3")) {

				System.out.println("„Nun geh! Ich habe viel zu tun.“" + System.lineSeparator()
				+ "Du verlässt seinen Laden." + System.lineSeparator());

				StadtSequence01 balianssadensequence01 = new StadtSequence01(01, playerName, player);
				balianssadensequence01.initSequence();

			} else {
				option = null;
				System.out.println("Falsche Eingabe.");
			}
		} while (option == null);
	}
}