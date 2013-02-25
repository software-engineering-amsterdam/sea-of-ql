package org.uva.sea.ql.visitor.eval.ui.statement;

import javax.swing.JLabel;

import org.uva.sea.ql.visitor.eval.Environment;
import org.uva.sea.ql.visitor.eval.ui.type.Widget;

public class Question extends Panel {

	private static final long serialVersionUID = -4189122396634678285L;
	private final Widget widget;

	public Question(Environment environment, java.lang.String label,
			Widget widget) {
		super(environment);
		this.widget = widget;

		this.add(new JLabel(label));
		this.add(widget.getComponent());
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		this.widget.setReadOnly(!enabled);
	}

}
