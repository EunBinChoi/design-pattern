// 파일명 : NewsClient.java

// 객체지향개발론 및 실습 Laboratory 2_숙제
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

public class NewsClient { // 새로운 객체를 정의하는 클래스 생성
	
	// 각 클라이언트마다 필요한 변수들
	private String id; // String형, 클라이언트의 id를 저장하는 변수
	private int newsPeriod; // int형, 클라이언트의 주기를 저장하는 변수
	private int cnt; // int형, 몇번의 정보를 제공받았는지 카운트하기 위한 변수
	private int prevPublisher; // 이전 통보 제공 시점을 저장하는 변수	
	
	
	public NewsClient() { // 생성자
	} 

	public NewsClient(String id) { // 클라이언트의 id를 설정해주는 생성자
		this.id = id; // 클라이언트의 id를 설정
	}

	public String getId(){ // 클라이언트의 id를 반환하는 함수
		return id; // id 반환
		
	}
	
	public void setInterval(int period) { // 클라이언트마다 뉴스 제공 주기를 저장해주는 함수
		
		newsPeriod = period; // 인자로 전달된 주기로 뉴스 제공 주기 설정
	}


	public int getCount() { // 클라이언트의 카운트 수를 반환하는 함수
		return cnt; // 카운트 수 반환
	}
	
	public void setCount(int cnt) { // 클라이언트의 카운트 수를 설정하는 함수
		this.cnt = cnt; // 카운트 수 설정
	}

	public int getNewsPeriod() { // 클라이언트의 주기를 반환하는 함수
		return newsPeriod; // 클라이언트 주기 반환
	}
	
	public int getPrevPublisher(){ // 클라이언트의 이전 통보 시점을 반환하는 함수
		return prevPublisher; // 클라이언트의 이전 통보 시점 반환
	}
	
	public void setPrevPublisher(int prev){ // 클라이언트의 이전 통보 시점을 설정하는 함수
		this.prevPublisher = prev; // 클라이언트의 이전 통보시점을 설정
	}
	
	/*
	 * 여기서 update 함수는 뉴스를 문자열 인자(lastestFeed)로 받아, 이를 출력해주는 함수이다.
	 * 이 함수는 클라이언트 클래스 안에 있으므로, 출력하는 것 이외에는 구현을 하지 않았다.
	 * 이 함수를 제어하는 부분은 ITNewsPublisher 클래스 안에 정의되어있다.
	 */
	public void update(String lastestFeed) { // 업데이트 함수

		System.out.println(lastestFeed); // 인자로 받은 뉴스를 출력
		
	}

	@Override
	public boolean equals(Object o) // equals 함수 재정의
	{
		if (o == null || o.getClass() != getClass())
			return false;
		if (o == this)
			return true;
		// 주소 같으면 당연히 같은 객체
		NewsClient nc = (NewsClient)o;
		// 멤버변수들을 타입 변환해서 참인지 아닌지 확인
		return id.equals(nc.id);
	}
}
