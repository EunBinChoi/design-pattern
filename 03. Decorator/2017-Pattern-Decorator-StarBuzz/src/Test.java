// ���ϸ� : Test.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 3_����(equals �Լ��� 2���� �������� ������, ������ �ϳ� �ּ� ó��)
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������


// ��ĵ� ��ü�� ���� ���θ� ���ϴ� ����� �߰��Ͽ� ����
// �ڹٿ����� equals �޼ҵ带 ���� �� ��ü�� ������ ���θ� Ȯ���Ѵ�

public class Test {
	public static void main(String[] args) { // �����Լ� ����
		Beverage beverage1 = new DarkRoast(); // Beverage Ŭ������ ��ü�� beverage�� DarkRoast ��ü�� �����Ͽ� ����
		beverage1 = new Mocha(beverage1); // beverage�� Mocha ��ü�� �����Ͽ� ����
		beverage1 = new Mocha(beverage1); // beverage�� Mocha ��ü�� �����Ͽ� ����
		beverage1 = new Whip(beverage1); // beverage�� Whip ��ü�� �����Ͽ� ����
		
		
		Beverage beverage2 = new DarkRoast(); // Beverage Ŭ������ ��ü�� beverage�� DarkRoast ��ü�� �����Ͽ� ����
		beverage2 = new Mocha(beverage2); // beverage�� Mocha ��ü�� �����Ͽ� ����
		beverage2 = new Whip(beverage2); // beverage�� Whip ��ü�� �����Ͽ� ����
		beverage2 = new Mocha(beverage2); // beverage�� Whip ��ü�� �����Ͽ� ����
		//beverage2 = new Whip(beverage2); // beverage�� Mocha ��ü�� �����Ͽ� ����

		
		System.out.printf("%s : %,d��\n", beverage1.getDescription(), beverage1.cost());
		// beverage1 ���ڿ� ��� �� ���� ���
		System.out.printf("%s : %,d��\n", beverage2.getDescription(), beverage2.cost());
		// beverage2 ���ڿ� ��� �� ���� ���
		System.out.println("\n[Beverage1, Beverage2]");
		System.out.println(">>EQUALS() : " + beverage1.equals(beverage2));
		// equals �Լ� test �ϱ� ���� ����
	}

}
