/**
 * Ruinen Pfad nach Pfad 2 - Sackgasse
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.Enemy;
import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;
import se2.theWorldBetweenUs.objectSet.ItemObject;

public class Sequence15 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);
	private Enemy troll = new Enemy(07, "Troll", 3);
	private ItemObject item10 = new ItemObject(10, "geköpfter Trollkopf" ,"Das ist ein abgeschlagener Kopf eines Trolls.");

	public Sequence15(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Hinter dem Brocken befindet sich ein Eingang zu einer unterirdischen Höhle." + System.lineSeparator());

		System.out.println("1 :gehe runter");
		System.out.println("2 :zurückgehen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1' oder '2' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();

			if (option.matches("1") || option.matches("runter") || option.matches("höhle")) {
				System.out.println("Du steigst runter in die Höhle, es ist kaum etwas zu sehen. Auf dem Boden" + System.lineSeparator()
				+ "hebst du eine Streichholzschachtel auf und wunderst dich, warum sie hier" + System.lineSeparator()
				+ "rumliegt. Du zündest sie an." + System.lineSeparator()
				+ "...");

				option = scanner.nextLine();

				if (player.isKilltroll() == false) {
					System.out.println("Auf einmal hörst du einen schmerzvollen Schrei. Ein Troll taucht auf und" + System.lineSeparator()
					+ "wird durch dein Licht wütend, so dass er dich angreift.");

					if (troll.getEnemyLevel() > player.getPlayerLevel()) {
						System.out.println("Du wolltest noch rechtzeitig ausweichen, aber der Troll war" + System.lineSeparator()
						+ "schneller und hat dich mit einem Hieb erwischt." + System.lineSeparator()
						+ "Troll hat Dich besiegt." + System.lineSeparator()
						+ System.lineSeparator());

						if (player.getPlayerSafepoint() == 0) {
							Sequence01 monstertroll = new Sequence01(07, playerName, player);
							monstertroll.initSequence();
						} else {
							TaverneSequence00 monstertroll = new TaverneSequence00(07, playerName, player);
							monstertroll.initSequence();
						}
					} else {
						player.setPlayerExperience(troll.getExpPoints());
						player.refreshLevel(player.getPlayerExperience());
						player.setKilltroll(true);
						player.setAuftrag01(false);

						System.out.println("Du weichst gekonnt aus und greifst mit " + player.getPlayerWeapon().getObjectName() + " an und besiegst " + troll.getEnemyName() + " damit." + System.lineSeparator()
						+ troll.getEnemyName() + " stirbt und du erhälst " + troll.getExpPoints() + " EXP." + System.lineSeparator()
						+ System.lineSeparator()
						+ "Deine aktuelle EXP beträgt: " + player.getPlayerExperience() + System.lineSeparator()
						+ "Dein aktuelles Level beträgt: " + player.getPlayerLevel() + System.lineSeparator());

						if (player.isTausch02done() == false && player.getItem(10) == null) {
							player.addItem(item10);
							System.out.println("Du erhälst " + item10.getObjectName() + "." + System.lineSeparator());
							System.out.println("Du gehst raus aus der Höhle und zurück zur Kreuzung." + System.lineSeparator());

							player.addPlayerHighScore(30);

							Sequence13 monsterTroll = new Sequence13(01, playerName, player);
							monsterTroll.initSequence();
						} else {
							System.out.println("Du gehst raus aus der Höhle und zurück zur Kreuzung." + System.lineSeparator());

							Sequence13 monsterTroll = new Sequence13(01, playerName, player);
							monsterTroll.initSequence();
						}
					}
				} else {
					System.out.println("Da ist nichts." + System.lineSeparator()
					+ "Du gehst zurück." + System.lineSeparator());

					Sequence13 sequence15 = new Sequence13(15, playerName, player);
					sequence15.initSequence();
				}
			} else if (option.matches("2") || option.matches("zurückgehen") || option.matches("back")) {

				System.out.println("Du gehst zurück." + System.lineSeparator());

				Sequence13 sequence15 = new Sequence13(15, playerName, player);
				sequence15.initSequence();

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Gehst du zu den alten Ruinen, dann schreibe 'Ruinen'."
						+ System.lineSeparator() + "Gehe zurück, wenn du 'zurückgehen' schreibst."
						+ System.lineSeparator() + "Wofür entscheidest du dich?");
			}
		} while (option == null);
	}
}