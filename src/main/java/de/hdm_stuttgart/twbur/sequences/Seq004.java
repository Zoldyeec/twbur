package de.hdm_stuttgart.twbur.sequences;

import de.hdm_stuttgart.twbur.Game;
import de.hdm_stuttgart.twbur.GameString;
import de.hdm_stuttgart.twbur.Seq;
import de.hdm_stuttgart.twbur.interfaces.ISeq;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Beschreibung der Seq004:
 * Nachdem der Spieler die Gilden angeschaut hat,
 * kann er sich für eine Klasse entscheiden.
 * Der erste Auftrag - Teil III abgeschlossen
 */
public class Seq004 extends Seq implements ISeq {

	final TextArea textArea = game.gc.textArea;
	final TextField textField = game.gc.textField;

	private String imageFile = "/images/orte/wizardstore.jpg";

	//Auswahl von drei verschiedenen Waffen und Titel
	//		private WeaponObject weapon01 = new WeaponObject(01, "Laien-Stab");
	//		private WeaponObject weapon02 = new WeaponObject(02, "einfacher Bogen");
	//		private WeaponObject weapon03 = new WeaponObject(03, "Abenteurer-Schwert");
	//		private TitleObject title01 = new TitleObject(01, "Magier");
	//		private TitleObject title02 = new TitleObject(02, "Jäger");
	//		private TitleObject title03 = new TitleObject(03, "Krieger");

	public Seq004(int seqID, Game game) {
		super(seqID, game);
	}

	@Override
	public void initSeq() {
		game.showText(getGameString(1) + getGameString(2));

		textField.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				String input = textField.getText().toLowerCase();
				game.getLog().info("Eingabe des Spielers: {}", input);
				textField.clear();

				if (input.matches("1") || input.matches("magier")) {

					game.getLog().info("Klasse: Magier");
					game.showText(getGameString(3));

					textField.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {

							game.player.addPlayerHighScore(10);
							game.switchScene(Seq004.this, 5);
						}
					});

				} else if (input.matches("2") || input.matches("jäger")) {

					game.getLog().info("Klasse: Jäger");
					game.showText(getGameString(4));

					textField.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {

							game.player.addPlayerHighScore(10);
							game.switchScene(Seq004.this, 5);
						}
					});

				} else if (input.matches("3") || input.matches("krieger")) {

					game.getLog().info("Klasse: Krieger");
					game.showText(getGameString(5));

					textField.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {

							game.player.addPlayerHighScore(10);
							game.switchScene(Seq004.this, 5);
						}
					});

				} else {
					game.getLog().info("error input: {}", input);
					textArea.appendText(input + "\n");
					textArea.appendText(getGameString(6));
				}
			}
		});
	}

	@Override
	public void initStrings() {

		//Auswahl der Klasse
		stringList.add(new GameString(1,
				"„Danke &name, dass du diese Dinge für mich ausgeliefert hast. Ich darf dich "
						+ "doch nun Dutzen, oder?! Dieser nutzlose Trottel Godric ist immer "
						+ "noch nicht zurück.\n\nHier ist schon mal deine Bezahlung.\n\n\n"));
		stringList.add(new GameString(2,
				"Hast du dich schon entschieden, welcher Gilde du beitreten willst?“"
						+ "\n&line\n"
						+ "1 :Klasse der Magier\n"
						+ "2 :Klasse der Jäger\n"
						+ "3 :Klasse der Krieger"
						+ "\n&dlin\n"));
		//Magier
		stringList.add(new GameString(3,
				"„Sehr gut. Du bist nun ein ?.\n\nDu solltest zum Hauptquartier zurückkehren.\n" 
						+ "Die Gildenmitglieder werden dir mit der Ausrüstung weiter helfen.“\n"
						+ "&line\n" 
						+ "[&name erhält eine magische Robe + ?.]"));
		//Jäger
		stringList.add(new GameString(4,
				"„Sehr gut. Du bist nun ein ?.\n\nDu solltest zum Hauptquartier zurückkehren.\n" 
						+ "Die Gildenmitglieder werden dir mit der Ausrüstung weiter helfen.“\n"
						+ "&line\n" 
						+ "[&name erhält eine Lederrüstung + ?.]"));
		//Krieger
		stringList.add(new GameString(5,
				"„Sehr gut. Du bist nun ein ?.\n\nDu solltest zum Hauptquartier zurückkehren.\n" 
						+ "Die Gildenmitglieder werden dir mit der Ausrüstung weiter helfen.“\n"
						+ "&line\n"  
						+ "[&name erhält eine schwere Rüstung + ?.]"));
		//Falsche Eingabe
		stringList.add(new GameString(6,
				"════════════════════════════════════════════════════════════════\n"
						+ "Falsche Eingabe. Wählst du die Gilde der Magier, um in die Magiekünste "
						+ "einzutauchen, dann schreibe 'Magier'.\nMöchtest du dich den Jägern "
						+ "anschließen und aus der Ferne angreifen, schreibe 'Jäger'. Möchtest "
						+ "du dein neues Leben als Krieger beginnen, so schreibe 'Krieger'.\n"
						+ "Wofür entscheidest du dich?"
						+ "\n════════════════════════════════════════════════════════════════\n"));
		//Warnung -> besser als Pop Up-Fenster
		//		stringList.add(new GameString(7,
		//				"Bist du sicher mit der Auswahl? [y/n]\n"
		//						+ "Danach kannst du sie nicht mehr ändern."));
	}

	@Override
	public String getImageFile() {
		return imageFile;
	}

}
