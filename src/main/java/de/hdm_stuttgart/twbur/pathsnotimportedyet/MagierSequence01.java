/**
 * Gilde der Magier - Teil 1
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class MagierSequence01 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public MagierSequence01(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Als du zum Magierturm angekommen bist, stehst du vor einer geschlossenen Tür."  + System.lineSeparator()
				+ "Du willst gerade schon umdrehen, da geht die Tür plötzlich wie von alleine" + System.lineSeparator()
				+ "einen Spalt weit auf. Verwundert schaust du durch den Spalt. „Hallo, ist da" + System.lineSeparator()
				+ "jemand? Ich hab eine Lieferung von Balian für die Magiergilde.“ Die Tür öffnet" + System.lineSeparator()
				+ "sich weiter, so dass du durch sie passt. Die Eingangshalle ist beeindruckend." + System.lineSeparator()
				+ "Hohe Buntglasfenster brechen das Licht in allen Farben, verschiedene Treppen," + System.lineSeparator()
				+ "die sich wie ineinander verschlungenen Schlangen die Wände hoch zu schlängeln." + System.lineSeparator()
				+ "Auf unterschiedlichen Ebenen siehst du Gestalten in langen violetten Roben" + System.lineSeparator()
				+ "entlang schleichen. Eine dieser Gestalten kommt auf dich zu. Der Mann trägt" + System.lineSeparator()
				+ "lange schwarze Haare, in denen Perlen und Edelsteine hängen. „Hallo, wir haben" + System.lineSeparator()
				+ "schon sehnlichst auf diese Lieferung gewartet. Vielen Dank.“ Er nimmt dir die" + System.lineSeparator()
				+ "Flaschen mit einem Lächeln ab." + System.lineSeparator()
				+ "„Mein Name ist Delmore. Es scheint vielleicht etwas aufdringlich von mir, aber" + System.lineSeparator()
				+ "seit du hier eingetreten bist, spüre ich eine gewisse magische Energie, die von" + System.lineSeparator()
				+ "dir ausgeht. Wenn es dir nichts ausmacht, würde ich gerne einen kleinen Versuch" + System.lineSeparator()
				+ "starten. „Du nickst ihm skeptisch zu. „Hier, nimm diesen Zauberstab.“ Das glatte" + System.lineSeparator()
				+ "Holz des Stabes fühlt sich warm in deinen Händen an. Dich überkommt die Lust" + System.lineSeparator()
				+ "den Stab auf etwas zu richten." + System.lineSeparator());
		
		System.out.println("1 :Zauberstab auf Drachenfigur am Brunnen zielen");
		System.out.println("2 :Schwungvoll auf grünes Feuer in silberner Schalle richten");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? Wähle eine Option aus.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			
			if (option.matches("1")) {
				System.out.println("Der Kopf des Drachen zerspringt in tausend Teile." + System.lineSeparator());
				
				player.addPlayerHighScore(5);

				MagierSequence02 magiersequence02 = new MagierSequence02(02, playerName, player);
				magiersequence02.initSequence();

			} else if (option.matches("2")) {
				System.out.println("Die Flamme wird größer, Funken sprühen, die Farbe ändert sich von hellem" + System.lineSeparator()
						+ "Grün zu einem dunklen Violett." + System.lineSeparator());

				player.addPlayerHighScore(10);

				MagierSequence03 magiersequence03 = new MagierSequence03(03, playerName, player);
				magiersequence03.initSequence();

			} else { 
				option = null;
				System.out.println("Falsche Eingabe. Wähle folgene Optionen: 1 oder 2.");
			}
		} while (option == null);
	}
}