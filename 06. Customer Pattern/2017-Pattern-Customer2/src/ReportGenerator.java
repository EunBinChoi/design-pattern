import java.util.List;

public abstract class ReportGenerator {
	protected List<Customer> selected = null;
	
	public String generate(List<Customer> customers) {
		selected = select(customers);
		return generateHeader()
				+ generateMain()
				+ generateFooter();
		
		// 어떤 걸 hook으로 가고, 어떤걸 concrete로 할지 정하는 메소드
		// 예를 들어 select는 hook(abstract)은 구현할 수 있지만, concrete은 구현할 수 없음
		
		
	}
	// hook 방법
	// Simple은 재정의 필요하지 않음
	// Complex는 200 넘는 애들로 재정의
	// ex) 다른 리포트에 성이 김씨인 애만 뽑기로 재정의
	protected List<Customer> select(List<Customer> customers) {
		return customers;
	}
	protected String generateHeader() {
		 return String.format("고객 수 : %d명%n", selected.size());
	 }
	public abstract String generateMain();
	
	// hook 방법
	// Simple은 재정의 필요하지 않음
	protected String generateFooter() {
		return "";
	}
	
}
