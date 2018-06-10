package newPlayerName;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hdm_stuttgart.twbur.Player;

/**
 * checkPlayerName() wird getestet, ob der Name valide Buchstaben enthält
 * 
 */
public class AddNewPlayerName {

	Player player = new Player(null);
	String name = "NewPlayerName";
	String name2 = "Playeris1";
	String name3 = "";
	String name4 = "New Player Name";
	String name5 = "New_Player_Name";

	public boolean checkPlayerName(String playerName) {
		if (playerName.matches("[a-zA-Zä-üÄ-Ü_]*") && playerName.length() != 0 && playerName.length() < 24) {
			return true;
		} else {
			return false;
		}
	}

	@Test
	public void addNewPlayer() {
		System.out.println("Checking Name: " + name);
		boolean playerName = checkPlayerName(name);

		if (playerName == true) {
			player.setPlayerName(name);
			playerName = true;

		} else {
			assertEquals("not working", null, player.getPlayerName());
			System.out.println(name + " should not work!");
		}

		if (playerName == true) {
			assertEquals("not working", name, player.getPlayerName());
			System.out.println(player.getPlayerName() + " is valid and it's working!");
		}
		System.out.printf(System.lineSeparator());
	}

	@Test
	public void addNewPlayer2() {
		System.out.println("Checking Name: " + name2);
		boolean playerName = checkPlayerName(name2);

		if (playerName == true) {
			player.setPlayerName(name2);
			playerName = true;

		} else {
			assertEquals(null, player.getPlayerName());
			System.out.println(player.getPlayerName() + " is not valid, but it's working!");
		}

		if (playerName == true) {
			System.out.println(name2 + " should not work!");
		}
		System.out.printf(System.lineSeparator());
	}
	
	@Test
	public void addNewPlayer3() {
		System.out.println("Checking Name: " + name3);
		boolean playerName = checkPlayerName(name3);

		if (playerName == true) {
			player.setPlayerName(name3);
			playerName = true;

		} else {
			assertEquals(null, player.getPlayerName());
			System.out.println(player.getPlayerName() + " is not valid, but it's working!");
		}

		if (playerName == true) {
			System.out.println(name3 + " should not work!");
		}
		System.out.printf(System.lineSeparator());
	}
	
	@Test
	public void addNewPlayer4() {
		System.out.println("Checking Name: " + name4);
		boolean playerName = checkPlayerName(name4);

		if (playerName == true) {
			player.setPlayerName(name4);
			playerName = true;

		} else {
			assertEquals(null, player.getPlayerName());
			System.out.println(player.getPlayerName() + " is not valid, but it's working!");
		}

		if (playerName == true) {
			System.out.println(name4 + " should not work!");
		}
		System.out.printf(System.lineSeparator());
	}
	
	@Test
	public void addNewPlayer5() {
		System.out.println("Checking Name: " + name5);
		boolean playerName = checkPlayerName(name5);

		if (playerName == true) {
			player.setPlayerName(name5);
			playerName = true;

		} else {
			assertEquals("not working", null, player.getPlayerName());
			System.out.println(name5 + " should not work!");
		}

		if (playerName == true) {
			assertEquals("not working", name5, player.getPlayerName());
			System.out.println(player.getPlayerName() + " is valid and it's working!");
		}
		System.out.printf(System.lineSeparator());
	}
}