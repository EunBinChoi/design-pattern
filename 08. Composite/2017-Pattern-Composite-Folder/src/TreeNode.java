import java.util.Iterator;

public abstract class TreeNode implements Iterable<TreeNode>{
	private String name; // 모든 노드들은 이름을 가진다고 가정
	public TreeNode(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	// 예외처리
	public void add(TreeNode node) {
		throw new UnsupportedOperationException();
	}
	public void remove(TreeNode node) {
		throw new UnsupportedOperationException();
	}
	public TreeNode getChild(int index) {
		throw new UnsupportedOperationException();
	}
	public int numberOfChilds(){
		return 0;
	}
	@Override
	public boolean equals(Object o){
		if(o==null||o.getClass()!=getClass()) return false;
		if(this==o) return true;
		TreeNode node = (TreeNode)o;
		return node.name.equals(name);
	}
	public TreeNode getRearranged(){ // 예외처리
		throw new UnsupportedOperationException();
	}
	public Iterator<TreeNode> iterator() {
		return new NullIterator(); // 비워져있는 반복자로 반환
	}
}