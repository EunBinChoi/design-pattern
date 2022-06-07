// ���ϸ� : LastResultBasedStrategy.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 1_���ο� �˰��� ����
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

import java.util.Random; // ���� Ŭ������ �����ϱ� ���� ��Ű���� ����


public class LastResultBasedStrategy implements PlayingStrategy { // ���� ������ ����� ������� ������ ���� ������ �ִ� �����Ͽ� ���� Ŭ����
	private Random randomGen = new Random(); // ���� Ŭ���� ��ü�� ����
	private HandType prevHand = HandType.valueOf(randomGen.nextInt(3));
	// ������ ���� ����� �����ϴ� ������, �ʱⰪ�� 0~2���� ���� ������ ����
	private ResultType prevResult = ResultType.values()[randomGen.nextInt(3)];
	// ������ ���������� ����� �����ϴ� ������, �ʱⰪ�� 0~2���� ���� ������ ����

	public void setPrevHand(HandType prevHand) { // ���� ���� ����� �������ִ� �Լ�
		this.prevHand = prevHand;

	}

	public void recordHistory(ResultType currentResult) { // ���� ������ ����ϴ� �Լ�
		if (currentResult != null) { // ���� ����� ���� ��� ����
			prevResult = currentResult;
		}
	}

	@Override
	public HandType nextHand() { // ���� ���� ����� �������ִ� �Լ�
	
		switch (prevResult) { // ���� ����� ���� �޶���
		case WON: { // ���� �̰�����
			prevHand = HandType.valueOf((prevHand.ordinal() + randomGen.nextInt(2) + 1) % 3);
			// ���� ���� �ٽ� ���� ���� ���̶�� �����ϰ�, �װ��� ������ ������ �� ���� �� �ϳ��� �����ϰ� ������
			break; 
		}
		case DRAWN: { // ���� �������
			prevHand = HandType.valueOf((prevHand.ordinal() + randomGen.nextInt(2) + 1) % 3);
			// ���� ���� �ٽ� ���� ���� ���̶�� �����ϰ�, �װ��� ������ ������ �� ���� �� �ϳ��� �����ϰ� ������
			break;
		}
		case LOST: { // ���� ������
			prevHand = HandType.valueOf(((prevHand.winValueOf()).winValueOf()).ordinal());
			// ������ ���� ���� �� ���̶�� �����ϰ� �װ��� �̱� �� �ִ� ������ ������
			break;
		}

		}
		return prevHand; // ���� ��� ��ȯ
	}

	
}