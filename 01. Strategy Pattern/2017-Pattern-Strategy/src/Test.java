// ���ϸ� : Test.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 1_���ο� �˰��� ����
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

public class Test { // Test Ŭ����
	public static void main(String[] args) {
		
		System.out.println("--------------[ Start Strategy GawiBawiBO !! ]--------------");
		System.out.println();
		
		RandomStrategy strategy1 = new RandomStrategy(); // ���� Ŭ������ ��ü ����
		WeightBasedStrategy strategy2 = new WeightBasedStrategy(); // ������ ������� �� ����ġ Ŭ���� ��ü ����
		Player player1 = new Player(strategy1); // ����� 1 => ���� ���� ���
		Player player2 = new Player(strategy2); // ����� 2 => ���� Ȯ���� ������ ���Դ� ���� ��翡 ���� �޶����� ���� ���
		
		for (int i = 0; i < 100; i++) {  // 0���� 99���� ���鼭
			// �� ���� HandType Ŭ������ ��ü ����
			HandType hand1 = player1.nextHand(); 
			HandType hand2 = player2.nextHand();
			System.out.printf("## ���� Ƚ�� : %d\n\n", i+1);
			System.out.printf("�����1: %s  VS �����2: %s\n", hand1, hand2);

			if (hand1 == hand2) { // ���� ���� ����� ������
				System.out.println("> ��� : ���º�");
				// ���º�
				player1.setResult(ResultType.DRAWN);
				player2.setResult(ResultType.DRAWN);
			
			} else if (hand1.winValueOf() == hand2) { // ���� ��1�� �̱�� ���� hand�� ������
				System.out.println("> ��� : �����2 ��");
				// �����2 ��
				player1.setResult(ResultType.LOST);
				player2.setResult(ResultType.WON);
				
			} else { // �׷��� �ʴٸ�
				System.out.println("> ��� : �����1 ��");
				// �����1 ��
				player1.setResult(ResultType.WON);
				player2.setResult(ResultType.LOST);
				
			}
			System.out.println("[�����1 ����] "+player1);
			System.out.println("[�����2 ����] "+player2);
			System.out.println();
			System.out.println("------------------------------------------------------------");
			
			System.out.println();
			System.out.println();
		}
	}
}