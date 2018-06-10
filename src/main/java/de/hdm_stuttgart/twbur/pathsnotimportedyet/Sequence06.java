/**
 * diese Sequence führt nur zu Tode durch DRACHE MUHAHAHAHAHAHAHAHAHA‚
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class Sequence06 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public Sequence06(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Das Rascheln wird immer lauter. Es fällt dir schwer zu orten aus welcher Richtung es kommt." + System.lineSeparator()
				+ "Im Augenwinkel nimmst du wahr, wie Etwas an dir vorbei huscht. Als du dich umdrehst, erkennst du etwas" + System.lineSeparator()
				+ "Dunkelgrünes auf einem alten Baumstumpf. Du näherst dich und bemerkst, dass es sich um einen kleinen" + System.lineSeparator()
				+ "Drachen handelt. Er flattert mit den Flügeln und legt seinen Kopf schräg. Ohne Furcht schaut er dir" + System.lineSeparator()
				+ "direkt in die Augen." + System.lineSeparator());

		System.out.println("1 :Drachen versuchen zu streicheln");
		System.out.println("2 :Drachen mit Ast stupsen");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1' oder '2' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();

			if (option.matches("1") || option.matches("streicheln")) {
				System.out.println("Langsam näherst du dich dem Drachen und hälst vorsichtig deine Hand hin." + System.lineSeparator()
				+ "Er schaut sie verwundert an und schnuppert daran. Als du versuchst die Schuppen" + System.lineSeparator()
				+ "zu berühren, weicht der kleine Drache zurück und gibt ein lautes Krächzen von sich." + System.lineSeparator()
				+ "Plötzlich hörst du einen weiteren Schrei, lauter und tiefer als das des kleinen Drachen." + System.lineSeparator()
				+ "Du schaust zum Himmel rauf und bemerkst einen riesigen schwarzen Drachen über dir." + System.lineSeparator()
				+ "Er funkelt dich böse an und gibt einen weiteren ohrenbetäubenden Schrei von sich." + System.lineSeparator()
				+ "Ohne zu zögern, fängt sein Hals an zu glühen und er speit glühende Flammen auf dich" + System.lineSeparator()
				+ "und alles was dich umgibt. Game Over!"+ System.lineSeparator());
				
				player.addPlayerHighScore(-20);

				if (player.getPlayerSafepoint() == 0) {
					Sequence01 sequence06 = new Sequence01(06, playerName, player);
					sequence06.initSequence();
				} else {
					TaverneSequence00 sequence06 = new TaverneSequence00(06, playerName, player);
					sequence06.initSequence();
				}
			} else if (option.matches("2") || option.matches("stupsen")) {

				System.out.println("Du findest einen langen Ast, mit dem du den Drachen vorsichtig stupst. Verärgert " + System.lineSeparator()
				+ "faucht er dich an. Du stupst ihn ein zweites Mal. Plötzlich bläht er sich auf. Sein Hals"+ System.lineSeparator()
				+ "fängt an zu glühen. Er spreizt seine Flügel. Dir fällt auf, dass er größer ist, als du dachtest," + System.lineSeparator()
				+ "bevor er mit einem lauten Krächzen Feuer aus seinem Rachen speit. Du versuchst zu entkommen," + System.lineSeparator()
				+ "aber alle umgebenen Pflanzen fangen sofort Feuer und kesseln dich ein. Du spürst einen starken" + System.lineSeparator()
				+ "Windstoß von oben und blickst dort hin. Über dir fliegt der Drache auf einer Stelle und " + System.lineSeparator()
				+ "fixiert dich, bevor er ein weiteres Mal glühende Flammen speit. Game Over!"+ System.lineSeparator());

				player.addPlayerHighScore(-20);
				
				if (player.getPlayerSafepoint() == 0) {
					Sequence01 sequence06 = new Sequence01(06, playerName, player);
					sequence06.initSequence();
				} else {
					TaverneSequence00 sequence06 = new TaverneSequence00(06, playerName, player);
					sequence06.initSequence();
				}
			} else {
				option = null;
				System.out.println("Falsche Eingabe.");
			}
		} while (option == null);
	}
}