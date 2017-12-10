package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Table {
	
	private static Stage tableStage;
	
	public static void tableScene() {

		tableStage = new Stage();
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("table.fxml"));
			Scene scene = new Scene(root);
			tableStage.initModality(Modality.APPLICATION_MODAL);
			tableStage.setTitle("Fitness Table");
			tableStage.setScene(scene);
			tableStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getTableStage(){
		return tableStage;
	}


}
