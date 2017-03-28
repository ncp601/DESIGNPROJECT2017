package Frame;

public class ElevatorComponentFactory extends AbstractFloorComponentFactory{
	
	@Override
	public FloorComponent getComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp();
		}
		
		else if(componentType == "ELEVATORDOWN"){
			return new ElevatorComponentFacingDown();
		}
		
		else if(componentType == "ELEVATORRIGHT"){
			return new ElevatorComponentFacingRight();
		}
		
		else if(componentType == "ELEVATORLEFT"){
			return new ElevatorComponentFacingLeft();
		}
		
		else
			return null;
	}
	
}