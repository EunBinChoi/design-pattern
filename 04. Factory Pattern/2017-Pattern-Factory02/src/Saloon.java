/**
* 객체지향개발론 및 실습 2017학년도 1학기 실습 4. Factory Method 패턴
* @editor최은빈(컴퓨터공학부 2014136129) 
* 일반승용차량 중 LUXURY 타입에 해당하는 구체적 Product 클래스
*/
public class Saloon extends Car {
	// 대형 승용 차량을 나타내는 클래스
	public Saloon(String description) {
		super(description);
	}
	@Override
	public int cost() {
		return 5000;
	}
}
