// ���ϸ� : NewsClient.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 2_����
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

public class NewsClient { // ���ο� ��ü�� �����ϴ� Ŭ���� ����
	
	// �� Ŭ���̾�Ʈ���� �ʿ��� ������
	private String id; // String��, Ŭ���̾�Ʈ�� id�� �����ϴ� ����
	private int newsPeriod; // int��, Ŭ���̾�Ʈ�� �ֱ⸦ �����ϴ� ����
	private int cnt; // int��, ����� ������ �����޾Ҵ��� ī��Ʈ�ϱ� ���� ����
	private int prevPublisher; // ���� �뺸 ���� ������ �����ϴ� ����	
	
	
	public NewsClient() { // ������
	} 

	public NewsClient(String id) { // Ŭ���̾�Ʈ�� id�� �������ִ� ������
		this.id = id; // Ŭ���̾�Ʈ�� id�� ����
	}

	public String getId(){ // Ŭ���̾�Ʈ�� id�� ��ȯ�ϴ� �Լ�
		return id; // id ��ȯ
		
	}
	
	public void setInterval(int period) { // Ŭ���̾�Ʈ���� ���� ���� �ֱ⸦ �������ִ� �Լ�
		
		newsPeriod = period; // ���ڷ� ���޵� �ֱ�� ���� ���� �ֱ� ����
	}


	public int getCount() { // Ŭ���̾�Ʈ�� ī��Ʈ ���� ��ȯ�ϴ� �Լ�
		return cnt; // ī��Ʈ �� ��ȯ
	}
	
	public void setCount(int cnt) { // Ŭ���̾�Ʈ�� ī��Ʈ ���� �����ϴ� �Լ�
		this.cnt = cnt; // ī��Ʈ �� ����
	}

	public int getNewsPeriod() { // Ŭ���̾�Ʈ�� �ֱ⸦ ��ȯ�ϴ� �Լ�
		return newsPeriod; // Ŭ���̾�Ʈ �ֱ� ��ȯ
	}
	
	public int getPrevPublisher(){ // Ŭ���̾�Ʈ�� ���� �뺸 ������ ��ȯ�ϴ� �Լ�
		return prevPublisher; // Ŭ���̾�Ʈ�� ���� �뺸 ���� ��ȯ
	}
	
	public void setPrevPublisher(int prev){ // Ŭ���̾�Ʈ�� ���� �뺸 ������ �����ϴ� �Լ�
		this.prevPublisher = prev; // Ŭ���̾�Ʈ�� ���� �뺸������ ����
	}
	
	/*
	 * ���⼭ update �Լ��� ������ ���ڿ� ����(lastestFeed)�� �޾�, �̸� ������ִ� �Լ��̴�.
	 * �� �Լ��� Ŭ���̾�Ʈ Ŭ���� �ȿ� �����Ƿ�, ����ϴ� �� �̿ܿ��� ������ ���� �ʾҴ�.
	 * �� �Լ��� �����ϴ� �κ��� ITNewsPublisher Ŭ���� �ȿ� ���ǵǾ��ִ�.
	 */
	public void update(String lastestFeed) { // ������Ʈ �Լ�

		System.out.println(lastestFeed); // ���ڷ� ���� ������ ���
		
	}

	@Override
	public boolean equals(Object o) // equals �Լ� ������
	{
		if (o == null || o.getClass() != getClass())
			return false;
		if (o == this)
			return true;
		// �ּ� ������ �翬�� ���� ��ü
		NewsClient nc = (NewsClient)o;
		// ����������� Ÿ�� ��ȯ�ؼ� ������ �ƴ��� Ȯ��
		return id.equals(nc.id);
	}
}
