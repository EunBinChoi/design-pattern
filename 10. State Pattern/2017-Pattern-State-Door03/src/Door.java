
/* 2. 문맥 중심의 상태패턴의 구현
 * 조건문이 존재하기 때문에 context가 복잡해짐
 * 상태에 대한 getter, setter가 필요하지 않음*/

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
