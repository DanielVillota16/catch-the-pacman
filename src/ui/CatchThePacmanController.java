package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
//import javafx.scene.control.Label;
//import javafx.scene.control.MenuButton;
import javafx.scene.layout.Pane;
import model.CatchThePacmanGame;
import threads.PacmanThread;

public class CatchThePacmanController {

    @FXML
    private Pane pane;

    @FXML
    private Label bounces;

    /*@FXML
    private MenuButton fileMenu;

    @FXML
    private MenuButton viewMenuButton;*/
    
    private CatchThePacmanGame catchPacmanGame;
    
    private PacmanThread mpt;

    /*@FXML
    void exit(ActionEvent event) {

    }

    @FXML
    void loadGame(ActionEvent event) {

    }

    @FXML
    void saveGame(ActionEvent event) {
    	
    }*/
    
    @FXML
    void stop(ActionEvent event) {
    	mpt.setGameOver(true);
    	bounces.setText("Bounces: "+this.catchPacmanGame.getNumberOfBounces());
    }
    
    @FXML
    public void initialize() throws InterruptedException {
    	catchPacmanGame = new CatchThePacmanGame((short) 0, pane.getLayoutX(), pane.getLayoutY());
    	for(int i = 0; i < catchPacmanGame.getPacmans().length; i++) {
    		pane.getChildren().add(catchPacmanGame.getPacmans()[i].getPacmanShape());
    		pane.getChildren().add(catchPacmanGame.getPacmans()[i].getPacmanEye());
    	}
    	mpt = new PacmanThread(this);
    	mpt.start();
    }

	public void move() {
    	for(int i = 0; i < catchPacmanGame.getPacmans().length; i++) {
    		catchPacmanGame.getPacmans()[i].move();
    		catchPacmanGame.getPacmans()[i].move();
    		catchPacmanGame.getPacmans()[i].move();
    		catchPacmanGame.getPacmans()[i].move();
    	}
    }

	public CatchThePacmanGame getCatchPacmanGame() {
		return catchPacmanGame;
	}

	public void setCatchPacmanGame(CatchThePacmanGame catchPacmanGame) {
		this.catchPacmanGame = catchPacmanGame;
	}
	
}