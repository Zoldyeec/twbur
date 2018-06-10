/**
 * Die zweite Taverne Teil 1
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class TaverneSequence04 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public TaverneSequence04(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du erreichst die Taverne und öffnest die Tür. Der Minotaurus steht wohl immer dort."
				+ "Er schaut dich an. Was steht heute an? Du siehst außerdem eine bunte Wiese.");

		TaverneSequence05 tavernesequence03 = new TaverneSequence05(03, player.getPlayerName(), player);
		tavernesequence03.initSequence();
	}
}