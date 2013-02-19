package org.uva.sea.ql.questionnaire.ui.swing.control.visible;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Arr;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.questionnaire.State;

public class ArrControl extends AbstractVisibleControl {
	private JComboBox comboBox;
	private final Arr arr;

	//control which contains combo box to chose one of the possible answers
	public ArrControl(State state, Ident ident, Arr arr) {
		super(state, ident);
		this.arr = arr;

		this.comboBox = new JComboBox(this.arr.getValues().toArray());
		this.comboBox.setSelectedIndex(0);
		this.controlPanel.add(comboBox);
		initEventListener();
	}

	@Override
	public void setIsChangeable(boolean changeable) {
		this.isChangeable = changeable;

	}

	@Override
	protected void initEventListener() {
		this.comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				Value val = (Value) cb.getSelectedItem();
				setValue(val);
			}
		});
	}

	@Override
	public void setValue(Value value) {
		setChanged();
		state.putValue(this.ident, value);
		state.notify(this.ident);
	}

}
