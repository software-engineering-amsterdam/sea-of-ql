package org.uva.sea.ql.ui.control;

import org.uva.sea.ql.value.StringValue;

abstract public class TextFieldControl extends InputControl {
	@Override
	abstract public StringValue getValue();
}
