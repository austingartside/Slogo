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
	}

	protected double getOldXpos() {
		return oldXpos;
	}

	protected double getOldYpos() {
		return oldYpos;
	}

	protected double getNewXpos() {
		return newXpos;
	}

	protected double getNewYpos() {
		return newYpos;
	}

	protected boolean isRevealBoolean() {
		return revealBoolean;
	}

	protected boolean isPenBoolean() {
		return penBoolean;
	}

	protected boolean isClearScreen() {
		return clearScreen;
	}

	protected ImageView getImage() {
		return image;
	}

	protected double getAngleNow() {
		return angleNow;
	}

}
