package middleearthmadness.cms;

import middleearthmadness.character.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	private int size;
	
	/**
	 * Adds character to array, doubles array size if full.
	 * @param c The character to add
	 * @return Return true if successfully added, return false is character to add is invalid.
	 */
	boolean addCharacter(MiddleEarthCharacter c) {
//		if (c == null) {
//			System.out.println("Invalid character.");
//			return false;
//		}
//		if (size == characters.length) {
//			size *= 2;
//		}
//		
//		return true;
		
	}
	/**
	 * Iterates through the characters in the array until one matches the given name and returns the matching MiddleEarthCharacter.
	 * @param name The name of the character to return.
	 * @return Returns null if name is invalid or if the character is not found, returns the MiddleEarthCharacter that matches the given name if found.
	 */
	MiddleEarthCharacter getCharacter(String name) {
		if (name == null) {
			System.out.println("Invalid character name.");
			return null;
		}
		for (int i = 0; i < size; i++) {
			if (characters[i].getName().equals(name)) {
				System.out.println("Character found!");
				return characters[i];
			}
		}
		return null;
	}
	
	boolean updateCharacter (MiddleEarthCharacter character, String name, int health, int power) {
		
	}
	
	boolean deleteCharacter(MiddleEarthCharacter character) {
		
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

