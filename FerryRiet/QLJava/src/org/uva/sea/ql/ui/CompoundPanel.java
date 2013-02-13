package org.uva.sea.ql.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.operatorresults.Result;

public class CompoundPanel extends Panel {
	private JPanel compoundJPanel;
	private List<Panel> panelList = new ArrayList<Panel>();

	public CompoundPanel() {
		compoundJPanel = new JPanel();
		compoundJPanel.setBorder(new EmptyBorder(0, 0, 0, 0) );
		compoundJPanel.setLayout(new MigLayout("", "0[]0", "0[18]0"));
	}

	@Override
	public synchronized void addObserver(Observer o) {
		for (Panel panel : panelList) {
			panel.addObserver(o);
		}
	}

	public void addPanel(Panel newPanel) {
		panelList.add(newPanel);
	}

	public void removeFrom(JPanel parentPanel) {
		parentPanel.remove(compoundJPanel);
	}

	@Override
	public void registerAt(JPanel parentPanel, int location) {

		String result = String.format("cell 0 %d ,growx", location) ;

		parentPanel.add(compoundJPanel, result);

		int panelCount = 0;
		for (Panel panel : panelList) {
			panel.registerAt(compoundJPanel, panelCount++);
		}
	}

	@Override
	public void updatecalculatedField(Map<String, Result> symbols) {
		for (Panel panel : panelList) {
			panel.updatecalculatedField(symbols);
		}
	}

	public void setVisible(boolean visible) {
		compoundJPanel.setVisible(visible);
	}
}
