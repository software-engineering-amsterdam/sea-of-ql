package org.uva.sea.ql.driver;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.nodevisitor.VisitorResult;



public class CompoundPanel implements VisitorResult {
	private JPanel compoundJPanel ;
	private List<Panel> panelList = new ArrayList<Panel>() ;
	
	public CompoundPanel() {
		compoundJPanel = new JPanel() ;
		compoundJPanel.setLayout(new MigLayout("",
				"[]", "[][][][][][][][][][][]"));

	}
	public void registerActionListener(ActionListener actionHandler) {
		for (Panel panel : panelList) {
			panel.registerActionListener(actionHandler);
		}
	}

	public void addPanel(Panel newPanel) {
		panelList.add(newPanel) ;
	}
	
	public void registerAt(JPanel parentPanel, int location) {

		parentPanel.add(compoundJPanel, "cell 0 0 , growx");
		
		int panelCount = 0 ;
		for (Panel panel : panelList) {
			panel.registerAt(compoundJPanel, panelCount++);
		}
	}
}
