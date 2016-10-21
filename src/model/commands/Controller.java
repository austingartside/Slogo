package model.commands;
import model.Turtle;
import model.TurtleFactory;

public class Controller {
	private Turtle myTurtle= new Turtle();
	public void setUp(){
		//Factory useless as of now. May be needed for later additions
		TurtleFactory myTurtleFactory=new TurtleFactory();
		myTurtle= myTurtleFactory.createTurtle();
	}
	
	public Turtle getTurtle(){
		return myTurtle;
	}
	
}
