package khosrow.uva.sea.ql.ui.controls;

import java.awt.Component;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class PanelControl extends Control {
	private final JPanel component;
	private MigLayout layout;

	public PanelControl() {
		component = new JPanel();
		layout = new MigLayout();	
	    component.setLayout(layout);		
	}
	
	public void addControl (Control ctr) {	
	
		component.add(ctr.getComponent());
	}
	
	public void addLabel (LabelControl ctr) {		
		component.add(ctr.getComponent(),"width 300");
	}
	
	public void addSubPanel (PanelControl ctr) {		
		component.add(ctr.getComponent(), "dock north");
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

	public MigLayout getLayout() {
		return layout;
	}

	public void setLayout(MigLayout layout) {
		this.layout = layout;
	}	
}
