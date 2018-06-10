/**
 * Die erste Taverne Teil 1
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class TaverneSequence02 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public TaverneSequence02(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du erreichst eine Taverne und öffnest die Tür. Drinnen erkennst du einen" + System.lineSeparator()
		+ "Minotaurus, der gerade die Gläser putzt. Er starrt dich an mit seinen" + System.lineSeparator()
		+ "ausdrucksvollen Augen, doch dann grinst er dich breit an:" + System.lineSeparator());
		System.out.printf("„Willkommen %s, dies ist meine bescheidene Taverne, hier sind alle ", playerName);
		System.out.println("Aben-" + System.lineSeparator()
		+ "teurer eingeladen, die Nacht hier sicher zu verbringen." + System.lineSeparator());
		System.out.println("Ansonsten kannst du deinen Weg fortsetzen oder zum Strand laufen." + System.lineSeparator()
		+ "Hier, das geht auf's Haus.“ Der Barkeeper überreicht dir ein Krug Pale Ale." + System.lineSeparator()
		+ System.lineSeparator()
		+ "Du überlegst und antwortest dann bestimmt:" + System.lineSeparator());
				
		TaverneSequence03 tavernesequence02 = new TaverneSequence03(01, player.getPlayerName(), player);
		tavernesequence02.initSequence();
	}
}