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
		System.out.println("Power: " + power);
		System.out.println("Race: " + getRace());
	}

	/**
	 * Getter for character's name.
	 * @return Returns the name of the character.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for the character's name
	 * @param name The name to set the character's name to.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for the character's health.
	 * @return Returns health of the character.
	 */
	public double getHealth() {
		return health;
	}

	/**
	 * Setter for the character's health level.
	 * @param power The health level to set the character's power to.
	 */
	public void setHealth(double health) {
		this.health = health;
	}
	/**
	 * Getter for the character's power level.
	 * @return Returns power level of the character.
	 */
	public double getPower() {
		return power;
	}

	/**
	 * Setter for the character's power level.
	 * @param power The power level to set the character's power to.
	 */
	public void setPower(double power) {
		this.power = power;
	}
	
	
	
	
}