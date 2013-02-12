package org.uva.sea.ql.ui;

import org.uva.sea.ql.ui.control.CheckBoxControl;
import org.uva.sea.ql.ui.control.LabelControl;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.ui.control.TextFieldControl;
import org.uva.sea.ql.ui.control.WindowControl;

abstract public class ControlFactory {
	abstract public CheckBoxControl createCheckBox();
	abstract public TextFieldControl createTextBox();
	abstract public PanelControl createPanel();
	abstract public WindowControl createWindow( String title, PanelControl panel );
	abstract public LabelControl createLabel( String text );
}
