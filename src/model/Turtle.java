package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Turtle {
	private double oldXpos;
	private double oldYpos;
	private double newXpos;
	private double newYpos;
	private boolean revealBoolean=true;
	private boolean penBoolean=false;
	private boolean clearScreen=false; ////TODO: WORK WITH THIS TO DIFFER HOME AND CLEARSCREEN
	private ImageView image;
	private double angleNow;
	private double ZERO=0.0; //temporary
	
	public Turtle(){
		newXpos=0.0;
		newYpos=0.0;
		this.setPosition(ZERO,ZERO);
		//this.setImage("Turtle.png"); //Resource File
		this.setOrientation(ZERO);
		
	}
	
	public void setImage(String pngfile) {
		Image imager = new Image(this.getClass().getClassLoader().getResourceAsStream(pngfile));
        image=new ImageView();
        image.setImage(imager);
	}
	
	/**
	 * Changes position of turtle
	 * Used for FORWARD,BACK
	 */
	public double move(double vector){
		double xmove=vector*(Math.sin(Math.toRadians(angleNow)));
		double ymove=vector*(Math.cos(Math.toRadians(angleNow)));
		newXpos=oldXpos+xmove;
		newYpos=oldYpos+ymove;
		setPosition(newXpos,newYpos);
		Controller.UpdateView(); //Give to controller then package up into Turtle View which is just a list of sttributes, the send to View.
		return vector;
		//image.setX(newXpos);
		//image.setY(newYpos);
	}
	/**
	 * Sets position of turtle
	 * Used for Home,ClearScreen
	 */
	public void setPosition(double x, double y){
		oldXpos=newXpos;
		oldYpos=newYpos;
		//image.setX(x);
		//image.setY(y);
		newXpos=x;
		newYpos=y;
		Controller.UpdateView();
	}
	
	/**
	 * Used for XCOR
	 */
	public double getNewPositionX(){
		return newXpos;
	}
	
	/**
	 * Used for YCOR
	 */
	public double getNewPositionY(){
		return newYpos;
	}
	
	/**
	 * Used for line drawing with NewPosition
	 */
	public double getOldPositionX(){
		return oldXpos;
	}
	
	/**
	 * Used for line drawing with newPosition
	 */
	public double getOldPositionY(){
		return oldYpos;
	}

	/**
	 * Sets the angle of the turtle
	 * Used for RIGHT,LEFT
	 * @return 
	 */
	public double changeOrientation(double angle){
		//image.setRotate(angle);
		angleNow=angleNow+angle;
		Controller.UpdateView();
		return angle;
	}
	
	/**
	 * Sets the angle of the turtle
	 * Used for RIGHT,LEFT,SETHEADING,TOWARD and all resets
	 */
	
	public void setOrientation(double angle){
		//image.setRotate(360-angleNow);
		angleNow=angle;
		Controller.UpdateView();
		//image.setRotate(angle);
	}
	 /**
	 * Used for HEADING
	 */
	public double getOrientation(){
		return angleNow;
	}
	
	/**
	 * Used for SHOWTURTLE
	 */
	public void showTurtle(){
		revealBoolean=true;
		Controller.UpdateView();
	}
	
	/**
	 * Used for HIDETURTLE
	 */
	public void hideTurtle(){
		revealBoolean=false;
		Controller.UpdateView();
	}
	
	/**
	 * Used for PENUP
	 */
	public void penUp(){
		penBoolean=false;
		Controller.UpdateView();
	}
	
	/**
	 * Used for PENDOWN
	 */
	public void penDown(){
		penBoolean=true;
		Controller.UpdateView();
	}
	
	public double getAngle(){
		return angleNow;
	}

	public ImageView getImage() {
		return image;
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

}
