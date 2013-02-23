package org.uva.sea.ql.gui.widget;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.ast.primitive.Str;
import org.uva.sea.ql.ast.primitive.Undefined;

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
	public Component getComponent() {
		return txtfield;
	}

	@Override
	public Primitive getValue() {
		if(!empty())
			return new Str(txtfield.getText());
		
		return new Undefined();
	}

}