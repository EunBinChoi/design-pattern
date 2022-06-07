
public interface DoorState {
	void open();
    void close();
    void lock();
    void unlock();
}


/* DoorState를 추상 클래스로도 구혈할 수 있음, 각 메소드는 기본적으로 예외를 발생하도록 구현
 * 이렇게 하면 이 상태를 구현하는 클래스들을 작성하는 것이 편리할 수 있음*/
//// DoorState가 abstract class일 때
//public abstract class DoorState{
//	public void open(){throw new UnsupportedOperationException();}
//	public void close(){throw new UnsupportedOperationException();}
//	public void lock(){throw new UnsupportedOperationException();}
//	public void unlock(){throw new UnsupportedOperationException();}
//	
//}