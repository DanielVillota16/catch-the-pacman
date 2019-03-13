package model;

public class CatchThePacmanGame {
	
	public static final short EASY = 0;
	public static final short MEDIUM = 1;
	public static final short HARD = 2;
	
	public static final short TOTAL_SCORES = 10;
	
	private short level;

	private int numberOfBounces;
	private Pacman[] pacmans;
	private Score[] hallOfFame;
	
	public CatchThePacmanGame(short level, double maxValueX, double maxValueY) {
		this.level = level;
		if(level == EASY) {
			pacmans = new Pacman[4];
		} else if(level == MEDIUM) {
			pacmans = new Pacman[6];
		} else if(level == HARD) {
			pacmans = new Pacman[8];
		}
		for(int i = 0; i < pacmans.length; i++) {
			char[] dirs = {Pacman.DIR_HORIZONTAL, Pacman.DIR_VERTICAL};
			char randomDir = dirs[(int) (Math.random()*2)];
			//double randomPosX = Math.random()*maxValueX;
			//double randomPosY = Math.random()*maxValueY;
			pacmans[i] = new Pacman(maxValueX/2, maxValueY/2, randomDir, 600.0, 400.0);
		}
		//(double centerX,double centerY,double radiusX,double radiusY,double startAngle,double length)
		this.numberOfBounces = 0;
		this.hallOfFame = new Score[TOTAL_SCORES];
		
		System.out.println(maxValueX+ " " +maxValueY);
	}
	
	public void addScore(String name, int score) {
		int pos = 0;
		for(int i = 1; i < TOTAL_SCORES-1; i++) {
			if(score < hallOfFame[i].getScore()) {
				pos = i;
			}
		}
		for(int i = pos; i < TOTAL_SCORES-2; i++) {
			hallOfFame[i+1] = hallOfFame[i];
		}
		hallOfFame[pos] = new Score(name, score);
	}

	public short getLevel() {
		return level;
	}

	public void setLevel(short level) {
		this.level = level;
	}

	public Pacman[] getPacmans() {
		return pacmans;
	}

	public void setPacmans(Pacman[] pacmans) {
		this.pacmans = pacmans;
	}

	public int getNumberOfBounces() {
		return numberOfBounces;
	}
	
	public void addBounces() {
		int lastNumberOfBounces = numberOfBounces;
		int sum = numberOfBounces;
		for (int i = 0; i < pacmans.length; i++) {
			sum+=pacmans[i].getNumberOfBounces();
		}
		if(sum-lastNumberOfBounces > 0) {
			this.numberOfBounces = sum-lastNumberOfBounces;
		}
	}

	public void setNumberOfBounces(int numberOfBounces) {
		this.numberOfBounces = numberOfBounces;
	}

	public Score[] getHallOfFame() {
		return hallOfFame;
	}

	public void setHallOfFame(Score[] hallOfFame) {
		this.hallOfFame = hallOfFame;
	}

	public boolean isGameOver() {
		boolean gameOver = false;
		int counter = 0;
		for (int i = 0; i < pacmans.length; i++) {
			if(!pacmans[i].isMoving()) {
				counter++;
			}
		}
		if(counter==pacmans.length) {
			gameOver = true;
		}
		return gameOver;
	}
	
}
