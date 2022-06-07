// ���ϸ� : Player.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 1_���ο� �˰��� ����
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

public class Player { // ����ڸ� ����
   private int[] resultCount = new int[3]; // �̱� Ƚ��, ��� Ƚ��, �� Ƚ���� �����ϴ� �迭
   private PlayingStrategy strategy; // ���� ������ �����ϴ� ����

   // ������
   public Player(PlayingStrategy strategy) {
      this.strategy = strategy; // ���� ������ ����
   }
   public void setStrategy(PlayingStrategy strategy) {
      this.strategy = strategy; // ���� ������ ����
   }
   public HandType nextHand() { // ���� ���� �����ϴ� �Լ�
      return strategy.nextHand();
   }
   private int getGameCount() { // ������ �� Ƚ���� ��ȯ�ϴ� �Լ�
      int sum = 0; // �� Ƚ���� ������ sum�� ����, 0���� �ʱ�ȭ
      for (int i : resultCount) // ���� i�� resultCount ũ�⸸ŭ ���鼭
         sum += i; // sum�� ������
      return sum; // sum ��ȯ
   }
   
   public void setResult(ResultType currentResult) { // ������ ����� �������ִ� �Լ�
	   ++resultCount[currentResult.ordinal()]; 
      strategy.recordHistory(currentResult);
   }
  
   @Override
   public String toString() { // ������ Ƚ��, ��, ���º�, �и� ����ϴ� �Լ�
      return String.format("���Ӽ�: %d, ��: %d, ���º� : %d, ��: %d", getGameCount(), resultCount[0], resultCount[1], resultCount[2]);
   }
}