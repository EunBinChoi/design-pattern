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
		
		// getWidthPane�� ũ�⸦ �����ͼ� ..
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
		
		// ��� ���� ���ؼ� ������ �ٲ��ش�, ������ ��� �ľ�?
		// getWidthPane�� ũ�⸦ �����ͼ� �����ϸ� ��
		for(Node node: getChildren()){
			Line line = (Line)node;
			if(line.getStartX() == line.getEndX()) { // �������� �׸� ��
				line.setEndY(height);
			} 
			else // ������ �׸� ��
				line.setEndX(width);

		}
    }
}
