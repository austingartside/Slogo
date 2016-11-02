package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Turtle {
	private double oldXpos;
	private double oldYpos;
	private int SQUARED =2;
	private double ZERO =0;
	private double ONE = 1;
	//private DoubleProperty oldYpos
	private double newXpos;
	private double newYpos;
	private double revealBoolean=ONE;
	private double penBoolean=ONE;
	private double clearScreen=ZERO; ////TODO: WORK WITH THIS TO DIFFER HOME AND CLEARSCREEN
	private ImageView image;
	private double angleNow;
	private double angleChange;
	private Controller myController;
	private int errorState;
	private double myID;

	public Turtle(Controller control, double id){
		newXpos=0.0;
		newYpos=0.0;
		myController=control;
		errorState = 0;
		myID=id;
		//this.setPosition(ZERO,ZERO);
		//this.setImage("Turtle.png"); //Resource File
		//this.setOrientation(ZERO);
		
	}
	public void reset(){
		oldXpos=0.0;
		oldYpos=0.0;
		newXpos=0.0;
		newYpos=0.0;
		myController.UpdateView();
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
		System.out.println(newAngle);
		setOrientation(newAngle);
		return Math.abs(currentAngle-newAngle);
	}
	
	/**
	 * Sets position of turtle
	 * Used for Home,ClearScreen
	 */
	public double setPosition(double x, double y){
		oldXpos=newXpos;
		oldYpos=newYpos;
		//image.setX(x);
		//image.setY(y);
		newXpos=x;
		newYpos=-1*y;
		myController.UpdateView();
		return Math.sqrt(Math.pow(newXpos-oldXpos, SQUARED)+(Math.pow(newYpos-oldYpos,SQUARED)));
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
	        angleChange = angle;
		angleNow=angleNow+angle;
		myController.UpdateView();
		return angle;
	}
	
	/**
	 * Sets the angle of the turtle
	 * Used for RIGHT,LEFT,SETHEADING,TOWARD and all resets
	 * @return 
	 */
	
	public double setOrientation(double angle){
		//image.setRotate(360-angleNow);
		angleNow=angle;
		myController.UpdateView();
		//return angleNow;
		//image.setRotate(angle);
		return angle;
	}
	 /**
	 * Used for HEADING
	 */
	public double getOrientation(){
		return angleNow;
	}
	
	public double clearScreen(){
		double dist=Math.sqrt(Math.pow(newXpos, SQUARED)+(Math.pow(newYpos,SQUARED)));
		reset();
		setOrientation(ZERO);
		clearScreen=ONE;
		myController.UpdateView();
		return dist;
	}
	
	/**
	 * Used for SHOWTURTLE
	 * @return 
	 */
	public double showTurtle(){
		revealBoolean=ONE;
		myController.UpdateView();
		return ONE;
	}
	
	/**
	 * Used for HIDETURTLE
	 * @return 
	 */
	public double hideTurtle(){
		revealBoolean=ZERO;
		myController.UpdateView();
		return ZERO;
	}
	
	/**
	 * Used for PENUP
	 * @return 
	 */
	public double penUp(){
		penBoolean=ZERO;
		myController.UpdateView();
		return ZERO;
	}
	
	/**
	 * Used for PENDOWN
	 * @return 
	 */
	public double penDown(){
		penBoolean=ONE;
		myController.UpdateView();
		return ONE;
	}
	
	public double getAngle(){
		return angleNow;
	}
        public double getAngleChange(){
            return angleChange;
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
	public double setClearScreenOff(){
		return clearScreen=ZERO;
	}
	public boolean checkID(double i) {
		return(myID==i);
	}
        public void setAngleChange(){
            angleChange=ZERO;
        }
}
