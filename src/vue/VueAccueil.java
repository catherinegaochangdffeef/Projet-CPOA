package vue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class VueAccueil extends Application {

	@Override
	public void start(Stage primaryStage){
		try {
		
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/FenetreAccueil.fxml"));
			Scene scene = new Scene((VBox) root, 600, 400);		
			primaryStage.setScene(scene);
			primaryStage.setTitle("AccueilController");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
