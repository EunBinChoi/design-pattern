public class HorizontalDrawCommand implements Command {
	private int y = 10;
	private LinePane pane;
	
	public HorizontalDrawCommand(LinePane pane){	
		this.pane = pane;
	}
	public void execute(){ // ���� �߰��ϴ� �Լ��� �����ϴ� �Լ�
		pane.addLine(0, y, LinePane.LineType.HORIZONTAL);
		if(y >= 10) y += 10;	
	}
	public void undo(){ // �߰��ߴ� ���� ����ϴ� �Լ�
		pane.deleteLine();
		if(y >= 10) y -= 10;
	}
}
