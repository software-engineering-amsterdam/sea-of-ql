package org.uva.sea.ql.gui.widget;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.eval.value.StrVal;
import org.uva.sea.ql.eval.value.UndefinedVal;
import org.uva.sea.ql.eval.value.Value;

public class WidgetStr extends Widget implements KeyListener{

	private JTextField txtfield;
	
	public WidgetStr(){
		super();
		txtfield = new JTextField();
		txtfield.addKeyListener(this);
	}

	
	private boolean empty(){
		return txtfield.getText().equals("");
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
        fireChangeEvent();
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	
	@Override
	public JComponent getControl() {
		return txtfield;
	}

	@Override
	public Value getValue() {
		if(!empty())
			return new StrVal(txtfield.getText());
		
		return new UndefinedVal();
	}

}
