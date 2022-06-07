// 파일명 : CondimentDecorator.java

// 객체지향개발론 및 실습 Laboratory 3_숙제(equals 함수를 2개의 버전으로 구현함, 나머지 하나 주석 처리)
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

// 실제 포장은 상속을 가지고 안함
// 하지만 결과값이 음료 그대로여야하기 때문에 상속을 이용

// 추상클래스 : 인터페이스처럼 이 클래스를 상속받은  클래스가 추상클래스에 정의된 메소드를 가지고 ,
// 오버라이딩해서 사용할 수 있지만, 모든 메소드를 오버라이딩해야하는 것은 아니다.
import java.util.ArrayList; // ArrayList를 정의하기 위한 패키지 import
import java.util.Collections; // Collections을 정의하기 위한 패키지 import

public abstract class CondimentDecorator extends Beverage { // 첨가물을 관리하는 클래스로, Beverage를 상속 받음
	ArrayList<String> str1 = new ArrayList<>(); // ArrayList<String> 정의
	ArrayList<String> str2 = new ArrayList<>(); // ArrayList<String> 정의
	private Beverage beverage; // Beverage 클래스의 beverage 객체 생성

	protected void setDecoratee(Beverage beverage) { // 추가물을 설정하는 함수
		this.beverage = beverage; // 인자로 받아온 beverage를 현재 클래스의 객체 beverage에 대입
	}

	protected Beverage getBeverage() { // beverage을 반환하는 함수
		return beverage; // beverage 반환
	}

	public abstract String getDescription(); // 음료에 첨가된 추가물을 문자열로 반환하는 함수

	
	
	// 버전 1
	/*equals 메소드 재정의
	 * 
	 * 먼저 문자열을 저장하는 ArrayList str1, str2을 먼저 clear로 초기화해준다.(이전에 저장되어있는 값들을 삭제하기 위해)
	 * 인자로 받아오는 객체 o를 CondimentDecorator 클래스로 형식을 변환하고, cd에 저장한다.
	 * 
	 * 문자열을 저장하는 배열 token1, token2을 정의해준 뒤, token(,)을 기준으로 문자열을 분리하여 저장해준다.
	 * 토큰을 기준으로 자른 문자열을 str1과 str2에 복사한 뒤, 각각의 문자열의 길이를 size1, size2에 저장해준다.
	 * 
	 * 그리고 반복문을 돌리면서,
	 * str2의 s번째 인덱스 값이 존재하지 않으면 -1을 반환해주고,(길이 확인, 동일한 값이 있는지 확인하기 위함)
	 * str2의 s번쨰 인덱스 값이 존재하면, s번째 인덱스의 값을 삭제한다. 그리고 문자열의 길이 size2를 하나 감소시킨다.
	 * 
	 * 또한, 만약 str1의 s번째 인덱스의 값과 str1의 문자열의 길이에 1을 뺀 것과 같고, str2의 문자열의 갯수가 0개라면
	 * 두 배열에 존재하는 문자열들이 모두 일치한다는 것이다.(순서와 상관없이)
	 */
	
//	@Override
//	public boolean equals(Object o) // equals 함수 재정의
//	{
//		str1.clear(); // ArrayList<String>형 str1 안의 내용을 clear함
//		str2.clear(); // ArrayList<String>형 str2 안의 내용을 clear함
//		
//		CondimentDecorator cd = (CondimentDecorator)o; // 인자로 받아온 Object 객체 o를 CondimentDecorator로 형변환
//		String[] token1 = this.getDescription().split(", "); 
//		// 현재 객체의 문자열을 반환하는 getDescription() 함수를 호출하여, 문자열을 (,)으로 나누는 함수 split을 호출
//		String[] token2 = cd.getDescription().split(", ");
//		// 객체 cd의 문자열을 반환하는 getDescription() 함수를 호출하여, 문자열을 (,)으로 나누는 함수 split을 호출
//		
//		Collections.addAll(str1, token1); // 토큰(,)을 기준으로 자른 문자열 배열을 str1에 복사
//		Collections.addAll(str2, token2); // 토큰(,)을 기준으로 자른 문자열 배열을 str2에 복사 
////		System.out.println(str1);
////		System.out.println(str2);
//		
//		int size1 = str1.size(); // size1에 str1 길이 저장
//		int size2 = str2.size(); // size2에 str2 길이 저장
//		
//		for (String s : str1) { // 반복문을 돌면서
//			if (str2.indexOf(s) == -1) // str2의 s번째 인덱스의 값이 존재하지 않으면 -1 반환
//				return false;
//				
//			else{
//				str2.remove(s); // str2에서 s번째 인덱스의 값을 삭제
//				size2 --; // size2의 값 1 감소
//			}
//			if((str1.indexOf(s) == size1 - 1) && (size2 == 0))
//				// str1의 s번째 인덱스의 값과 str1의 문자열의 길이에 1을 뺀 것과 같고
//				// str2의 문자열의 갯수가 0개라면
//				// true 반환
//				return true;
//		}
//		return false; // 반복문 만에서 두 문자열이 같은지 확인하는 절차를 거치지 않았으면 true 반환
//	}
	
	// 버전 2
	/*equals 메소드 재정의
	 * 
	 * 먼저 문자열을 저장하는 ArrayList str1, str2을 먼저 clear로 초기화해준다.(이전에 저장되어있는 값들을 삭제하기 위해)
	 * 인자로 받아오는 객체 o를 CondimentDecorator 클래스로 형식을 변환하고, cd에 저장한다.
	 * 
	 * 문자열을 저장하는 배열 token1, token2을 정의해준 뒤, token(,)을 기준으로 문자열을 분리하여 저장해준다.
	 * 토큰을 기준으로 자른 문자열을 ArrayList형 str1, str2에 추가해준 뒤, 각각의 문자열의 길이를 size1, size2에 저장해준다.
	 * 
	 * 1) 만약 구해준 문자열의 길이 size1와 size2이 다르다면 false를 반환한다. 
	 * (두 문자열의 배열이 같은지 확인하려면 먼저 배열의 크기가 같아야함으로)
	 * 
	 * 2) 이중 반복문을 돌면서 이중 반복문에서 큰 반복문을 제어하는 변수는 i이고, 작은 반복문을 제어하는 변수는 j이다.
	 * i는 size1까지 돌고 j는 str2.size()까지 돌면서
	 * (j가 str2.size()까지 도는 이유는 반복문 중간에 str2를 삭제하는 데, 이를 반영해주기 위함이다)
	 * 
	 * 3) str1의 i번째 있는 문자열과 str2의 j번쨰 있는 문자열이 동일하면, str2의 j번째 있는 문자열을 삭제해준다.
	 * 이렇게 문자열읋 삭제해주는 이유는, str1에서 동일한 문자열 "Mocha"가 있을 때, str1에서 두번째 "Mocha"를 접근하려고 할떄
	 * str2의 같은 인덱스를 접근하여 중복을 허용할 수 있으므로 , 이를 막기위한 방법이다.
	 * 
	 * 4) 작은 반복문이 끝나고 만약 j가 size2와 같다면, str2 배열이 아무것도 삭제되지 않았다는 의미이므로, 반복문을 한번 돌았을 때,
	 * 값이 일치하는 것이 없다는 것이다. false를 반환한다.
	 * 
	 * 5) 만약 전체 반복문이 끝났을 시 str2의 배열 크기가 0이면 str2에 있는 
	 * 모든 문자열이 str1과 일치한다는 것이므로(순서, 인덱스와 상관없이), true를 반환한다.
	 *
	 */
	
	// 버전 2
	@Override
	public boolean equals(Object o) // equals 함수 재정의
	{
		str1.clear(); // ArrayList<String>형 str1 안의 내용을 clear함
		str2.clear(); // ArrayList<String>형 str2 안의 내용을 clear함
		
		CondimentDecorator cd = (CondimentDecorator)o; // 인자로 받아온 Object 객체 o를 CondimentDecorator로 형변환
		String[] token1 = this.getDescription().split(", "); 
		// 현재 객체의 문자열을 반환하는 getDescription() 함수를 호출하여, 문자열을 (,)으로 나누는 함수 split을 호출
		String[] token2 = cd.getDescription().split(", ");
		// 객체 cd의 문자열을 반환하는 getDescription() 함수를 호출하여, 문자열을 (,)으로 나누는 함수 split을 호출
		
		for(int i = 0 ; i < token1.length ; i ++){ // 문자열을 (,)으로 나눠 나온 문자열의 갯수만큼 반복문을 돌면서 
			str1.add(token1[i]); // ArrayList<String>형 str1에 token1[i] 대입
		}
		
		for(int i = 0 ; i < token2.length ; i ++){ // 문자열을 (,)으로 나눠 나온 문자열의 갯수만큼 반복문을 돌면서 
			str2.add(token2[i]); // ArrayList<String>형 str2에 token2[i] 대입
		}

		int i = 0 , j = 0; // 반복문을 돌기 위한 변수 선언
		int size1 = str1.size(); // str1의 배열 크기를 계산하여 size1에 대입
		int size2 = str2.size(); // str2의 배열 크기를 계산하여 size2에 대입
		
		if(size1 != size2) return false; // 만약 두 배열의 크기가 다르다면 false 반환
		
		for(i = 0 ; i < size1; i++){ // i는 str1의 문자열을 접근하는 반복문 변수
			for(j = 0 ; j < str2.size() ; j++) // j는 str2의 문자열을 접근하는 반복문 변수
			{
				
				if(str1.get(i).equals(str2.get(j))) { // str1의 i번째에 있는 문자열과 str2의 j번째에 있는 문자열 비교
					// 만약 두 문자열이 같다면
					str2.remove(j); // str2에 j번째 있는 문자열 제거(이렇게 해주는 이유는 str2의 동일한 인덱스에 접근을 막기 위함
					break; // 반복문을 빠져나옴
				}		
			}
			if(j ==  size2)	return false; // 만약 j가 size2와 같다면, false 반환	
			
		}
		

		if(str2.size() == 0) return true;  
		// 만약 str2 배열의 크기가 0이라면 모든 str2  배열이 삭제됨을 의미함
		// 즉, 모든 str2 배열은 str1과 일치(인덱스와 상관없이, 순서와 상관 없이)
		// true 반환
		else return false; // 만약 그렇지 않다면 false 반환
	
	}
}
