package org.uva.sea.ql.visitor.eval;

import org.uva.sea.ql.visitor.eval.ui.Widget;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class IdentContext {

	private final Widget widget;

	private AbstractValue value;

	public IdentContext(Widget widget) {
		this.widget = widget;
	}

	public Widget getWidget() {
		return this.widget;
	}

	public AbstractValue getValue() {
		return this.value;
	}

}
