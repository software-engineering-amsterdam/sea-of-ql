package org.uva.sea.ql.interpreter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.interpreter.controls.AControl;

public class ObservableQuestion extends Observable implements ActionListener, KeyListener {
	private final Question stmt;
	private final State state;
	private final AControl ctrl;
	
	public ObservableQuestion(Question stmt, State state, AControl ctrl) {
		this.stmt = stmt;
		this.state = state;
		this.ctrl = ctrl;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		update();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		update();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}
	
	public void update() {
		state.putValue(stmt.getIdent(), ctrl.getValue());
		this.setChanged();
		this.notifyObservers();
	}
}