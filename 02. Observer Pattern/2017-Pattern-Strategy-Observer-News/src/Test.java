// 파일명 : Test.java

// 객체지향개발론 및 실습 Laboratory 2_숙제
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

public class Test { // test 클래스
   public static void main(String[] args){ // 메인함수
      ITNewsPublisher newsServer = new ITNewsPublisher();
         
      // 객체 생성
      NewsClient client1 = new NewsClient("sangjin"); 
      NewsClient client2 = new NewsClient("jinhee");
      
      client1.setInterval(1); // 뉴스를 출력하는 주기를 1로 설정
      client2.setInterval(3); // 뉴스를 출력하는 주기를 3로 설정
     
   
      newsServer.addObserver(client1); // 객체 client1를 삽입 
      newsServer.addObserver(client2); // 객체 client2를 삽입
     
      // 새로운 뉴스 제공
      newsServer.setNewFeed("리버폴 1: 맨유 0");
      newsServer.setNewFeed("리버폴 2: 맨유 0");
      newsServer.setNewFeed("리버폴 3: 맨유 0");
      newsServer.setNewFeed("리버폴 3: 맨유 1");
      newsServer.deleteObserver(client1); // 객체 client1를 삭제
      
      // 새로운 뉴스 제공
      newsServer.setNewFeed("리버폴 3: 맨유 2");
      newsServer.setNewFeed("리버폴 4: 맨유 2");
      newsServer.setNewFeed("루니 퇴장");
   
   }
} 