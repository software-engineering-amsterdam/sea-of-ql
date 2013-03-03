package org.uva.sea.ql.visitor.ui.widgets;

import java.awt.Component;

import javax.swing.JCheckBox;

public class CheckboxWidget extends BaseWidget {

	private static final long serialVersionUID = 2789085532540606840L;
	
	public CheckboxWidget(String description) {
		super(description);
	}

	@Override
	protected Component getControlComponent() {
		return new JCheckBox();
	}

}
