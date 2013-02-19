package org.uva.sea.ql.questionnaire.ui.swing.control.visible;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.questionnaire.State;

public abstract class KeyControl extends AbstractVisibleControl {

	private final JTextField control;

	public KeyControl(State state, Ident ident) {
		super(state, ident);
		control = new JTextField();
		control.setPreferredSize(new Dimension(200, 30));
		this.controlPanel.add(control);
		initEventListener();
	}

	@Override
	public String toString() {
		return "abstract KeyControl Ident(" + this.ident.toString() + ")";
	}

	@Override
	public void setIsChangeable(boolean changeable) {
		this.control.setEnabled(changeable);
	}

	@Override
	public void setValue(Value value) {
		setChanged();
		this.state.putValue(this.ident, value);
		this.state.notify(this.ident);
		if (value.isDefined()) {
			control.setText(value.getValue().toString());
		}

	}

	protected abstract void handleKeyPressed(String input);

	@Override
	public void initEventListener() {

		this.control.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				handleKeyPressed(control.getText());

			}

			@Override
			public void focusGained(FocusEvent arg0) {

			}
		});
		this.control.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					handleKeyPressed(control.getText());
				}
			}
		});

	}

}