package org.uva.sea.ql.ui.control;

import org.uva.sea.ql.value.MoneyValue;

abstract public class MoneyFieldControl extends InputControl {
	@Override
	abstract public MoneyValue getValue();
}
