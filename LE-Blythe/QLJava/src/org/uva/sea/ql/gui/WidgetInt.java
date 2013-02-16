package org.uva.sea.ql.gui;

import java.awt.Component;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WidgetInt extends Widget implements KeyListener{

	private TextField txtfield;
	
	public WidgetInt(){
		super();
		txtfield = new TextField();
		txtfield.addKeyListener(this);
	}
	
	
	private boolean legalChar(char c){
		return (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)  ||  (c== KeyEvent.VK_ENTER)  
				|| (c == KeyEvent.VK_TAB)  ||  (Character.isDigit(c));
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		char c = arg0.getKeyChar() ;
        
        if (!legalChar(c)) {
        	arg0.consume() ;
        } 
        
        fireChangeEvent();
	}
	
	@Override
	public Component getComponent() {
		return txtfield;
	}

}
