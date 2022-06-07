// ���ϸ� : Mocha.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 3_����(equals �Լ��� 2���� �������� ������, ������ �ϳ� �ּ� ó��)
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

public class Mocha extends CondimentDecorator { // codiment �߿� �ϳ��� Mocha Ŭ���� ����
	public Mocha(Beverage beverage){ // ������ ����
		setDecoratee(beverage); 
	}
		
	@Override
	public String getDescription() { // ���ڿ��� ��ȯ���ִ� �Լ�
		return getBeverage().getDescription() + ", Mocha"; // ���� getDescription�� "Mocha" ���ڿ��� ������
	} // ������ �������ϰ� ���� // ����� ���� ����ϴ°� �ƴ϶�
	// has-a ����� ����� ����

	@Override
	public int cost() { // ������ ��ȯ�ϴ� �Լ�
		return getBeverage().cost() + 200; // ���� cost�� 200�� �߰�(200���� Mocha�� ���� ��)
	}

}
