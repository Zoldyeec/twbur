package de.hdm_stuttgart.twbur;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.controlsfx.control.textfield.TextFields;

import de.hdm_stuttgart.twbur.controller.GameController;
import de.hdm_stuttgart.twbur.highscore.Highscore;
import de.hdm_stuttgart.twbur.highscore.HighscoreList;
import de.hdm_stuttgart.twbur.interfaces.ISeq;
import de.hdm_stuttgart.twbur.interfaces.ISeqFactory;
import de.hdm_stuttgart.twbur.music_thread.MusicThread;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class Game {

	private static final Logger log = LogManager.getLogger(App.class);
	private static MusicThread mt0 = App.getSound();

	public Player player;
	public GameController gc;

	//für showText();
	private int lineCount;
	private int currVal;
	private String gameString;
	private boolean keyPressed = false;
	private boolean pauseText = false;
	private int tick = 0;

	//für checkInput
	private String input = null;

	//Wortliste für autoCompletion()
	public String[] words = {
			"angreifen",
			"aufheben",
			"beobachten",
			"benutzen",
			"beobachten",
			//Platzhalter
			"",
			"verteidigen",
			"weglaufen",
			"wegwerfen"
	};

	public Game(Player player, GameController gc) {
		this.player = player;
		this.gc = gc;
	}

	/**
	 * startet das Spiel und fängt bei der Seq001 an
	 */
	public void initGame() {
		log.debug("start game");

		//um Startbildschirm zu verlassen (wird disabled)
		gc.menuPane.setDisable(true);
		gc.menuPane.setOpacity(0);

		//zum Testen der Sequencen
		player.setPlayerName("TestPlayer");

		//ändert die Musik
		mt0.changeTrack(1);
		//startet mit der Seq001
		switchScene(null, 1);
	}

	/**
	 * Spieler wechselt von der aktuellen Sequence zur neuen Sequence
	 * @param curSeq = aktuelle Sequence
	 * @param targetSeqID = Zielsequence (nächste Sequence)
	 */
	public void switchScene(Seq curSeq, int targetSeqID) {

		if (player.getSeq(targetSeqID) == null) {
			try {
				ISeq newSeq = ISeqFactory.getInstance(targetSeqID, this);
				player.addSeq(curSeq);
				log.info("init {}", newSeq.getClass());
				changeImage(newSeq.getImageFile());
				newSeq.initStrings();
				newSeq.initSeq();
			} catch (NullPointerException npe) {
				npe.printStackTrace();
			}
		} else {
			log.info("init {}", player.getSeq(targetSeqID).getClass());
			changeImage(player.getSeq(targetSeqID).getImageFile());
			player.getSeq(targetSeqID).initStrings();
			player.getSeq(targetSeqID).initSeq();
		}
	}

	/**
	 * wird noch entwickelt, damit man nicht überall
	 * ein ActionEvent Handler hat
	 * @return Eingabe
	 */
	public String checkInput() {
		gc.textField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				input = gc.textField.getText();
			}
		}); return input;
	}

	/**
	 * ändert die Bilder von gameImage
	 */
	public void changeImage(String imageFile) {
		InputStream inStream = getClass().getResourceAsStream(imageFile);
		Image imageObject = new Image(inStream, 615, 396, false, false);
		gc.gameImage.setImage(imageObject);
	}

	/**
	 * lässt den Text einzeln erscheinen
	 * @param tick = [...]
	 */
	public void showText(String gameString) {
		gc.textArea.clear();
		this.gameString = gameString;

		final IntegerProperty i = new SimpleIntegerProperty(0);
		Timeline timeline = new Timeline();
		KeyFrame keyFrame = new KeyFrame(Duration.millis(30), event -> {

			if (i.get() >= this.gameString.length()) {
				this.lineCount = 0;
				this.currVal = 0;
				timeline.stop();

			} else {

				if (this.lineCount == 5) {
					currVal = i.get();
					pauseText = true;

					if (keyPressed == false) {		

						//beim Drücken von 'Leertaste' wird der nächste Text angezeigt
						gc.textField.setOnKeyPressed(new EventHandler<KeyEvent>() {

							@Override
							public void handle(KeyEvent keyEvent) {
								if (keyEvent.getCode() == KeyCode.SPACE) {
									keyPressed = true;
								}
							}
						});

						//zeigt an, dass man die 'Leertaste' drücken muss
						if (tick == 0) {
							gc.textField.setText("[...]");
							tick = 1;
						} else if (tick == 1) {
							gc.textField.setText("[...]");
							tick = 2;
						} else if (tick == 2) {
							gc.textField.setText("[...]");
							tick = 3;
						} else if (tick == 3) {
							gc.textField.setText("[...]");
							tick = 4;
						} else if (tick == 4) {
							gc.textField.setText("[...]");
							tick = 5;
						} else if (tick == 5) {
							gc.textField.setText("");
							tick = 0;
						}

					} else {

						if (tick == 1) {
							gc.textArea.setText(gc.textArea.getText().substring(0, gc.textArea.getText().length() - 5));
							tick = 0;
						}

						this.lineCount = 0;
						gc.textArea.clear();
						pauseText = false;
						keyPressed = false;
						gc.textField.clear();
					}
				}

				//konvertiert die Zeichen
				if (pauseText == false) {

					String a = Character.toString(this.gameString.charAt(i.get()));
					if (a.matches("&")) {
						if (this.gameString.substring(i.get() + 1, i.get() + 5).matches("line")) {
							String line = "		-------------------------";
							this.gameString = this.gameString.replaceFirst("&line", line);
							gc.textArea.setText(this.gameString.substring(currVal, i.get()+line.length()));

							i.set(i.get()+line.length());

						} else if (this.gameString.substring(i.get() + 1, i.get() + 5).matches("dlin")) {
							String dline = "════════════════════════════════════════════════════════════════";
							this.gameString = this.gameString.replaceFirst("&dlin", dline);
							gc.textArea.setText(this.gameString.substring(currVal, i.get()+dline.length()));

							i.set(i.get()+dline.length());

						} else if (this.gameString.substring(i.get() + 1, i.get() + 5).matches("name")) {
							this.gameString = this.gameString.replaceFirst("&name", player.getPlayerName());
							gc.textArea.setText(this.gameString.substring(currVal, i.get()));
						}

					} else {
						gc.textArea.setText(this.gameString.substring(currVal, i.get()));

						//zeigt den Text in der Konsole an
						//bei PlayerName zeigt er -1 Buchstabe an
						System.out.print(Character.toString(this.gameString.charAt(i.get())));
					}

					if (a.matches("\n")) {
						this.lineCount++;
					}
					i.set(i.get() + 1);
				}
			}
		});

		timeline.getKeyFrames().add(keyFrame);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	/**
	 * "automatisches Füllen" - wenn man eine Aufgabe hat
	 * zeigt eine Liste von bestimmten Befehlen an
	 */
	public void autoCompletion() {
		TextFields.bindAutoCompletion(gc.textField, words);
		gc.textField.deselect();
	}

	/**
	 * überprüft den Playername auf erlaubte Zeichen
	 * @return true, wenn Name erlaubt ist, sonst false
	 */
	public boolean checkPlayerName(String playerName) {
		if (playerName.matches("[a-zA-Zä-üÄ-Ü_]*") && playerName.length() != 0 && playerName.length() < 24) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * beim Beenden des Spiels zeigt es den Highscore an
	 * wird in hs.txt gespeichert
	 */
	public void displayHighscore() {
		log.info("Game Over");
		gc.highscoreText.clear();
		HighscoreList hsl = new HighscoreList();
		hsl.checkHighscore(new Highscore(player.getPlayerName(), player.getPlayerHighScore()));
		hsl.showHighscore(gc.highscoreText);
		log.debug("show highscore:\n{}", gc.highscoreText.getText());

		//GUI-Elemente
		gc.highscorePane.setDisable(false);
		gc.highscorePane.setVisible(true);

		gc.textField.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				gc.highscorePane.setDisable(true);
				gc.highscorePane.setVisible(false);
				gc.menuPane.setDisable(false);
				gc.menuPane.setOpacity(1);
			}
		});
	}

	public void changeMusic(int trackID){
		mt0.changeTrack(trackID);
	}

	/**
	 * Logger für andere Klassen
	 * @return Log
	 */
	public Logger getLog() {
		return log;
	}
}