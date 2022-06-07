import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VehicleSelectView extends Application {
	private RadioButton carButton = new RadioButton("Car");
	private RadioButton offRoadButton = new RadioButton("OffRoad");
	private Button submitButton = new Button("Submit");
	private TextField recommendedVehicle = new TextField();
	private ComboBox<String> drivingStyleBox = new ComboBox<>();
	private ComboBox<String> vehicleColorBox = new ComboBox<>();
	//private VehicleFactory vFactory;
	
	// summit 눌렀을 때 시행되는 함수
	public void getVehicleRecommendation(){
		
		VehicleFactory vFactory = null;
		if(carButton.isSelected()) vFactory = new CarFactory();
		else vFactory = new OffRoadFactory();
		String text = null;
		
		try{
			String style = drivingStyleBox.getValue();
			String color = vehicleColorBox.getValue();
			Vehicle v = vFactory.build(
					VehicleFactory.DrivingStyle.valueOf(style),
					Vehicle.Color.valueOf(color));
			text = v.toString();
		}
		catch(IllegalArgumentException e){
			text = "추천할 차량이 없음";	
		}	
		recommendedVehicle.setText(text);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane mainPane = new BorderPane();
		HBox vehicleChoiceBox = new HBox(10);
		ToggleGroup vehicleChoiceGroup = new ToggleGroup();
		/* ToggleGroup : 이 클래스는 선택된 변수가 관리되어야하는 
		 * 모든 토글의 주소를 포함하는 클래스로,
		 * 같은 토글그룹에서 오직 하나의 글만 선택되도록 함*/
		carButton.setToggleGroup(vehicleChoiceGroup);
		offRoadButton.setToggleGroup(vehicleChoiceGroup);
		carButton.setSelected(true);
		// 처음 초기화값을 carBUtton에 클릭되어있도록 되어있음
		vehicleChoiceBox.getChildren().addAll(carButton, offRoadButton);
		drivingStyleBox.getItems().addAll("ECONOMICAL", "MIDRANGE", "LUXURY", "POWERFUL");
		drivingStyleBox.setValue(drivingStyleBox.getItems().get(0));
		// 초기값을 처음 문자열이 저장되어있는 0 인덱스를 접근하여 설정
		drivingStyleBox.setMaxWidth(Double.MAX_VALUE);
		// ComboBox의 가로 길이를 현재 창의 MAX_VALUE로 설정
		vehicleColorBox.getItems().addAll("BLUE", "BLACK", "PERLWHITE", "WHITE", "SILVER", "GRAY", "RED");
		vehicleColorBox.setValue(vehicleColorBox.getItems().get(0));
		// 초기값을 처음 문자열이 저장되어있는 0 인덱스를 접근하여 설정
		vehicleColorBox.setMaxWidth(Double.MAX_VALUE);
		// ComboBox의 가로 길이를 현재 창의 MAX_VALUE로 설정	
		
		GridPane mainGrid = new GridPane();
		mainGrid.setPadding(new Insets(10));
		// 안쪽으로 여백을 10으로 설정
		mainGrid.setHgap(10);
		// 요소들 사이에 수평적인 갭을 10으로 설정
		mainGrid.setVgap(10);
		// 요소들 사이에 수직적인 갭을 10으로 설정
		mainGrid.addRow(0, new Label("차량 종류:"), vehicleChoiceBox);
		mainGrid.addRow(1, new Label("차량 스타일:"), drivingStyleBox);
		mainGrid.addRow(2, new Label("차량 색:"), vehicleColorBox);
		mainGrid.addRow(3, submitButton);
		
		GridPane.setColumnSpan(submitButton,2);
		// submitButton의 수평적인 Span을 2로 설정
		GridPane.setHalignment(submitButton, HPos.CENTER);
		// 만약 gridpane이 포함될 때, 수평적인 정렬을 중앙으로 한다
		
		
		VBox outputBox = new VBox(10);
		outputBox.setPadding(new Insets(10));
		outputBox.getChildren().addAll(new Separator(), new Label("추천 차량"), recommendedVehicle);
		
		mainPane.setCenter(mainGrid);
		mainPane.setBottom(outputBox);
		
		
		submitButton.setOnAction(e->getVehicleRecommendation());
		// 행동의 속성의 값을 설정
		primaryStage.setTitle("Vehicle Select App");
		// 타이틀을 Vehicle Select App으로 설정
		primaryStage.setScene(new Scene(mainPane));
		// 이 단계에 사용되는 장면을 분명화한다
		primaryStage.sizeToScene();
		// 이 윈도우의 길이와 너비 설정, 윈도우 장면의 내용의 사이즈를 맞추기 위해
		primaryStage.show();
		// 윈도우에 창을 띄운다
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
