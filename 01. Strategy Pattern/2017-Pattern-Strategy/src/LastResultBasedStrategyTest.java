// ���ϸ� : LastResultBasedStrategyTest.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 1_���ο� �˰��� ����
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

import static org.junit.Assert.*; // JUnit �����׽�Ʈ ���
// �ܺ� �׽�Ʈ ���α׷�(���̽�)�� �ۼ��Ͽ� System.out���� ���ŷӰ� ��������� �ʾƵ� ��
import org.junit.Test;

public class LastResultBasedStrategyTest {
   @Test
   public void WonTest() {
      Player player = new Player(null);
      
      LastResultBasedStrategy strategy = new LastResultBasedStrategy();
      player.setStrategy(strategy);
     
      strategy.setPrevHand(HandType.GAWI); // ���� ���� ������ ����
      strategy.recordHistory(ResultType.WON); // ������ �̰�ٰ� ����
      
      HandType hand = player.nextHand();
      assertTrue(hand!=HandType.GAWI); // bool ���� �ִ°�
   }
}