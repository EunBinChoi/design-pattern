// Ŭ���� ����� => ��� �̿�, �ڹٿ����� ���� ��ӾȵǼ� ���� ���� �ȵ� �� ����
public class FullNameAdapter2 extends User implements FullName {	

	public FullNameAdapter2(String firstName, String lastName) {
		super(firstName, lastName);
	}
	// Ŭ���� ����ʹ� �������� superUser�� ���ؼ� ����� ������

	@Override
	public String getFullName() {
		return getFirstName()+" "+getLastName();
	}

}
