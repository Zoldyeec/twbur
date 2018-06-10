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
 * Beschreibung der Seq002:
 * Der Spieler kommt in eine neue Welt und muss einen Auftrag annehmen.
 * Der erste Auftrag - Teil I
 */
public class Seq002 extends Seq implements ISeq {

	final TextArea textArea = game.gc.textArea;
	final TextField textField = game.gc.textField;

	private String imageFile = "/images/orte/door.jpg";

	public Seq002(int seqID, Game game) {
		super(seqID, game);
	}

	@Override
	public void initSeq() {
		game.showText("Für " + game.player.getPlayerName() + " beginnt nun ein neues Leben.\n\n" + getGameString(1));

		textField.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				game.changeImage("/images/orte/wizardstore02.jpg");

				game.showText(getGameString(2));

				textField.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						game.changeImage("/images/orte/wizardstore.jpg");

						game.showText(getGameString(3));

						textField.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {

								String input = textField.getText().toLowerCase();
								game.getLog().info("Eingabe des Spielers: {}", input);
								textField.clear();

								if (input.matches("1") || input.matches("annehmen")) {

									game.showText(getGameString(4));
									game.player.addPlayerHighScore(10);

									textField.setOnAction(new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent event) {
											game.switchScene(Seq002.this, 3);
										}
									});

								} else if (input.matches("2") || input.matches("warum")) {

									game.showText(getGameString(5));
									game.player.addPlayerHighScore(5);

									textField.setOnAction(new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent event) {
											game.switchScene(Seq002.this, 3);
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
				});
			}
		});
	}

	@Override
	public void initStrings() {
		stringList.add(new GameString(1,
				"Vor dir erscheint eine hochpolierte Eichentür. Es ist kein Türknauf oder Griff zu erkennen, "
						+ "aber im Zentrum der Tür ruht ein schöner Messingklopfer. Du greifst danach. "
						+ "Er ist elegant entworfen und gefertigt worden.\n\n\n"
						+ "Bevor du die Tür öffnest, flüstert dir die liebliche Stimme nochmal ins Ohr: “Mutig, mein "
						+ "tapferer Abenteurer. Doch noch einen Rat möchte ich dir mit auf dem Weg geben, "
						+ "bevor du in diese neue Welt eintrittst:\nSuche dir erfahrene Verbündete, wenn du "
						+ "länger als einen Tag überleben willst. Du kannst hier genauso sterben und "
						+ "Schmerz fühlen wie in deiner alten Welt. Also bleibe wachsam“.\n\n\n\n"
						//ab hier funkt es nicht mehr, außer man drückt SPACE
						+ "Du drehst dich noch einmal um, aber kannst im Zwielicht nicht\nerkennen, woher "
						+ "die Stimme kommen könnte. Zögerlich klopfst du\nmit Hilfe des Messingklopfers "
						+ "an der Tür. Das Klopfen erzeugt\nein lautes Echo, in der sonst stillen Halle. "
						+ "Die schwere\nEichentür öffnet sich majestätisch und du stehst plötzlich mitten in einem Laden drin.\n"));
		stringList.add(new GameString(2,
				"Vor dir entdeckst du ein Labyrinth aus Vitrinen und Regalen. Alle gefüllt mit Tränken, "
						+ "Zauberstäben und andere seltsame Gegenstände. Hinter einer Theke erscheint eine "
						+ "Gestalt mit spitzen Zähnen und Fledermausohren. Sie trägt einen dunkelblauen Umhang.\n\n\n\n\n"
						+ "“Willkommen in Balian's Magie Laden! Wir haben Ozeane an Tränken aller Art, Meter "
						+ "über Meter an Schriftrollen mit Zaubersprüchen gegen oder für fast alles. "
						+ "Wenn es magisch ist, haben wir es bei Balian'! Treten Sie doch näher!“ "
						+ "Er kommt auf dich zu und betrachtet dich skeptisch.\n\n\n\n\n"));
		stringList.add(new GameString(3,
				"„Interessante Kleiderwahl. Zu welcher Gilde gehören Sie?“\nEr winkt ab. "
						+ "“Ist auch egal. So können Sie auf jedenfalls nicht in eine aufgenommen werden. "
						+ "Was Sie dringend sollten, wenn Sie nicht gleich im Gefängnis landen wollen. "
						+ "Hör'n Sie zu, ich habe einige Lieferungen für die Gilden. Aber Godric, der "
						+ "eigentlich als mein Lieferbursche arbeitet, ist verschwunden.\n\n\n\n"

						+ "Wenn Sie diese Lieferung machen, gibt es eine Belohnung dafür.“\n"
						+ "&line\n"
						+ "1 :'Sehr gerne.'\n"
						+ "2 :'Warum ich?'\n"
						+ "&dlin\n"
						+ "Wie entscheidest du dich? - Du kannst '1' oder '2' wählen."
						+ "\n&dlin\n"));
		stringList.add(new GameString(4,
				"'Perfekt! Hier sind die Sachen!'\n"
						+ "Ohne weitere Erklärungen drückt Balian dir die Gegenstände in die Hand "
						+ "und verschwindet im Labyrinth seines Ladens. Du bahnst dir den Weg zu der "
						+ "gegenüberliegenden offen stehenden Tür frei und trittst aus den spärlich "
						+ "beleuchteten Laden in das helle Tageslicht hinaus auf eine beschäftigte Straße. "));
		stringList.add(new GameString(5,
				"'Stellen Sie nicht so viele Fragen. Ich bezahle Sie auch dafür. "
						+ "Welche Wahl haben Sie sonst? Hier sind die Sachen und der Auftrag!' "
						+ "Ohne weitere Erklärungen drückt Balian dir die Gegenstände in die Hand "
						+ "und verschwindet im Labyrinth seines Ladens. Du bahnst dir den Weg zu der "
						+ "gegenüberliegenden offen stehenden Tür frei und trittst aus den spärlich "
						+ "beleuchteten Laden in das helle Tageslicht hinaus auf eine beschäftigte Straße."));
		stringList.add(new GameString(6, 
				"════════════════════════════════════════════════════════════════\n"
						+ "Falsche Eingabe. Nimmst du den Auftrag an, schreibe 'annehmen'. "
						+ "Fragst du dich „Warum ich?“, dann schreibe 'warum'. Wofür entscheidest du dich?\n"
						+ "════════════════════════════════════════════════════════════════"));						
	}

	@Override
	public String getImageFile() {
		return imageFile;
	}
}