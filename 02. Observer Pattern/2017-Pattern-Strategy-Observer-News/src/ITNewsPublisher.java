// 파일명 : ITNewsPublisher.java

// 객체지향개발론 및 실습 Laboratory 2_숙제
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

import java.util.ArrayList; // ArrayList을 사용하기 위한 라이브러리 import

public class ITNewsPublisher implements NewsPublisher {
	// Subject 타입의 클래스를 구체적으로 정의하기 위한  ITNewsPublisher 클래스 정의
	
	// ArrayList 정의
   private ArrayList<NewsClient> client = new ArrayList<>(); // 클라이언트를 저장하기 위한 배열
   private ArrayList<String> lastestFeed = new ArrayList<>(); // 제공된 뉴스를 저장하기 위한 배열
   
   private int cnt = 0; // 이 클래스 내에서 최신 뉴스 개수를 저장하기 위한 정수형 변수
  
   
   /*
    * 여기서 notifyObservers은 데이터를 인자릁 통해 전해주는 방식, 즉, push 방식을 통해 구현해주었다. 
    * 
    * 함수 내부에 대해 설명을 하자면, 
    * 1)객체의 개수 만큼 반복문을 돌면서 NewsClient 클래스의 setCount 함수를 호출한다.
    * setCount 함수는 이 클래스 내에서 저장한 최신 뉴스 개수(cnt)를 NewsClient 클래스로 넘겨주는 것이다.
    * 이렇게 하는 이유는 현재 ITNewsPublisher 이 클래스 내에서 setNewFeed 함수를 통해서 최신 뉴스 개수를 NewsClient의 cnt에 저장해주기 위함이다.
    * 
    * 2) 만약 현재까지 받은 최신 뉴스의 개수와 이전에 통보받았던 시기의 차이가 객체의 주기와 같으면,
    * 객체의 id를 출력해준 뒤,
    * 이전에 통보받았던 시기에서 cnt까지 돌면서, NewsClient 클래스의 update 함수를 호출해준다.
    * 여기서 ArrayList의 lastestFeed 배열을 접근하기 위해 get이라는 내장함수를 사용하였다.
    * 
    *  3) 반복문이 완전히 끝나고나면, 현재 cnt 값을 이전의 통보받았던 시기로 설정해준다.
    *  (다음부턴, 현재 cnt 값이 이전의 통보받았던 시기가 되므로)
    *  
    */
   
   @Override
   public void notifyObservers(ArrayList<String> data) { // 객체의 주기에 따라 뉴스 발생을 통보해주는 함수
	  
      for (NewsClient o : client) // 객체의 개수만큼 반복문을 돌면서
      {
    	  
         o.setCount(cnt); // 현재 이 클래스 내의 cnt값을 NewsClient 클래스로 넘겨준다.
       
         if (o.getCount() - o.getPrevPublisher() == o.getNewsPeriod()) 
        	 // 만약 현재까지 뉴스의 카운트와 이전 뉴스 통보받은 시점의 차가 객체의 주기가 된다면
         {
            
            System.out.println(o.getId() + ":");  // 그 객체의 id 출력
            
            for (int i = o.getPrevPublisher() ; i < cnt ; i ++) {
            	// 이전 통보받은 시점을 부터 현재 카운트의 수(cnt)까지 돌면서
            	o.update(lastestFeed.get(i));
            	// update 함수 호출
            	// ArrayList의 get이라는 내장함수를 통해 lastestFeed을 접근
            	
            }
            System.out.println("\n==="); // 경계선
            
            o.setPrevPublisher(cnt);
            // 현재 cnt값을 이전에 통보받은 값으로 설정
        
         }
         
      }
   }

   @Override
   public void addObserver(NewsClient o) { // 클라이언트 추가
      client.add(o); // 재정의
   }

   @Override
   public void deleteObserver(NewsClient o) { // 클라이언트 삭제
      client.remove(o); // 재정의
   }

   @Override
   public void setNewFeed(String newFeed) { // 최신의 뉴스를 설정하는 함수
      
      lastestFeed.add(newFeed); // 인자로 받은 최신의 뉴스를 lastestFeed 배열에 추가
      ++cnt;    // 카운트 수 증가
      notifyObservers(lastestFeed); // 변화를 알리는 함수 호출
   }
  

}