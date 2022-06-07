// 파일명 : RandomStrategy.java

// 객체지향개발론 및 실습 Laboratory 1_새로운 알고리즘 구현
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

import java.util.Random; // 랜덤 클래스를 정의하기 위한 패키지를 정의

public class RandomStrategy implements PlayingStrategy { // 게임 랜덤 전략을 정의하기 위한 클래스
	private Random randomGen = new Random(); // 랜덤 클래스 객체를 정의
	@Override
	public HandType nextHand() { // 다음 손을 랜덤 값으로 정의
		return HandType.valueOf(randomGen.nextInt(3));
	}
	@Override
	public void recordHistory(ResultType currentResult) {} // 이전 값을 저장해줄 필요 없음(어차피 랜덤이기 때문)
	
}