// ���ϸ� : DarkRoast.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 3_����(equals �Լ��� 2���� �������� ������, ������ �ϳ� �ּ� ó��)
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

public class DarkRoast extends Beverage{ // beverage �� �ϳ��� DarkRoast Ŭ���� ����
	// �� Ŭ������ Beverage Ŭ������ ��ӹ���
	public DarkRoast(){ // ������
		setDescription("DarkRoast"); // setDescription �Լ��� "DarkRoast" ���ڿ��� �Բ� ������
	}
	
	@Override 
	public int cost() { // ������ ��ȯ�ϴ� �Լ�
		return 2000; 
	}

}
