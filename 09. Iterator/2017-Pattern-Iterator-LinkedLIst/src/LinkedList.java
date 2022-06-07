import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class LinkedList<T> implements Iterable<T> {
	private static class Node<T> {
		public T item;
		public Node<T> next = null;
	}

	private class LinkedListIterator implements ListIterator<T> {
		private Node<T> curr = head;
		private Node<T> prev = null;
		public boolean isIllegalState = true;

		@Override
			public boolean hasNext() {
			return curr != null;
		}

		@Override
			public T next() {
			T item = curr.item;
			prev = curr;
			curr = curr.next;
			isIllegalState = false;
			return item; // 반환하는 값은 현재값을 반환한다는 의미
		}

		@Override
			public boolean hasPrevious() {
			throw new UnsupportedOperationException();
		}

		@Override
			public T previous() {
			throw new UnsupportedOperationException();
		}

		@Override
			public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
			public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
			public void remove() {
			if (isIllegalState)
				throw new IllegalStateException();

			//if (prev == head) {
			//	// 만약 head와 prev 값이 같으면 (이 프로그램에서는 항상 같지만 논리적인 구조를 위해 작성)
			//	head = curr; // head 값을 현재 값으로 설정
			//	prev = null; // prev 값을 null로 설정
			//}
			
			/*교수님 코드*/
			if (prevprev == null) {
				// 만약 head와 prev 값이 같으면 (이 프로그램에서는 항상 같지만 논리적인 구조를 위해 작성)
				head = curr; // head 값을 현재 값으로 설정
				prev = null; // prev 값을 null로 설정
			}
			else {
				prevprev.next = curr;
				prev = prevprev;
			}
			
			size--; // size 감소
			isIllegalState = true; // 한번 실행가능하게 함
		}

		@Override
			public void set(T item) {
			if (isIllegalState)
				throw new IllegalStateException();
			prev.item = item;
		}

		@Override
			public void add(T item) {
			// System.out.println("curr :"+curr.item);
			Node<T> newNode = new Node<>();
			newNode.item = item;

			if (prev == null) {
				head = newNode;
			}
			else
				prev.next = newNode;

			newNode.next = curr;
			prev = newNode;
			++size;
			isIllegalState = true;

		}
	}

	public Node<T> head = null;
	public int size = 0;

	public boolean isEmpty() {
		return head == null;
	}

	public void add(T item) {
		Node<T> newNode = new Node<>();
		newNode.item = item;
		newNode.next = head;
		head = newNode;
		++size;
	}

	public T remove() {
		if (isEmpty()) throw new IllegalStateException();
		T item = head.item;
		head = head.next;
		size--;
		return item;
	}

	public String toString() {
		ArrayList<T> tmp = new ArrayList<>();
		for (T t : this)
			tmp.add(t);
		return tmp.toString();
	}

	@Override
		public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	public ListIterator<T> listIterator() {
		return new LinkedListIterator();
	}
}
