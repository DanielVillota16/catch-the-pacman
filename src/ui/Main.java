package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	/**
	 * Main method: it allows to the program to get executed.
	 * @param args the necessary argument that the main method needs to get initialized.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Start method: it allows to the user interface to get executed and showed on screen.
	 * @param stage the root Node where the all the other ones will get into.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("CatchThePacman2.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Catch the Pacman");
		stage.setScene(scene);
		stage.show();
		
	}

}
