package model.commands;

import java.util.Map;

import model.Controller;
import model.parser.ListOfCommands;

public abstract class DisplayCommand extends Command {
	
	public DisplayCommand(String command){
		super(command);
	}
	
	@Override
	public abstract double execute(Controller control);

}
