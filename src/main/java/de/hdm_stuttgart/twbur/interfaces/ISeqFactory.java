package de.hdm_stuttgart.twbur.interfaces;

import de.hdm_stuttgart.twbur.Game;
import de.hdm_stuttgart.twbur.sequences.*;

/**
 * greift auf alle Sequencen zurück
 */
public class ISeqFactory {

	/**
	 * @param seqID = Sequence
	 * @param game = Game.class
	 * @return neue Sequence
	 */
	public static ISeq getInstance(int seqID, Game game){

		switch (seqID) {
		case 1:
			return new Seq001(seqID, game);
		case 2:
			return new Seq002(seqID, game);
		case 3:
			return new Seq003(seqID, game);
		case 4:
			return new Seq004(seqID, game);
		case 5:
			return new Seq005(seqID, game);

		default:
			return new Seq001(seqID, game);
		}
	}


}
