/**
 * Der erste Auftrag Teil 3 - abgeschlossen
 * Klassenauswahl (später nicht mehr änderbar)
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;
import se2.theWorldBetweenUs.objectSet.TitleObject;
import se2.theWorldBetweenUs.objectSet.WeaponObject;

public class Sequence04 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);
	//obtain one of three chooseable weapons and titles
	private WeaponObject weapon01 = new WeaponObject(01, "Laien-Stab");
	private WeaponObject weapon02 = new WeaponObject(02, "einfacher Bogen");
	private WeaponObject weapon03 = new WeaponObject(03, "Abenteurer-Schwert");
	private TitleObject title01 = new TitleObject(01, "Magier");
	private TitleObject title02 = new TitleObject(02, "Jäger");
	private TitleObject title03 = new TitleObject(03, "Krieger");

	public Sequence04(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.printf("„Danke %s, dass du diese Dinge für mich ausgeliefert hast. Ich darf dich" + System.lineSeparator(), playerName);
		System.out.println("doch nun Dutzen, oder?! Dieser nutzlose Trottel Godric ist immer noch" + System.lineSeparator()
		+ "nicht zurück. Hier ist schon mal deine Bezahlung. Hast du dich schon ent-" + System.lineSeparator()
		+ "schieden welcher Gilde du beitreten willst?“" + System.lineSeparator());

		System.out.println("1 :Klasse der Magier");
		System.out.println("2 :Klasse der Jäger");
		System.out.println("3 :Klasse der Krieger");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1', '2' oder '3' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			
			if (option.matches("1") || option.matches("magier")) {
				System.out.println("„Bist du sicher mit der Auswahl? [y/n]");
				String option2 = null;

				option2 = scanner.nextLine();
				option2.toLowerCase();
				
				if (option2.matches("y") || (option2.matches("ja"))) {
					player.setPlayerWeapon(weapon01);
					player.setPlayerTitle(title01);

					System.out.println("„Sehr gut. Du bist nun ein " + player.getPlayerTitle().getObjectName() + ". Du solltest zum Hauptquartier zurückkehren." + System.lineSeparator()
					+ "Die Gildenmitglieder werden dir mit der Ausrüstung weiter helfen." + System.lineSeparator()
					+ "[" + player.getPlayerName() + " erhält eine magische Robe + " + player.getPlayerWeapon().getObjectName() + ".]" + System.lineSeparator());
					
					player.addPlayerHighScore(10);

					Sequence05 sequence04 = new Sequence05(4, playerName, player);
					sequence04.initSequence();

				} else if (option2.matches("n") || (option2.matches("nein"))) {
					System.out.println("Wie entscheidest du dich? - Du kannst '1', '2' oder '3' wählen.");
					option = null;
				} else {
					System.out.println("Falsche Eingabe. Wähle nochmal die Klasse aus.");
					option = null;
				}
			} else if (option.matches("2") || option.matches("Jäger") || option.matches("jäger")) {
				System.out.println("„Bist du sicher mit der Auswahl? [y/n]");
				option = null;

				String option2 = scanner.nextLine();
				option2.toLowerCase();
				
				if (option2.matches("y") || (option2.matches("ja"))) {
					player.setPlayerWeapon(weapon02);
					player.setPlayerTitle(title02);

					System.out.println("„Sehr gut. Du bist nun ein " + player.getPlayerTitle().getObjectName() + ". Du solltest zum Hauptquartier zurückkehren." + System.lineSeparator()
					+ "Die Gildenmitglieder werden dir mit der Ausrüstung weiter helfen.“" + System.lineSeparator()
					+ "[" + player.getPlayerName() + " erhält eine Lederrüstung + " + player.getPlayerWeapon().getObjectName() + ".]" + System.lineSeparator());

					player.addPlayerHighScore(10);
					
					Sequence05 sequence04 = new Sequence05(4, playerName, player);
					sequence04.initSequence();

				} else if (option2.matches("n") || (option2.matches("nein"))) {
					System.out.println("Wie entscheidest du dich? - Du kannst '1', '2' oder '3' wählen.");
					option = null;
				} else {
					System.out.println("Falsche Eingabe. Wähle nochmal die Klasse aus.");
					option = null;
				}
			} else if (option.matches("3") || option.matches("Krieger") || option.matches("krieger")) {
				System.out.println("Bist du sicher mit der Auswahl? [y/n]");
				option = null;

				String option2 = scanner.nextLine();
				option2.toLowerCase();
				
				if (option2.matches("y") || (option2.matches("ja"))) {
					player.setPlayerWeapon(weapon03);
					player.setPlayerTitle(title03);

					System.out.println("„Sehr gut. Du bist nun ein " + player.getPlayerTitle().getObjectName() + ". Du solltest zum Hauptquartier zurückkehren." + System.lineSeparator()
					+ "Die Gildenmitglieder werden dir mit der Ausrüstung weiter helfen.“" + System.lineSeparator()
					+ "[" + player.getPlayerName() + " erhält eine schwere Rüstung + " + player.getPlayerWeapon().getObjectName() + ".]" + System.lineSeparator());

					player.addPlayerHighScore(10);

					Sequence05 sequence04 = new Sequence05(4, playerName, player);
					sequence04.initSequence();

				} else if (option2.matches("n") || (option2.matches("nein"))) {
					System.out.println("Wie entscheidest du dich? - Du kannst '1', '2' oder '3' wählen.");
					option = null;
				} else {
					System.out.println("Falsche Eingabe. Wähle nochmal die Klasse aus.");
					option = null;
				}
			} else {
				option = null;
				System.out.println("Falsche Eingabe. Wählst du die Gilde der Magier, um in die Magiekünste" + System.lineSeparator()
				+ "einzutauchen, dann schreibe 'Magier'."
				+ System.lineSeparator() + "Möchtest du dich den Jägern anschließen und aus der Ferne angreifen," + System.lineSeparator()
				+ "schreibe 'Jäger'."
				+ System.lineSeparator() + "Möchtest du dein neues Leben als Krieger beginnen, so schreibe 'Krieger'."
				+ System.lineSeparator() + "Wofür entscheidest du dich?");
			}
		} while (option == null);
	}
}
