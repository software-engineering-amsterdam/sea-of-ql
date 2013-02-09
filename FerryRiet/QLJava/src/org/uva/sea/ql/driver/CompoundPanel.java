package org.uva.sea.ql.driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;



public class CompoundPanel extends Panel {
	private JPanel compoundJPanel ;

	private List<Panel> panelList = new ArrayList<Panel>() ;
	public CompoundPanel() {
		compoundJPanel = new JPanel() ;
		compoundJPanel.setLayout(new MigLayout("",
				"[]", "[20]"));

	}
	
	public void addPanel(Panel newPanel) {
		panelList.add(newPanel) ;
	}
	@Override
	public Panel isActionSource(ActionEvent ev) {
		for (Panel panel : panelList) {
			if ( panel.isActionSource(ev) != null ) return panel ;
		}
		return null;
	}

	@Override
	public void registerActionListener(ActionListener actionHandler) {
		for (Panel panel : panelList) {
			panel.registerActionListener(actionHandler);
		}
	}
	@Override
	public void registerAt(JPanel parentPanel, int location) {

		parentPanel.add(compoundJPanel, "cell 0 0 , growx");
		
		int panelCount = 0 ;
		for (Panel panel : panelList) {
			panel.registerAt(compoundJPanel, panelCount++);
		}
	}
}
