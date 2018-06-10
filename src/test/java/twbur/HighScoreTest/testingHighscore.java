package twbur.HighScoreTest;

import org.junit.Test;

import de.hdm_stuttgart.twbur.Player;
import twbur.HighScoreTest.Highscore;
import twbur.HighScoreTest.HighscoreList;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class testingHighscore {

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, restartButtonPanel, mainTextPanel, highScoreTextPanel, choiceButtonPanel;
	JLabel titleNameLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	JButton startButton, restartButton, choice1;
	JTextArea mainTextArea, highscoreTextArea;

	String position;

	TitleScreenHandler tsHandler = new TitleScreenHandler();
	TitleScreenHandler2 tsRHandler = new TitleScreenHandler2();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	@Test
	public static void main(String[] args) {
		new testingHighscore();
	}

	public void testDaten() {
		Player player = new Player("RankingTester");
		File file = new File("hsTest.txt");

		player.setPlayerHighScore(0);
		player.addPlayerHighScore(100);
		HighscoreList hsl = new HighscoreList();
		hsl.checkHighscore(new Highscore(player.getPlayerName(), player.getPlayerHighScore()));

		hsl.writeFileTest(file);
		hsl.showHighscore(highscoreTextArea);
	}

	public testingHighscore() {

		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();

		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("RANKING TESTS");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);

		restartButtonPanel = new JPanel();
		restartButtonPanel.setBounds(300, 400, 200, 100);
		restartButtonPanel.setBackground(Color.black);
		restartButtonPanel.setVisible(false);

		startButton = new JButton("OPEN");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.black);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);

		restartButton = new JButton("CLOSE");
		restartButton.setBackground(Color.black);
		restartButton.setForeground(Color.black);
		restartButton.setFont(normalFont);
		restartButton.addActionListener(tsRHandler);

		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		restartButtonPanel.add(restartButton);

		con.add(titleNamePanel);
		con.add(startButtonPanel);
		con.add(restartButtonPanel);

		window.setVisible(true);
	}

	public void createTitleScreen() {

		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);

		highScoreTextPanel = new JPanel();
		highScoreTextPanel.setBounds(10, 10, 800, 500);
		highScoreTextPanel.setBackground(Color.black);
		con.add(highScoreTextPanel);

		highscoreTextArea = new JTextArea("insert Ranking here");
		highscoreTextArea.setBounds(100, 100, 600, 250);
		highscoreTextArea.setBackground(Color.black);
		highscoreTextArea.setForeground(Color.white);
		highscoreTextArea.setFont(normalFont);
		highscoreTextArea.setLineWrap(true);
		highScoreTextPanel.add(highscoreTextArea);

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(150, 200, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);

		mainTextArea = new JTextArea("insert any text");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 510, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);

		choice1 = new JButton("Button");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.black);
		choice1.setFocusPainted(false);
		choiceButtonPanel.add(choice1);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");

		highscoreTextArea.setLineWrap(true);
		highscoreTextArea.setWrapStyleWord(true);

		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);

		setup();
	}

	public void setup() {
		titleNamePanel.setVisible(true);
		startButtonPanel.setVisible(true);		
		Ranking();
	}

	public void Ranking() {
		position = "ranking";
		mainTextPanel.setVisible(false);
		highScoreTextPanel.setVisible(true);
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		testDaten();

		choice1.setText("CLOSE");
	}

	public void backScreen() {
		position = "back";
		mainTextPanel.setVisible(true);
		titleNamePanel.setVisible(false);
		restartButtonPanel.setVisible(false);
		mainTextArea.setText("Nochmal RankingTester hinzufügen.");
		highScoreTextPanel.setVisible(false);
		choice1.setText("OPEN AGAIN");
	}

	public class TitleScreenHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			createTitleScreen();
		}
	}

	public class TitleScreenHandler2 implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			choice1.setVisible(true);		
			setup();
		}
	}

	public class ChoiceHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String yourChoice = event.getActionCommand();

			switch(position) {
			case "back":
				switch(yourChoice) {
				case "c1": setup();
				} break;

			case "ranking":
				switch(yourChoice) {
				case "c1": backScreen();
				} break;
			}
		}
	}
}
