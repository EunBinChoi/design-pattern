
public class Locked implements DoorState {
	@Override
	public boolean Open() {
		System.out.println("문이 잠겨 있어 열 수 없음");
		return false;
	}

	@Override
	public boolean Close() {
		System.out.println("문이 이미 닫혀있음");
		return false;
	}

	@Override
	public boolean Lock() {
		System.out.println("문이 이미 잠겨있음");
		return false;
	}

	@Override
	public boolean Unlock() {
		System.out.println("문의 잠금을 해제함");
		return true;
	}
}
