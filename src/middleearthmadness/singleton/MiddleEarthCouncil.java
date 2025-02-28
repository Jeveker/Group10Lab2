package middleearthmadness.singleton;

public class MiddleEarthCouncil {
	
	private static MiddleEarthCouncil instance;
	
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

}
