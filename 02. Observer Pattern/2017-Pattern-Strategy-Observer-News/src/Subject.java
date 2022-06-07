import java.util.ArrayList; // ArrayList을 사용하기 위한 라이브러리 import

// 파일명 : Subject.java

// 객체지향개발론 및 실습 Laboratory 2_숙제
// 교수님 : 김상진 교수님
// 분반 : 1분반
// 학부 : 컴퓨터공학부 
// 학번 : 2014136129
// 이름 : 최은빈

// 객체들을 정의하는 인터페이스
public interface Subject { 
	public void addObserver(NewsClient o); // 클라이언트 추가하는 함수
	public void deleteObserver(NewsClient o); // 클라이언트 삭제하는 함수
	public void notifyObservers(ArrayList<String> data); // 새로운 내용이 추가됨을 알리는 함수

}
