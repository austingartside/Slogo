package model;

public class TurtleFactory {

	public Turtle createTurtle(Controller control, double i) {
		Turtle turtle=new Turtle(control,i);
		return turtle;
	}
}
