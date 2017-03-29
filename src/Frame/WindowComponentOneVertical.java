package Frame;

import javax.swing.*;
import java.awt.*;

public class WindowComponentOneVertical extends FloorComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final private String componentType = "WINDOW1V";

	private Dimension size = new Dimension(110, 110);
	private Dimension gridSize = new Dimension(32,17);
	
	private boolean inMenu;
	private ComponentMover compMove = new ComponentMover();
	
	public WindowComponentOneVertical(boolean m){
		this.inMenu = m;
        addMouseListener(compMove);
        addMouseMotionListener(compMove);
		createComponent();
		setVisible(true);
	}
	
	@Override
	public void createComponent(){

		if(inMenu){
			ImageIcon image = new ImageIcon("images/oneBlockWindowVertical");
			setIcon(image);
			setMaximumSize(size);
			setMinimumSize(size);
	        setPreferredSize(size);
		}
		
		if(!inMenu){
			ImageIcon image = new ImageIcon("images/resizedOneBlockWindowVertical");
			setIcon(image);
			setMaximumSize(gridSize);
			setMinimumSize(gridSize);
	        setPreferredSize(gridSize);
		}
	}
	
	@Override
	public String getComponentType(){
		return componentType;
	}
	
	@Override
	public Dimension getImageSize(){
		return size;
	}
	
	@Override
	public Dimension getGridImageSize(){
		return gridSize;
	}

}