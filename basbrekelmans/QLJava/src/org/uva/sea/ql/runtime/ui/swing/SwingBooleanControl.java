package org.uva.sea.ql.runtime.ui.swing;

import java.awt.Component;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.uva.sea.ql.runtime.Variable;
import org.uva.sea.ql.runtime.ui.IBooleanControl;
import org.uva.sea.ql.runtime.values.BooleanValue;
import org.uva.sea.ql.runtime.values.Value;

class SwingBooleanControl implements IBooleanControl<JComponent> {

	private final Variable variable;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton yes, no;

	public SwingBooleanControl(final Variable variable) {
		this.variable = variable;
		this.initializeComponent();
		this.setEnabled(true);
		this.initializeVariable();
	}

	@Override
	public JComponent getUnderlyingComponent() {
		return this.contentPane;
	}

	private void initializeComponent() {
		// copy pasted from window designer
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BoxLayout(this.contentPane,
				BoxLayout.X_AXIS));

		this.yes = new JRadioButton("Yes");
		this.yes.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(final ChangeEvent arg0) {
				SwingBooleanControl.this.onValueChanged();
			}

		});
		this.buttonGroup.add(this.yes);
		this.yes.setAlignmentX(Component.RIGHT_ALIGNMENT);
		this.contentPane.add(this.yes);

		this.no = new JRadioButton("No");
		this.buttonGroup.add(this.no);
		this.no.setAlignmentX(Component.RIGHT_ALIGNMENT);
		this.contentPane.add(this.no);

	}

	private void initializeVariable() {
		this.updateUI();
		this.variable.addObserver(new Observer() {

			@Override
			public void update(final Observable o, final Object arg) {

				SwingBooleanControl.this.updateUI();

			}

		});
	}

	@Override
	public boolean isEnabled() {
		return this.yes.isEnabled();
	}

	private void onValueChanged() {
		if (this.isEnabled()) {
			this.variable.setValue(new BooleanValue(this.yes.isSelected()));
		}

	}

	@Override
	public void setEnabled(final boolean value) {
		this.yes.setEnabled(value);
		this.no.setEnabled(value);

	}

	private void setValue(final boolean value) {
		this.yes.setSelected(value);
		this.no.setSelected(!value);
	}

	private void updateUI() {
		if (!this.isEnabled()) {
			final Value value = this.variable.getValue();
			if (value == Value.UNSET_VALUE) {
				this.buttonGroup.clearSelection();
			} else {
				final BooleanValue booleanValue = (BooleanValue) value;
				this.setValue(booleanValue.getValue());
			}
		}

	}
}
