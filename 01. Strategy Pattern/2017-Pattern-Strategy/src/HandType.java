// 파일명 : HandType.java

// 객체지향개발론 및 실습 Laboratory 1_새로운 알고리즘 구현
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

public enum HandType { // 손의 모양을 저장해주는 열거형
	GAWI { // 가위
		@Override
		public String toString() { // 해당되는 손의 모양을 문자열로 출력해주는 함수
			return "가위";
		}

		@Override
		public HandType winValueOf() { // 각각의 손의 모양에서 이기는 손의 모양을 저장해주는 함수
			return BAWI; 
		}
	},
	BAWI { // 바위
		@Override
		public String toString() { // 해당되는 손의 모양을 문자열로 출력해주는 함수
			return "바위";
		}

		@Override
		public HandType winValueOf() { // 각각의 손의 모양에서 이기는 손의 모양을 저장해주는 함수
			return BO;
		}
	},
	BO { // 보
		@Override
		public String toString() { // 해당되는 손의 모양을 문자열로 출력해주는 함수
			return "보";
		}

		@Override
		public HandType winValueOf() { // 각각의 손의 모양에서 이기는 손의 모양을 저장해주는 함수
			return GAWI;
		}
	};


	// 각각의 손의 모양에서 이기는 손의 모양을 저장해주는 함수
	public abstract HandType winValueOf();

	// 해당하는 인덱스 값의 손의 모양이 무엇인지 반환해주는 함수
	// 인덱스 0 => 가위, 1=> 바위, 2=>보
	public static HandType valueOf(int n) {
		return HandType.values()[n]; 
	}
}