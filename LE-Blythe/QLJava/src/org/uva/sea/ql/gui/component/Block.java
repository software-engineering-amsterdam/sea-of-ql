package org.uva.sea.ql.gui.component;

import java.awt.AWTEvent;
import java.util.List;

import org.uva.sea.ql.util.Environment;

public class Block extends Statement {

	private static final long serialVersionUID = 1L;
	
	private List<Statement> statements;
	
	public Block(List<Statement> statements, Environment environment){
		super(environment);
		this.statements = statements;
		
		for(Statement s: statements){
			this.add(s);
		}
	}

	
	/*@Override
	public boolean handleEvent(Event event) {
		for(Statement s : statements){
			s.evaluateVisibility();
		}
		
		return true; //event is handled
	}*/
	
	@Override
	protected void processEvent(AWTEvent e){
		evaluateVisibility();
	}


	@Override
	public boolean evaluateVisibility() {
		
		for(Statement s : statements){
			s.evaluateVisibility();
		}
		
		return true;
	}
	

	
}
