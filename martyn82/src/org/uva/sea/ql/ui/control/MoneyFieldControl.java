package org.uva.sea.ql.ui.control;

import org.uva.sea.ql.visitor.evaluator.value.MoneyValue;

abstract public class MoneyFieldControl extends Control {
	@Override
	abstract public MoneyValue getValue();
}
