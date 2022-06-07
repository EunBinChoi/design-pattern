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
	// 버튼과 선을 연결하는 HaspMap 구현
	
	boolean check = false;
	// redo 구현 중, undo 다음에 선이 생성된 것이 있으면 redo를 못하게 하기 위함
	// undo 이 호출된 다음, 선이 생성된 것이 있는지 확인하기 위한 boolean 변수 
	
	public void handle(ActionEvent event) {
		Object source = event.getSource();
		
		if (source == horizontalBtn || source == verticalBtn) {
			// 만약 이벤트가 발생한 부분이 horizontalBtn 또는 verticalBtn 라면
			check = true;
			// 현재 check를 true으로 설정
			// check 변수를 통해 최근에 눌린 버튼이 horizontalBtn 이나 verticalBtn 임을 알 수 있음
			Command command = commandList.get(source);
			undoCommands.push(command);
			command.execute();
		}

		else if (source == undoBtn) {
			// 만약 이벤트가 발생한 부분이 undoBtn 라면
			if (!undoCommands.isEmpty()) { // 만약 undoCommands 스택이 비어있지 않으면
				check = false; // check를 false으로 설정
				Command command = undoCommands.pop(); 
				// undoCommands 스택에 pop을 시켜 가장 최근에 스택에 들어간 값을 command에 저장
				redoCommands.push(command);
				// redoCommand에 현재 값을 push 시킴
				command.undo();
		
			}
						
		} else if (source == redoBtn) {
			// 만약 이벤트가 발생한 부분이 redoBtn 라면

			if (check == true) { 
				// 만약 수직선이나 수평선이 add 된 것이 있으면  redo를 못하게 막기 위함
				redoCommands.clear(); // redoCommands 스택을 clear 시킴
			}

			if (!redoCommands.isEmpty()) { // 만약 redoCommands 스택이 비어있지 않으면
				Command command = redoCommands.pop();
				// redoCommands 스택에 pop을 시켜 가장 최근에 스택에 들어간 값을 command에 저장
				undoCommands.push(command);
				// undoCommands에 현재 값을 push 시킴
				// redo 시켜 다시 생성한 선들을 나중에 취소(undo)시키고 싶을 경우가 있음
				// => 현재 command도 undo 스택에 push 시켜야함
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
		// 버튼이랑 줄을 연결시켜놓은것

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

		// 윈도우 창을 늘렸을 때 다시 paint 될 수 있도록 하는 것
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
