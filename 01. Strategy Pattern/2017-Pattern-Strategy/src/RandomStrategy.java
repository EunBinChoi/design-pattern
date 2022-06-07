// ���ϸ� : RandomStrategy.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 1_���ο� �˰��� ����
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

import java.util.Random; // ���� Ŭ������ �����ϱ� ���� ��Ű���� ����

public class RandomStrategy implements PlayingStrategy { // ���� ���� ������ �����ϱ� ���� Ŭ����
	private Random randomGen = new Random(); // ���� Ŭ���� ��ü�� ����
	@Override
	public HandType nextHand() { // ���� ���� ���� ������ ����
		return HandType.valueOf(randomGen.nextInt(3));
	}
	@Override
	public void recordHistory(ResultType currentResult) {} // ���� ���� �������� �ʿ� ����(������ �����̱� ����)
	
}