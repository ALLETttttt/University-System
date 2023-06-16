package university;

import java.util.Comparator;

public class SurnameComparator implements Comparator<User> {
	public int compare(User u1, User u2) {
		return u1.getSurname().compareTo(u2.getSurname());
	}	
}
