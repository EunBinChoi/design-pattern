// ���ϸ� : HouseBlend.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 3_����(equals �Լ��� 2���� �������� ������, ������ �ϳ� �ּ� ó��)
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

public class HouseBlend extends Beverage { // beverage �� �ϳ��� HouseBlend Ŭ���� ����
	// �� Ŭ������ Beverage Ŭ������ ��ӹ���
	public HouseBlend(){ // ������
		setDescription("HouseBlend"); // setDescription �Լ��� "DarkRoast" ���ڿ��� �Բ� ������
	}
	
	@Override
	public int cost() {// ������ ��ȯ�ϴ� �Լ�
		return 1000; 
		// cost = 1000, return cost; �̷������� ���� ����
		// ���� ������ �����Ǹ� cost ��ü�� �����ؾ��ϴ� ������������
	}	
}
