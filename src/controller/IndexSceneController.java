package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Table;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class IndexSceneController implements Initializable {

    @FXML
    private Button nextButton;

    @FXML
    private Button exitButton;

    @FXML
    void nextButton(ActionEvent event) {
    	Table.tableScene();
    	Main.getStartupStage().close();
    }

    @FXML
    void exitButton(ActionEvent event) {
    	Main.getStartupStage().close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}