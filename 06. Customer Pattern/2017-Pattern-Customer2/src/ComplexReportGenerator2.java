// stream ������� �ʴ� ���(for�� ���)
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
		report = String.format("�� ��:  %d��%n", count)+report;
		report += String.format("�հ� : %d", sum);
		return report;
	}
}
