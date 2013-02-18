package org.uva.sea.ql.ui.control;

import org.uva.sea.ql.visitor.evaluator.value.StringValue;

abstract public class TextFieldControl extends Control {
	@Override
	abstract public StringValue getValue();
}
