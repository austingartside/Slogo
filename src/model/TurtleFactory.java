package model;

public class TurtleFactory {

	public Turtle createTurtle(Controller control) {
		Turtle turtle=new Turtle(control);
		return turtle;
	}
}
