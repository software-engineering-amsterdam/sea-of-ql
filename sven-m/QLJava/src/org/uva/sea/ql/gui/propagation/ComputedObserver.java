package org.uva.sea.ql.gui.propagation;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.form.Computed;
import org.uva.sea.ql.gui.control.display.DisplayControl;
import org.uva.sea.ql.gui.misc.InputSource;
import org.uva.sea.ql.gui.misc.InputSourceDelegate;
import org.uva.sea.ql.gui.misc.ValueState;
import org.uva.sea.ql.parser.evaluator.ExpressionEvaluator;
import org.uva.sea.ql.parser.evaluator.result.Value;

public class ComputedObserver implements Observer, InputSource {
	private final Computed question;
	private final DisplayControl display;
	private final ValueState state;
	private InputSourceDelegate delegate;

	public ComputedObserver(Computed question, DisplayControl display,
			ValueState state)
	{
		this.question = question;
		this.display = display;
		this.state = state;
	}

	private ValueState getState() {
		return state;
	}
	
	private Computed getQuestion() {
		return question;
	}

	private DisplayControl getDisplay() {
		return display;
	}
	
	@Override
	public Value getValue() {
		ExpressionEvaluator eval = new ExpressionEvaluator(
				getState().getSymbolTable());
		
		return getQuestion().getExpression().accept(eval);
	}
	
	/* Observer */
	
	@Override
	public void update(Observable o, Object arg) {
		/* signal delegate that value has changed */
		signalDelegate();

		/* update UI */
		getDisplay().setValue(getValue());
	}
	
	
	/* Input Source */
	
	private void signalDelegate() {
		if (getDelegate() != null) {
			getDelegate().valueChanged(this);
		}
	}
	
	@Override
	public void setDelegate(InputSourceDelegate delegate) {
		this.delegate = delegate;
		signalDelegate();
	}

	@Override
	public InputSourceDelegate getDelegate() {
		return delegate;
	}

}
