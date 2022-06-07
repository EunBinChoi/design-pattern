// ���ϸ� : Beverage.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 3_����(equals �Լ��� 2���� �������� ������, ������ �ϳ� �ּ� ó��)
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

public abstract class Beverage { // ���� Ŭ���� ����
	private String description = "Unknown Beverage";
	// ������ �̸��� 'Unknown Beverage'���� �ʱ�ȭ

	public String getDescription() { // description�� ���� ��ȯ���ִ� getter �Լ�
		return description; // ���� description ��ȯ
	}

	public void setDescription(String description) { // description�� ���� �������ִ� setter �Լ�
		this.description = description; // ���ڷ� ���� description ���� ���� description�� ����
										
	}

	abstract public int cost(); // ������ ������ִ� �Լ�
	// �߻� �޼ҵ�� ���� (��ӹ޴� Ŭ�������� �޼ҵ��� ������ �ٲ�)

	public Beverage removeCondiment() { // ÷������ �������ִ� �Լ�
		return this;
	} 
	

	/*equals �޼ҵ� ������
	 * 
	 * �� �޼ҵ�� Object�� ���ǵǾ��ִ� equals �޼ҵ带 �������ϴ� �޼ҵ��,
	 * ���� ���ڷ� �޾ƿ��� Object Ŭ������ ��ü o�� null�̰ų� ����ε� class�� �ƴ϶�� false ��ȯ�ϰ�,
	 * o�� this�� ���ٸ� true ��ȯ�Ѵ�.
	 * 
	 * ���⼭ ��ü�� ���� �� �񱳿� ���Ǵ� �����Ͱ� �����Ƿ�, getClass�� �̿��Ͽ� ��ü�� ���ϴµ�,
	 * ���� ���ڷ� ���� Object�� ��ü o�� Ŭ������ ���� Ŭ������ ������ true�� ��ȯ�ϰ�, �ٸ��� false�� ��ȯ�Ѵ�. 
	 * */
	
	@Override
	public boolean equals(Object o) { // equals �Լ� ������
		// ���� ���ڷ� ���� Object Ŭ������ ��ü o�� null�̰ų� o�� Ŭ������ ���� Ŭ������ �ٸ��ٸ� false ��ȯ
		if (o == null || o.getClass() != getClass()) return false;
		// ��ü o�� this�� ���ٸ� true ��ȯ
		if (o == this) return true;
		
		return o.getClass() == getClass(); // ��ü o�� Ŭ������ ���� Ŭ������ ���ٸ� true ��ȯ, �ٸ��ٸ� false ��ȯ
	}
}
