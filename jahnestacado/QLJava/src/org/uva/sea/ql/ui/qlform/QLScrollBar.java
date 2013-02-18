package org.uva.sea.ql.ui.qlform;

import java.awt.Dimension;
import java.awt.ScrollPane;

@SuppressWarnings("serial")
public class QLScrollBar extends ScrollPane{
	public final static String containerScrollPanelId="QL_SCROLLBAR_CONTAINER_PANEL";

	
	public QLScrollBar(){
		super(SCROLLBARS_ALWAYS );
		setScrollPaneSettings();
	}
	
	private void setScrollPaneSettings(){
		this.setSize(new Dimension(650,400));
		this.setName(containerScrollPanelId);
		this.setWheelScrollingEnabled(true);
	}
	

	

}
