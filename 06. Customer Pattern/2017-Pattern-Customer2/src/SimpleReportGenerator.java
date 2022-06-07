
public class SimpleReportGenerator extends ReportGenerator{
	@Override
	public String generateMain() {
		return selected.stream()
				.map(c->String.format("%d : %s%n",  c.getPoint(),c.getName()))
				.reduce("", String::concat);
	}
}
