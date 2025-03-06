package middleearthmadness.singleton;

import middleearthmadness.cms.CharacterManager;

public class MiddleEarthCouncil {
	
	private static MiddleEarthCouncil instance;
	private CharacterManager characterManager;
	
	
	private MiddleEarthCouncil() {
		this.characterManager = new CharacterManager();
	}
	
	/**
	 * Singleton method that returns a single instance
	 * 
	 * @return
	 */
	public static MiddleEarthCouncil getInstance() {
		if(instance == null) {
			instance = new MiddleEarthCouncil();
		}
		
		return instance;
	}
	
	/**
	 * getter for CharacterManager instance
	 * 
	 * @return
	 */
	public CharacterManager getCharacterManager() {
		return characterManager;
	}

}
