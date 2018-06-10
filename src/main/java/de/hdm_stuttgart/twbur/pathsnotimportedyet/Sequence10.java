/**
 * Ein Tod durch Kraken
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class Sequence10 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public Sequence10(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Der Tunnel öffnet sich zu einer großen unterirdischen Höhle. Durch einige Löcher an"+ System.lineSeparator()
				+ "der Decke scheint Sonnenlicht herein. Die Felswände sind mit zahlreichen kleinen Höhlenöffnungen"+ System.lineSeparator()
				+ "perforiert und in der erscheint vor dir ein dunkler unterirdischer See. Das Wasser bewegt sich"+ System.lineSeparator()
				+ "kaum, so dass die Oberfläche wie ein großer schwarzer Spiegel wirkt. Ein paar Meter entfernt, liegt"+ System.lineSeparator()
				+ "ein altes Boot."+ System.lineSeparator());
		
		System.out.println("1 :Boot benutzen, um mögliche Auswege aus der Höhle zu finden");
		System.out.println("2 :Weiter dem Ufer folgen und versuchen, um den See zu gehen.");
		System.out.println(System.lineSeparator());
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("Wie entscheidest du dich? - Du kannst '1' oder '2' wählen.");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		String option = null;
		do {
			option = scanner.nextLine();
			option.toLowerCase();
			
			if (option.matches("1") || option.matches("boot") || option.matches("boot benutzen")) {
				System.out.println("Du steigst vorsichtig in das Boot. Es schwankt ein wenig und verursacht Wellen auf dem Wasser. "+ System.lineSeparator()
						+ "Mit dem Paddel stößt du dich vom Rand ab. Das Boot gleitet sanft durch das schwarze Wasser. "+ System.lineSeparator()
						+ "Du treibst immer weiter auf dem stillen Wasser bis sich plötzlich kleine Wellen bilden, die immer "+ System.lineSeparator()
						+ "größer werden. Ein tiefes Rauschen erklingt. Die Höhle bebt. Geröll fällt von der Decke. Aus den Tiefen "+ System.lineSeparator()
						+ "des Wassers erscheinen lange Krankenarme, die das kleine Boot packen und zerstören. Du versuchst mit "+ System.lineSeparator()
						+ "letzter Kraft zu entkommen, aber die Krankenarme packen dich und ziehen dich mit sich in die untiefen "+ System.lineSeparator()
						+ "des schwarzen Sees. Game Over." + System.lineSeparator());
				
				player.addPlayerHighScore(-20);

				if (player.getPlayerSafepoint() == 0) {
					Sequence01 sequence10 = new Sequence01(10, playerName, player);
					sequence10.initSequence();
				} else {
					TaverneSequence00 sequence10 = new TaverneSequence00(10, playerName, player);
					sequence10.initSequence();
				}
			} else if (option.matches("2") || option.matches("ufer") || option.matches("ufer folgen")) {

				System.out.println("missing Text." + System.lineSeparator());

				player.addPlayerHighScore(10);

				Sequence11 sequence10 = new Sequence11(11, playerName, player);
				sequence10.initSequence();

			} else {
				option = null;
				System.out.println("Falsche Eingabe. Versuch es doch noch einmal.");
			}
		} while (option == null);
	}
}