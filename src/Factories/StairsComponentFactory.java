
package Factories;

import FloorComponent.*;

public class StairsComponentFactory extends AbstractFloorComponentFactory{
		
		@Override
		public FloorComponent getComponent(String componentType){
			if(componentType == null){
				return null;
			}
			
			else if(componentType.equals("STAIRSSU")){
				return new StairsStraightFacingUp(true);
			}
			
			else if(componentType.equals("STAIRSSD")){
				return new StairsStraightFacingDown(true);
			}
			
			else if(componentType.equals("STAIRSSR")){
				return new StairsStraightFacingRight(true);
			}
			
			else if(componentType.equals("STAIRSSL")){
				return new StairsStraightFacingLeft(true);
			}
			
			else
				return null;
		}
		
		@Override
		public FloorComponent getGridComponent(String componentType){
			if(componentType.equals(null)){
				return null;
			}
			
			else if(componentType.equals("STAIRSSU")){
				return new StairsStraightFacingUp(false);
			}
			
			else if(componentType.equals("STAIRSSD")){
				return new StairsStraightFacingDown(false);
			}
			
			else if(componentType.equals("STAIRSSR")){
				return new StairsStraightFacingRight(false);
			}
			
			else if(componentType.equals("STAIRSSL")){
				return new StairsStraightFacingLeft(false);
			}
			
			else
				return null;
		}
		
}
