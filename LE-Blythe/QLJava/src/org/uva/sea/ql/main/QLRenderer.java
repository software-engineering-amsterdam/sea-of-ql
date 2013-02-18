package org.uva.sea.ql.main;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.gui.VisitorRenderStatement;

public class QLRenderer extends QLProgramBase {

	public QLRenderer(){
		super();
	}
	
	@Override
	protected void execute(Statement ast) {
		VisitorRenderStatement.Render((Form)ast);
	}

	
	public static void main(String[] args){
		new QLRenderer().start(args);
	}



}
