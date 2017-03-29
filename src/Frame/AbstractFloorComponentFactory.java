package Frame;

public abstract class AbstractFloorComponentFactory {
	
	abstract public FloorComponent getComponent(String componentType);
	abstract public FloorComponent getGridComponent(String componentType);
	
}
