/**
 * Ruinen Pfad 3 - Sackgasse
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.Enemy;
import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class Sequence14 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);
	private Enemy orc = new Enemy(05, "Ork", 1);

	public Sequence14(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du gehst immer weiter und weiter bis du bemerkst, dass du den großen" + System.lineSeparator()
		+ "Stein in der Kreuzung schon mal gesehen hast. Es scheint, dass du dich" + System.lineSeparator()
		+ "im Kreis drehst. Es geht wohl nicht weiter." + System.lineSeparator());

		System.out.println("1 :Du legst eine Pause ein");
		System.out.println("2 :zurückgehen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1' oder '2' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			
			if (option.matches("1") || option.matches("pause")) {
				
				if (player.isKillorc() == false) {
				System.out.println("Du legst dich etwas kurz hin und schließt deine Augen. Später wachst du" + System.lineSeparator()
				+ "auf und ein Ork schaut dich interessiert an. Du schreckst auf und er geht" + System.lineSeparator()
				+ "in Angriffstellung." + System.lineSeparator());
				option = scanner.nextLine();

					if (orc.getEnemyLevel() > player.getPlayerLevel()) {
						System.out.println("Du wolltest noch rechtzeitig ausweichen, aber der Ork war" + System.lineSeparator()
						+ "schneller und hat dich mit einem Hieb erwischt." + System.lineSeparator()
						+ "Ork hat Dich besiegt." + System.lineSeparator()
						+ System.lineSeparator());

						if (player.getPlayerSafepoint() == 0) {
							Sequence01 monsterorc = new Sequence01(05, playerName, player);
							monsterorc.initSequence();
						} else {
							TaverneSequence00 monsterorc = new TaverneSequence00(05, playerName, player);
							monsterorc.initSequence();
						}
					} else {
						player.setPlayerExperience(orc.getExpPoints());
						player.refreshLevel(player.getPlayerExperience());
						player.setKillorc(true);

						System.out.println("Du weichst gekonnt aus und greifst mit " + player.getPlayerWeapon().getObjectName() + " an und besiegst " + orc.getEnemyName() + " damit." + System.lineSeparator()
						+ orc.getEnemyName() + " stirbt und du erhälst " + orc.getExpPoints() + " EXP." + System.lineSeparator()
						+ System.lineSeparator()
						+ "Deine aktuelle EXP beträgt: " + player.getPlayerExperience() + System.lineSeparator()
						+ "Dein aktuelles Level beträgt: " + player.getPlayerLevel() + System.lineSeparator());

						System.out.println("Du gehst den Pfad zurück." + System.lineSeparator());

						player.addPlayerHighScore(20);
						
						Sequence13 monsterorc = new Sequence13(05, playerName, player);
						monsterorc.initSequence();
					}
				} else {
					System.out.println("Du legst dich etwas kurz hin und schließt die Augen." + System.lineSeparator()
					+ "Du wachst wieder auf. Nichts ist passiert. Du gehst zurück." + System.lineSeparator());

					Sequence13 sequence14 = new Sequence13(15, playerName, player);
					sequence14.initSequence();
				}
			} else if (option.matches("2") || option.matches("zurückgehen") || option.matches("back")) {

				System.out.println("Du gehst den Pfad zurück." + System.lineSeparator());

				Sequence13 sequence14 = new Sequence13(14, playerName, player);
				sequence14.initSequence();

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Gehst du zu den alten Ruinen, dann schreibe 'Ruinen'."
						+ System.lineSeparator() + "Gehe zurück, wenn du 'zurückgehen' schreibst."
						+ System.lineSeparator() + "Wofür entscheidest du dich?");
			}
		} while (option == null);
	}
}
