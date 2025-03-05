package middleearthapp.main;

import middleearthapp.menu.Menu;

/**
 * main class for Middle Earth Character Management System
 * Initializes the application and invokes the menu
 */

public class Main {
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		//running the menu
		menu.run();
		
	}

}
