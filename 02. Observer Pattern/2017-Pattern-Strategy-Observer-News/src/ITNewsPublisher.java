// ���ϸ� : ITNewsPublisher.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 2_����
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

import java.util.ArrayList; // ArrayList�� ����ϱ� ���� ���̺귯�� import

public class ITNewsPublisher implements NewsPublisher {
	// Subject Ÿ���� Ŭ������ ��ü������ �����ϱ� ����  ITNewsPublisher Ŭ���� ����
	
	// ArrayList ����
   private ArrayList<NewsClient> client = new ArrayList<>(); // Ŭ���̾�Ʈ�� �����ϱ� ���� �迭
   private ArrayList<String> lastestFeed = new ArrayList<>(); // ������ ������ �����ϱ� ���� �迭
   
   private int cnt = 0; // �� Ŭ���� ������ �ֽ� ���� ������ �����ϱ� ���� ������ ����
  
   
   /*
    * ���⼭ notifyObservers�� �����͸� ���ڐd ���� �����ִ� ���, ��, push ����� ���� �������־���. 
    * 
    * �Լ� ���ο� ���� ������ ���ڸ�, 
    * 1)��ü�� ���� ��ŭ �ݺ����� ���鼭 NewsClient Ŭ������ setCount �Լ��� ȣ���Ѵ�.
    * setCount �Լ��� �� Ŭ���� ������ ������ �ֽ� ���� ����(cnt)�� NewsClient Ŭ������ �Ѱ��ִ� ���̴�.
    * �̷��� �ϴ� ������ ���� ITNewsPublisher �� Ŭ���� ������ setNewFeed �Լ��� ���ؼ� �ֽ� ���� ������ NewsClient�� cnt�� �������ֱ� �����̴�.
    * 
    * 2) ���� ������� ���� �ֽ� ������ ������ ������ �뺸�޾Ҵ� �ñ��� ���̰� ��ü�� �ֱ�� ������,
    * ��ü�� id�� ������� ��,
    * ������ �뺸�޾Ҵ� �ñ⿡�� cnt���� ���鼭, NewsClient Ŭ������ update �Լ��� ȣ�����ش�.
    * ���⼭ ArrayList�� lastestFeed �迭�� �����ϱ� ���� get�̶�� �����Լ��� ����Ͽ���.
    * 
    *  3) �ݺ����� ������ ��������, ���� cnt ���� ������ �뺸�޾Ҵ� �ñ�� �������ش�.
    *  (��������, ���� cnt ���� ������ �뺸�޾Ҵ� �ñⰡ �ǹǷ�)
    *  
    */
   
   @Override
   public void notifyObservers(ArrayList<String> data) { // ��ü�� �ֱ⿡ ���� ���� �߻��� �뺸���ִ� �Լ�
	  
      for (NewsClient o : client) // ��ü�� ������ŭ �ݺ����� ���鼭
      {
    	  
         o.setCount(cnt); // ���� �� Ŭ���� ���� cnt���� NewsClient Ŭ������ �Ѱ��ش�.
       
         if (o.getCount() - o.getPrevPublisher() == o.getNewsPeriod()) 
        	 // ���� ������� ������ ī��Ʈ�� ���� ���� �뺸���� ������ ���� ��ü�� �ֱⰡ �ȴٸ�
         {
            
            System.out.println(o.getId() + ":");  // �� ��ü�� id ���
            
            for (int i = o.getPrevPublisher() ; i < cnt ; i ++) {
            	// ���� �뺸���� ������ ���� ���� ī��Ʈ�� ��(cnt)���� ���鼭
            	o.update(lastestFeed.get(i));
            	// update �Լ� ȣ��
            	// ArrayList�� get�̶�� �����Լ��� ���� lastestFeed�� ����
            	
            }
            System.out.println("\n==="); // ��輱
            
            o.setPrevPublisher(cnt);
            // ���� cnt���� ������ �뺸���� ������ ����
        
         }
         
      }
   }

   @Override
   public void addObserver(NewsClient o) { // Ŭ���̾�Ʈ �߰�
      client.add(o); // ������
   }

   @Override
   public void deleteObserver(NewsClient o) { // Ŭ���̾�Ʈ ����
      client.remove(o); // ������
   }

   @Override
   public void setNewFeed(String newFeed) { // �ֽ��� ������ �����ϴ� �Լ�
      
      lastestFeed.add(newFeed); // ���ڷ� ���� �ֽ��� ������ lastestFeed �迭�� �߰�
      ++cnt;    // ī��Ʈ �� ����
      notifyObservers(lastestFeed); // ��ȭ�� �˸��� �Լ� ȣ��
   }
  

}