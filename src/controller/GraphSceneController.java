package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Graph;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class GraphSceneController implements Initializable {

	@FXML
	private Button close;

	@FXML
	private LineChart<String, Number> lineChart;

	@FXML
	void close(ActionEvent event) {
		Graph.getGraphStage().close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		graphRepresentation();
	}

	private void graphRepresentation() {
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();

		for (int i = 0; i < TableSceneController.fitness.size(); i++) {
			series.getData().add(
					new XYChart.Data<String, Number>("" + (i + 1), TableSceneController.fitness.get(i).getFitness()));
		}

		lineChart.getData().add(series);
	}

}
