package khosrow.uva.sea.ql.ui.controls;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

public class PanelControl extends Control {
	private final JPanel component;

	public PanelControl() {
		this.component = new JPanel();
	}
	
	public void addControl (Control ctr) {
		component.add(ctr.getComponent());
	}
	
	public void addLabel (LabelControl ctr) {
		component.add(ctr.getComponent(), BorderLayout.SOUTH);
	}
	
	@Override
	public Component getComponent(){
		return component;
	}	

	@Override
	public void setVisible(boolean isVisible) {
		component.setVisible(isVisible);		
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		component.setEnabled(isEnabled);
	}	
}
