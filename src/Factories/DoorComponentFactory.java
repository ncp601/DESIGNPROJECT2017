package Factories; 

import FloorComponent.*;

public class DoorComponentFactory extends AbstractFloorComponentFactory{
	
	@Override
	public FloorComponent getComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else if(componentType.equals("DOORFDOL")){
			return new DoorComponentFacingDownOpenLeft(true);
		}
		
		else if(componentType.equals("DOORFDOR")){
			return new DoorComponentFacingDownOpenRight(true);
		}
		
		else if(componentType.equals( "DOORFLOL")){
			return new DoorComponentFacingLeftOpenLeft(true);
		}
		
		else if(componentType.equals("DOORFLOR")){
			return new DoorComponentFacingLeftOpenRight(true);
		}
		
		else if(componentType.equals("DOORFROL")){
			return new DoorComponentFacingRightOpenLeft(true);
		}
		
		else if(componentType.equals("DOORFROR")){
			return new DoorComponentFacingRightOpenRight(true);
		}
		
		else if(componentType.equals("DOORFUOL")){
			return new DoorComponentFacingUpOpenLeft(true);
		}
		
		else if(componentType.equals("DOORFUOR")){
			return new DoorComponentFacingUpOpenRight(true);
		}
		else
			return null;
	}

	@Override
	public FloorComponent getGridComponent(String componentType) {
		if(componentType == null){
			return null;
		}
		
		else if(componentType.equals("DOORFDOL")){
			return new DoorComponentFacingDownOpenLeft(false);
		}
		
		else if(componentType.equals("DOORFDOR")){
			return new DoorComponentFacingDownOpenRight(false);
		}
		
		else if(componentType.equals("DOORFLOL")){
			return new DoorComponentFacingLeftOpenLeft(false);
		}
		
		else if(componentType.equals("DOORFLOR")){
			return new DoorComponentFacingLeftOpenRight(false);
		}
		
		else if(componentType.equals("DOORFROL")){
			return new DoorComponentFacingRightOpenLeft(false);
		}
		
		else if(componentType.equals("DOORFROR")){
			return new DoorComponentFacingRightOpenRight(false);
		}
		
		else if(componentType.equals("DOORFUOL")){
			return new DoorComponentFacingUpOpenLeft(false);
		}
		
		else if(componentType.equals("DOORFUOR")){
			return new DoorComponentFacingUpOpenRight(false);
		}
		else
			return null;
	}
	
}