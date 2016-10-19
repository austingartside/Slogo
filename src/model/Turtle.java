package model;


public class Turtle {
	private double xpos;
	private double ypos;
	private boolean revealBoolean=true;
	private boolean penBoolean=false;
	
	public Turtle(){
		
	}
	/**
	 * Addresses setting the co-ordinates of the turtl
	 * Used for FORWARD,BACK,SETXY,HOME,CLEARSCREEN
	 */
	public void setPosition(double x, double y){
		//
	}
	
	/**
	 * Used for XCOR
	 */
	public void getPositionX(){
		//
	}
	
	/**
	 * Used for YCOR
	 */
	public void getPositionY(){
		//
	}
	
	/**
	 * Sets the angle of the turtle
	 * Used for RIGHT,LEFT,SETHEADING,TOWARDS and all resets
	 */
	public void setOrientation(double angle){
		//
	} 
	/**
	 * Used for HEADING
	 */
	public void getOrientation(){
		//
	}
	/**
	 * Used for FORWARD,BACK
	 */
	public void moveDirection(double value){
		
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
