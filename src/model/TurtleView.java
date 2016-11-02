package model;

import javafx.scene.image.ImageView;

public class TurtleView {
	
	private double oldXpos;
	private double oldYpos;
	private double newXpos;
	private double newYpos;
	private double revealBoolean;
	private double penBoolean;
	private double clearScreen; ////TODO: WORK WITH THIS TO DIFFER HOME AND CLEARSCREEN
	private double angleNow;
	private int errorState;
	private double angleChange;
	
	public TurtleView(Turtle turtle){
		oldXpos=turtle.getOldPositionX();
		oldYpos=turtle.getOldPositionY();
		newXpos=turtle.getNewPositionX();
		newYpos=turtle.getNewPositionY();
		revealBoolean=turtle.isRevealBoolean();
		penBoolean=turtle.isPenBoolean();
		clearScreen=turtle.isClearScreen(); 
		angleNow=turtle.getAngle();
		errorState = turtle.getErrorState();
		angleChange = turtle.getAngleChange();
	}
	
	public int getErrorState(){
		return errorState;
	}

	public double getOldXpos() {
		return oldXpos;
	}

	public double getOldYpos() {
		return oldYpos;
	}

	public double getNewXpos() {
		return newXpos;
	}

	public double getNewYpos() {
		return newYpos;
	}

	public double isRevealBoolean() {
		return revealBoolean;
	}

	public double isPenBoolean() {
		return penBoolean;
	}

	public double isClearScreen() {
		return clearScreen;
	}

	public double getAngleNow() {
		return angleNow;
	}
	
        public double getAngleChange() {
            return angleChange;
        }	

}
