package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TurtleController {
	private Collection<Turtle> myTurtleCollection;
	private Collection<TurtleView> myTurtleViewCollection;
	private TurtleFactory myTurtleFactory;
	private TurtleArmy myTurtleArmy;
	private Collection<Double> myTurtleIDs;
	private Collection<Double> myAskList;
	private Controller myController;
	private static double ONE=1.0; 
	
	public TurtleController(Controller controller) {
		myTurtleFactory=new TurtleFactory();
		myTurtleIDs=new ArrayList<Double>();
		myTurtleCollection=new ArrayList<Turtle>();
		myTurtleViewCollection=new ArrayList<TurtleView>();
		myAskList=new ArrayList<Double>();
		myController=controller;
	}
	
	public void makeTurtle(double turtleNum) {
		Turtle turtle=myTurtleFactory.createTurtle(myController, turtleNum); ////??????????
		myTurtleCollection.add(turtle);
		myTurtleIDs.add(turtleNum);
		myTurtleArmy= new TurtleArmy(myTurtleCollection);
		myTurtleViewCollection=updateTurtleViewCollection();
	}

	public Collection<Turtle> getTurtleList() {
		return myTurtleCollection;
	}
	
	public Collection<Double> getTurtleIDs() {
		return myTurtleIDs;
	}
	
	public void askListUpdate(double turtleNum){
		myAskList.add(turtleNum);
	}
	
	public void setTurtleArmy(){
		Collection<Turtle> tempCollection=new ArrayList<Turtle>();
		Iterator<Double> tempIterator= myAskList.iterator();
    	while(tempIterator.hasNext()){
    		Double i=tempIterator.next();
			for(Turtle t :myTurtleCollection){
				if(t.checkID(i)){
					tempCollection.add(t);
				}
			}
		}
    	myTurtleArmy=new TurtleArmy(tempCollection);
		myAskList.clear();
	}
	
	public TurtleArmy getTurtle(){
		return myTurtleArmy;
	}
	
	public Collection<TurtleView> updateTurtleViewCollection(){
		//Change to binding
		myTurtleViewCollection.clear();
		for(Turtle t: myTurtleCollection){
			TurtleView turtleView= new TurtleView(t);
			myTurtleViewCollection.add(turtleView);
		}
		return myTurtleViewCollection;
	}
	
	public void refresh(){
		myTurtleCollection.clear();
		myTurtleIDs.clear();
		makeTurtle(ONE);
	}
	
	public void resetClearScreens() {
		for(Turtle t: myTurtleCollection){
			t.setClearScreenOff();
		}
	}

	public void resetArmy() {
		myTurtleArmy=new TurtleArmy(myTurtleCollection);
	}
}
