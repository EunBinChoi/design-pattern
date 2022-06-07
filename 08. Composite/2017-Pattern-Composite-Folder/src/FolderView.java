import java.awt.Label;
import java.io.File;
import java.io.FilenameFilter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

@FunctionalInterface
interface FileFilter { // FunctionalInterfaced으로 함수형 프로그래밍 요소
	boolean filter(String fileName);
}

public class FolderView extends Application implements FileFilter {
	private Button selectBtn = new Button("폴더 선택");
	private TextArea infoboard = new TextArea();
	private BorderPane mainPane = null;
	private Stage mainStage = null;
	private TreeView<String> tree;

	private String extension = ".html"; // 필터링하고 싶은 확장자를 저장하는 변수

	private NonLeaf constructFolderTree(File selectedDirectory) { // 폴더 트리 구조
																  // 중간자 노드로 구성된 폴더들을 트리 구조로 생성

		NonLeaf folder = new NonLeaf(selectedDirectory.getName());
		File[] list = selectedDirectory.listFiles();
		for (File file : list) {
			if (file.isDirectory()) { // 해당 패스에서 디렉토리(폴더)가 존재하는지 확인
				NonLeaf node = constructFolderTree(file);
				// 존재한다면 constructFolderTree 함수 부름
				folder.add(node);
			}
			else { // 존재하지 않는다면 단말 노드라는 의미이므로
				folder.add(new Leaf(file.getName())); // 단말 노드로 생성
			}
		}
		return folder;
	}

	/* 파일 필더링이 구현된 메소드 */
	private TreeItem<String> constructFilteredTreeItem(NonLeaf currentFolder, FileFilter filter) {

		int cnt = 0; // 해당 확장명을 가진 파일의 개수를 저장하는 변수
		currentFolder = currentFolder.getRearranged();
		TreeItem<String> root = new TreeItem<>(currentFolder.getName());

		for (int i = 0; i < currentFolder.numberOfChilds(); i++) {
			TreeNode node = currentFolder.getChild(i);
			TreeItem<String> item = null;

		//	if (node instanceof NonLeaf) { // 중간자일때
		//		item = constructFilteredTreeItem((NonLeaf)node, filter);
		//		// constructFilteredTreeItem 호출(재귀 호출)

		//		if (item != null) { // 만약 item 값이 null이 아니라면
		//			root.getChildren().add(item); // item을 root의 자식으로 add
		//			cnt++; // cnt 증가
		//		}
		//	}

		//	else { // 리프 노드 일때
		//		if (filter.filter(node.getName()) == true) { // filter한 값이 true라면
		//			item = new TreeItem<>(node.getName()); // item 생성
		//			cnt++; // cnt 증가
		//			root.getChildren().add(item); // item을 root의 자식으로 add
		//		}

		//	}
		//}

		/*교수님 소스*/
			if (node instanceof NonLeaf) { // 중간자일때
				item = constructFilteredTreeItem((NonLeaf)node, filter);
				// constructFilteredTreeItem 호출(재귀 호출)
			}

			else { // 리프 노드 일때
				if (filter.filter(node.getName())) { // filter한 값이 true라면
					item = new TreeItem<>(node.getName()); // item 생성
				}

			}
			if(item != null) root.getChildren().add(item);
		}

		if (cnt == 0) // 만약 하위 디렉토리에 해당 확장명을 가진 파일이 없는 경우
			root = null; // root에 null 대입

		return root; // root 반환
	}

	/* 파일 필더링을 구현되지 않은 메소드 */
	private TreeItem<String> constructTreeItem(NonLeaf currentFolder, FileFilter filter) {

		currentFolder = currentFolder.getRearranged(); // 폴더들을 이름순으로 정렬
		TreeItem<String> root = new TreeItem<>(currentFolder.getName());

		for (int i = 0; i < currentFolder.numberOfChilds(); i++) {
			TreeNode node = currentFolder.getChild(i);
			TreeItem<String> item = null;

			if (node instanceof NonLeaf) {
				item = constructTreeItem((NonLeaf)node, filter);
			}
			else
				item = new TreeItem<>(node.getName());

			root.getChildren().add(item);
		}
		return root;
	}

	private void directoryList() {
		DirectoryChooser chooser = new DirectoryChooser();
		File selectedDirectory = chooser.showDialog(mainStage);
		if (selectedDirectory == null)
			return;

		//NonLeaf currentFolder = constructFolderTree(selectedDirectory);

		///*try~~catch문 사용*/
		//try {
		//	// 람다를 이용한 필터사용
		//	TreeItem<String> root = constructFilteredTreeItem(currentFolder, fileName -> {
		//		return filter(fileName);
		//	});

		//	// 콘솔에 출력된 내용을 지우는 방법
		//	// 이전에 검사했던 폴더에 에러 메세지가 출력됬을 수 있으므로 콘솔 내용 지움
		//	for (int i = 0; i < 80; i++) System.out.println("");

		//	root.setExpanded(false);
		//	tree = new TreeView<>(root);
		//	mainPane.setCenter(tree);
		//}
		//catch (NullPointerException e) { // 확장명 html을 가진 폴더가 어디에도 존재하지 않을 때

		//								 // tree의 값을 null로 설정
		//								 // 이렇게 해주는 이유는 이전에 출력되었던 tree의 값들을 clear 시켜주기 위함
		//	tree = null;
		//	mainPane.setCenter(tree);
		// 콘솔에 에러와 해결방법 출력
	//	System.out.printf("해당 확장명(%s)에 해당하는 파일이 선택하신 폴더 안에 없습니다!\n\n", extension);
	//	System.out.println("[해결 방법은 다음과 같습니다]");
	//	System.out.println(">> 다른 폴더를 선택하시거나 다른 확장명으로 변경하십시오!");
	//}

		/*교수님 코드*/
		//String info = selectedDirectory.getName() + "폴더 내용 ..\n";
		//info.setText(info);
		NonLeaf currentFolder = constructFolderTree(selectedDirectory);
		//TreeItem<String> root = constructTreeItem(currentFolder);
		TreeItem<String> root = constructFilteredTreeItem(currentFolder, 
			fileName->{
			String[] splittedNames = fileName.split("\\.");
			if (splittedNames.length <= 1) return false;
			//splittedNames.length은 2가 나올 것임
			String extension = splittedNames[splittedNames.length-1]//맞니?
				return extension.equals("html");
		});

		root.setExpanded(true); // setExpanded(false)도 되지않나...?
		tree = new TreeView<>(root);
		mainPane.setCenter(tree);
	}

	@Override
		public boolean filter(String fileName) { // 필터를 정의해주는 함수
												 // 파일이 extension에 저장된 확장명으로 끝나는지 확인
		return fileName.toLowerCase().endsWith(extension);
	}

	@Override
		public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;
		mainPane = new BorderPane();

		HBox buttonPane = new HBox();
		buttonPane.setPadding(new Insets(10));
		buttonPane.setSpacing(10);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().add(selectBtn);
		selectBtn.setOnAction(e->directoryList());

		StackPane centerPane = new StackPane();
		centerPane.setPadding(new Insets(10));
		centerPane.getChildren().add(infoboard);
		infoboard.setEditable(false);

		mainPane.setCenter(centerPane);
		mainPane.setBottom(buttonPane);
		primaryStage.setTitle("폴더 내용 보여주기");
		primaryStage.setScene(new Scene(mainPane, 400, 200));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
