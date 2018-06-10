package de.hdm_stuttgart.twbur;

public class GameString {
	
	private int stringID;
	private String gameString;
	
	public GameString(int stringID, String gameString) {
		super();
		this.stringID = stringID;
		this.gameString = gameString;
	}

	public int getStringID() {
		return stringID;
	}

	public void setStringID(int stringID) {
		this.stringID = stringID;
	}

	public String getGameString() {
		return gameString;
	}

	public void setGameString(String gameString) {
		this.gameString = gameString;
	}
	
}
