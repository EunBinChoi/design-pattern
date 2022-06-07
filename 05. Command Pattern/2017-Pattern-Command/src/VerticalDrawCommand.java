public class VerticalDrawCommand implements Command {
	private int x = 10;
	private LinePane pane;
	
	public VerticalDrawCommand(LinePane pane){
		this.pane = pane;
	}
	public void execute(){ // ���� �߰��ϴ� �Լ��� �����ϴ� �Լ�
		pane.addLine(x, 0, LinePane.LineType.VERTICAL);
		if(x >= 10) x += 10;
	}
	public void undo(){ // �߰��ߴ� ���� ����ϴ� �Լ�
		pane.deleteLine();
		if(x >= 10) x -= 10;
	}
}
