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
 * Beschreibung der Seq003:
 * Der Spieler schaut sich alle 3 Klassen an, um dann darunter eine auszuwählen.
 * Der erste Auftrag - Teil II
 */
public class Seq003 extends Seq implements ISeq {

	final TextArea textArea = game.gc.textArea;
	final TextField textField = game.gc.textField;

	private String imageFile = "/images/orte/stadt02.jpg";

	public Seq003(int seqID, Game game) {
		super(seqID, game);
	}

	@Override
	public void initSeq() {
		game.showText(getGameString(1));

		textField.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				String input = textField.getText().toLowerCase();
				game.getLog().info("Eingabe des Spielers: {}", input);
				textField.clear();

				if (input.matches("1") || input.matches("fluss")) {

					game.showText(getGameString(2));
					game.player.addPlayerHighScore(10);

					textField.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							game.switchScene(Seq003.this, 4);
						}
					});

				} else if (input.matches("2") || input.matches("platz")) {

					game.showText(getGameString(3));
					game.player.addPlayerHighScore(10);

					textField.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							game.switchScene(Seq003.this, 4);
						}
					});

				} else if (input.matches("3") || input.matches("tempel")) {

					game.showText(getGameString(4));
					game.player.addPlayerHighScore(10);

					textField.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							game.switchScene(Seq003.this, 4);
						}
					});

				} else {
					game.getLog().info("error input: {}", input);
					textArea.appendText(input + "\n");
					textArea.appendText(getGameString(5));
				}
			}
		});
	}

	@Override
	public void initStrings() {
		stringList.add(new GameString(1,
				"Die alten Fachwerkhäuser beugen sich über die gepflasterte Straße, "
						+ "auf der Leute in mittelalterlicher Kleidung ihren Geschäften nachgehen. "
						+ "Bei näherer Betrachtung, erkennst du weitere seltsam aussehende Personen. Manche, "
						+ "haben wie Balian Fledermausohren, andere grüne Haut .., so machst du dich auf"
						+ "den Weg, um die erste Lieferung abzugeben.\n\n\n\n\n"
						+ "Dabei entdeckst du drei Pfade. Wo gehst du zuerst hin?\n"
						+ "&line\n"
						+ "1 :Magierturm am Fluss		| 3 :Bruderschaft der Krieger\n"
						+ "2 :Jagdgemeinschaft am großen Platz | in der Nähe des Tempels \n"
						+ "&dlin\n"
						+ "Wie entscheidest du dich? - Du kannst '1','2' oder '3' wählen.\n"
						+ "&dlin\n"));
		stringList.add(new GameString(2,
				"Du läufst entlang des Flusses.\n"));
		stringList.add(new GameString(3,
				"Du läufst zum großen Platz.\n"));
		stringList.add(new GameString(4,
				"Du läufst in Richtung des Tempels.\n"));
		stringList.add(new GameString(5,
				"════════════════════════════════════════════════════════════════\n"
						+ "Falsche Eingabe. Gehe den Fluss entlang zum Magierturm, so schreibe 'Fluss'.\n"
						+ "Gehe zum großen Platz der Jagdgemeinschaft, so schreibe 'Platz'.\n"
						+ "Gehe zum Tempel, wo dich die Bruderschaft der Krieger erwartet, so schreibe 'Tempel'.\n"
						+ "Wofür entscheidest du dich?"
						+ "\n════════════════════════════════════════════════════════════════\n"));
	}

	@Override
	public String getImageFile() {
		return imageFile;
	}
}