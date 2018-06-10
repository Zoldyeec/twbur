/**
 * Gilde der Krieger - Teil 1
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class KriegerSequence01 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public KriegerSequence01(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du erklimmst die Stufen zum Tempel. Die schweren Steine machen den Aufstieg nicht einfacher." + System.lineSeparator()
		+ "Als du oben ankommst, stehst du vor einem Gebäude mit stabilen Säulen aus Marmor und einer" + System.lineSeparator()
		+ "Kuppel aus schimmerndem blauen Material. Neben dem imposanten Gebäude des Tempels steht" + System.lineSeparator()
		+ "eine kleine Festung aus massiven Stein. Von weitem erkennst du Personen, die im Hof gegen-" + System.lineSeparator()
		+ "einander kämpfen und trainieren. Du gehst darauf zu. Der Hof ist groß und ausgestattet mit" + System.lineSeparator()
		+ "Strohfiguren, die von Kämpfern energisch malträtierend werden. Ein groß gewachsener Mann" + System.lineSeparator()
		+ "läuft durch die Reihen und korrigiert die Kämpfer. Er scheint eine wichtige Person in der" + System.lineSeparator()
		+ "Bruderschaft zu sein, also gehst du auf ihn zu, um die Lieferung anzugeben. „Entschuldigung," + System.lineSeparator()
		+ "ich habe eine Lieferung von Balian für die Bruderschaft der Krieger.“ - „Sehr gut.“" + System.lineSeparator()
		+ "Er dreht sich zu dir um. Seine mächtige Statur ist noch beeindruckender aus der Nähe." + System.lineSeparator()
		+ "„Bei solchen Rekruten braucht man sehr viele Schleifsteine. Diese Trottel nutzen die Schwerter" + System.lineSeparator()
		+ "ab wie nichts.“ Er nimmt dir die Steine ab, als würden sie nichts wiegen. „Hmmm. Du bist neu bei" + System.lineSeparator()
		+ "Balian. Godric hat sich immer beschwert, wenn er Schleifsteine ausliefern musste. Er hat verlangt," + System.lineSeparator()
		+ "dass die Bruderschaft selbst jemanden schickt.“ Er schüttelt den Kopf. „Hast du Erfahrung im Kampf?“" + System.lineSeparator()
		+ "Du schüttelst den Kopf. „Hmmm... Na gut, ich dachte jemand, der nicht so wehleidig ist, könnten wir" + System.lineSeparator()
		+ "gebrauchen. Ich würde gerne sehen, wie du dich gegenüber den anderen Rekruten schlägst. Wenn es" + System.lineSeparator()
		+ "dir nichts ausmacht.“ Er wartet deine Antwort gar nicht ab, sondern drückt dir gleich ein Schwert" + System.lineSeparator()
		+ "in die Hand. „Versuch' es an dieser Trainingspuppe.“" + System.lineSeparator());

		System.out.println("1 :Kopf der Puppe abschlagen");
		System.out.println("2 :Mit der Spitze auf das Herz zielen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1' oder '2' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			
			if (option.matches("1")) {
				System.out.println("Mit einem Hieb trennst du den Kopf von den Schultern der Puppe." + System.lineSeparator());

				player.addPlayerHighScore(5);

				KriegerSequence02 kriegersequence01 = new KriegerSequence02(01, playerName, player);
				kriegersequence01.initSequence();

			} else if (option.matches("2")) {
				System.out.println("Mit schnellen Hieben schlägst du mehrmals auf das Herz ein." + System.lineSeparator());

				player.addPlayerHighScore(10);

				KriegerSequence03 kriegersequence01 = new KriegerSequence03(01, playerName, player);
				kriegersequence01.initSequence();

			} else { 
				option = null;
				System.out.println("Falsche Eingabe. Wähle folgene Optionen: 1 oder 2.");
			}
		} while (option == null);
	}
}