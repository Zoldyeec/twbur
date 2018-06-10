/**
 * Dunklen Gasse - Sackgasse
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.Enemy;
import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class StadtSequence02 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);
	private Enemy skeleton = new Enemy(10, "magisches Skelett", 1);

	public StadtSequence02(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {

		System.out.println("Du begibst dich auf dem Weg und suchst zuerst in der dunklen Gasse nach Meko." + System.lineSeparator()
		+ "Es sieht nach einer Sackgasse aus." + System.lineSeparator());
		if (player.isSkelett() == false) {
			System.out.println("In einer Ecke kannst du eine Gestalt erkennen." + System.lineSeparator());
		}

		System.out.println("1 :zur dreckigen Seitengasse");
		System.out.println("2 :zurück zur Einkaufspassage");
		if (player.isSkelett() == false) {
			System.out.println("3 :Gestalt nähern");
		}
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich?");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();

			if (option.matches("1") || option.matches("seitengasse") || option.matches("gasse")) {

				System.out.println("Du gehst weiter zur dreckigen Seitengasse." + System.lineSeparator());

				RaetselSequence00 stadtsequence02 = new RaetselSequence00(02, playerName, player);
				stadtsequence02.initSequence();

			} else if (option.matches("2") || option.matches("zurück") || option.matches("ablehnen")) {

				System.out.println("Du kehrst zurück zur Einkaufspassage.");

				StadtSequence01 stadtsequence02 = new StadtSequence01(02, playerName, player);
				stadtsequence02.initSequence();

			} else if (option.matches("3") || option.matches("gestalt") || option.matches("angreifen")) {

				if (player.isSkelett() == false) {
					System.out.println("Du näherst dich und diese Gestalt ist ein magisches Skelett.");
					System.out.println("Er bemerkt dich, läuft auf dich zu und greift dich an.");

					scanner.nextLine();

					if (skeleton.getEnemyLevel() > player.getPlayerLevel()) {
						System.out.println("Du wolltest noch rechtzeitig ausweichen, aber das Skelett war" + System.lineSeparator()
						+ "schneller und hat dich mit einem Hieb erwischt." + System.lineSeparator()
						+ skeleton.getEnemyName() + " hat Dich besiegt." + System.lineSeparator()
						+ System.lineSeparator());
						scanner.nextLine();

						if (player.getPlayerSafepoint() == 0) {
							Sequence01 monsterskeleton = new Sequence01(10, playerName, player);
							monsterskeleton.initSequence();
						} else {
							TaverneSequence00 monsterskeleton = new TaverneSequence00(10, playerName, player);
							monsterskeleton.initSequence();
						}
					} else {
						player.setPlayerExperience(skeleton.getExpPoints());
						player.refreshLevel(player.getPlayerExperience());
						player.setSkelett(true);

						System.out.println("Du weichst gekonnt aus und greifst mit " + player.getPlayerWeapon().getObjectName() + " an und besiegst " + skeleton.getEnemyName() + " damit." + System.lineSeparator()
						+ skeleton.getEnemyName() + " stirbt und du erhälst " + skeleton.getExpPoints() + " EXP." + System.lineSeparator()
						+ System.lineSeparator()
						+ "Deine aktuelle EXP beträgt: " + player.getPlayerExperience() + System.lineSeparator()
						+ "Dein aktuelles Level beträgt: " + player.getPlayerLevel() + System.lineSeparator());

						System.out.println("Du kehrst zurück zur Einkaufspassage." + System.lineSeparator());

						StadtSequence01 stadtsequence02 = new StadtSequence01(02, playerName, player);
						stadtsequence02.initSequence();
					} 
				} else {
					System.out.println("Da ist niemand." + System.lineSeparator());

					this.initSequence();
				}

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Wohin möchtest du gehen?");
			}
		} while (option == null);
	}
}