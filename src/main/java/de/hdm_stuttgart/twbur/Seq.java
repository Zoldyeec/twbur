package de.hdm_stuttgart.twbur;

import java.util.ArrayList;

import de.hdm_stuttgart.twbur.interfaces.ISeq;

public abstract class Seq implements ISeq{

	protected int seqID;
	protected Game game;
	protected ArrayList<GameString> stringList;
	protected String imageFile;
	
	
	public Seq(int seqID, Game game){
		this.seqID = seqID;
		this.game = game;
		this.stringList = new ArrayList<>();
	}

	public int getSeqID() {
		return seqID;
	}

	public String getGameString(int stringID){
		for (int i = 0; i < stringList.size(); i++) {
			if (stringList.get(i).getStringID() == stringID) {
				return stringList.get(i).getGameString();
			}
		} return null;
	}

}
