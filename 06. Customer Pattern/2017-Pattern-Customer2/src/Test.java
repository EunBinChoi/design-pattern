import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("ȫ�浿", 100));
		customers.add(new Customer("�̼���", 300));
		customers.add(new Customer("������", 150));
		customers.add(new Customer("�庸��", 250));
		
//		SimpleReportGenerator generator1
//			= new SimpleReportGenerator();
//		System.out.println(generator1.generate(customers));
//		
		// ���ø� ��� ����
		ComplexReportGenerator generator
			= new ComplexReportGenerator();
		System.out.println(generator.generate(customers));
		
	}

}
