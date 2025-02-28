package middleearthmadness.character;

public abstract class MiddleEarthCharacter {
	private String name;
	private double health;
	private double power;
	
	/**
	 * Constructor that initializes name, health, and power
	 * @param name Name of character
	 * @param health Health level of character
	 * @param power Power level of character
	 */
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}

	/**
	 * Abstract method that returns true if attack is successful and reduced target's
	 * health, returns false if attack was ineffective or against their own kin.
	 * @param target The character to attack
	 */
	public abstract boolean attack(MiddleEarthCharacter target);
	
	/**
	 * Abstract method to return the race of the character.
	 */
	public abstract String getRace();
	
	/**
	 * Prints character details.
	 */
	public void displayInfo() {
		System.out.println("Character details...");
		System.out.println("Name: " + name);
		System.out.println("Health: " + health);
		System.out.println("Power: " + name);
		System.out.println("Race: " + getRace());
	}
	
	
}