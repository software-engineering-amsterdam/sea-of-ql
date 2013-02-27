package org.uva.sea.ql.ui.control;

import org.uva.sea.ql.value.IntegerValue;

abstract public class NumberFieldControl extends InputControl {
	@Override
	abstract public IntegerValue getValue();
}
