// ���ϸ� : Test.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 2_����
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

public class Test { // test Ŭ����
   public static void main(String[] args){ // �����Լ�
      ITNewsPublisher newsServer = new ITNewsPublisher();
         
      // ��ü ����
      NewsClient client1 = new NewsClient("sangjin"); 
      NewsClient client2 = new NewsClient("jinhee");
      
      client1.setInterval(1); // ������ ����ϴ� �ֱ⸦ 1�� ����
      client2.setInterval(3); // ������ ����ϴ� �ֱ⸦ 3�� ����
     
   
      newsServer.addObserver(client1); // ��ü client1�� ���� 
      newsServer.addObserver(client2); // ��ü client2�� ����
     
      // ���ο� ���� ����
      newsServer.setNewFeed("������ 1: ���� 0");
      newsServer.setNewFeed("������ 2: ���� 0");
      newsServer.setNewFeed("������ 3: ���� 0");
      newsServer.setNewFeed("������ 3: ���� 1");
      newsServer.deleteObserver(client1); // ��ü client1�� ����
      
      // ���ο� ���� ����
      newsServer.setNewFeed("������ 3: ���� 2");
      newsServer.setNewFeed("������ 4: ���� 2");
      newsServer.setNewFeed("��� ����");
   
   }
} 