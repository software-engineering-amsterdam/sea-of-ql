package org.uva.sea.ql.form.gui.components.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.form.gui.state.State;
import org.uva.sea.ql.values.VBool;

public class CheckBoxListener implements ActionListener {
	
	private final State state;
	private final Ident ident;
	
	public CheckBoxListener(Ident ident, State state){
		this.ident = ident;
		this.state = state;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox cb = (JCheckBox) e.getSource();
        boolean selected = cb.isSelected();
        state.putValue(ident, new VBool(selected));
		state.notify(ident);
	}
}
