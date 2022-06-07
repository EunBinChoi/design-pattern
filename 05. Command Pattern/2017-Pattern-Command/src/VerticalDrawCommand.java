public class VerticalDrawCommand implements Command {
	private int x = 10;
	private LinePane pane;
	
	public VerticalDrawCommand(LinePane pane){
		this.pane = pane;
	}
	public void execute(){ // 선을 추가하는 함수를 실행하는 함수
		pane.addLine(x, 0, LinePane.LineType.VERTICAL);
		if(x >= 10) x += 10;
	}
	public void undo(){ // 추가했던 선을 취소하는 함수
		pane.deleteLine();
		if(x >= 10) x -= 10;
	}
}
