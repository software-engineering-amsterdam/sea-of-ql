package org.uva.sea.ql.gui.control.input;

import org.uva.sea.ql.gui.InputSource;
import org.uva.sea.ql.gui.InputSourceDelegate;
import org.uva.sea.ql.gui.control.Control;
import org.uva.sea.ql.parser.evaluator.result.Value;

public abstract class InputControl extends Control implements InputSource {
	private InputSourceDelegate delegate;
	
	public abstract Value getValue();
	
	public void setDelegate(InputSourceDelegate delegate) {
		this.delegate = delegate;
	}
	
	public InputSourceDelegate getDelegate() {
		return delegate;
	}
	
	protected void signalDelegate() {
		getDelegate().valueChanged(this);
	}

}
