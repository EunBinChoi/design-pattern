import java.util.Stack;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LinePane extends Pane {
	public enum LineType {HORIZONTAL, VERTICAL};
//	private LinePane pane = new LinePane();
	
	public void addLine(double startX, double startY, LineType type){
		Line line = new Line();
		line.setStartX(startX);
		line.setStartY(startY);
		
		// getWidthPane의 크기를 가져와서 ..
		if(type==LineType.HORIZONTAL){
			line.setEndX(getWidth());
			line.setEndY(startY);
			line.setStroke(Color.BLUE);
		}
		
		else{
			line.setEndX(startX);
			line.setEndY(getHeight());
			line.setStroke(Color.RED);
		}	
        getChildren().add(line);
	}
	public void deleteLine(){
		int index = getChildren().size()-1;
		if(index >= 0) getChildren().remove(index);
	}
	
	public void repaint(){
		double height = getHeight();
		double width = getWidth();
		
		// 모든 선에 대해서 끝점을 바꿔준다, 끝점은 어떻게 파악?
		// getWidthPane의 크기를 가져와서 구현하면 됨
		for(Node node: getChildren()){
			Line line = (Line)node;
			if(line.getStartX() == line.getEndX()) { // 수직선을 그릴 때
				line.setEndY(height);
			} 
			else // 수평선을 그릴 때
				line.setEndX(width);

		}
    }
}
