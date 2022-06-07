
public class Opened implements DoorState {

	@Override
	public boolean Open() {
		System.out.println("이미 열려 있음");
		return false;
	}

	@Override
	public boolean Close() {
		System.out.println("문이 닫힘");
		return true;
	}

	@Override
	public boolean Lock() {
		System.out.println("문이 열려 있어 잠글 수 없음");
		return false;
	}

	@Override
	public boolean Unlock() {
		System.out.println("문이 잠겨 있지 않음");
		return false;
	}

}
