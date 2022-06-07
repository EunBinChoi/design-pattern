// ���ϸ� : Whip.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 3_����(equals �Լ��� 2���� �������� ������, ������ �ϳ� �ּ� ó��)
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

public class Whip extends CondimentDecorator{ // codiment �߿� �ϳ��� Whip Ŭ���� ����
	//private Beverage beverage;
	
	public Whip(Beverage beverage){ // ������ ����
		setDecoratee(beverage);
	}
	
	@Override
	public String getDescription() { // ���ڿ��� ��ȯ���ִ� �Լ�
		return getBeverage().getDescription()+ ", Whip"; // ���� getDescription�� "Whip" ���ڿ��� ������
	} // ������ �������ϰԲ��� // ����� ���� ��Ĥ��°� �ƴ϶�
	// has-a���·� ����� ����
	
	
	@Override
	public int cost() { // ������ ��ȯ�ϴ� �Լ�
		return getBeverage().cost() + 500; // ���� cost�� 500�� �߰�(500���� Mocha�� ���� ��)
	}
	
	
	
}
