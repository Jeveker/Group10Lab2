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
    
    /**
     * Displays menu options for user-selection
     */
    private void displayMenu() {
        System.out.println("\n=== Middle-Earth Character Management System ===");
        System.out.println("1. Add a new character");
        System.out.println("2. View all characters");
        System.out.println("3. Update a character");
        System.out.println("4. Delete a character");
        System.out.println("5. Execute all characters’ attack actions");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
    
    
    /**
     * Retrieves and checks user's menu selection
     * @returns the menu choice, if a valid integer input
     */
    private int getUserChoice() {
    	while (!scanner.hasNextInt()) {
    		System.out.print("Please enter a valid integer: ");
    		scanner.next();
    	}
    	
    	return scanner.nextInt();
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
