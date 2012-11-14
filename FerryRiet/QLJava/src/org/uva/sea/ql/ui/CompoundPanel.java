package org.uva.sea.ql.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.literals.Result;


import net.miginfocom.swing.MigLayout;

public class CompoundPanel extends Panel {
	private JPanel compoundJPanel ;

	private List<Panel> panelList = new ArrayList<Panel>() ;
	public CompoundPanel() {
		compoundJPanel = new JPanel() ;
		compoundJPanel.setLayout(new MigLayout("",
				"[]", "[18]"));
		compoundJPanel.setBackground(Color.GREEN) ;

	}
	
	public void addPanel(Panel newPanel) {
		panelList.add(newPanel) ;
	}
	@Override
	public Panel isActionSource(ActionEvent ev) {
		Panel actionPanel ;
		for (Panel panel : panelList) {
			actionPanel = panel.isActionSource(ev) ;
			if ( actionPanel != null ) return actionPanel ;
		}
		return null;
	}

	@Override
	public void updatecalculatedField(HashMap<String, Result> symbols) {
		for (Panel panel : panelList) {
			panel.updatecalculatedField(symbols) ;
		}
	}

	@Override
	public void registerActionListener(ActionListener actionHandler) {
		for (Panel panel : panelList) {
			panel.registerActionListener(actionHandler);
		}
	}
	@Override
	public void registerAt(JPanel parentPanel, int location) {

		StringBuilder stringBuilder = new StringBuilder("cell 0 ");

		stringBuilder.append(location);
		stringBuilder.append(" ,growx");
		parentPanel.add(compoundJPanel, stringBuilder.toString());
		
		int panelCount = 0 ;
		for (Panel panel : panelList) {
			panel.registerAt(compoundJPanel, panelCount++);
		}
	}
}
