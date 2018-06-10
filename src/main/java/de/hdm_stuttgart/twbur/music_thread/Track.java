package de.hdm_stuttgart.twbur.music_thread;

public class Track{
	
	String filePath;
	int trackID;
		
	public Track(String filePath, int trackID){
		this.filePath = filePath;
		this.trackID = trackID;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int trackID) {
		this.trackID = trackID;
	}
}
