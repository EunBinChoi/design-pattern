
/* 기존 방법 : 상태 패턴을 모르는 경우(state pattern을 이용하지 않은 경우)
 * 상태를 정의하고 일련의 조건문(switch)으로 상태 전이를 처리함
 * 코드가 매우 복잡함, 이와 같은 형태의 코드가 각 전이함수마다 반복됨*/

public class Door {
	public enum State {OPENED, CLOSED, LOCKED} // 현재 상태를 열거형으로 정의
	private State currentState = State.CLOSED; // 현재 상태를 저장하는 변수
	
	public void open(){
		switch(currentState){
		case OPENED:
			System.out.println("이미 열려 있음");
			break;
		case CLOSED:
			System.out.println("문이 열림");
			currentState = State.OPENED;
			break;
		case LOCKED:
			System.out.println("문이 잠겨 있어 열 수 없음");
			break;
		} // switch
	}
	public void close(){
		switch(currentState){
		case OPENED:
			System.out.println("문이 닫힘");
			currentState = State.CLOSED;
			break;
		case CLOSED:
		case LOCKED:
			System.out.println("문이 이미 닫혀 있음");
			break;
		} // switch
	}
	public void lock(){
		switch(currentState){
		case OPENED:
			System.out.println("문이 열려 있어 잠글 수 없음");
			break;
		case CLOSED:
			System.out.println("문을 잠금");
			currentState = State.LOCKED;
			break;
		case LOCKED:
			System.out.println("문이 이미 잠겨 있음");
			break;
		} // switch
	}
	public void unlock(){
		switch(currentState){
		case OPENED:
		case CLOSED:
			System.out.println("문이 잠겨 있지 않음");
			break;
		case LOCKED:
			System.out.println("문의 잠금을 해제함");
			currentState = State.CLOSED;
			break;
		} // switch
	}
}
