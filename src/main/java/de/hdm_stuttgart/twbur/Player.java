package de.hdm_stuttgart.twbur;

import java.util.ArrayList;

public class Player {
	private String playerName;
	private int playerExperience;
	private int playerLevel;
	private int playerHighScore;

	ArrayList<Seq> loadedSeq;
	//	ArrayList<Quest> questlog = new ArrayList <>();
	//	ArrayList<ItemObject> inventory = new ArrayList <>();

	public Player(String playerName) {
		this.setPlayerName(playerName);
		this.setPlayerExperience(0);
		this.setPlayerLevel(0);
		this.setPlayerHighScore(0);
		this.loadedSeq = new ArrayList<>();
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @param seqID = Sequence
	 * @return null
	 */
	public Seq getSeq(int seqID){
		for (int i = 0; i < loadedSeq.size(); i++) {
			if (loadedSeq.get(i).getSeqID() == seqID) {
				return loadedSeq.get(i);
			}
		} return null;
	}

	/**
	 * @param newSeq = neue Sequence
	 */
	public void addSeq(Seq newSeq){
		for (int i = 0; i < loadedSeq.size(); i++) {
			if (loadedSeq.get(i) == newSeq) {
				break;
			} else {
				loadedSeq.add(newSeq);
			}
		}
	}

	public int getPlayerExperience() {
		return playerExperience;
	}

	public void setPlayerExperience(int playerExperience) {
		this.playerExperience = this.playerExperience + playerExperience;
	}

	public int getPlayerLevel() {
		return playerLevel;
	}

	public void setPlayerLevel(int playerLevel) {
		this.playerLevel = playerLevel;
	}

	/**
	 * aktualisiert den Erfahrungsstand des Spielers
	 * @param playerExperience = Erfahrungspunkte des Spielers
	 */
	public void refreshLevel(int playerExperience) {
		int playerLevel = this.playerLevel;
		int reqExp;
		if (playerLevel >= 0 && playerLevel < 5){
			reqExp = (playerLevel * playerLevel) * 10;
			if (playerExperience >= reqExp) {
				this.playerLevel = this.playerLevel + 1;
			}
		}
	}

	public int getPlayerHighScore() {
		return playerHighScore;
	}

	public void setPlayerHighScore(int playerHighScore) {
		this.playerHighScore = playerHighScore;
	}

	public void addPlayerHighScore(int additionalScore) {
		this.playerHighScore = this.playerHighScore + additionalScore;
	}

}