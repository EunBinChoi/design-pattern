// stream 사용하지 않는 방법(for문 사용)
import java.util.List;

public class ComplexReportGenerator2 {
	public String generate(List<Customer> customers) {
		String report = "";
		int count = 0;
		int sum = 0;
		for(Customer c : customers) {
			if(c.getPoint() >= 200){
				sum += c.getPoint();
				count++;
				report += String.format("%d : %s%n",  c.getPoint(),c.getName());
			}
		}
		report = String.format("고객 수:  %d명%n", count)+report;
		report += String.format("합계 : %d", sum);
		return report;
	}
}
