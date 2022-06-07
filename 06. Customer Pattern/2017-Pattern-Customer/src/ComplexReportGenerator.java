// stream ����� ���
import java.util.List;
import java.util.stream.Collectors;

public class ComplexReportGenerator {
	public String generate(List<Customer> customers) {
		List<Customer> selected = 
				customers.stream()
				.filter(c->c.getPoint()>=200)
				.collect(Collectors.toList());
				
		String report = String.format("�� �� : %d��%n", selected.size());
		report = selected.stream()
				.map(c->String.format("%d : %s%n", c.getPoint(), c.getName()))
				.reduce(report, String::concat);
		report += String.format("�հ� : %d", 
						selected.stream()
						.map(c->c.getPoint())
						.reduce(0, Integer::sum));
		return report;
	}
}
