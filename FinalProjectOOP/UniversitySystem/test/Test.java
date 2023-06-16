package test;

import menu.*;
import university.*;

public class Test {

	public static void main(String[] args) throws Exception {
		UniSystem uniSys = UniSystem.getDatabase();

		MainMenu menu = MainMenu.getMainMenu();

		menu.displayMenu();
		menu.enterToTheSystem();
	}

}
