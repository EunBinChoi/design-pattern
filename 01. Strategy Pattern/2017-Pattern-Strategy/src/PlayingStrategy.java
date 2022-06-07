// 파일명 : PlayerStrategy.java

// 객체지향개발론 및 실습 Laboratory 1_새로운 알고리즘 구현
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

public interface PlayingStrategy { // 게임 전략을 정의해주는 인터페이스
	HandType nextHand(); // 다음 손으로 무엇을 낼 것인지 반환해주는 함수
	void recordHistory(ResultType currentResult); // 지난 게임의 결과을 저장해주는 함수
}