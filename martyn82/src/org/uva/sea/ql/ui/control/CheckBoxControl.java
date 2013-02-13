package org.uva.sea.ql.ui.control;

import org.uva.sea.ql.visitor.evaluator.value.BooleanValue;

abstract public class CheckBoxControl extends Control {
	@Override
	abstract public BooleanValue getValue();
}
