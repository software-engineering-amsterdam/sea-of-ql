package org.uva.sea.ql.ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.literals.Result;

public class CompoundPanel extends Panel {
	private JPanel compoundJPanel ;
	private List<Panel> panelList = new ArrayList<Panel>() ;

	public CompoundPanel() {
		compoundJPanel = new JPanel() ;
		compoundJPanel.setLayout(new MigLayout("",
				"[]", "[18]"));
		//compoundJPanel.setBackground(Color.GREEN) ;

	}
	@Override
	public synchronized void addObserver(Observer o) {
		for (Panel panel : panelList) {
			panel.addObserver(o);
		}
	}
	
	public void addPanel(Panel newPanel) {
		panelList.add(newPanel) ;
	}

	public void removeFrom(JPanel parentPanel) {
		parentPanel.remove(compoundJPanel) ;
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

	@Override
	public void updatecalculatedField(HashMap<String, Result> symbols) {
		for (Panel panel : panelList) {
			panel.updatecalculatedField(symbols) ;
		}
	}
	public void  setVisible(boolean visible) {
		compoundJPanel.setVisible(visible) ;		
	}
}
