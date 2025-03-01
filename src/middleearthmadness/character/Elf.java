package middleearthmadness.character;

public class Elf extends MiddleEarthCharacter {

	public Elf(String name, double health, double power) {
		super(name, health, power);
	}

	/**
	 * Returns true if attack is successful and target's health is reduced.
	 * Returns false if attack is unsuccessful and does no damage. 
	 * @param target The target to attack.
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(this.getRace().equals(target.getRace())) { // Elf vs. Elf
			System.out.println("Ineffective attack! You cannot attack your own kin.");
			return false;
		}
		
		double damage = this.getPower(); 
		
		if (target.getRace().equals("Dwarf")) { // Elf vs. Dwarf
			damage = 0;
		} else if (target.getRace().equals("Orc")) { // Elf vs. Orc
			damage *= 1.5;
		}
		
		// Applies normal damage against Human and Wizard by default
		
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
		return "Elf";
	}
	
	
	
}
