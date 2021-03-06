/**
 * Die Taverne nach dem Tod durch Sequence zu TaverneSequence03
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;
import se2.theWorldBetweenUs.interfaces.GameSequenceFactory;
import se2.theWorldBetweenUs.interfaces.IGameSequence;

public class TaverneSequence01 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public TaverneSequence01(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du schließt die Augen. Du wachst plötzlich auf und schaust dich um." + System.lineSeparator()
		+ "Dann bemerkst du, dass du wieder in der Taverne aufgewacht bist." + System.lineSeparator()
		+ "Der Minotaurus steht an deinem Bett und spricht zu dir:" + System.lineSeparator()
		+ "„Ich habe dich draußen gefunden. Vielleicht solltest du einen anderen Weg nehmen.“" + System.lineSeparator());

		if (player.getPlayerSafepoint() == 0) {
			TaverneSequence03 tavernesequence00 = new TaverneSequence03(0, playerName, player);
			tavernesequence00.initSequence();

		} else {

			IGameSequence loadSequence = GameSequenceFactory.getInstance(player.getPlayerSafepoint(), player.getPlayerName(), player);
			loadSequence.initSequence();
		}
	}
}