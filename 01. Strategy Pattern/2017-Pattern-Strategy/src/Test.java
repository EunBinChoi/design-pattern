// 파일명 : Test.java

// 객체지향개발론 및 실습 Laboratory 1_새로운 알고리즘 구현
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

public class Test { // Test 클래스
	public static void main(String[] args) {
		
		System.out.println("--------------[ Start Strategy GawiBawiBO !! ]--------------");
		System.out.println();
		
		RandomStrategy strategy1 = new RandomStrategy(); // 랜덤 클래스의 객체 정의
		WeightBasedStrategy strategy2 = new WeightBasedStrategy(); // 랜덤을 기반으로 한 가중치 클래스 객체 정의
		Player player1 = new Player(strategy1); // 사용자 1 => 랜덤 전략 사용
		Player player2 = new Player(strategy2); // 사용자 2 => 랜덤 확률이 이전에 나왔던 손의 모양에 따라 달라지는 전략 사용
		
		for (int i = 0; i < 100; i++) {  // 0부터 99까지 돌면서
			// 두 개의 HandType 클래스의 객체 생성
			HandType hand1 = player1.nextHand(); 
			HandType hand2 = player2.nextHand();
			System.out.printf("## 실행 횟수 : %d\n\n", i+1);
			System.out.printf("사용자1: %s  VS 사용자2: %s\n", hand1, hand2);

			if (hand1 == hand2) { // 만약 손의 모양이 같으면
				System.out.println("> 결과 : 무승부");
				// 무승부
				player1.setResult(ResultType.DRAWN);
				player2.setResult(ResultType.DRAWN);
			
			} else if (hand1.winValueOf() == hand2) { // 만약 손1의 이기는 값이 hand와 같으면
				System.out.println("> 결과 : 사용자2 승");
				// 사용자2 승
				player1.setResult(ResultType.LOST);
				player2.setResult(ResultType.WON);
				
			} else { // 그렇지 않다면
				System.out.println("> 결과 : 사용자1 승");
				// 사용자1 승
				player1.setResult(ResultType.WON);
				player2.setResult(ResultType.LOST);
				
			}
			System.out.println("[사용자1 입장] "+player1);
			System.out.println("[사용자2 입장] "+player2);
			System.out.println();
			System.out.println("------------------------------------------------------------");
			
			System.out.println();
			System.out.println();
		}
	}
}