/**
 * kein gültiges Level
 */

package de.hdm_stuttgart.twbur.pathsnotimportedyet;

import se2.theWorldBetweenUs.GameSequence;
import se2.theWorldBetweenUs.Player;

public class Sequence00 extends GameSequence{

	public Sequence00(int sequenceID, String playerName, Player player) {
		super(sequenceID, playerName, player);
	}

	@Override
	public void initSequence() {
	System.out.println("keine gültige levelID");
		
	}

}
