package Frame;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Factories.AbstractFloorComponentFactory;
import Factories.FloorComponentFactoryProducer;
import FloorComponent.FloorComponent;

/**
 * Class that creates everything in the left tabbed panel. 
 * 
 */
public class TabbedPane implements ChangeListener{

	// Variables declaration                  
    private JButton addTabButton;
    private JTabbedPane floorTabPanel;
	private MainLayeredPane selectedTab;
	private MainLayeredPane previousTab;
	private MainLayeredPane currentFloor;
    
	private Component[] onGrid;
	private Component[] componentList;
	private String extendedComponentType;
	private StringBuilder loadedType;
	private FloorComponent extendedComponent;
	private AbstractFloorComponentFactory wallFactory = FloorComponentFactoryProducer.getFactory("WALL");
	private AbstractFloorComponentFactory stairsFactory = FloorComponentFactoryProducer.getFactory("STAIRS");
	private AbstractFloorComponentFactory elevatorFactory = FloorComponentFactoryProducer.getFactory("ELEVATOR");
	
    private InnerPanel innerPanel;
    
    //Regular expressions used to parse various strings
    String addFloorPattern = "(Wall)|(Elevator)|(Stairs)"; // (WALL([1-3]+([H|V])|(HALF)))|(ELEVATOR(DOWN|UP|RIGHT|LEFT))
    String initialCheckPattern = "^[$].*[$]$";
    
	private int tabNumber = 0;
	private int index = 0;
	
	public TabbedPane() {
		
	//Creates floorTabPanel
    floorTabPanel = new JTabbedPane();
    floorTabPanel.setBackground(new Color(155, 155, 155));
    floorTabPanel.setFocusable(false);
    
  //------------------------------------------------------------------------------
    
    //Adds the initial floor to the tab panel 
    floorTabPanel.addTab("Floor 1", new MainLayeredPane(tabNumber));
    
  //------------------------------------------------------------------------------

    //Creates the button that will add new tabs to the TabbedPane
    addTabButton = new JButton(); 
    addTabButton.setText("  +  ");
    addTabButton.setOpaque (false); //
    addTabButton.setBorder (null);
    addTabButton.setContentAreaFilled(false);
    addTabButton.setFocusPainted (false);
    addTabButton.setFocusable (false);
    addTabButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        	insertTab();
        	addExtendingComponents();
        }
    });
    
    insertTab();
    
	}
	
	//Gets the current floorTabPanel
	public JTabbedPane getGUI(){
		return floorTabPanel;
	}
	
	//Inserts an additional tab when the add tab button us pressed
	private void insertTab(){
		tabNumber++;
		String title = "Floor " + String.valueOf (floorTabPanel.getTabCount());
		System.out.println(floorTabPanel.getTabCount());
	    System.out.println(title);
	    if (tabNumber >= 0 && tabNumber < 17) {
	        JPanel pnl = new JPanel();
	        pnl.setOpaque(false);
			floorTabPanel.insertTab(title, null, new MainLayeredPane(tabNumber), "", floorTabPanel.getTabCount() - 1);
	        pnl.add(addTabButton);
	        floorTabPanel.setTabComponentAt(floorTabPanel.getTabCount() - 1, pnl);
	        floorTabPanel.setSelectedIndex(floorTabPanel.getTabCount() - 2);
	        floorTabPanel.setEnabledAt(floorTabPanel.getTabCount()-1, false);	
	        floorTabPanel.addChangeListener(this);
	 
	    } 
    }
	
	public  void removeCurrentFloor(){

        //if 1 tab + plus tab do nothing
        if(tabNumber == 1){ 
        	return;
        }
        
        else if(tabNumber == (index+1)){
        	floorTabPanel.setSelectedIndex(index-1);
            floorTabPanel.remove(index);        	
        }
        
        else if( index+1 == 1){
        	floorTabPanel.setSelectedIndex(index);
            floorTabPanel.remove(index);
        }
        
        else {
        	floorTabPanel.setSelectedIndex(index);
            floorTabPanel.remove(index);
        }
        
        tabNumber = floorTabPanel.getTabCount() - 1;        
        updateFloorNames();
    }
	
	private void updateFloorNames(){
		for(int i = 0; i< tabNumber; i++){
			String title = "Floor " + (i+1);
			floorTabPanel.setTitleAt(i , title);
		}
	}
	
	//Removes all the current tabs and adds the default 
	public void removeAll(){
		for(int i = floorTabPanel.getTabCount(); i > 1  ; i--){
			floorTabPanel.remove(i-2);
		}
		tabNumber = floorTabPanel.getTabCount();
		insertTab();
	}
	
	//Adds copies of all wall components of the previous layer to the new layer 
	public void addExtendingComponents(){
		innerPanel = InnerPanel.getInstance();
		previousTab = (MainLayeredPane)floorTabPanel.getComponentAt(tabNumber - 2);
		onGrid = previousTab.getGlassPanel().getComponents();
		
		Pattern wallPattern = Pattern.compile(addFloorPattern);
		
		for(int i = 0; i < onGrid.length; i++){
			Matcher m = wallPattern.matcher(onGrid[i].toString());
			if(m.find()){
				extendedComponentType = ((FloorComponent) onGrid[i]).getComponentType();
				
				if(wallFactory.getGridComponent(extendedComponentType) != null)
					extendedComponent = wallFactory.getGridComponent(extendedComponentType);
				
				if(elevatorFactory.getGridComponent(extendedComponentType) != null)
					extendedComponent = elevatorFactory.getGridComponent(extendedComponentType);
				
				if(stairsFactory.getGridComponent(extendedComponentType) != null)
					extendedComponent = stairsFactory.getGridComponent(extendedComponentType);
				
				innerPanel.getSelectedFloor().getGlassPanel().add(extendedComponent);
				extendedComponent.setLocation(onGrid[i].getLocation());
				extendedComponent.setSize(onGrid[i].getSize());
				extendedComponent.setVisible(true);
				extendedComponent.setIsOnGrid(true);
				System.out.println(onGrid[i].toString());
			}
		}
		previousTab.repaint();
		previousTab.revalidate();
	}
	
	public void stringToFloorComponents(){
		innerPanel = InnerPanel.getInstance();
		String loadComponents = innerPanel.getLoadedComponents();
		Pattern initialPattern = Pattern.compile(initialCheckPattern);
		Matcher m = initialPattern.matcher(loadComponents);
		
		if(m.find()){
			System.out.println("Match comfirmed");
			for(int i = 0; i < loadComponents.length(); i++){
				int j = i+1;
				if(loadComponents.charAt(i) == '@'){
					System.out.println("@ Found");
					loadedType = new StringBuilder();
					while(loadComponents.charAt(j) != '@'){
						loadedType.append(loadComponents.charAt(j));
						j++;
					}
				}
				
				i = j;
				
				if(loadComponents.charAt(i) == '#'){
					j = i;
					
				}
					
			}
			
		}
	}
	
	public String floorsToString(){
        innerPanel = InnerPanel.getInstance();

        String allComponents = "";
        int tabs = floorTabPanel.getTabCount() - 1;

        for(int i = 0; i < tabs; i++){
            currentFloor = (MainLayeredPane) floorTabPanel.getComponentAt(tabs -1);
            componentList = currentFloor.getGlassPanel().getComponents();
            for(int j = 0; j < componentList.length; j++){
                String name = ((FloorComponent) componentList[j]).getComponentType();
                String location = componentList[j].getLocation().toString();
                if(i == 0 && j == 0){
                    allComponents = "$" + "@" + name + "@" + "#" + location + "||";
                }

                if(j == componentList.length - 1){
                    allComponents = allComponents + "@" + name + "@" + "#" + location;
                }

                else {
                    allComponents = allComponents + "@" + name + "@" + "#" + location + "||";
                }
            }
            allComponents = allComponents + "%%%%";
        }
        allComponents = allComponents + "$";
        return allComponents;
    }
	
	public void stateChanged(ChangeEvent event) {
		innerPanel = InnerPanel.getInstance();
		
        if (event.getSource() instanceof JTabbedPane) {
            JTabbedPane pane = (JTabbedPane)event.getSource();
            index = pane.getSelectedIndex();
            selectedTab = (MainLayeredPane)pane.getComponentAt(index);
            innerPanel.setSelectedFloor(selectedTab);             
        }

    }
	
}
