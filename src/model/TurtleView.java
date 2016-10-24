package model;

import javafx.scene.image.ImageView;

public class TurtleView {
	
	private double oldXpos;
	private double oldYpos;
	private double newXpos;
	private double newYpos;
	private boolean revealBoolean;
	private boolean penBoolean;
	private boolean clearScreen; ////TODO: WORK WITH THIS TO DIFFER HOME AND CLEARSCREEN
	private ImageView image;
	private double angleNow;
	private int errorState;
	
	public TurtleView(Turtle turtle){
		oldXpos=turtle.getOldPositionX();
		oldYpos=turtle.getOldPositionY();
		newXpos=turtle.getNewPositionX();
		newYpos=turtle.getNewPositionY();
		revealBoolean=turtle.isRevealBoolean();
		penBoolean=turtle.isPenBoolean();
		clearScreen=turtle.isClearScreen(); 
		image=turtle.getImage();
		angleNow=turtle.getAngle();
		errorState = turtle.getErrorState();
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

	public boolean isRevealBoolean() {
		return revealBoolean;
	}

	public boolean isPenBoolean() {
		return penBoolean;
	}

	public boolean isClearScreen() {
		return clearScreen;
	}

	protected ImageView getImage() {
		return image;
	}

	public double getAngleNow() {
		return angleNow;
	}

}
