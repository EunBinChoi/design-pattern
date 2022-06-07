
/* 3. 열거형을 이용한 상태패턴의 구현
 * 상태전이가 필요하다는 것만을 알리는 것이 아니라 어떤 상태로 전이해야하는 지를 반환하도록 구현 가능
 * 이와 같은 구현은 정확하게 상태 중심, 문맥 중심으로 구분하기 어려운 측면이 있음
 * 열거형으로 만들 때 가장 효과적임*/

public class Door {
	private DoorState currentState = DoorState.CLOSED;
	public void open(){
		currentState = currentState.open();
	}
	public void close(){
		currentState = currentState.close();
	}
	public void lock(){
		currentState = currentState.lock();
	}
	public void unlock(){
		currentState = currentState.unlock();
	}
}
