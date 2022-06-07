
/* ���� ��� : ���� ������ �𸣴� ���(state pattern�� �̿����� ���� ���)
 * ���¸� �����ϰ� �Ϸ��� ���ǹ�(switch)���� ���� ���̸� ó����
 * �ڵ尡 �ſ� ������, �̿� ���� ������ �ڵ尡 �� �����Լ����� �ݺ���*/

public class Door {
	public enum State {OPENED, CLOSED, LOCKED} // ���� ���¸� ���������� ����
	private State currentState = State.CLOSED; // ���� ���¸� �����ϴ� ����
	
	public void open(){
		switch(currentState){
		case OPENED:
			System.out.println("�̹� ���� ����");
			break;
		case CLOSED:
			System.out.println("���� ����");
			currentState = State.OPENED;
			break;
		case LOCKED:
			System.out.println("���� ��� �־� �� �� ����");
			break;
		} // switch
	}
	public void close(){
		switch(currentState){
		case OPENED:
			System.out.println("���� ����");
			currentState = State.CLOSED;
			break;
		case CLOSED:
		case LOCKED:
			System.out.println("���� �̹� ���� ����");
			break;
		} // switch
	}
	public void lock(){
		switch(currentState){
		case OPENED:
			System.out.println("���� ���� �־� ��� �� ����");
			break;
		case CLOSED:
			System.out.println("���� ���");
			currentState = State.LOCKED;
			break;
		case LOCKED:
			System.out.println("���� �̹� ��� ����");
			break;
		} // switch
	}
	public void unlock(){
		switch(currentState){
		case OPENED:
		case CLOSED:
			System.out.println("���� ��� ���� ����");
			break;
		case LOCKED:
			System.out.println("���� ����� ������");
			currentState = State.CLOSED;
			break;
		} // switch
	}
}
