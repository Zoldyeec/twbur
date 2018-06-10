package de.hdm_stuttgart.twbur.highscore;

public class Highscore {

	String name;
	int highscore;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHighscore() {
		return highscore;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}

	public Highscore(String name, int highscore) {
		this.name = name;
		this.highscore = highscore;
	}

	/**
	 * schreibt in die Rangliste der GUI rein Fehler: bei kürzeren und längeren
	 * Namen als 5 Zeichen stimmen die Abstände nicht
	 */
	public String writeOut() {
		String name = this.name + ":\t";
		int i;

		if (this.name.length() == 1) {
			for (i = this.name.length(); i < 20; i++) {
				name = name + " ";
			}
		} else if (this.name.length() == 2) {
			for (i = this.name.length(); i < 20 + 1; i++) {
				name = name + " ";
			}
		} else if (this.name.length() == 3) {
			for (i = this.name.length(); i < 20 + 2; i++) {
				name = name + " ";
			}
		} else if (this.name.length() == 4) {
			for (i = this.name.length(); i < 20 - 5; i++) {
				name = name + " ";
			}
		} else if (this.name.length() == 5) {
			for (i = this.name.length(); i < 20 - 4; i++) {
				name = name + " ";
			}
		} else if (this.name.length() == 6) {
			for (i = this.name.length(); i < 20 - 3; i++) {
				name = name + " ";
			}
		} else if (this.name.length() == 7) {
			for (i = this.name.length(); i < 20 - 2; i++) {
				name = name + " ";
			}
		} else if (this.name.length() == 8) {
			for (i = this.name.length(); i < 20 - 1; i++) {
				name = name + " ";
			}
		} else if (this.name.length() == 9) {
			for (i = this.name.length(); i < 20 - 8; i++) {
				name = name + " ";
			}
		} else if (this.name.length() == 10) {
			for (i = this.name.length(); i < 20 - 7; i++) {
				name = name + " ";
			}
		} else {
			for (i = this.name.length(); i < 15; i++) {
				name = name + " ";
			}
		}
		return name + highscore;
	}

	// public String writeOut() {
	// String name = this.name + ":";
	// //Der Abstand beträgt 15 Zeichen
	// for (int i = this.name.length(); i < 15; i++) {
	// //zwischen Name und Score ein Leerzeichen machen
	// name = name + " ";
	// } return name + highscore;
	// }

	/**
	 * schreibt in die File hs.txt rein
	 */
	@Override
	public String toString() {
		return this.name + ": " + highscore;
	}

}
