package Frame;

public class StairsComponentFactory extends AbstractFloorComponentFactory{
	
	@Override
	public FloorComponent getComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "STAIRSSD"){
			return new StairsStraightFacingDown(true);
		}
		
		else if(componentType == "STAIRSSU"){
			return new StairsStraightFacingUp(true);
		}
		
		else if(componentType == "STAIRSSR"){
			return new StairsStraightFacingRight(true);
		}
		
		else if(componentType == "STAIRSSL"){
			return new StairsStraightFacingLeft(true);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(true);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(true);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(true);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(true);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(true);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(true);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(true);
		}
		
		else
			return null;
	}

	@Override
	public FloorComponent getGridComponent(String componentType) {
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "STAIRSSD"){
			return new StairsStraightFacingDown(false);
		}
		
		else if(componentType == "STAIRSSU"){
			return new StairsStraightFacingUp(false);
		}
		
		else if(componentType == "STAIRSSR"){
			return new StairsStraightFacingRight(false);
		}
		
		else if(componentType == "STAIRSSL"){
			return new StairsStraightFacingLeft(false);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(false);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(false);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(false);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(false);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(false);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(false);
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(false);
		}
		
		else
			return null;
	}
	
}