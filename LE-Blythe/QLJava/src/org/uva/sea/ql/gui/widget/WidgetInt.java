package org.uva.sea.ql.gui.widget;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.primitive.Int;
import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.ast.primitive.Undefined;

public class WidgetInt extends Widget implements KeyListener{

	private JTextField txtfield;
	
	public WidgetInt(){
		super();
		txtfield = new JTextField();
		txtfield.addKeyListener(this);
	}
	
	
	private boolean legalChar(char c){
		return (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)  ||  (c== KeyEvent.VK_ENTER)  
				|| (c == KeyEvent.VK_TAB)  ||  (Character.isDigit(c));
	}

	private boolean empty(){
		return txtfield.getText().equals("");
	}
	
	private int parseInt() {
		String str = txtfield.getText();

		return str.length() > 0 ? Integer.parseInt(str) : 0;
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
		char c = arg0.getKeyChar() ;
        
        if (!legalChar(c)) {
        	arg0.consume() ;
        } 

	}
	
	@Override
	public Component getComponent() {
		return txtfield;
	}	
	
	@Override
	public Primitive getValue() {
		if(!empty())
			return new Int(parseInt() );
		
		return new Undefined();
	}

}
