package model;

import javafx.scene.image.ImageView;

public class Turtle {
	private double xpos;
	private double ypos;
	private boolean revealBoolean=true;
	private boolean penBoolean=false;
	private ImageView image;
	private double angleNow;
	
	public Turtle(){
		
	}
	/**
	 * Changes position of turtle
	 * Used for FORWARD,BACK
	 */
	public void move(double vector){
		double xmove=vector*(Math.sin(Math.toRadians(angleNow)));
		double ymove=vector*(Math.cos(Math.toRadians(angleNow)));
		xpos=xpos+xmove;
		ypos=ypos+ymove;
		image.setX(xpos);
		image.setY(ypos);
	}
	/**
	 * Sets position of turtle
	 * Used for Home,ClearScreen
	 */
	public void setPosition(double x, double y){
		image.setX(x);
		image.setY(y);
		xpos=x;
		ypos=y;
	}
	
	/**
	 * Used for XCOR
	 */
	public double getPositionX(){
		return xpos;
	}
	
	/**
	 * Used for YCOR
	 */
	public double getPositionY(){
		return ypos;
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
