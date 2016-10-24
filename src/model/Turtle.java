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
	private Controller myController;
	private int errorState;

	public Turtle(Controller controller){
		newXpos=0.0;
		newYpos=0.0;
		myController=controller;
		errorState = 0;
		//this.setPosition(ZERO,ZERO);
		//this.setImage("Turtle.png"); //Resource File
		//this.setOrientation(ZERO);
		
	}
	
	public void setImage(String pngfile) {
		Image imager = new Image(this.getClass().getClassLoader().getResourceAsStream(pngfile));
        image=new ImageView();
        image.setImage(imager);
	}
	
	public int getErrorState(){
		return errorState;
	}
	
	public void setErrorState(int errorNum){
		errorState = errorNum;
	}

	/**
	 * Changes position of turtle
	 * Used for FORWARD,BACK
	 */
	public double move(double vector){
		System.out.print("Vector:");
		System.out.println(vector);
		double xmove=vector*(Math.sin(Math.toRadians(angleNow)));
		double ymove=-1*vector*(Math.cos(Math.toRadians(angleNow)));
		newXpos=oldXpos+xmove;
		newYpos=oldYpos+ymove;
		myController.UpdateView(); //Give to controller then package up into Turtle View which is just a list of sttributes, the send to View.
		oldXpos=newXpos;
		oldYpos=newYpos;
		return vector;
		//image.setX(newXpos);
		//image.setY(newYpos);
	}
	
	public double towards(double x, double y){
		double angle;
		double currentAngle=angleNow;
		angle=Math.toDegrees(Math.atan(x/y));
		System.out.println(angle);
		//orientQuadrant(0,angle,currentAngle);
		//This is garbage. Fix later. Enum?
		if(x>0){
			if(y>0){
				orientQuadrant(0,angle,currentAngle);
			}
			else{
				orientQuadrant(90,angle,currentAngle);
			}
		}
		if(x<0){
			if(y>0){
				orientQuadrant(270,angle,currentAngle);
			}
			else{
				orientQuadrant(180,angle,currentAngle);
			}
		}
		return 0;
	}
	
	public double orientQuadrant(double quadrant,double angle, double currentAngle){
		double newAngle=quadrant+angle;
		System.out.println(quadrant);
		System.out.println(angle);
		System.out.println("Gdhdh");
		System.out.println(newAngle);
		setOrientation(newAngle);
		return Math.abs(currentAngle-newAngle);
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
		newYpos=-1*y;
		myController.UpdateView();
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
		myController.UpdateView();
		return angle;
	}
	
	/**
	 * Sets the angle of the turtle
	 * Used for RIGHT,LEFT,SETHEADING,TOWARD and all resets
	 * @return 
	 */
	
	public void setOrientation(double angle){
		//image.setRotate(360-angleNow);
		angleNow=angle;
		myController.UpdateView();
		//return angleNow;
		//image.setRotate(angle);
	}
	 /**
	 * Used for HEADING
	 */
	public double getOrientation(){
		return angleNow;
	}
	
	public void clearScreen(){
		clearScreen=true;
		myController.UpdateView();
	}
	
	/**
	 * Used for SHOWTURTLE
	 */
	public void showTurtle(){
		revealBoolean=true;
		myController.UpdateView();
	}
	
	/**
	 * Used for HIDETURTLE
	 */
	public void hideTurtle(){
		revealBoolean=false;
		myController.UpdateView();
	}
	
	/**
	 * Used for PENUP
	 */
	public void penUp(){
		penBoolean=false;
		myController.UpdateView();
	}
	
	/**
	 * Used for PENDOWN
	 */
	public void penDown(){
		penBoolean=true;
		myController.UpdateView();
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
	public void setClearScreenOff(){
		clearScreen=false;
	}

}
