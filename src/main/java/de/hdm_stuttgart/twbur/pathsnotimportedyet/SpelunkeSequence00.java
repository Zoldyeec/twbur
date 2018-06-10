/**
 * Eine Art Wirtshaus zum Speichern und Informationen sammeln Teil 1
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import java.util.Scanner;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class SpelunkeSequence00 extends GameSequence {

	static Scanner scanner = new Scanner(System.in);

	public SpelunkeSequence00(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	public String getPlayerName() {
		return playerName = super.getPlayerName();
	}

	@Override
	public void initSequence() {
		System.out.println("Du schaust dich um. Neben dir steht ein mysteriöser Mann mit schwarzen" + System.lineSeparator()
		+ "Umhang. An der Theke steht der Barkeeper und wartet auf deine Bestellung." + System.lineSeparator()
		+ "Einer der Gäste winkt dich zu ihm. „Psst, ich erzähle dir etwas. Willst" + System.lineSeparator()
		+ "du es wissen, dann komm' her und setz' dich zu mir!“" + System.lineSeparator());
				
		SpelunkeSequence01 spelunkesequence00 = new SpelunkeSequence01(01, player.getPlayerName(), player);
		spelunkesequence00.initSequence();
	}
}