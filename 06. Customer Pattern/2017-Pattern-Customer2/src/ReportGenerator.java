import java.util.List;

public abstract class ReportGenerator {
	protected List<Customer> selected = null;
	
	public String generate(List<Customer> customers) {
		selected = select(customers);
		return generateHeader()
				+ generateMain()
				+ generateFooter();
		
		// � �� hook���� ����, ��� concrete�� ���� ���ϴ� �޼ҵ�
		// ���� ��� select�� hook(abstract)�� ������ �� ������, concrete�� ������ �� ����
		
		
	}
	// hook ���
	// Simple�� ������ �ʿ����� ����
	// Complex�� 200 �Ѵ� �ֵ�� ������
	// ex) �ٸ� ����Ʈ�� ���� �达�� �ָ� �̱�� ������
	protected List<Customer> select(List<Customer> customers) {
		return customers;
	}
	protected String generateHeader() {
		 return String.format("�� �� : %d��%n", selected.size());
	 }
	public abstract String generateMain();
	
	// hook ���
	// Simple�� ������ �ʿ����� ����
	protected String generateFooter() {
		return "";
	}
	
}
