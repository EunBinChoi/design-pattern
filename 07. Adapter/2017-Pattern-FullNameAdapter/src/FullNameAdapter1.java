// °´Ã¼ ¾î´ðÅÍ => has-a
public class FullNameAdapter1 implements FullName{
	private User user;
	public FullNameAdapter1(User user){
		this.user = user;
	}
	
	@Override
	public String getFullName() {		
		return user.getFirstName()+" "+user.getLastName();
	}
	
}
