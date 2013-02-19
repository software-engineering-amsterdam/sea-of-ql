package khosrow.uva.sea.ql.ui.controls;

import java.awt.Component;

import javax.swing.JPanel;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.values.Value;

public class PanelWidget extends Control {
	private final JPanel component;

	public PanelWidget() {
		this.component = new JPanel();
	}
	
	@Override
	public Component getComponent(){
		return component;
	}
	
	@Override
	public void setValue(Value value) {
		throw new UnsupportedOperationException();		
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
	public void addListener(Ident name, Env env) {
		// TODO Auto-generated method stub		
	}

	@Override
	public <T> T accept(IControlVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}
}
