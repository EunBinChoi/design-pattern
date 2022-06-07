// 파일명 : Mocha.java

// 객체지향개발론 및 실습 Laboratory 3_숙제(equals 함수를 2개의 버전으로 구현함, 나머지 하나 주석 처리)
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

public class Mocha extends CondimentDecorator { // codiment 중에 하나인 Mocha 클래스 정의
	public Mocha(Beverage beverage){ // 생성자 정의
		setDecoratee(beverage); 
	}
		
	@Override
	public String getDescription() { // 문자열을 반환해주는 함수
		return getBeverage().getDescription() + ", Mocha"; // 현재 getDescription에 "Mocha" 문자열을 덧붙임
	} // 무조건 재정의하게 끔함 // 상속을 통해 장식하는게 아니라
	// has-a 관계로 장식을 갖음

	@Override
	public int cost() { // 가격을 반환하는 함수
		return getBeverage().cost() + 200; // 현재 cost에 200을 추가(200원은 Mocha에 대한 값)
	}

}
