package org.uva.sea.ql.gui.widget;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.ast.primitive.Str;
import org.uva.sea.ql.ast.primitive.Undefined;
import org.uva.sea.ql.gui.control.Control;
import org.uva.sea.ql.gui.control.TextField;

public class WidgetStr extends Widget implements KeyListener{

	private TextField txtfield;
	
	public WidgetStr(){
		super();
		txtfield = new TextField();
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
	public Control getControl() {
		return txtfield;
	}

	@Override
	public Primitive getValue() {
		if(!empty())
			return new Str(txtfield.getText());
		
		return new Undefined();
	}

}
