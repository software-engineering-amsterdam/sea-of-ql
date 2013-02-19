package khosrow.uva.sea.ql.ui.controls;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.values.BoolVal;
import khosrow.uva.sea.ql.values.Value;

public class BoolWidget extends Control{
	private final JCheckBox component;
	
	public BoolWidget(){
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
	public void addListener(final Ident name, final Env env) {
		component.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				env.assignValue(name, getBoolVal());				
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
