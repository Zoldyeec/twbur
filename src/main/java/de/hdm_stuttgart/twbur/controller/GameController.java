package de.hdm_stuttgart.twbur.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hdm_stuttgart.twbur.App;
import de.hdm_stuttgart.twbur.Game;
import de.hdm_stuttgart.twbur.Player;
import de.hdm_stuttgart.twbur.highscore.HighscoreList;
import de.hdm_stuttgart.twbur.music_thread.MusicThread;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Gamescreen - GUI
 * Buttons
 */

public class GameController {

	private static final Logger log = LogManager.getLogger(App.class);
	private static MusicThread mt0 = App.getSound();
	
	@FXML public Pane gamePane, menuPane, highscorePane;
	@FXML public StackPane rightPane, imagePane, textAreaPane, inputPane;
	@FXML public Button resumeGame, newGame, showHighscore, highscoreBack, endGame, gameMenu, gameMusik;
	@FXML public TextArea textArea, highscoreText;
	@FXML public TextField textField;
	@FXML public ImageView gameImage, introImage;
	@FXML public Stage stage;

//	public Media ma = new Media(new File("src/main/resources/music/asteria.mp3").toURI().toString());
//	public MediaPlayer asteria = new MediaPlayer(ma);
//	int posMusik = 0;

	/**
	 * Button "Neues Spiel"
	 * startet das Spiel
	 */
	@FXML
	public void startGame() {
		Player player = new Player(null);
		Game game = new Game(player, this);



		game.initGame();
	}

	/**
	 * Button "Rangliste"
	 * öffnet und zeigt die Highscore-Liste an
	 */
	@FXML
	public void showHighscore() {
		highscoreText.clear();
		HighscoreList hsl = new HighscoreList();
		hsl.showHighscore(highscoreText);


		log.debug("show highscore:\n{}", highscoreText.getText());
		highscorePane.setDisable(false);
		highscorePane.setVisible(true);
	}

	/**
	 * Button "zurück" bei der Rangliste
	 * kehrt zum Hauptmenü zurück
	 */
	@FXML
	public void highscoreBack() {
		log.debug("exit highscore");
		highscorePane.setDisable(true);
		highscorePane.setVisible(false);
	}

	/**
	 * Button "Spiel beenden"
	 * schließt das Programm
	 */
	@FXML
	public void endGame() {
		log.debug("exit game");
		System.exit(0);
	}

	//Funktioniert noch nicht
	@FXML
	public void displayText() {
		textArea.clear();
		//		textArea.appendText(output);
	}

	@FXML
	public void checkInput() {
		
	}

	/**
	 * Button "Menu" nach "Neues Spiel"
	 */
	@FXML
	public void gameMenu() {
		log.debug("show menu");
//		asteria.pause();
		menuPane.setDisable(false);
		menuPane.setOpacity(1);

		resumeGame.setDisable(false);
		resumeGame.setOpacity(1);
	}

	/**
	 * Button "Musik off" nach "Neues Spiel"
	 */
	@FXML
	public void gameMusic() {
//		log.debug("music stopped: {}", ma.getSource());
		mt0.stopMusic();
	}

	/**
	 * Button "Spiel fortsetzen" beim Startbildschirm
	 */
	@FXML
	public void resumeGame() {
		log.debug("resume game");

		

		menuPane.setDisable(true);
		menuPane.setOpacity(0);
	}
}