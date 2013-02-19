package org.uva.sea.ql.questionnaire.ui.swing.control.visible;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Bool;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.questionnaire.State;

public class BoolControl extends AbstractVisibleControl {
	
	private final ButtonGroup radioButtonGroup;
	private final JRadioButton trueButton, falseButton;

	//control containing radio buttons for true or false
	public BoolControl(State state, Ident ident) {
		super(state, ident);
		this.trueButton = new JRadioButton("yes");
		this.falseButton = new JRadioButton("no");
		this.radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(trueButton);
		radioButtonGroup.add(falseButton);
		this.controlPanel.add(trueButton);
		this.controlPanel.add(falseButton);
		initEventListener();
	}

	@Override
	public String toString() {
		return "BoolControl Ident(" + this.ident.toString() + ")";
	}

	@Override
	public void setIsChangeable(boolean changeable) {
		this.trueButton.setEnabled(changeable);
		this.falseButton.setEnabled(changeable);
	}

	@Override
	public void setValue(Value value) {

		if (value.isDefined() && value.typeOf(null).isCompatibleToBool()) {
			if (!isChangeable) {
				trueButton.setSelected((Boolean) value.getValue());
				falseButton.setSelected(!(Boolean) value.getValue());
			}
			setChanged();
			state.putValue(this.ident, value);
			state.notify(this.ident);
		}

	}

	@Override
	public void initEventListener() {
		this.trueButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setValue(new Bool(trueButton.isSelected()));
			}
		});
		this.falseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setValue(new Bool(trueButton.isSelected()));
			}
		});
	}

}
