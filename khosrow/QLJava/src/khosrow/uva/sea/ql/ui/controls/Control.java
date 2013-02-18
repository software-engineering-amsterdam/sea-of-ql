package khosrow.uva.sea.ql.ui.controls;

import java.awt.Component;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.values.Value;

public abstract class Control {		
	public abstract Component getComponent();
	public abstract void setValue(Value value);	
	public abstract void setVisible(boolean isVisible);	
	public abstract void setEnabled(boolean isEnabled);	
	public abstract void addListener(final Ident name, final Env env);
	public abstract <T> T accept(IControlVisitor<T> visitor);
}
