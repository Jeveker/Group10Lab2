package middleearthmadness.character;

public class Orc extends MiddleEarthCharacter {

	public Orc(String name, double health, double power) {
		super(name, health, power);
	}

	/**
	 * Returns true if attack is successful and target's health is reduced.
	 * Returns false if attack is unsuccessful and does no damage. 
	 * @param target The target to attack.
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(this.getRace().equals(target.getRace())) { // Orc vs. Orc
			System.out.println("Ineffective attack! You cannot attack your own kin.");
			return false;
		}
		
		double damage = this.getPower(); 
		
		if (target.getRace().equals("Elf")) { // Orc vs. Elf
			damage = 0;
		} else if (target.getRace().equals("Human")) { // Orc vs. Human
			damage *= 1.5;
		}
		
		// Applies normal damage against Dwarf and Wizard by default
		
		if (damage > 0) { // Reduces target's health
			target.setHealth(target.getHealth() - damage);
			System.out.println("Successful attack! " + damage + " damage dealt against " + target.getRace() +"." );
			return true;
		} else {
			System.out.println("Ineffective attack! Zero damage dealt against " + target.getRace() + ".");
			return false;
		}
	}

	/**
	 * Returns character's race.
	 */
	@Override
	public String getRace() {
		return "Orc";
	}
	
	
	
}
