/**
* 객체지향개발론 및 실습 2017학년도 1학기 실습 4. Factory Method 패턴
* @editor최은빈(컴퓨터공학부 2014136129) 
* POWERFUL 타입의 OffRoad 차량을 나타내는 Concrete Product 클래스
*/
public class OriginalSUV extends OffRoad {
	public OriginalSUV(String description) {
		super(description);
	}
	@Override
	public int cost() {
		return 4000;
	}

}
