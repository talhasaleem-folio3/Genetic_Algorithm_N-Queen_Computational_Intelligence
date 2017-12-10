package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Graph {
	
	private static Stage graphStage;
	
	public static void graphScene() {

		graphStage = new Stage();
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("graph.fxml"));
			Scene scene = new Scene(root);
			graphStage.initModality(Modality.APPLICATION_MODAL);
			graphStage.setTitle("Graph");
			graphStage.setScene(scene);
			graphStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getGraphStage(){
		return graphStage;
	}


}
