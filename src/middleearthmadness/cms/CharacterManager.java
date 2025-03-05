package middleearthmadness.cms;

import middleearthmadness.character.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	private int size;
	
	/**
	 * Adds character to array, doubles array size if full by creating a new array with double the 
	 * size and copying over the previous characters into the new, larger array.
	 * @param c The character to add
	 * @return Return true if successfully added, return false if the character to add is invalid.
	 */
	boolean addCharacter(MiddleEarthCharacter c) {
		if (c == null) {
			System.out.println("Invalid character.");
			return false;
		}
		if (size == characters.length) { // maximum size reached
			MiddleEarthCharacter[] newCharacters = new MiddleEarthCharacter[characters.length * 2]; 
			for (int i = 0; i < characters.length; i++) {
				newCharacters[i] = characters[i]; // copy full array into new array
			}
			characters = newCharacters;
		}
		characters[size] = c; // add new character
		size++; // increment size
		System.out.println("Character successfully added!");
		return true;
	}
		
	
	/**
	 * Iterates through the characters in the array until one matches the given name and returns the matching MiddleEarthCharacter.
	 * @param name The name of the character to return.
	 * @return Returns null if name is invalid or if the character is not found, returns the MiddleEarthCharacter that matches the given name if found.
	 */
	MiddleEarthCharacter getCharacter(String name) {
		if (name == null) { // 
			System.out.println("Invalid character name.");
			return null;
		}
		for (int i = 0; i < size; i++) {
			if (characters[i].getName().equals(name)) { // character found
				System.out.println("Character found!");
				return characters[i];
			}
		}
		return null;
	}

	/**
	 * Updates the corresponding character with a new name, health, and/or power.
	 * @param character The character to update.
	 * @param name The name to update.
	 * @param health The health to update.
	 * @param power The power to update.
	 * @return Returns true if any update is made. Returns false if there are no changes to make.
	 */
	boolean updateCharacter (MiddleEarthCharacter character, String name, int health, int power) {
		for (int i = 0; i < size; i++) {
			if (characters[i].equals(character)) {
				if ((characters[i].getName().equals(name)) &&
					(characters[i].getHealth() == health) &&
					(characters[i].getPower() == power)) { // provided name, health, and power already match
					System.out.println("No updates made.");
					return false;
				}	
				characters[i].setName(name);
				characters[i].setHealth(health);
				characters[i].setPower(power);
				System.out.println("Updates made successfully.");
				return true;
			}
		}
		System.out.println("Invalid character provided."); // no character found matching in array
		return false;
	}
	
	/**
	 * Deletes the corresponding character from the array of MiddleEarthCharacters and shifts the array to fill the gap.
	 * @param character The character to delete
	 * @return Return true if successfully deleted, returns false if the character provided is invalid or not found. 
	 */
	boolean deleteCharacter(MiddleEarthCharacter character) {
		
		if (character == null) {
			System.out.println("Invalid character provided.");
			return false;
		}
		for (int i = 0; i < size; i++) {
			if (characters[i].equals(character)) { // character found
				for (int j = i; j < size - 1; j++) {
					characters[j]  = characters[j+1]; // shift elements
				}
				size--;
				characters[size] = null;
				System.out.println("Character deleted successfully!");	
				return true;
			}
		}
		System.out.println("Character not found.");
		return false;
	}
	
	/**
	 * Displays information of all characters in the management system.
	 */
	void displayAllCharacters() {
		for (int i = 0; i < size; i++) {
			characters[i].displayInfo();
		}
	}
}

