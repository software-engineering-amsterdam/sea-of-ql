package org.uva.sea.ql.gui.widget;

import java.awt.Component;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.ast.primitive.Str;

public class WidgetStr extends Widget implements KeyListener{

	private TextField txtfield;
	
	public WidgetStr(){
		super();
		txtfield = new TextField();
		txtfield.addKeyListener(this);
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
		return new Str(txtfield.getText());
	}

}
