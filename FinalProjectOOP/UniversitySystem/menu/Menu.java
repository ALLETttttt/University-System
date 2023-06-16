package menu;

import university.UniSystem;
import university.User;

public abstract class Menu{
	public User user;
	
	public Menu() {
		
	}
	public Menu(User u) {
		this.user = u;
	}
	
	public abstract void displayMenu();

	public abstract void action() throws Exception;
}
