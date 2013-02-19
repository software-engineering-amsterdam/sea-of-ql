package org.uva.sea.ql.rendering.controls;

import javax.swing.JComponent;

import org.uva.sea.ql.evaluation.values.Value;

public abstract class Control {

	public abstract Value getValue();
	public abstract JComponent getControl();

}
