package org.uva.sea.ql.questionnaire.ui.swing.control.visible;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.questionnaire.State;
import org.uva.sea.ql.questionnaire.ui.swing.control.AbstractControl;

public abstract class AbstractVisibleControl extends AbstractControl {

	protected boolean isChangeable;
	protected JPanel controlPanel;


	public AbstractVisibleControl(State state, Ident ident) {
		super(state, ident);
		this.controlPanel = new JPanel(new FlowLayout());
		controlPanel.setPreferredSize(new Dimension(350,40));
	}

	public abstract void setIsChangeable(boolean changeable);



	protected abstract void initEventListener(); 

	public JPanel getControlElement() {
		return this.controlPanel;
	}

}
