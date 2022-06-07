// 이거 시험문제 냈었음
public class Test {

	public static void main(String[] args) {
		FullName name1 = new FullNameAdapter1(new User("김", "상진"));
		FullName name2 = new FullNameAdapter2("김", "상진");
		System.out.println(name1.getFullName());
		System.out.println(name2.getFullName());
	}

}
