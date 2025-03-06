package middleearthapp.menu;

import java.util.Scanner;

import middleearthmadness.character.Dwarf;
import middleearthmadness.character.Elf;
import middleearthmadness.character.Human;
import middleearthmadness.character.MiddleEarthCharacter;
import middleearthmadness.character.Orc;
import middleearthmadness.character.Wizard;
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
        this.characterManager = MiddleEarthCouncil.getInstance().getCharacterManager();

	}
	
	/**
	 * Runs menu loop, allows user to manage characters and their actions.
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
                    System.out.println("Invalid choice. Please enter a valid entry.");
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
    
    /**
     * Allows user to add a new character
     */
    private void addCharacter(){
    	scanner.nextLine();
    	System.out.print("Enter your character's name: ");
    	String name = scanner.nextLine();
    	System.out.print("Enter your character's health: ");
    	double health = scanner.nextDouble();
    	System.out.print("Enter your character's power: ");
    	double power = scanner.nextDouble();
    	scanner.nextLine();
    	System.out.print("Enter your character's race (choose from Elf, Dwarf, Human, Orc, or Wizard): ");
    	String race = scanner.nextLine().trim().toLowerCase(); // accounts for uppercase or lowercase user input
    	
    	MiddleEarthCharacter character;
    	switch (race.toLowerCase()) {
    		case "elf":
    			character = new Elf(name, health, power);
    			break;
    		
    		case "dwarf":
    			character = new Dwarf(name, health, power);
    			break;
    			
    		case "human": 
    			character = new Human(name, health, power);
    			break;
    			
    		case "orc": 
    			character = new Orc(name, health, power);
    			break;
    			
    		case "wizard": 
    			character = new Wizard(name, health, power);
    			break;
    			
    		default: 
    			System.out.println("Unknown character race, character not created.");
    			return;
    	}
    	
    	if (characterManager.addCharacter(character)) {
    		System.out.println("Character added!");
    	}
    	
    	else {
    		System.out.println("Failed to add character!");
    	}
    	
    }
    
    
    /**
     * Updates an existing user character
     */
    private void updateCharacter() {
    	scanner.nextLine();
    	System.out.println("Enter the name of the character to update: ");
    	String name = scanner.nextLine();
    	MiddleEarthCharacter character = characterManager.getCharacter(name);
    	
    	if (character == null) {
    		System.out.println("Character not found!");
    		return;
    	}
    	
    	System.out.println("Enter new health (enter -1 to keep current value): ");
    	double health = scanner.nextDouble();
    	System.out.println("Enter new power (enter -1 to keep current value):");
    	double power = scanner.nextDouble();
    	
    	if (health == -1) {
    		health = character.getHealth();
    	}
    	if (power ==-1) {
    		power = character.getPower();
    	}
    	
    	if (characterManager.updateCharacter(character,  name,  health,  power)) {
    		System.out.println("Character update succesfull!");
    	}
    	else {
    		System.out.println("Something went wrong. No character changes made.");
    	}
    }
    
    
    
    /**
     * Deletes an existing user character.
     */
    private void deleteCharacter() {
    	scanner.nextLine();
    	System.out.println("Enter the name of the character to delete: ");
    	String name = scanner.nextLine();
    	MiddleEarthCharacter character = characterManager.getCharacter(name);
    	
    	if(character == null) {
    		System.out.println("Character you entered was not found, deletion failed.");
    		return;
    	}
    	
    	if(characterManager.deleteCharacter(character)) {
    		System.out.println("Character succesfully delete!");
    	}
    	else {
    		System.out.println("Failed to delete character.");
    	}
    }
    
    /**
     * Initiates attack sequence between all characters
     */
    private void executeAttacks() {
        System.out.println("Characters are attacking each other...");
        MiddleEarthCharacter[] characters = characterManager.getAllCharacters();
        
        //iterating for attacking character
        for (int i = 0; i < characters.length; i++) {
        	
        	//iterating for character being attacked, i+1 to ensure no duplicates or attacks on oneself.
            for (int j = i + 1; j < characters.length; j++) {
            	
                if (characters[i] != null && characters[j] != null) {
                	
                	//confirmation of attack or ineffectiveness
                    boolean attackSuccess = characters[i].attack(characters[j]);
                    
                    if (attackSuccess) {
                        System.out.println(characters[i].getName() + " successfully attacked " + characters[j].getName());
                    } 
                    else {
                        System.out.println(characters[i].getName() + " could not damage " + characters[j].getName());
                    }
                }
            }
        }
    }
    

	

}

