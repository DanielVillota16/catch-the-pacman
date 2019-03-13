package threads;

import ui.CatchThePacmanController;

public class PacmanThread extends Thread{

	private CatchThePacmanController mpC;
	private boolean gameOver;

	public PacmanThread(CatchThePacmanController mpC) {
		this.mpC = mpC;
		this.gameOver = false;
	}
	
	@Override
	public void run() {
		while(!gameOver && !mpC.getCatchPacmanGame().isGameOver()) {
			this.mpC.move();
			this.mpC.getCatchPacmanGame().addBounces();
			try {
				sleep(70);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
}
