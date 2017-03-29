package ToolBarCommand;

import Frame.TabbedPane;

public class RemoveFloorCommand implements ToolBarCommands{

	ToolBarReceiver toolbarR;
	TabbedPane currentTabbedPane;
	
	public RemoveFloorCommand(ToolBarReceiver r ,TabbedPane p) {
		this.toolbarR = r;
		this.currentTabbedPane = p;
	}
	
	@Override
	public void execute() {
		toolbarR.removeCurrentFloor(currentTabbedPane);		
	}
	
}
