// 파일명 : LastResultBasedStrategyTest.java

// 객체지향개발론 및 실습 Laboratory 1_새로운 알고리즘 구현
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

import static org.junit.Assert.*; // JUnit 단위테스트 사용
// 외부 테스트 프로그램(케이스)를 작성하여 System.out으로 번거롭게 디버깅하지 않아도 됨
import org.junit.Test;

public class LastResultBasedStrategyTest {
   @Test
   public void WonTest() {
      Player player = new Player(null);
      
      LastResultBasedStrategy strategy = new LastResultBasedStrategy();
      player.setStrategy(strategy);
     
      strategy.setPrevHand(HandType.GAWI); // 이전 값을 가위로 정의
      strategy.recordHistory(ResultType.WON); // 이전에 이겼다고 가정
      
      HandType hand = player.nextHand();
      assertTrue(hand!=HandType.GAWI); // bool 값을 주는것
   }
}