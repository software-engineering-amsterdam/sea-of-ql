package org.uva.sea.ql.ui.control;

import org.uva.sea.ql.visitor.evaluator.value.IntegerValue;

abstract public class NumberFieldControl extends Control {
	@Override
	abstract public IntegerValue getValue();
}
