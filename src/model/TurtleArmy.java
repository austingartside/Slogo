package model;

import java.util.Collection;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleArmy {
	private Collection<Turtle> myTurtleCollection;
	
	public TurtleArmy(Collection<Turtle> turtleCollection){
		myTurtleCollection=turtleCollection;
	} 
	
	public void reset(){
		for(Turtle t : myTurtleCollection){
			t.reset();
		}
	}
	
	//
	public void getErrorState(){
		for(Turtle t : myTurtleCollection){
			t.getErrorState();
		}
	}
	
	public void setErrorState(int errorNum){
		for(Turtle t : myTurtleCollection){
			//t.setErrorState();
		}
	}

	public double move(double vector){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.move(vector);
		}
		return val;
	}
	
	public double towards(double x, double y){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.towards(x,y);
		}
		return val;
	}

	public double setPosition(double x, double y){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.setPosition(x,y);
		}
		return val;
	}
	
	public double getNewPositionX(){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.getNewPositionX();
		}
		return val;
	}
	
	public double getNewPositionY(){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.getNewPositionY();
		}
		return val;
	}
	
	public double getOldPositionX(){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.getOldPositionY();
		}
		return val;
	}
	
	public double getOldPositionY(){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.getOldPositionY();
		}
		return val;
	}

	public double changeOrientation(double angle){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.changeOrientation(angle);
		}
		return val;
	}
	
	public double setOrientation(double angle){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.setOrientation(angle);
		}
		return val;
	}
	 
	public double getOrientation(){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.getOrientation();
		}
		return val;
	}
	
	public double clearScreen(){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.clearScreen();
		}
		return val;
	}
	
	public double showTurtle(){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.showTurtle();
		}
		return val;
	}
	
	public double hideTurtle(){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.hideTurtle();
		}
		return val;
	}
	
	public double penUp(){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.penUp();
		}
		return val;
	}
	
	public double penDown(){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.penDown();
		}
		return val;
	}
	
	public double getAngle(){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.getAngle();
		}
		return val;
	}
	
	public double isRevealBoolean() {
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.isRevealBoolean();
		}
		return val;
	}

	public double isPenBoolean() {
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.isPenBoolean();
		}
		return val;
	}

	public double isClearScreen() {
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.isClearScreen();
		}
		return val;
	}
	public double setClearScreenOff(){
		double val = 0;
		for(Turtle t : myTurtleCollection){
			val=t.setClearScreenOff();
		}
		return val;
	}
	

}
