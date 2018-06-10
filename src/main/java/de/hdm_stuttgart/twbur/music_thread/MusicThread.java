package de.hdm_stuttgart.twbur.music_thread;

import java.io.File;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hdm_stuttgart.twbur.App;
import javafx.scene.media.*;

/**
 * Thread, um Musik laufen zu lassen
 */
public class MusicThread implements Runnable{

	private static final Logger log = LogManager.getLogger(App.class);

	private ArrayList<Track> tracks = new ArrayList<>();
	private static MediaPlayer player;

	private boolean toggleMusic = true;
	private int currentTrack;

	@Override
	public void run() {
		// Musik beim Startbildschirm (intro.wav)
		tracks.add(new Track("src/main/resources/music/intro.wav", 0));
		// Musik beim Spielstart (asteria.mp3)
		tracks.add(new Track("src/main/resources/music/asteria.mp3", 1));

		startIntro();
	}

	
	public void startIntro() {
		currentTrack = 0;
		Media intro = new Media(new File(getURI(0)).toURI().toString());
		player = new MediaPlayer(intro);
		try {
			player.play();
			log.debug("music started: {}", intro.getSource());
		} catch (Exception e) {
			log.error("unable to play music", e, e.getCause());
		}
	}

	public String getURI(int trackID) {
		for (int i = 0; i < tracks.size(); i++) {
			if (tracks.get(i).getTrackID() == trackID) {
				return tracks.get(i).getFilePath();
			}
		} return null;
	}

	public void changeTrack(int trackID) {
		player.stop();
		Media mediafile = new Media(new File(getURI(trackID)).toURI().toString());
		player = new MediaPlayer(mediafile);
		currentTrack = trackID;

		if (toggleMusic == true) {
			try {
				player.play();
				log.debug("music started: {}", mediafile.getSource());
			} catch (Exception e) {
				log.error("unable to play music", e, e.getCause());
			}
		}
	}

	public void stopMusic() {
		if (toggleMusic == true) {
			player.stop();
			log.debug("current music stopped");
			toggleMusic = false;

		} else {
			Media mediafile = new Media(new File(getURI(currentTrack)).toURI().toString());
			player = new MediaPlayer(mediafile);
			toggleMusic = true;

			try {
				player.play();
				log.debug("music started: {}", mediafile.getSource());
			} catch (Exception e) {
				log.error("unable to play music", e, e.getCause());
			}
		}
	}
}
