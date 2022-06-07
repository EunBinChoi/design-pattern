
/* 1. 상태전이를 이용한 상태패턴의 구현
 * 비교적 간단하고 조건문이 없음
 * 그러나 this 날려야됨, 상태에 대한 getter, setter 필요(setter만을 가지고도 구현 가능)
 * 상태전이가 상태 객체에서 이루어지기 때문에 각 상태 객체는 형제 상태 객체를 알고 있어야함. 
 * 즉, 의존관계가 증가함 */

public class Door { 
	private final DoorState openedState = new Opened(this);
	private final DoorState closedState = new Closed(this);
	private final DoorState lockedState = new Locked(this);
	
	// 여기서 context 객체를 멤버로 유지할 수 있지만 싱글톤으로 모델링하고 싶으면, 
	// context 객체를 모든 메소드의 인자로 전달하는 방법도 존재
	private DoorState currentState = closedState;
	
	public void changeToOpenedState(){
		currentState = openedState;
	}
	public void changeToClosedState(){
		currentState = closedState;
	}
	public void changeToLockedState(){
		currentState = lockedState;
	}
	public void open(){
		currentState.open();
	}
	public void close(){
		currentState.close();
	}
	public void lock(){
		currentState.lock();
	}
	public void unlock(){
		currentState.unlock();
	}
}
