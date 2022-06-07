
public class Locked implements DoorState {
	private Door door;
    public Locked(Door door){
        this.door = door;
    }
   
	@Override
	public void open() {
		System.out.println("문이 잠겨 있어 열 수 없음");
	}

	@Override
	public void close() {
		System.out.println("문이 이미 닫혀있음");

	}

	@Override
	public void lock() {
		System.out.println("문이 이미 잠겨있음");
	}

	@Override
	public void unlock() {
		System.out.println("문의 잠금을 해제함");
		door.changeToClosedState();
	}

}

//// DoorState가 abstract class일 때
//public class Locked extends DoorState {
//	private Door door;
//    public Locked(Door door){
//        this.door = door;
//    }
//   
//	@Override
//	public void open() {
//		System.out.println("잠금 해제해야 열 수 있음");
//	}
//
//	@Override
//	public void close() {
//		System.out.println("문이 이미 닫혀있음");
//
//	}
//
//	@Override
//	public void lock() {
//		System.out.println("문이 이미 잠겨있음");
//	}
//
//	@Override
//	public void unlock() {
//		System.out.println("문의 잠금을 해제함");
//		door.changeToClosedState();
//	}
//}