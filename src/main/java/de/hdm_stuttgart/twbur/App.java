package de.hdm_stuttgart.twbur;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hdm_stuttgart.twbur.music_thread.MusicThread;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Starte das Mini (Text)Adventure
 * @author ew036 + mn047 + ta029
 * @project Software Entwicklung 2
 */
public class App extends Application {

	private static MusicThread mt0 = new MusicThread();
	private static final Logger log = LogManager.getLogger(App.class);

	/**
	 * startet das Hauptmenü des Spiels
	 * @param launch
	 */
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {

		log.info("Starting The World Between Us - RELOADED");

		final String fxmlFile = "/fxml/gameview.fxml";
		log.debug("Loading FXML for main view from: {}", fxmlFile);
		final FXMLLoader loader = new FXMLLoader();
		final Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

		log.debug("Showing JFX scene");
		final Scene scene = new Scene(rootNode, 800, 600);
		scene.getStylesheets().add("/styles/styles.css");

		mt0.run();
		stage.setTitle("The World Between Us");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public static MusicThread getSound() {
		return mt0;
	}

}