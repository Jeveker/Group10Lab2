package middleearthmadness.character;

public class Human extends MiddleEarthCharacter {

	public Human(String name, double health, double power) {
		super(name, health, power);
	}

	/**
	 * Returns true if attack is successful and target's health is reduced.
	 * Returns false if attack is unsuccessful and does no damage. 
	 * @param target The target to attack.
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(this.getRace().equals(target.getRace())) { // Human vs. Human
			System.out.println("Ineffective attack! You cannot attack your own kin.");
			return false;
		}
		
		double damage = this.getPower(); 
		
		if (target.getRace().equals("Orc")) { // Human vs. Orc
			damage = 0;
		} else if (target.getRace().equals("Wizard")) { // Human vs. Wizard
			damage *= 1.5;
		}
		
		// Applies normal damage against Elf and Dwarf by default
		
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
		return "Human";
	}
	
	
	
}
