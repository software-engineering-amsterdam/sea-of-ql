package org.uva.sea.ql.evaluator;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.Observable;
import org.uva.sea.ql.Observer;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.evaluator.value.Value;

public class ComputedObserver implements Observer {
	private final JComponent component;
	private final Environment environment;
	private final QuestionComputed question;

	public ComputedObserver( JComponent component, Environment environment, QuestionComputed question ) {
		this.component = component;
		this.environment = environment;
		this.question = question;
	}

	@Override
	public void update( Observable observable ) {
		Value value = this.question.getExpression().accept( new Evaluator( this.environment ) );
		this.environment.assign( question.getIdent(), value );
		this.environment.notifyObservers( this.question.getIdent() );

		if ( this.component instanceof JCheckBox ) {
			( (JCheckBox) this.component ).setSelected( ( (org.uva.sea.ql.evaluator.value.Boolean) value ).getValue() );
		}
		else if ( this.component instanceof JTextField ) {
			( (JTextField) this.component ).setText( String.valueOf( value.getValue() ) );
		}
	}
}
