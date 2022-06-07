import static org.junit.Assert.*;
import java.util.ListIterator;
import org.junit.Test;

public class LinkedListTest {

//	@Test
//	public void testAdd() {
//		LinkedList<Integer> list = new LinkedList<>();
//		list.add(5);
//		list.add(3);
//		list.add(2);
//		ListIterator<Integer> iter = list.listIterator();
//		iter.add(1);
//		iter.next();
//		iter.add(4);
//		assertEquals("[1, 2, 4, 3, 5]",list.toString());
//	}
	@Test
	public void testRemove() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(5);
		list.add(3);
		list.add(2); 
		// add만 호출했기 떄문에 curr의 초기값은 head
		ListIterator<Integer> iter = list.listIterator();
		System.out.println();
		iter.next();
		iter.remove();
		System.out.println("1:"+list);
		iter.next();
		iter.remove();
		System.out.println("2:"+list);
		assertEquals("[5]",list.toString());
	}
//	@Test
//	public void testSet() {
//		LinkedList<Integer> list = new LinkedList<>();
//		list.add(5);
//		list.add(3);
//		list.add(2);
//		ListIterator<Integer> iter = list.listIterator();
//		iter.next();
//		iter.set(4);
//		assertEquals("[4, 3, 5]",list.toString());
//	}
}
