package org.uva.sea.ql.gui;

import java.awt.Component;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
        fireChangeEvent();
	}
	
	@Override
	public Component getComponent() {
		return txtfield;
	}

}
