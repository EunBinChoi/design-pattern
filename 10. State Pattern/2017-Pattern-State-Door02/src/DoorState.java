
public interface DoorState {
	void open();
    void close();
    void lock();
    void unlock();
}


/* DoorState�� �߻� Ŭ�����ε� ������ �� ����, �� �޼ҵ�� �⺻������ ���ܸ� �߻��ϵ��� ����
 * �̷��� �ϸ� �� ���¸� �����ϴ� Ŭ�������� �ۼ��ϴ� ���� ���� �� ����*/
//// DoorState�� abstract class�� ��
//public abstract class DoorState{
//	public void open(){throw new UnsupportedOperationException();}
//	public void close(){throw new UnsupportedOperationException();}
//	public void lock(){throw new UnsupportedOperationException();}
//	public void unlock(){throw new UnsupportedOperationException();}
//	
//}