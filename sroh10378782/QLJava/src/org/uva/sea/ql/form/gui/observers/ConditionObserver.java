package org.uva.sea.ql.form.gui.observers;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import org.uva.sea.ql.ast.nodes.expressions.Expr;
import org.uva.sea.ql.form.gui.state.State;
import org.uva.sea.ql.form.output.visitor.QLEvalVisitor;
import org.uva.sea.ql.values.Value;
import org.uva.sea.ql.values.VBool;


public class ConditionObserver implements Observer {
	
	private final Expr condition;
	private final State state;
	private final JPanel ifControl;
	private final JPanel elseControl;

	public ConditionObserver(Expr condition, State state, JPanel ifControl, JPanel elseControl){
		this.condition = condition;
		this.state = state;
		this.ifControl = ifControl;
		this.ifControl.setVisible(true);
		this.elseControl = elseControl;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Value value = condition.accept(new QLEvalVisitor(state.getValueEnv()));
		boolean visible = value.isDefined() && ((VBool)value).getValue();
		ifControl.setVisible(visible);
		ifControl.repaint();
		if(elseControl != null) {
		 	elseControl.setVisible(!visible);
		}
	}
}
