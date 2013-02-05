package org.uva.sea.ql.visitors;

import java.util.Observable;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.IntLiteral;
import org.uva.sea.ql.ast.expr.value.MoneyLiteral;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.ast.formelements.CompQuestion;

public class ComputedObserver {

	private final JComponent component;
	private final State state;
	private final CompQuestion element;
	
	public ComputedObserver( JComponent component, State state, CompQuestion element ) {
		this.component = component;
		this.state = state;
		this.element = element;
	}
	
	
	public void setValue(JComponent component, Value value){
		if ( component instanceof JCheckBox ) {
			( (JCheckBox) component ).setSelected( ( (BoolLiteral) value ).getValue() );
		}
		else if ( component instanceof JTextField ) {
			if (value.isIntLiteral()){
				( (JTextField) component ).setText( String.valueOf( ( (IntLiteral) value ).getValue() ) );
			}
			if (value.isMoneyLiteral()){
				( (JTextField) component ).setText( String.valueOf( ( (MoneyLiteral) value ).getValue() ) );
			}
			if (value.isMoneyLiteral()){
				( (JTextField) component ).setText( ( (StringLiteral) value ).getValue() );
			}
		}
	}
	
	/* need to implement observer/observalble
	@Override
	public void update(Observable o) {
	Value value = element.getQuestionExpr().accept(new ExprEvaluator(state.getEnv()));
	state.setValue(element.getQuestionName().getName(), value);
	state.notify(element.getQuestionName().getName());
	setValue(component, value);
	} */
}
