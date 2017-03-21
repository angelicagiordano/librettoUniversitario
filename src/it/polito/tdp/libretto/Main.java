package it.polito.tdp.libretto;
	
import javafx.application.Application;


import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import it.polito.tdp.model.*;
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Libretto.fxml"));
			BorderPane root = (BorderPane)loader.load(); //creo la vista
			
			LibrettoController controller =loader.getController();
			LibrettoModel model = new LibrettoModel();
			controller.setModel(model);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
