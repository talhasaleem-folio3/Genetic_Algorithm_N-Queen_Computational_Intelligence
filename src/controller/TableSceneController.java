package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Graph;
import application.Table;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableSceneController implements Initializable {

	private int gen;
	private int mut;
	private int child;
	private int parent;
	protected static ArrayList<GeneTable> fitness;

	@FXML
	private TextField generation;

	@FXML
	private TextField mutation;
	
	@FXML
    private Button closeBtn;

	@FXML
	private TableColumn<GeneTable, Integer> generationColumn;

	@FXML
	private TableView<GeneTable> evoTable;

	@FXML
	private TextField children;

	@FXML
	private TableColumn<GeneTable, Double> cColumn;

	@FXML
	private TableColumn<GeneTable, Double> fitnessColumn;

	@FXML
	private TableColumn<GeneTable, Double> aColumn;

	@FXML
	private TableColumn<GeneTable, Double> dColumn;

	@FXML
	private Button runButton;

	@FXML
	private TableColumn<GeneTable, Double> bColumn;

	@FXML
	private Button graph;

	@FXML
	private TextField population;

	@FXML
	void runButton(ActionEvent event) {
		this.gen = Integer.parseInt(generation.getText());
		this.parent = Integer.parseInt(population.getText());
		this.child = Integer.parseInt(children.getText());
		this.mut = Integer.parseInt(mutation.getText());

		Genes gene = new Genes(gen, parent, child, mut);
		fitness = gene.fitness;

		for (int i = 0; i < fitness.size(); i++) {
			evoTable.getItems().add(fitness.get(i));
		}

	}

	@FXML
	void graph(ActionEvent event) {

		Graph.graphScene();
	}
	
	@FXML
    void closeBtn(ActionEvent event) {
		Table.getTableStage().close();
    }

	@FXML
	private void initializeColumns() {
		generationColumn.setCellValueFactory(new PropertyValueFactory<>("generations"));
		aColumn.setCellValueFactory(new PropertyValueFactory<>("geneA"));
		bColumn.setCellValueFactory(new PropertyValueFactory<>("geneB"));
		cColumn.setCellValueFactory(new PropertyValueFactory<>("geneC"));
		dColumn.setCellValueFactory(new PropertyValueFactory<>("geneD"));
		fitnessColumn.setCellValueFactory(new PropertyValueFactory<>("fitness"));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		initializeColumns();

	}

}
