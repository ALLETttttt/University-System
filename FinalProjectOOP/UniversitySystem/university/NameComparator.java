package university;

import java.util.Comparator;

public class NameComparator implements Comparator<User>  {	
	public int compare(User u1, User u2) {
		return u1.getName().compareTo(u2.getName());
	}															
}
