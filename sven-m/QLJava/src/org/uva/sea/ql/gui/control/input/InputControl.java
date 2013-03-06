package org.uva.sea.ql.gui.control.input;

import org.uva.sea.ql.gui.control.Control;
import org.uva.sea.ql.gui.misc.InputSource;
import org.uva.sea.ql.gui.misc.InputSourceDelegate;
import org.uva.sea.ql.parser.evaluator.result.Value;

public abstract class InputControl extends Control implements InputSource {
	private InputSourceDelegate delegate = null;

	public abstract Value getValue();

	/* Input Source */
	
	@Override
	public InputSourceDelegate getDelegate() {
		return delegate;
	}
	
	@Override
	public void setDelegate(InputSourceDelegate delegate) {
		this.delegate = delegate;
	}

	protected void signalDelegate() {
		if (getDelegate() != null) {
			getDelegate().valueChanged(this);
		}
	}

}
