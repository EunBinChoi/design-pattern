
public class Closed implements DoorState {

	@Override
	public boolean Open() {
		System.out.println("문이 열림");
		return true;
	}

	@Override
	public boolean Close() {
		System.out.println("문이 이미 닫혀있음");
		return false;
	}

	@Override
	public boolean Lock() {
		System.out.println("문을 잠금");
		return true;
	}

	@Override
	public boolean Unlock() {
		System.out.println("문이 잠겨 있지 않음");
		return false;
	}
}
