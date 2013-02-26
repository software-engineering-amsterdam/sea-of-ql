package org.uva.sea.ql.gui.misc;

import org.uva.sea.ql.parser.evaluator.result.Value;

public interface InputSource {

	Value getValue();
	void setDelegate(InputSourceDelegate delegate);
	InputSourceDelegate getDelegate();

}
