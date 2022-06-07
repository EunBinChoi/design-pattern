
/* 2. ���� �߽��� ���������� ����
 * ���ǹ��� �����ϱ� ������ context�� ��������
 * ���¿� ���� getter, setter�� �ʿ����� ����*/

public class Door { 
	private final DoorState openedState = new Opened();
	private final DoorState closedState = new Closed();
	private final DoorState lockedState = new Locked();
	
	private DoorState currentState = closedState;
	
	public void open(){
		if(currentState.Open()){
			currentState = openedState;
		}
	}
	public void close(){
		if(currentState.Close()){
			currentState = closedState;
		}
	}
	public void lock(){
		if(currentState.Lock()){
			currentState = lockedState;
		}
	}
	public void unlock(){
		if(currentState.Unlock()){
			currentState = closedState;
		}
	}
}
