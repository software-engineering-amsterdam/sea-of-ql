package org.uva.sea.ql.ui.swing;

import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.CheckBoxControl;
import org.uva.sea.ql.ui.control.LabelControl;
import org.uva.sea.ql.ui.control.MoneyFieldControl;
import org.uva.sea.ql.ui.control.NumberFieldControl;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.ui.control.TextFieldControl;
import org.uva.sea.ql.ui.control.WindowControl;

public class SwingControlFactory extends ControlFactory {
	@Override
	public CheckBoxControl createCheckBox() {
		return new JCheckBoxControl();
	}

	@Override
	public MoneyFieldControl createMoneyBox() {
		return new JMoneyFieldControl();
	}

	@Override
	public NumberFieldControl createNumberBox() {
		return new JNumberFieldControl();
	}

	@Override
	public TextFieldControl createTextBox() {
		return new JTextFieldControl();
	}

	@Override
	public PanelControl createPanel() {
		return new JPanelControl();
	}

	@Override
	public WindowControl createWindow( String title, PanelControl panel ) {
		return new Window( title, panel );
	}

	@Override
	public LabelControl createLabel( String text ) {
		return new JLabelControl( text );
	}
}
