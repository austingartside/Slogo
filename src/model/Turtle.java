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
	private ImageView image;
	private double angleNow;
	private double ZERO=0; //temporary
	
	public Turtle(){
		this.setPosition(ZERO,ZERO);
		this.setImage("Turtle.png"); //Resource File
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
	public void move(double vector){
		double xmove=vector*(Math.sin(Math.toRadians(angleNow)));
		double ymove=vector*(Math.cos(Math.toRadians(angleNow)));
		newXpos=oldXpos+xmove;
		newYpos=oldYpos+ymove;
		image.setX(newXpos);
		image.setY(newYpos);
	}
	/**
	 * Sets position of turtle
	 * Used for Home,ClearScreen
	 */
	public void setPosition(double x, double y){
		oldXpos=newXpos;
		oldYpos=newYpos;
		image.setX(x);
		image.setY(y);
		newXpos=x;
		newYpos=y;
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
	 */
	public void changeOrientation(double angle){
		image.setRotate(angle);
		angleNow=angle;
	}
	
	/**
	 * Sets the angle of the turtle
	 * Used for RIGHT,LEFT,SETHEADING,TOWARD and all resets
	 */
	
	public void setOrientation(double angle){
		image.setRotate(360-angleNow);
		angleNow=angle;
		image.setRotate(angle);
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
	}
	
	/**
	 * Used for HIDETURTLE
	 */
	public void hideTurtle(){
		revealBoolean=false;
	}
	
	/**
	 * Used for PENUP
	 */
	public void penUp(){
		penBoolean=true;
	}
	
	/**
	 * Used for PENDOWN
	 */
	public void penDown(){
		penBoolean=false;
	}
	
	
}
