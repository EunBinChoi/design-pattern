// 클래스 어댑터 => 상속 이용, 자바에서는 다중 상속안되서 때에 따라 안될 수 있음
public class FullNameAdapter2 extends User implements FullName {	

	public FullNameAdapter2(String firstName, String lastName) {
		super(firstName, lastName);
	}
	// 클래스 어댑터는 수정없이 superUser에 대해서 사용이 가능함

	@Override
	public String getFullName() {
		return getFirstName()+" "+getLastName();
	}

}
