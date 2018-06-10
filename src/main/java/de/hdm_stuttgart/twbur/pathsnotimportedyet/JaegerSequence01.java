/**
 * Gilde der Jäger - Teil 1
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class JaegerSequence01 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public JaegerSequence01(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Nicht weit von Balins Laden ist ein großer Platz. Du erkennst das Gebäude der Jagd-" + System.lineSeparator()
				+ "gemeinschaft sehr schnell. Es ist ein großes Haus, das Stützen aus kompletten Bäumen mit" + System.lineSeparator()
				+ "Rinde und Ästen besteht. Die Eingangstür ist mit Schnitzereien überzogen, die eine Jagdszene zeigen." + System.lineSeparator()
				+ "Aus dem Inneren sind Stimmen zu hören. Du klopfst an der Tür und trittst ein. Mitten in der" + System.lineSeparator()
				+ "Eingangshalle steht ein großer alter Baum mit frischem grünen Laub und roten Früchten. In einer" + System.lineSeparator()
				+ "Ecke des Raumes brennt Feuer in einem offenen Kamin, um herum sitzen zwei Personen mit dem Rücken zu dir." + System.lineSeparator()
				+ "„Hallo, ich habe eine Lieferung von Balian für die Jagdgemeinschaft. Beide drehen sich um." + System.lineSeparator()
				+ "Sie tragen Lederrüstungen aus feinem braunen Leder. Eine der Personen ist ein bärtiger kleiner Mann und" + System.lineSeparator()
				+ "die andere ist eine schlanke Frau. Sie steht auf und kommt auf dich zu. Sie hat ein dick geflochtes, rotes" + System.lineSeparator()
				+ "Haar unter denen lange spitze Ohren zutage treten. Du reichst ihr den Sack und in dem Moment," + System.lineSeparator()
				+ "in dem sie danach greift, hörst du ein dunkles Murmeln aus dem Sack kommen." + System.lineSeparator()
				+ "„Vielen Dank für die schnelle Lieferung. Du musst neu sein. Ich bin Locana. Wie lautet dein Name?“" + System.lineSeparator()
				+ "Du sagst ihn ihr." + System.lineSeparator());
		System.out.printf("Gut %s, kann ich dich um einen Gefallen bitten? Ich habe diesen neuen Pfeil entwickelt, der es" + System.lineSeparator()
				+ "selbst einem ungeübten Schützen ermöglicht es, ein Ziel aus großer Entenfug zu treffen. Kannst du" + System.lineSeparator()
				+ "es versuchen?“ Zögerlich nickst du. Sie drückt dir einen Bogen und einen Pfeil in die Hand." + System.lineSeparator()
				+ "Etwas überfordert legst du den Pfeil ein. An einer Wand der Halle ist eine Gemälde mit einer" + System.lineSeparator()
				+ "weiteren Jagdszene. Du spannst den Bogen zusammen mit dem Pfeil an und versuchst die Personen" + System.lineSeparator()
				+ "darauf so gut wie möglich nach zu ahmen.", playerName);
		System.out.println(System.lineSeparator());
		
		System.out.println("1 :Auf den riesigen Wolfskopf über dem Kamin zielen");
		System.out.println("2 :Frucht am Baum abschießen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1' oder '2' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			if (option.matches("1")) {
				System.out.println("Du atmest tief durch und konzentrierst dich auf das Auge des Wolfes." + System.lineSeparator());
				
				player.addPlayerHighScore(10);

				JaegerSequence02 jaegersequence01 = new JaegerSequence02(02, playerName, player);
				jaegersequence01.initSequence();

			} else if (option.matches("2")) {
				System.out.println("Du kneifst ein Auge zu und konzentrierst dich auf dein Ziel." + System.lineSeparator());

				player.addPlayerHighScore(5);

				JaegerSequence03 jaegersequence01 = new JaegerSequence03(02, playerName, player);
				jaegersequence01.initSequence();

			} else { 
				option = null;
				System.out.println("Falsche Eingabe. Wähle folgene Optionen: 1, oder 2.");
			}
		} while (option == null);
	}
}