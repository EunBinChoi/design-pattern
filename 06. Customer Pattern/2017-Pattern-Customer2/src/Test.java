import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("홍길동", 100));
		customers.add(new Customer("이순신", 300));
		customers.add(new Customer("김유신", 150));
		customers.add(new Customer("장보고", 250));
		
//		SimpleReportGenerator generator1
//			= new SimpleReportGenerator();
//		System.out.println(generator1.generate(customers));
//		
		// 템플릿 사용 버전
		ComplexReportGenerator generator
			= new ComplexReportGenerator();
		System.out.println(generator.generate(customers));
		
	}

}
