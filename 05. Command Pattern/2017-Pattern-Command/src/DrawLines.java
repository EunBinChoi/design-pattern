import java.util.HashMap;
import java.util.Stack;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DrawLines extends Application {
	private Button horizontalBtn = new Button("Horizontal");
	private Button verticalBtn = new Button("Vertical");
	private Button undoBtn = new Button("Undo");
	private Button redoBtn = new Button("Redo");
	private LinePane linePane = new LinePane();

	private Command vCommand = new VerticalDrawCommand(linePane);
	private Command hCommand = new HorizontalDrawCommand(linePane);

	private Stack<Command> undoCommands = new Stack<Command>();
	private Stack<Command> redoCommands = new Stack<Command>();
	private HashMap<Object, Command> commandList = new HashMap<>();
	// ��ư�� ���� �����ϴ� HaspMap ����
	
	boolean check = false;
	// redo ���� ��, undo ������ ���� ������ ���� ������ redo�� ���ϰ� �ϱ� ����
	// undo �� ȣ��� ����, ���� ������ ���� �ִ��� Ȯ���ϱ� ���� boolean ���� 
	
	public void handle(ActionEvent event) {
		Object source = event.getSource();
		
		if (source == horizontalBtn || source == verticalBtn) {
			// ���� �̺�Ʈ�� �߻��� �κ��� horizontalBtn �Ǵ� verticalBtn ���
			check = true;
			// ���� check�� true���� ����
			// check ������ ���� �ֱٿ� ���� ��ư�� horizontalBtn �̳� verticalBtn ���� �� �� ����
			Command command = commandList.get(source);
			undoCommands.push(command);
			command.execute();
		}

		else if (source == undoBtn) {
			// ���� �̺�Ʈ�� �߻��� �κ��� undoBtn ���
			if (!undoCommands.isEmpty()) { // ���� undoCommands ������ ������� ������
				check = false; // check�� false���� ����
				Command command = undoCommands.pop(); 
				// undoCommands ���ÿ� pop�� ���� ���� �ֱٿ� ���ÿ� �� ���� command�� ����
				redoCommands.push(command);
				// redoCommand�� ���� ���� push ��Ŵ
				command.undo();
		
			}
						
		} else if (source == redoBtn) {
			// ���� �̺�Ʈ�� �߻��� �κ��� redoBtn ���

			if (check == true) { 
				// ���� �������̳� ������ add �� ���� ������  redo�� ���ϰ� ���� ����
				redoCommands.clear(); // redoCommands ������ clear ��Ŵ
			}

			if (!redoCommands.isEmpty()) { // ���� redoCommands ������ ������� ������
				Command command = redoCommands.pop();
				// redoCommands ���ÿ� pop�� ���� ���� �ֱٿ� ���ÿ� �� ���� command�� ����
				undoCommands.push(command);
				// undoCommands�� ���� ���� push ��Ŵ
				// redo ���� �ٽ� ������ ������ ���߿� ���(undo)��Ű�� ���� ��찡 ����
				// => ���� command�� undo ���ÿ� push ���Ѿ���
				command.execute();
			}
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		horizontalBtn.setMinWidth(80);
		verticalBtn.setMinWidth(80);
		undoBtn.setMinWidth(80);
		redoBtn.setMinWidth(80);

		horizontalBtn.setOnAction(e -> handle(e));
		verticalBtn.setOnAction(e -> handle(e));
		undoBtn.setOnAction(e -> handle(e));
		redoBtn.setOnAction(e -> handle(e));
		// ��ư�̶� ���� ������ѳ�����

		commandList.put(horizontalBtn, hCommand);
		commandList.put(verticalBtn, vCommand);

		HBox buttonPane = new HBox(10);
		buttonPane.setPadding(new Insets(10));
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(horizontalBtn, verticalBtn, undoBtn, redoBtn);

		BorderPane mainPane = new BorderPane();
		mainPane.setCenter(linePane);
		mainPane.setBottom(buttonPane);

		primaryStage.setScene(new Scene(mainPane, 500, 500));
		primaryStage.setTitle("Horizontal and Vertical Lines");
		primaryStage.show();

		// ������ â�� �÷��� �� �ٽ� paint �� �� �ֵ��� �ϴ� ��
		ChangeListener<Number> listener = (observable, oldValue, newValue) -> {
			linePane.repaint();
		};
		primaryStage.widthProperty().addListener(listener);
		primaryStage.heightProperty().addListener(listener);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
