// 파일명 : WeightBasedStrategy.java

// 객체지향개발론 및 실습 Laboratory 1_새로운 알고리즘 구현
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

/* WeightBasedStrategy의 설명 : 이 전략은 기본 랜덤 가위바위보를 기반으로 내는 전략이다. 랜덤 가위바위보와 다른 점은 랜덤 가위바위보의 
 * 이전의 게임 결과에 따라 다음 손을 낼 랜덤 확률 달라진다는 것이다. 처음 랜덤 함수에서 가위,바위,보가 나올 확률은 각각 1/3, 1/3, 1/3이라고 할 때,
 * 본인은 전의 게임에서 이긴 손의 모양의 가중치를 +1, 비겼을 때 손의 모양 가중치를 +0.5, 졌을 때 가중치를 -1으로 설정해주었다.
 * 이는 랜덤 함수의 확률을 다르게 설정하여 랜덤 함수로 결정된 값이 가중치가 높은 손의 모양이 나올 수 있게끔 하기 위함이다.
 * 
 * 예를 들어, 전의 게임에서 가위로 이겼다면, 가위의 가중치를 +1을 하고, 전의 게임에서  비겼다면, 비긴 손의 모양의 가중치를 +0.5를 하고, 전의 게임에서 졌다면, 진 손의 모양의 가중치를 -1를 한다.
 * 이 전략은 랜덤 전략을 기반으로 두고 있기 때문에, 랜덤으로 손의 모양이 나오긴 하지만, 손의 모양에 따른 확률을 조정해 이긴 횟수가 많은 손의 모양을 내게 하기 위함이다.
 *
 * >> 여기서 랜덤 확률을 좀 더 정확하게 하기 위해 전체를 999로 두었으며, 전체 999 중 얼마나 해당되는 지를 저장한 것이 가중치를 고려한 확률이 되는 것이다.
 * 
 * <<알고리즘을 고안한 배경>>
 *본인은 친구와 가위바위보를 많이 하게 되면, 그 친구와 가위바위보를 했을 때 어떤 손으로 가장 많이 이길 수 있는지를 기억해 손의 모양을 결정하는 경우가 많다.
 *이것의 기반은 랜덤 가위바위보 전략이긴 하지만, 가위바위보를 했을 때 어떤 손으로 많이 이기거나 비기는지 또는  지는지를 기억해 랜덤확률을 바꿔주는 것이다.
 *현재 이 알고리즘을 기반한 애플리케이션도 상용화되어있으며, 주변 친구들 중에서도 이 애플리케이션을 사용하기도 한다.
*/

import java.util.Random; // 랜덤 클래스를 정의하기 위한 패키지를 정의

public class WeightBasedStrategy implements PlayingStrategy {
	// 랜덤 가위바위보 기반으로 가중치에 따라 내야되는 손의 모양을 결정하는 전략을 정의하기 위한 클래스
	public Random randomGen = new Random(); // 랜덤 클래스 객체를 정의
	private HandType prevHand = HandType.valueOf(randomGen.nextInt(3));
	// 이전에 손의 모양을 저장하는 변수로, 초기값은 0~2까지 랜덤 값으로 정의
	private ResultType prevResult = ResultType.values()[randomGen.nextInt(3)];
	// 이전의 가위바위보 결과를 저장하는 변수로, 초기값은 0~2까지 랜덤 값으로 정의
	private double[] weight = new double[3];
	// 가위바위보의 가중치를 저장하기 위한 배열

	WeightBasedStrategy() { // 생성자 정의
		// 처음의 가중치를 모두 333으로 정의
		weight[0] = 333.0;
		weight[1] = 333.0;
		weight[2] = 333.0;
	}



	@Override
	public HandType nextHand() { // 다음의 손의 모양을 정의하는 함수
		// 랜덤으로 기반으로 가중치에 따라 손의 모양을 결정하는 전략을 이용
		int c = randomGen.nextInt(1000);
		// 랜덤 함수가 어디에 있는지에 따라 다음 값이 달라진다.
		// 0~999 중 랜덤 함수를 돌려 랜덤 값을 나오게 한다.
		// 이때 가위,바위,보가 나올 확률은 1/3, 1/3, 1/3이라고 할 수 있다.
		//System.out.printf("%d\n", c);

		setWeight(); // 전체를 999라고 생각했을 때, 얼마나 차지하는 지 확인해주는 함수 호출

		//System.out.printf("<<확률>> 가위 : %f, 바위 : %f. 보 : %f\n", weight[0], weight[0] + weight[1], weight[0] + weight[1] + weight[2]);

		if (c < weight[0]) // c가 만약 weight[0]보다 작으면
			prevHand = HandType.valueOf(0); // 다음의 손의 모양을 가위로 설정한다.
		else if (c < weight[0] + weight[1]) // c가 만약 weight[0]보다 크고 weight[0] +
											// weight[1]보다 작으면
			prevHand = HandType.valueOf(1); // 다음의 손의 모양을 바위로 설정한다.
		else // c가 만약 위의 조건에 걸리지 않는다면(c가 weight[0] + weight[1]보다 크고 weight[0] +
				// weight[1] + weight[2]보다 작으면)
			prevHand = HandType.valueOf(2); // 다음의 손의 모양을 보로 설정한다.
			
		return prevHand;
	}

	private void setWeight() { // 가중치 값을 999 값을 기준으로 했을 때, 얼마나 차지하는 지를 정의해주는 함수
		weight[0] = (weight[0] / (weight[0] + weight[1] + weight[2])) * 999.0;
		weight[1] = (weight[1] / (weight[0] + weight[1] + weight[2])) * 999.0;
		weight[2] = (weight[2] / (weight[0] + weight[1] + weight[2])) * 999.0;
	}

	
	@Override
	public void recordHistory(ResultType currentResult) { // 이전 값들을 기록하는 함수
		if (currentResult != null) { // 이전 결과가 null이 아니라면
			prevResult = currentResult; // 이전 결과에 현재 결과 대입
		}

		changeWeight(); // 이 함수는 이전에 이겼는지, 비겼는지, 졌는지에 따라 가중치를 변경해주는 함수로,
		// 이겼을 때는 가중치를 1 증가, 비겼을 때에는 가중치를 0.5 증가, 졌을 때는 가중치를 1 감소해주었다.
		// 이렇게 가중치를 다르게 하여, 가중치가 높을 때는 랜덤 확률이 높아지게 하고, 가중치가 낮을 때는 랜덤 확률이 낮아지게 하기 위함이다.

	}
	
	private void changeWeight() { // 이전에 이김, 무승부, 짐에 따라 가중치를 변경해주는 함수
		switch (prevResult) { // 이전의 결과에 따라
		case WON: { // 사용자가 이전에 이겼으면
			if (prevHand.ordinal() == 0) // 이전 손이 가위라면
				weight[0] = weight[0] + 1; // 가위의 가중치(weight[0])을 1증가
			else if (prevHand.ordinal() == 1) // 이전 손이 바위라면
				weight[1] = weight[1] + 1; // 바위의 가중치(weight[1])를 1증가
			else if (prevHand.ordinal() == 2) // 이전 손이 보라면
				weight[2] = weight[2] + 1; // 보의 가중치(weight[2])를 1증가

			break;
		}

		case DRAWN: { // 사용자가 이전에 비겼으면
			if (prevHand.ordinal() == 0) // 이전 손이 가위라면
				weight[0] = (double) (weight[0] + 0.5); // 가위의 가중치(weight[0])을 0.5증가
			else if (prevHand.ordinal() == 1) // 이전 손이 바위라면
				weight[1] = (double) (weight[1] + 0.5); // 바위의 가중치(weight[1])을 0.5증가
			else if (prevHand.ordinal() == 2) // 이전 손이 보라면
				weight[2] = (double) (weight[2] + 0.5); // 보의 가중치(weight[2])를 0.5증가

			break;
		}
		case LOST: { // 사용자가 이전에 졌으면
			if (prevHand.ordinal() == 0) // 이전 손이 가위라면
				weight[0] = weight[0]-1; // 가위의 가중치(weight[0])을 1감소
			else if (prevHand.ordinal() == 1) // 이전 손이 바위라면
				weight[1] = weight[1]-1; // 바위의 가중치(weight[1])을 1감소
			else if (prevHand.ordinal() == 2) // 이전 손이 보라면
				weight[2] = weight[2]-1; // 보의 가중치(weight[2])를 1감소

			break;
		}

		}
	}

}
