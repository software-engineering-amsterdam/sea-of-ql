package khosrow.uva.sea.ql.ui.controls;

import java.awt.Component;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ui.State;
import khosrow.uva.sea.ql.values.Value;

public abstract class Control {		
	public abstract Component getComponent();	
	public abstract void setVisible(boolean isVisible);	
	public abstract void setEnabled(boolean isEnabled);	
	public void setValue(Value value) {
		throw new UnsupportedOperationException();
	}
	
	public void addListener(final Ident name, final State state) {
		throw new UnsupportedOperationException();
	}
	
	public <T> T accept(IControlVisitor<T> visitor) {
		throw new UnsupportedOperationException();
	}
}
