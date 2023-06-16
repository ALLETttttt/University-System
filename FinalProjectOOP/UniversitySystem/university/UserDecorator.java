package university;

public class UserDecorator implements UserInt{
	protected final UserInt decoratedUser;
	
	public UserDecorator(UserInt u) {
		this.decoratedUser = u;
	}
}
