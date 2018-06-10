package de.hdm_stuttgart.twbur.interfaces;

/**
 * @return the description of a sequence
 */
public interface ISeq {

	String imageFile = null;

	/**
	 * lädt sequence
	 */
	void initSeq();

	/**
	 * lädt sequence strings
	 */
	void initStrings();

	/**
	 * lädt imagefile
	 */
	String getImageFile();
}
