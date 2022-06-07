// 파일명 : Test.java

// 객체지향개발론 및 실습 Laboratory 3_숙제(equals 함수를 2개의 버전으로 구현함, 나머지 하나 주석 처리)
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈


// 장식된 객체의 동기 여부를 비교하는 기능을 추가하여 보자
// 자바에서는 equals 메소드를 통해 두 객체가 같은지 여부를 확인한다

public class Test {
	public static void main(String[] args) { // 메인함수 정의
		Beverage beverage1 = new DarkRoast(); // Beverage 클래스의 객체인 beverage에 DarkRoast 객체를 생성하여 대입
		beverage1 = new Mocha(beverage1); // beverage에 Mocha 객체를 생성하여 대입
		beverage1 = new Mocha(beverage1); // beverage에 Mocha 객체를 생성하여 대입
		beverage1 = new Whip(beverage1); // beverage에 Whip 객체를 생성하여 대입
		
		
		Beverage beverage2 = new DarkRoast(); // Beverage 클래스의 객체인 beverage에 DarkRoast 객체를 생성하여 대입
		beverage2 = new Mocha(beverage2); // beverage에 Mocha 객체를 생성하여 대입
		beverage2 = new Whip(beverage2); // beverage에 Whip 객체를 생성하여 대입
		beverage2 = new Mocha(beverage2); // beverage에 Whip 객체를 생성하여 대입
		//beverage2 = new Whip(beverage2); // beverage에 Mocha 객체를 생성하여 대입

		
		System.out.printf("%s : %,d원\n", beverage1.getDescription(), beverage1.cost());
		// beverage1 문자열 출력 및 가격 출력
		System.out.printf("%s : %,d원\n", beverage2.getDescription(), beverage2.cost());
		// beverage2 문자열 출력 및 가격 출력
		System.out.println("\n[Beverage1, Beverage2]");
		System.out.println(">>EQUALS() : " + beverage1.equals(beverage2));
		// equals 함수 test 하기 위한 문장
	}

}
