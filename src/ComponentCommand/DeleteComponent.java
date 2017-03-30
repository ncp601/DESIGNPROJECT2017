package ComponentCommand;

import java.awt.*;

import FloorComponent.FloorComponent;

public class DeleteComponent implements ComponentCommands {

	ComponentReceiver compR;
	FloorComponent currentLabel;
	Component source;
	Point currentLocation;
	
	public DeleteComponent(ComponentReceiver r, Component c, FloorComponent fc, Point l){
		this.compR = r;
		this.currentLabel = fc;
		this.source = c;
		this.currentLocation = l;
	}
	
	@Override 
	public void execute(){
		compR.deleteComponent(source, currentLocation);
	}
	
	@Override 
	public void undo(){
		compR.reAddComponent(currentLabel, currentLocation);
		currentLabel.setLocation(currentLabel.getPreviousLocation());
	}
	
	@Override 
	public void redo(){
		compR.deleteComponent(source, currentLocation);
	}
	
}
