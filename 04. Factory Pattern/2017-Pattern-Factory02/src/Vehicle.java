/**
 * 객체지향개발론 및 실습 2017학년도 1학기 실습 4. Factory Method 패턴
 * 
 * @editor최은빈(컴퓨터공학부 2014136129) 모든 종류의 차량을 추상화할 수 있는 추상 Product 클래스
 */
public abstract class Vehicle {
	public enum Color {
		UNPAINTED, BLUE, BLACK, PERLWHITE, WHITE, SILVER, GRAY, RED
	};

	private Vehicle.Color color = Vehicle.Color.UNPAINTED;
	private String description;

	public Vehicle() {
	}

	public Vehicle(String description) {
		this.description = description;
	}

	public void paint(Color color) {
		this.color = color;
	}

	public abstract int cost();

	/* [숙제02] 차량의 색깔이 PERLWHITE만 10만원 추가비용이 발생하도록 하는 프로그램
	 * addCost() 함수에서 현재 색깔이 PERLWHITE이면 10만원을 추가한 뒤, 그 값을 return함
	 */
	public int addCost() {
		int sum = 0;
		if (color == Color.PERLWHITE) {
			sum += 10;
		}
		return sum;
	}

	/* [숙제02] 차량의 색깔이 PERLWHITE만 10만원 추가비용이 발생하도록 하는 프로그램
	 * toString() 함수에서 마지막 가격을 출력할 때, cost()+addCost()으로 설정
	 */
	public String toString() {
		return String.format("%s, %s, %,d만원%n", description, color, cost()+addCost());
	}
}
