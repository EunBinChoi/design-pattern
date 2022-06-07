// 파일명 : LastResultBasedStrategy.java

// 객체지향개발론 및 실습 Laboratory 1_새로운 알고리즘 구현
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

import java.util.Random; // 랜덤 클래스를 정의하기 위한 패키지를 정의


public class LastResultBasedStrategy implements PlayingStrategy { // 지난 게임의 결과가 사용자의 결정에 많은 영향을 주는 가정하에 만든 클래스
	private Random randomGen = new Random(); // 랜덤 클래스 객체를 정의
	private HandType prevHand = HandType.valueOf(randomGen.nextInt(3));
	// 이전에 손의 모양을 저장하는 변수로, 초기값은 0~2까지 랜덤 값으로 정의
	private ResultType prevResult = ResultType.values()[randomGen.nextInt(3)];
	// 이전의 가위바위보 결과를 저장하는 변수로, 초기값은 0~2까지 랜덤 값으로 정의

	public void setPrevHand(HandType prevHand) { // 이전 손의 모양을 설정해주는 함수
		this.prevHand = prevHand;

	}

	public void recordHistory(ResultType currentResult) { // 이전 값들을 기록하는 함수
		if (currentResult != null) { // 이전 결과에 현재 결과 대입
			prevResult = currentResult;
		}
	}

	@Override
	public HandType nextHand() { // 다음 손의 모양을 결정해주는 함수
	
		switch (prevResult) { // 이전 결과에 따라 달라짐
		case WON: { // 만약 이겼으면
			prevHand = HandType.valueOf((prevHand.ordinal() + randomGen.nextInt(2) + 1) % 3);
			// 같은 손을 다시 내지 않을 것이라고 가정하고, 그것을 제외한 나머지 두 종류 중 하나를 랜덤하게 결정함
			break; 
		}
		case DRAWN: { // 만약 비겼으면
			prevHand = HandType.valueOf((prevHand.ordinal() + randomGen.nextInt(2) + 1) % 3);
			// 같은 손을 다시 내지 않을 것이라고 가정하고, 그것을 제외한 나머지 두 종류 중 하나를 랜덤하게 결정함
			break;
		}
		case LOST: { // 만약 졌으면
			prevHand = HandType.valueOf(((prevHand.winValueOf()).winValueOf()).ordinal());
			// 상대방이 같은 손을 낼 것이라고 가정하고 그것을 이길 수 있는 손으로 결정함
			break;
		}

		}
		return prevHand; // 손의 모양 반환
	}

	
}