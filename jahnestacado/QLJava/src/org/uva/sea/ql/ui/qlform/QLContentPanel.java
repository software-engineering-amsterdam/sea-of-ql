package org.uva.sea.ql.ui.qlform;

import java.awt.Color;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;



public class QLContentPanel {
	private final JPanel contentPanel;
	private final static String contentPanelId="QL_CONTENT_PANEL";

	
	private QLContentPanel(){
		contentPanel=new JPanel();
		setSettings();
	}
	
	public static JPanel getContentPanel(){
		return new QLContentPanel().getPanel();
	}
	
	private JPanel getPanel(){
		return contentPanel;
	}
	
	private void setSettings(){
		contentPanel.setLayout(new MigLayout("hidemode 1"));
		contentPanel.setName(contentPanelId);
		contentPanel.setBackground(Color.black);
		
	}

}
