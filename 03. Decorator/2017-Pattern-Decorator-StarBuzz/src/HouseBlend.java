// 파일명 : HouseBlend.java

// 객체지향개발론 및 실습 Laboratory 3_숙제(equals 함수를 2개의 버전으로 구현함, 나머지 하나 주석 처리)
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

public class HouseBlend extends Beverage { // beverage 중 하나인 HouseBlend 클래스 정의
	// 이 클래스는 Beverage 클래스를 상속받음
	public HouseBlend(){ // 생성자
		setDescription("HouseBlend"); // setDescription 함수에 "DarkRoast" 문자열을 함께 보내줌
	}
	
	@Override
	public int cost() {// 가격을 반환하는 함수
		return 1000; 
		// cost = 1000, return cost; 이런식으로 하지 않음
		// 물론 가격이 변동되면 cost 자체를 수정해야하는 문제점이있음
	}	
}
