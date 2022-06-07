import java.util.ArrayList; // ArrayList�� ����ϱ� ���� ���̺귯�� import

// ���ϸ� : Subject.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 2_����
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

// ��ü���� �����ϴ� �������̽�
public interface Subject { 
	public void addObserver(NewsClient o); // Ŭ���̾�Ʈ �߰��ϴ� �Լ�
	public void deleteObserver(NewsClient o); // Ŭ���̾�Ʈ �����ϴ� �Լ�
	public void notifyObservers(ArrayList<String> data); // ���ο� ������ �߰����� �˸��� �Լ�

}
