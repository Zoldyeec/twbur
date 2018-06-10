/**
 * Bosslevel Schildkrötendrache Teil 1
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;
import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.objectSet.ItemObject;
import se2.theWorldBetweenUs.Player;

public class BossSequence01 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);
	//obtain Feuerlöscher
	private ItemObject bossItem100 = new ItemObject(100, "Feuerlöscher", null);

	public BossSequence01(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Draußen läufst du in Richtung Süden. Nun entdeckst du einen Strand, der sich hinter" + System.lineSeparator()
		+ "den Büschen befindet. Du gehst den Strand entlang und bemerkst einen dunklen Schatten" + System.lineSeparator()
		+ "im Wasser. Neben dir liegt eine robuste Angel mit einem großen Köder."
		+ System.lineSeparator());
		System.out.printf("1 :Angel benutzen" + System.lineSeparator());
		System.out.println(
				"2 :Schatten im Wasser ignorieren und weitergehen");
		System.out.println(System.lineSeparator());
		System.out.println("══════════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1', '2' oder weitere Optionen auswählen.");
		System.out.println("══════════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();

			if ( option.matches("inspect") ){
				System.out.println("Im Wasser siehst du einen großen dunklen Schatten." + System.lineSeparator()
				+ "Der Umriss könnte von einer Riesenschildkröte stammen." + System.lineSeparator()
				+ "Neben dir liegt ein Feuerlöscher. Was tust du?" + System.lineSeparator());
				option = null;

			} else if ( option.matches("pick up") || option.matches("Feuerlöscher") || option.matches("feuerlöscher")){
				player.addItem(bossItem100);
				
				System.out.println("Du glaubst, dass der " + player.getItem(100).getObjectName() + " nützlich sein könnte und hebst ihn auf.");
				option = null;

			} else if ( option.matches("1") || option.matches("Angel benutzen") ){
				System.out.println("Du fährst die Angel aus. Du beobachtest dabei, wie sich der Schatten zu dem Köder bewegt" + System.lineSeparator()
				+ "und dann anbeißt. Du schaffst ihn herauszuziehen und die dunkle Gestalt wird langsam" + System.lineSeparator()
				+ "erkennbar. Es ist eine gigantische Schildkröte. Nein.. einen Moment Mal. Es ist in" + System.lineSeparator()
				+ "Wirklichkeit ein SCHILDKRÖTENDRACHE! Er ist wegen dir wütend und greift dich nun an." + System.lineSeparator());

				BossSequence02 bossSequence01 = new BossSequence02(2, playerName, player);
				bossSequence01.initSequence();

			} else if ( option.matches("2") || option.matches("flüchten") ){
				System.out.println("Du machst lieber einen großen Bogen drum und läufst weiter den Strand entlang." + System.lineSeparator());

				SequenceMenu bossSequenz01 = new de.hdm_stuttgart.twbur.pathsnotimportedyet.SequenceMenu(4, playerName, player);
				bossSequenz01.initSequence();

			} else { 
				option = null;
				System.out.println("Das geht leider nicht. Möchtest du die Angel benutzen, schreibe 'Angel benutzen'." + System.lineSeparator()
				+ "Möchtest du doch lieber weitergehen und den Schatten im Wasser ignorieren, schreibe 'flüchten'." + System.lineSeparator()
				+ "Möchtest du den Schatten genauer betrachten, schreibe 'inspect'." + System.lineSeparator()
				+ "Wofür entscheidest du dich?");
			}
		} while (option == null);
	}
}