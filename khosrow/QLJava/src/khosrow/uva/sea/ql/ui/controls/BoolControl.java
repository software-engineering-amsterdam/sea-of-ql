package khosrow.uva.sea.ql.ui.controls;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ui.State;
import khosrow.uva.sea.ql.values.BoolVal;
import khosrow.uva.sea.ql.values.Value;

public class BoolControl extends Control{
	private final JCheckBox component;
	
	public BoolControl(){
		this.component = new JCheckBox();
	}
	
	@Override
	public Component getComponent(){
		return component;
	}

	@Override
	public void setValue(Value value) {
		component.setSelected(((BoolVal)value).getValue());		
	}

	@Override
	public void setVisible(boolean isVisible) {
		component.setVisible(isVisible);		
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		component.setEnabled(isEnabled);
		
	}

	@Override
	public void addListener(final Ident name, final State state) {
		component.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				state.assignValue(name, getBoolVal());	
				//state.notifyObervers(name);			
			}			
		});	
	}
	
	private BoolVal getBoolVal() {
		return new BoolVal(component.isSelected());
	}

	@Override
	public <T> T accept(IControlVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
