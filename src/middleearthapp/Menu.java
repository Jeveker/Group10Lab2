package middleearthapp;

import java.util.Scanner;

import middleearthmadness.cms.CharacterManager;
import middleearthmadness.singleton.MiddleEarthCouncil;

/**
 * Handles the menu-driven interface for managing Middle-earth characters.
 */
public class Menu {
	private Scanner scanner;
	private CharacterManager characterManager;

	
	/**
	 * Constructor initializes scanner and imports CharacterManager
	 */
	public Menu() {
		this.scanner = new Scanner(System.in);
		
//i dunno what the getter is for this :(
        this.characterManager = MiddleEarthCouncil.getInstance().getCharacterManager();

	}
	
	/**
	 * runs menu loop, allows user to manage characters and their actions
	 */
    public void run() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addCharacter();
                    break;
                case 2:
                    characterManager.displayAllCharacters();
                    break;
                case 3:
                    updateCharacter();
                    break;
                case 4:
                    deleteCharacter();
                    break;
                case 5:
                    executeAttacks();
                    break;
                case 6:
                    System.out.println("Exiting Middle-Earth App");
                    scanner.close();
                    return;
                default:
                    System.out.println("Inavlid choice. Please enter a valid entry.");
            }
        }
    }
    
//i think these should all be booleans instead of void, but this just for setup
    
    private void displayMenu() {
    	
    }
    
    
    
    private int getUserChoice() {
    	
    }
    
    
    private void addCharacter(){
    	
    }
    
    
    private void updateCharacter() {
    	
    }
    
    
    
    
    private void deleteCharacter() {
    	
    }
    
    
    
    private void executeAttacks() {
    	
    }
    
    

	

}
