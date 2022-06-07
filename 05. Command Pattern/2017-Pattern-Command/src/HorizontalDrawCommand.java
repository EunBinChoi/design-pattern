public class HorizontalDrawCommand implements Command {
	private int y = 10;
	private LinePane pane;
	
	public HorizontalDrawCommand(LinePane pane){	
		this.pane = pane;
	}
	public void execute(){ // 선을 추가하는 함수를 실행하는 함수
		pane.addLine(0, y, LinePane.LineType.HORIZONTAL);
		if(y >= 10) y += 10;	
	}
	public void undo(){ // 추가했던 선을 취소하는 함수
		pane.deleteLine();
		if(y >= 10) y -= 10;
	}
}
