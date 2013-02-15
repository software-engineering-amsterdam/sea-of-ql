package org.uva.sea.ql.interpreter;

import java.awt.Dimension;
import java.awt.ScrollPane;

@SuppressWarnings("serial")
public class QLScrollBar extends ScrollPane{
	public final static String containerScrollPanelId="QL_SCROLLBAR_CONTAINER_PANEL";
	private int verticalPosition;

	
	public QLScrollBar(){
		super(SCROLLBARS_ALWAYS );
		setBarSettings();
	}
	
	private void setBarSettings(){
		this.setSize(new Dimension(650,400));
		this.setName(containerScrollPanelId);
		this.setWheelScrollingEnabled(true);
		
	}
	
	public int getVerticalPosition(){
		return this.getVAdjustable().getValue();
	}
	
	private void setVerticalPosition(){
		this.getVAdjustable().setValue(verticalPosition);
	}
	
	
	public void maintainPosition(int position){
		verticalPosition=position;
		 setVerticalPosition();
	}
	
	

}
