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
 * Beschreibung der Seq005:
 * Diese Sequence kommt nach der Klassenauswahl.
 * 1: Dieser Weg führt zum Tod.
 * 2: Dieser Weg führt zur Taverne, da ist der erste Speicherpunkt.
 * 
 * hier wiederholt sich Seq001, da die alten Sequencen noch nicht importiert wurden 
 */
public class Seq005 extends Seq implements ISeq {

	final TextArea textArea = game.gc.textArea;
	final TextField textField = game.gc.textField;

	private String imageFile = "/images/orte/kutsche.jpg";

	public Seq005(int seqID, Game game) {
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

				//führt in eine Falle
				if (input.matches("1") || input.matches("geräusch") || input.matches("geräusch folgen")) {

					game.player.addPlayerHighScore(-5);
					game.showText(getGameString(3));

					textField.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							game.switchScene(Seq005.this, 1);
						}
					});

					//führt zur 1.Taverne
				} else if (input.matches("2") || input.matches("fußspuren") || input.matches("fußspuren folgen")) {

					game.player.addPlayerHighScore(10);
					game.showText(getGameString(4));

					textField.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {

							game.switchScene(Seq005.this, 1);
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
				"Als du am Hauptquartier ankommst, stehen in einer Ecke einige "
						+ "Mitglieder vor einer Tafel und reden miteinander. Einer aus der "
						+ "Gruppe dreht sich um, nachdem du eintrittst. „Hey du Neuling! "
						+ "Warst du nicht Balian‘s Lieferant? Dieser Auftrag könnte für dich "
						+ "interessant werden. Jemand hat Godric‘s Lieferkutsche ein Stück "
						+ "außerhalb der Stadt gefunden. Sieht wohl nach einem Überfall aus, "
						+ "nur dass das Einzige was fehlt, Godric selbst ist.\n\n\n\n\n"
						+ "Alle Waren sind noch am Ort des Verbrechens. Es wurden außerdem Hinweise "
						+ "auf einen Kampf gefunden. Du solltest dort hin gehen und die Sache untersuchen.\n\n\n"
						+ "Du gehst der Sache auf den Grund ...\n\n"));
		stringList.add(new GameString(2,
				"Du untersuchst das Chaos. Die Spuren weisen auf einen Kampf hin. "
						+ "Blut ist auf den Boden, Fußspuren führen zu einem Pfad entlang. "
						+ "Plötzlich hörst du ein Rascheln hinter dir."
						+ "\n&line\n"
						+ "1 :Geräusch folgen\n"
						+ "2 :Fußspuren folgen"
						+ "\n&dline\n"));
		stringList.add(new GameString(3,
				"Das Rascheln wird immer lauter.\n"));
		stringList.add(new GameString(4,
				"Du folgst den Spuren bis du auf einen Weg stößt. In der Ferne siehst du eine Taverne.\n"));
		stringList.add(new GameString(5,
				"════════════════════════════════════════════════════════════════\n"
						+ "Falsche Eingabe. Gehst du zu den alten Ruinen, dann schreibe "
						+ "'Ruinen'. Gehe weiter, wenn du 'weitergehen' schreibst.\n"
						+ "Wofür entscheidest du dich?"
						+ "\n════════════════════════════════════════════════════════════════\n"));
	}

	@Override
	public String getImageFile() {
		return imageFile;
	}

}