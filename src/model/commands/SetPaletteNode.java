package model.commands;

import model.Controller;
import model.parser.CommandFactory;
import model.parser.ListOfCommands;

public class SetPaletteNode extends Command{

	public SetPaletteNode(ListOfCommands commandList, CommandFactory nodeMaker, Controller control) throws Exception {
		super(commandList.getCommand());
		commandList.updateLocation();
		for(int i = 0; i<4; i++){
			this.addChild((Command) nodeMaker.getCommand(commandList, control));
			commandList.updateLocation();
		}
	}

	@Override
	public double execute(Controller control) {
		return control.getDisplaySpecs().setPaletteIndex(this.executeChild(FIRSTENTRY, control),this.executeChild(SECONDENTRY,control),this.executeChild(3,control),this.executeChild(4,control));
	}
	
	

}
