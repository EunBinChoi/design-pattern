// 파일명 : Player.java

// 객체지향개발론 및 실습 Laboratory 1_새로운 알고리즘 구현
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

public class Player { // 사용자를 정의
   private int[] resultCount = new int[3]; // 이긴 횟수, 비긴 횟수, 진 횟수를 저장하는 배열
   private PlayingStrategy strategy; // 게임 전략을 저장하는 변수

   // 생성자
   public Player(PlayingStrategy strategy) {
      this.strategy = strategy; // 게임 전략을 설정
   }
   public void setStrategy(PlayingStrategy strategy) {
      this.strategy = strategy; // 게임 전략을 설정
   }
   public HandType nextHand() { // 다음 손을 결정하는 함수
      return strategy.nextHand();
   }
   private int getGameCount() { // 게임의 총 횟수를 반환하는 함수
      int sum = 0; // 총 횟수를 저장할 sum을 정의, 0으로 초기화
      for (int i : resultCount) // 정수 i가 resultCount 크기만큼 돌면서
         sum += i; // sum에 더해줌
      return sum; // sum 반환
   }
   
   public void setResult(ResultType currentResult) { // 게임의 결과를 설정해주는 함수
	   ++resultCount[currentResult.ordinal()]; 
      strategy.recordHistory(currentResult);
   }
  
   @Override
   public String toString() { // 게임의 횟수, 승, 무승부, 패를 출력하는 함수
      return String.format("게임수: %d, 승: %d, 무승부 : %d, 패: %d", getGameCount(), resultCount[0], resultCount[1], resultCount[2]);
   }
}