
public class Opened implements DoorState {

	@Override
	public boolean Open() {
		System.out.println("�̹� ���� ����");
		return false;
	}

	@Override
	public boolean Close() {
		System.out.println("���� ����");
		return true;
	}

	@Override
	public boolean Lock() {
		System.out.println("���� ���� �־� ��� �� ����");
		return false;
	}

	@Override
	public boolean Unlock() {
		System.out.println("���� ��� ���� ����");
		return false;
	}

}
