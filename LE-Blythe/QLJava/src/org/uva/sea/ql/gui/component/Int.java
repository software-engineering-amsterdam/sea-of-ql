package org.uva.sea.ql.gui.component;

import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Int extends TextField implements KeyListener{

	private static final long serialVersionUID = 1L;

	public Int(){
		this.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		char c = arg0.getKeyChar() ;
        
        if (!   ((c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE) 
            ||  (c== KeyEvent.VK_ENTER)      || (c == KeyEvent.VK_TAB) 
            ||  (Character.isDigit(c)))) 
        {
        	arg0.consume() ;
       } 
	}
	
	
}
