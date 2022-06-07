// ���ϸ� : CondimentDecorator.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 3_����(equals �Լ��� 2���� �������� ������, ������ �ϳ� �ּ� ó��)
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

// ���� ������ ����� ������ ����
// ������ ������� ���� �״�ο����ϱ� ������ ����� �̿�

// �߻�Ŭ���� : �������̽�ó�� �� Ŭ������ ��ӹ���  Ŭ������ �߻�Ŭ������ ���ǵ� �޼ҵ带 ������ ,
// �������̵��ؼ� ����� �� ������, ��� �޼ҵ带 �������̵��ؾ��ϴ� ���� �ƴϴ�.
import java.util.ArrayList; // ArrayList�� �����ϱ� ���� ��Ű�� import
import java.util.Collections; // Collections�� �����ϱ� ���� ��Ű�� import

public abstract class CondimentDecorator extends Beverage { // ÷������ �����ϴ� Ŭ������, Beverage�� ��� ����
	ArrayList<String> str1 = new ArrayList<>(); // ArrayList<String> ����
	ArrayList<String> str2 = new ArrayList<>(); // ArrayList<String> ����
	private Beverage beverage; // Beverage Ŭ������ beverage ��ü ����

	protected void setDecoratee(Beverage beverage) { // �߰����� �����ϴ� �Լ�
		this.beverage = beverage; // ���ڷ� �޾ƿ� beverage�� ���� Ŭ������ ��ü beverage�� ����
	}

	protected Beverage getBeverage() { // beverage�� ��ȯ�ϴ� �Լ�
		return beverage; // beverage ��ȯ
	}

	public abstract String getDescription(); // ���ῡ ÷���� �߰����� ���ڿ��� ��ȯ�ϴ� �Լ�

	
	
	// ���� 1
	/*equals �޼ҵ� ������
	 * 
	 * ���� ���ڿ��� �����ϴ� ArrayList str1, str2�� ���� clear�� �ʱ�ȭ���ش�.(������ ����Ǿ��ִ� ������ �����ϱ� ����)
	 * ���ڷ� �޾ƿ��� ��ü o�� CondimentDecorator Ŭ������ ������ ��ȯ�ϰ�, cd�� �����Ѵ�.
	 * 
	 * ���ڿ��� �����ϴ� �迭 token1, token2�� �������� ��, token(,)�� �������� ���ڿ��� �и��Ͽ� �������ش�.
	 * ��ū�� �������� �ڸ� ���ڿ��� str1�� str2�� ������ ��, ������ ���ڿ��� ���̸� size1, size2�� �������ش�.
	 * 
	 * �׸��� �ݺ����� �����鼭,
	 * str2�� s��° �ε��� ���� �������� ������ -1�� ��ȯ���ְ�,(���� Ȯ��, ������ ���� �ִ��� Ȯ���ϱ� ����)
	 * str2�� s���� �ε��� ���� �����ϸ�, s��° �ε����� ���� �����Ѵ�. �׸��� ���ڿ��� ���� size2�� �ϳ� ���ҽ�Ų��.
	 * 
	 * ����, ���� str1�� s��° �ε����� ���� str1�� ���ڿ��� ���̿� 1�� �� �Ͱ� ����, str2�� ���ڿ��� ������ 0�����
	 * �� �迭�� �����ϴ� ���ڿ����� ��� ��ġ�Ѵٴ� ���̴�.(������ �������)
	 */
	
//	@Override
//	public boolean equals(Object o) // equals �Լ� ������
//	{
//		str1.clear(); // ArrayList<String>�� str1 ���� ������ clear��
//		str2.clear(); // ArrayList<String>�� str2 ���� ������ clear��
//		
//		CondimentDecorator cd = (CondimentDecorator)o; // ���ڷ� �޾ƿ� Object ��ü o�� CondimentDecorator�� ����ȯ
//		String[] token1 = this.getDescription().split(", "); 
//		// ���� ��ü�� ���ڿ��� ��ȯ�ϴ� getDescription() �Լ��� ȣ���Ͽ�, ���ڿ��� (,)���� ������ �Լ� split�� ȣ��
//		String[] token2 = cd.getDescription().split(", ");
//		// ��ü cd�� ���ڿ��� ��ȯ�ϴ� getDescription() �Լ��� ȣ���Ͽ�, ���ڿ��� (,)���� ������ �Լ� split�� ȣ��
//		
//		Collections.addAll(str1, token1); // ��ū(,)�� �������� �ڸ� ���ڿ� �迭�� str1�� ����
//		Collections.addAll(str2, token2); // ��ū(,)�� �������� �ڸ� ���ڿ� �迭�� str2�� ���� 
////		System.out.println(str1);
////		System.out.println(str2);
//		
//		int size1 = str1.size(); // size1�� str1 ���� ����
//		int size2 = str2.size(); // size2�� str2 ���� ����
//		
//		for (String s : str1) { // �ݺ����� ���鼭
//			if (str2.indexOf(s) == -1) // str2�� s��° �ε����� ���� �������� ������ -1 ��ȯ
//				return false;
//				
//			else{
//				str2.remove(s); // str2���� s��° �ε����� ���� ����
//				size2 --; // size2�� �� 1 ����
//			}
//			if((str1.indexOf(s) == size1 - 1) && (size2 == 0))
//				// str1�� s��° �ε����� ���� str1�� ���ڿ��� ���̿� 1�� �� �Ͱ� ����
//				// str2�� ���ڿ��� ������ 0�����
//				// true ��ȯ
//				return true;
//		}
//		return false; // �ݺ��� ������ �� ���ڿ��� ������ Ȯ���ϴ� ������ ��ġ�� �ʾ����� true ��ȯ
//	}
	
	// ���� 2
	/*equals �޼ҵ� ������
	 * 
	 * ���� ���ڿ��� �����ϴ� ArrayList str1, str2�� ���� clear�� �ʱ�ȭ���ش�.(������ ����Ǿ��ִ� ������ �����ϱ� ����)
	 * ���ڷ� �޾ƿ��� ��ü o�� CondimentDecorator Ŭ������ ������ ��ȯ�ϰ�, cd�� �����Ѵ�.
	 * 
	 * ���ڿ��� �����ϴ� �迭 token1, token2�� �������� ��, token(,)�� �������� ���ڿ��� �и��Ͽ� �������ش�.
	 * ��ū�� �������� �ڸ� ���ڿ��� ArrayList�� str1, str2�� �߰����� ��, ������ ���ڿ��� ���̸� size1, size2�� �������ش�.
	 * 
	 * 1) ���� ������ ���ڿ��� ���� size1�� size2�� �ٸ��ٸ� false�� ��ȯ�Ѵ�. 
	 * (�� ���ڿ��� �迭�� ������ Ȯ���Ϸ��� ���� �迭�� ũ�Ⱑ ���ƾ�������)
	 * 
	 * 2) ���� �ݺ����� ���鼭 ���� �ݺ������� ū �ݺ����� �����ϴ� ������ i�̰�, ���� �ݺ����� �����ϴ� ������ j�̴�.
	 * i�� size1���� ���� j�� str2.size()���� ���鼭
	 * (j�� str2.size()���� ���� ������ �ݺ��� �߰��� str2�� �����ϴ� ��, �̸� �ݿ����ֱ� �����̴�)
	 * 
	 * 3) str1�� i��° �ִ� ���ڿ��� str2�� j���� �ִ� ���ڿ��� �����ϸ�, str2�� j��° �ִ� ���ڿ��� �������ش�.
	 * �̷��� ���ڿ��� �������ִ� ������, str1���� ������ ���ڿ� "Mocha"�� ���� ��, str1���� �ι�° "Mocha"�� �����Ϸ��� �ҋ�
	 * str2�� ���� �ε����� �����Ͽ� �ߺ��� ����� �� �����Ƿ� , �̸� �������� ����̴�.
	 * 
	 * 4) ���� �ݺ����� ������ ���� j�� size2�� ���ٸ�, str2 �迭�� �ƹ��͵� �������� �ʾҴٴ� �ǹ��̹Ƿ�, �ݺ����� �ѹ� ������ ��,
	 * ���� ��ġ�ϴ� ���� ���ٴ� ���̴�. false�� ��ȯ�Ѵ�.
	 * 
	 * 5) ���� ��ü �ݺ����� ������ �� str2�� �迭 ũ�Ⱑ 0�̸� str2�� �ִ� 
	 * ��� ���ڿ��� str1�� ��ġ�Ѵٴ� ���̹Ƿ�(����, �ε����� �������), true�� ��ȯ�Ѵ�.
	 *
	 */
	
	// ���� 2
	@Override
	public boolean equals(Object o) // equals �Լ� ������
	{
		str1.clear(); // ArrayList<String>�� str1 ���� ������ clear��
		str2.clear(); // ArrayList<String>�� str2 ���� ������ clear��
		
		CondimentDecorator cd = (CondimentDecorator)o; // ���ڷ� �޾ƿ� Object ��ü o�� CondimentDecorator�� ����ȯ
		String[] token1 = this.getDescription().split(", "); 
		// ���� ��ü�� ���ڿ��� ��ȯ�ϴ� getDescription() �Լ��� ȣ���Ͽ�, ���ڿ��� (,)���� ������ �Լ� split�� ȣ��
		String[] token2 = cd.getDescription().split(", ");
		// ��ü cd�� ���ڿ��� ��ȯ�ϴ� getDescription() �Լ��� ȣ���Ͽ�, ���ڿ��� (,)���� ������ �Լ� split�� ȣ��
		
		for(int i = 0 ; i < token1.length ; i ++){ // ���ڿ��� (,)���� ���� ���� ���ڿ��� ������ŭ �ݺ����� ���鼭 
			str1.add(token1[i]); // ArrayList<String>�� str1�� token1[i] ����
		}
		
		for(int i = 0 ; i < token2.length ; i ++){ // ���ڿ��� (,)���� ���� ���� ���ڿ��� ������ŭ �ݺ����� ���鼭 
			str2.add(token2[i]); // ArrayList<String>�� str2�� token2[i] ����
		}

		int i = 0 , j = 0; // �ݺ����� ���� ���� ���� ����
		int size1 = str1.size(); // str1�� �迭 ũ�⸦ ����Ͽ� size1�� ����
		int size2 = str2.size(); // str2�� �迭 ũ�⸦ ����Ͽ� size2�� ����
		
		if(size1 != size2) return false; // ���� �� �迭�� ũ�Ⱑ �ٸ��ٸ� false ��ȯ
		
		for(i = 0 ; i < size1; i++){ // i�� str1�� ���ڿ��� �����ϴ� �ݺ��� ����
			for(j = 0 ; j < str2.size() ; j++) // j�� str2�� ���ڿ��� �����ϴ� �ݺ��� ����
			{
				
				if(str1.get(i).equals(str2.get(j))) { // str1�� i��°�� �ִ� ���ڿ��� str2�� j��°�� �ִ� ���ڿ� ��
					// ���� �� ���ڿ��� ���ٸ�
					str2.remove(j); // str2�� j��° �ִ� ���ڿ� ����(�̷��� ���ִ� ������ str2�� ������ �ε����� ������ ���� ����
					break; // �ݺ����� ��������
				}		
			}
			if(j ==  size2)	return false; // ���� j�� size2�� ���ٸ�, false ��ȯ	
			
		}
		

		if(str2.size() == 0) return true;  
		// ���� str2 �迭�� ũ�Ⱑ 0�̶�� ��� str2  �迭�� �������� �ǹ���
		// ��, ��� str2 �迭�� str1�� ��ġ(�ε����� �������, ������ ��� ����)
		// true ��ȯ
		else return false; // ���� �׷��� �ʴٸ� false ��ȯ
	
	}
}
