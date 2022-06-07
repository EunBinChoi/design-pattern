// 파일명 : Beverage.java

// 객체지향개발론 및 실습 Laboratory 3_숙제(equals 함수를 2개의 버전으로 구현함, 나머지 하나 주석 처리)
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

public abstract class Beverage { // 음료 클래스 정의
	private String description = "Unknown Beverage";
	// 음료의 이름을 'Unknown Beverage'으로 초기화

	public String getDescription() { // description의 값을 반환해주는 getter 함수
		return description; // 현재 description 반환
	}

	public void setDescription(String description) { // description의 값을 설정해주는 setter 함수
		this.description = description; // 인자로 들어온 description 값을 현재 description에 대입
										
	}

	abstract public int cost(); // 가격을 계산해주는 함수
	// 추상 메소드로 정의 (상속받는 클래스마다 메소드의 내용이 바뀜)

	public Beverage removeCondiment() { // 첨가물을 제거해주는 함수
		return this;
	} 
	

	/*equals 메소드 재정의
	 * 
	 * 이 메소드는 Object에 정의되어있는 equals 메소드를 재정의하는 메소드로,
	 * 만약 인자로 받아오는 Object 클래스의 객체 o가 null이거나 제대로된 class가 아니라면 false 반환하고,
	 * o가 this와 같다면 true 반환한다.
	 * 
	 * 여기서 객체를 비교할 때 비교에 사용되는 데이터가 없으므로, getClass를 이용하여 객체를 비교하는데,
	 * 만약 인자로 들어온 Object의 객체 o의 클래스와 현재 클래스가 같으면 true를 반환하고, 다르면 false를 반환한다. 
	 * */
	
	@Override
	public boolean equals(Object o) { // equals 함수 재정의
		// 만약 인자로 들어온 Object 클래스의 객체 o가 null이거나 o의 클래스와 현재 클래스가 다르다면 false 반환
		if (o == null || o.getClass() != getClass()) return false;
		// 객체 o가 this와 같다면 true 반환
		if (o == this) return true;
		
		return o.getClass() == getClass(); // 객체 o의 클래스와 현재 클래스가 같다면 true 반환, 다르다면 false 반환
	}
}
