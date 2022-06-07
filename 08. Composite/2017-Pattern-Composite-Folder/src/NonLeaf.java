import java.util.ArrayList;
import java.util.Iterator;

public class NonLeaf extends TreeNode { // 중간자 노드
	private ArrayList<TreeNode> childs = new ArrayList<>(); 
	public NonLeaf(String name){
		super(name); 
	}
	@Override
	public void add(TreeNode node) {
		childs.add(node);
	}
	@Override
	public void remove(TreeNode node) {
		childs.remove(node);
	}
	@Override
	public TreeNode getChild(int index) {
		if(index >=0 && index < childs.size()) return childs.get(index);
		else throw new IllegalArgumentException("해당 색인에 해당되는 노드가 없음");
	}
	@Override
	public int numberOfChilds(){
		return childs.size();
	}
	@Override
	public NonLeaf getRearranged(){ // 폴더 간에는 또는 파일 간에는 이름 순으로 보여주도록 하는 함수
		NonLeaf newNode = new NonLeaf(getName());
		newNode.childs.addAll(childs); // 리프노드 newNode에 자식으로 childs arrayList에 저장되어있는 노드들을 모두 넣고 ..
		newNode.childs.sort((a,b)->{ // sort 
			if(a instanceof NonLeaf && b instanceof Leaf) return -1; // 만약 a가 중간자고 b는 리프노드면 에러발생
			if(a instanceof Leaf && b instanceof NonLeaf) return 1; // 만약 a가 리프노드이고 b는 중간자이면 에러발생
			return a.getName().compareTo(b.getName()); 
			/* a의 이름과 b의 이름을 비교하여 
			 * -1이 반환될 경우는 a의 이름의 사전 순서가 더 뒤에 있다는 것이고,
			 * 0이 반환될 경우에는 두 문자열이 같다는 것,
			 * 1이 반환될 경우에는 b의 이름의 사전 순서가 더 뒤에 있다는 의미*/
		});
		return newNode; // newNode를 반환
	}
	@Override
	public boolean equals(Object o){
		if(!super.equals(o)) return false;
		NonLeaf node = (NonLeaf)o;
		return childs.equals(node.childs);
	}
	@Override
	public Iterator<TreeNode> iterator() {
		return new TreeIteratorBFS(childs.iterator());
		//return new TreeIteratorBFS(childs.iterator());
	}
}
