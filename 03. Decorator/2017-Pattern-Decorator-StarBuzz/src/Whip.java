// 파일명 : Whip.java

// 객체지향개발론 및 실습 Laboratory 3_숙제(equals 함수를 2개의 버전으로 구현함, 나머지 하나 주석 처리)
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

public class Whip extends CondimentDecorator{ // codiment 중에 하나인 Whip 클래스 정의
	//private Beverage beverage;
	
	public Whip(Beverage beverage){ // 생성자 정의
		setDecoratee(beverage);
	}
	
	@Override
	public String getDescription() { // 문자열을 반환해주는 함수
		return getBeverage().getDescription()+ ", Whip"; // 현재 getDescription에 "Whip" 문자열을 덧붙임
	} // 무조건 재정의하게끔함 // 상속을 통해 장식ㅎ는게 아니라
	// has-a관걔로 장식을 갖음
	
	
	@Override
	public int cost() { // 가격을 반환하는 함수
		return getBeverage().cost() + 500; // 현재 cost에 500을 추가(500원은 Mocha에 대한 값)
	}
	
	
	
}
