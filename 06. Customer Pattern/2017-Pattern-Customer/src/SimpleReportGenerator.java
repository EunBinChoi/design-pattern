import java.util.List;

public class SimpleReportGenerator {
	public String generate(List<Customer> customers){
		String report = String.format("�� �� : %d��%n",customers.size());
		report = customers.stream()
				.map(c->String.format("%d : %s%n", c.getPoint(), c.getName()))
				.reduce(report,String::concat);
		return report;
	}
}
