// 템플릿 사용 버전
import java.util.List;
import java.util.stream.Collectors;

public class ComplexReportGenerator extends ReportGenerator{
	/*
	public String generate(List<Customer> customers) {
		
		List<Customer> selected = new ArrayList<>();
		for(Customer c:customers) {
			if(c.getPoint()>=0) selected.add(c);
		}
		return selected;
	}
	*/
	
	@Override
	protected List<Customer> select(List<Customer> customers) {
		List<Customer> selected = 
				customers.stream()
				.filter(c->c.getPoint()>=200)
				.collect(Collectors.toList());
		return selected;
	}
	
	/*
	@Override
	protected String generateHeader() {
		return String report = String.format("고객 수 : %d명\n", selected.size());
	}
	*/
	@Override
	public String generateMain() {
		return selected.stream()
				.map(c->String.format("%d : %s%n", c.getPoint(),  c.getName()))
				.reduce("", String::concat);
	}
	
	@Override
	protected String generateFooter() {
		return String.format("합계 : %d", 
				selected.stream()
				.map(c->c.getPoint())
				.reduce(0, Integer::sum));
	}
	
}
