package model;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

public class Pacman {
	
	public final static int ADVANCE = 3;

	public final static char DIR_VERTICAL = 'V';
	public final static char DIR_HORIZONTAL = 'H';
	
	private double posX;
	private double posY;
	private char direction;
	private int subDirection;
	private boolean moving;
	private Arc pacmanShape;
	private Circle pacmanEye;
	private double limitX;
	private double limitY;
	private int numberOfBounces;

	public Pacman(double posX, double posY, char direction, double limitX, double limitY) {
		this.posX = 300;
		this.posY = 250;
		this.direction = direction;
		this.pacmanShape=new Arc(0.0,0.0,39.0,34.0,45.0, 270.0);
		this.pacmanEye=new Circle(6.0);
		this.moving = true;
		this.subDirection = 1;
		this.numberOfBounces=0;
		this.limitX = limitX;
		this.limitY = limitY;
		
		this.pacmanShape.setLayoutX(this.posX);
		this.pacmanShape.setLayoutY(this.posY);
		this.pacmanEye.setLayoutX(this.posX-5);//-28
		this.pacmanEye.setLayoutY(this.posY-18);//-18
		this.pacmanShape.setStroke(Color.BLACK);
		this.pacmanShape.setStrokeType(StrokeType.INSIDE);
		this.pacmanShape.setType(ArcType.ROUND);
		
		this.pacmanShape.setFill(Color.YELLOW);
		
		pacmanShape.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				setMoving(false);
				pacmanShape.setDisable(true);
				pacmanEye.setDisable(true);
				pacmanShape.setVisible(false);
				pacmanEye.setVisible(false);
			}
			
		});
		
	}

	public void move() {
		changeSubDirection();
		if(moving) {
			if(direction == DIR_HORIZONTAL) {
				posX = posX+ADVANCE*subDirection;
				pacmanShape.setLayoutX(pacmanShape.getLayoutX()+ADVANCE*subDirection);
				pacmanEye.setLayoutX(pacmanEye.getLayoutX()+ADVANCE*subDirection);
			}else if(direction == DIR_VERTICAL){
				posY = posY+ADVANCE*subDirection;
				pacmanShape.setLayoutY(pacmanShape.getLayoutY()+ADVANCE*subDirection);
				pacmanEye.setLayoutY(pacmanEye.getLayoutY()+ADVANCE*subDirection);
			}
		}
	}

	public void changeSubDirection() {
		if(direction == DIR_HORIZONTAL) {
			double pacmanPosX = pacmanShape.getLayoutX();
			if((pacmanPosX >= limitX-2 && pacmanPosX <= limitX+2)
					|| (pacmanPosX >= -2 && pacmanPosX <= 2)) {
				subDirection*=(-1);
				setNumberOfBounces(numberOfBounces + 1);
			}
		}else {
			double pacmanPosY = pacmanShape.getLayoutY();
			if((pacmanPosY >= limitY-3 && pacmanPosY <= limitY+3)
					|| (pacmanPosY >= -2 && pacmanPosY <= 2)) {
				subDirection*=(-1);
				setNumberOfBounces(numberOfBounces + 1);
			}
		}
	}
	
	public int getSubDirection() {
		return subDirection;
	}

	public void setSubDirection(int subDirection) {
		this.subDirection = subDirection;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public Circle getPacmanEye() {
		return pacmanEye;
	}

	public void setPacmanEye(Circle pacmanEye) {
		this.pacmanEye = pacmanEye;
	}

	public Arc getPacmanShape() {
		return pacmanShape;
	}

	public void setPacmanShape(Arc pacmanShape) {
		this.pacmanShape = pacmanShape;
	}

	public int getNumberOfBounces() {
		return numberOfBounces;
	}

	public void setNumberOfBounces(int numberOfBounces) {
		this.numberOfBounces = numberOfBounces;
	}
}
