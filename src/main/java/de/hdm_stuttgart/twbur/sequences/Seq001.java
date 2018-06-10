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
 * Beschreibung der Seq001: 
 * Spieler stirbt und landet im Afterlife, playerName wird mitgegeben. 
 * Entscheidung, ob er das Spiel starten will mit ja oder nein.
 * @param seqID = current Sequence
 * @param player = Player.class
 * @param game = Game.class
 * @param gc = GameController
 */
public class Seq001 extends Seq implements ISeq {

	final TextArea textArea = game.gc.textArea;
	final TextField textField = game.gc.textField;

	private String imageFile = "/images/orte/himmel.jpg";

	public Seq001(int seqID, Game game) {
		super(seqID, game);
	}

	/**
	 * Inhalt der Story
	 */
	@Override
	public void initSeq() {
		game.showText(getGameString(1));

		textField.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				String name = textField.getText();
				textField.clear();

				// Name des Spielers wird eingegeben
				boolean playerName = game.checkPlayerName(name);

				if (playerName == true) {
					game.player.setPlayerName(name);
					game.showText(getGameString(2) + (getGameString(3)));
					game.getLog().debug("check PlayerName: {}", game.player.getPlayerName());
					playerName = true;

				} else {
					game.getLog().info("error input: {}", name);
					textArea.appendText(name + "\n");
					textArea.appendText(getGameString(4));
				}

				if (playerName == true) {


					//Testing Action Event Handler removing
					//					String input = game.checkInput();
					//					textField.clear();
					//					//Spieler geht zur nächsten Sequence
					//					if (input.matches("ja") || input.matches("j")) {
					//
					//						game.gc.asteria.stop();
					//						game.player.addPlayerHighScore(5);
					//
					//						game.switchScene(Seq001.this, 2);
					//
					//						//Spiel wird beendet und Highscore wird angezeigt
					//					} else if (input.matches("nein") || input.matches("n")) {
					//						game.gc.asteria.stop();
					//						game.changeImage("/images/orte/sky.jpg");
					//
					//						//Testing Highscore:
					//						//game.player.addPlayerHighScore(99);
					//						textArea.setText("Du landest direkt in den Himmel.\n");
					//						textArea.appendText("Dein Score: " + game.player.getPlayerHighScore());
					//						textField.setText("GAME OVER"); 
					//						game.displayHighscore();
					//
					//						//zurück zur Auswahl ja oder nein
					//					} else if (input.matches("nichts") || input.matches("nix")) {
					//						textArea.appendText(textField.getText() + "\n");
					//						textArea.appendText(getGameString(5));
					//					} else {
					//						//Bei falscher Eingabe muss Spieler nochmal eingeben
					//						textArea.appendText(textField.getText() + "\n");
					//						textArea.appendText(getGameString(6));
					//					}

					//Erste Entscheidung des Spielers:
					textField.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {

							String input = textField.getText().toLowerCase();
							game.getLog().info("Eingabe des Spielers: {}", input);
							textField.clear();

							//Spieler geht zur nächsten Sequence
							if (input.matches("ja") || input.matches("j")) {
							game.player.addPlayerHighScore(5);

								game.switchScene(Seq001.this, 2);

								//Spiel wird beendet und Highscore wird angezeigt
							} else if (input.matches("nein") || input.matches("n")) {
								game.changeImage("/images/orte/sky.jpg");

								//Testing Highscore:
								//game.player.addPlayerHighScore(99);
								textArea.setText("Du landest direkt in den Himmel.\n");
								textArea.appendText("Dein Score: " + game.player.getPlayerHighScore());
								textField.setText("GAME OVER"); 
								game.displayHighscore();

								//zurück zur Auswahl ja oder nein
							} else if (input.matches("nichts") || input.matches("nix")) {
								textArea.appendText(input + "\n");
								textArea.appendText(getGameString(5));

							} else {
								//Bei falscher Eingabe muss Spieler nochmal eingeben
								game.getLog().info("error input: {}", input);
								textArea.appendText(input + "\n");
								textArea.appendText(getGameString(6));
							}
						}
					});
				}
			} 
		});
	}

	/**
	 * Texte in einer Collection
	 * -> es passen nur 7 Zeilen in einer Textbox rein (TextArea)
	 * -> 65 Zeichen passen in einer Zeile
	 */
	public void initStrings() {
		stringList.add(new GameString(1,
				"...\nKABOOM!\n...\n!!\n...\n"
						+ "...\n!!\n...\n...\n...\n"
						+ "...\n‘Wer ist da?'\n...\n‘DU! Wie lautet dein Name?'\n" + "&dlin"));
		stringList.add(new GameString(2,
				"\n&line"
						+ "\n\t\tDein Name lautet also:\n"
						+ "&line\n"
						+ "\t\t&name!\n"
						+ "\t\t...\n\n"));
		stringList.add(new GameString(3,
				"Du öffnest deine Augen und eine liebliche Stimme aus dem Nichts flüstert dir ins Ohr:\n\n"
						+ "“Willkommen im Afterlife, &name! Du hast die Chance ein neues Leben zu beginnen. "
						+ "Du wirst in einer parallelen Welt voller Magie und Monster eintauchen, die es zu besiegen gilt.\n\n\n"
						+ "Bist du bereit für ein Abenteuer?“\n"
						+ "&line"
						+ "\nWie entscheidest du dich?\nDu kannst 'ja', 'nein' oder 'nichts' wählen.\n"
						+ "&dlin\n"));
		stringList.add(new GameString(4,
				"════════════════════════════════════════════════════════════════\n"
						+ "Error: Ungültiger Name, versuche es nochmal:\n"
						+ "════════════════════════════════════════════════════════════════"));
		stringList.add(new GameString(5,
				"════════════════════════════════════════════════════════════════\n"
						+ "Du überlegst es dir nochmal ganz genau. Abenteuer starten?\n"
						+ "════════════════════════════════════════════════════════════════"));
		stringList.add(new GameString(6,
				"════════════════════════════════════════════════════════════════\n"
						+ "Falsche Eingabe.\nMöchtest du das Abenteuer starten, schreibe 'j'.\n"
						+ "Interessiert dich das Abenteuer nicht, schreibe 'n'.\n"
						+ "Möchtest du nichts tun, schreibe 'nichts'.\n"
						+ "Wofür entscheidest du dich?\n"
						+ "════════════════════════════════════════════════════════════════"));
	}

	/**
	 * wechselt das Bild im ImageView
	 * @return imageFile
	 */
	@Override
	public String getImageFile() {
		return imageFile;
	}

}