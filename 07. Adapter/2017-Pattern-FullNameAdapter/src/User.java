
public class User { // 직접 수정이 가능하지 않은 상태
	private String firstName;
	private String lastName;
	public User(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;	
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
}
