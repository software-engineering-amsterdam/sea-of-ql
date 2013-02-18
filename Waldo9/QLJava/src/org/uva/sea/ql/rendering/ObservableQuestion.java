package org.uva.sea.ql.rendering;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;

import org.uva.sea.ql.ast.statements.Question;

public class ObservableQuestion extends Observable implements FocusListener {

	private final Question question;
	
	public ObservableQuestion(Question question) {
		this.question = question;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}	

}
