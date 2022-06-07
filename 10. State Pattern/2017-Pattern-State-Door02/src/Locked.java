
public class Locked implements DoorState {
	private Door door;
    public Locked(Door door){
        this.door = door;
    }
   
	@Override
	public void open() {
		System.out.println("���� ��� �־� �� �� ����");
	}

	@Override
	public void close() {
		System.out.println("���� �̹� ��������");

	}

	@Override
	public void lock() {
		System.out.println("���� �̹� �������");
	}

	@Override
	public void unlock() {
		System.out.println("���� ����� ������");
		door.changeToClosedState();
	}

}

//// DoorState�� abstract class�� ��
//public class Locked extends DoorState {
//	private Door door;
//    public Locked(Door door){
//        this.door = door;
//    }
//   
//	@Override
//	public void open() {
//		System.out.println("��� �����ؾ� �� �� ����");
//	}
//
//	@Override
//	public void close() {
//		System.out.println("���� �̹� ��������");
//
//	}
//
//	@Override
//	public void lock() {
//		System.out.println("���� �̹� �������");
//	}
//
//	@Override
//	public void unlock() {
//		System.out.println("���� ����� ������");
//		door.changeToClosedState();
//	}
//}