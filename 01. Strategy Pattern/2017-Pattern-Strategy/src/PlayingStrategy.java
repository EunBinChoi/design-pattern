// ���ϸ� : PlayerStrategy.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 1_���ο� �˰��� ����
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

public interface PlayingStrategy { // ���� ������ �������ִ� �������̽�
	HandType nextHand(); // ���� ������ ������ �� ������ ��ȯ���ִ� �Լ�
	void recordHistory(ResultType currentResult); // ���� ������ ����� �������ִ� �Լ�
}