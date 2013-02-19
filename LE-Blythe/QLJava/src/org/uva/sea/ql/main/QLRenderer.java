package org.uva.sea.ql.main;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.checker.Error;
import org.uva.sea.ql.checker.VisitorStatementChecker;
import org.uva.sea.ql.gui.VisitorRenderStatement;

public class QLRenderer extends QLProgramBase {

	public QLRenderer(){
		super();
	}
	
	@Override
	protected void execute(Statement ast) {
		
		Form form = (Form)ast;
		
		VisitorStatementChecker checker = new VisitorStatementChecker();
		boolean succeeded = form.accept(checker);
		
		if(succeeded){
			VisitorRenderStatement.Render(form, 500, 500);
		}
		else{
			for(Error e: checker.getErrors()){
				out.printf(e.getMessage());
			}
		}
	}

	
	public static void main(String[] args){
		new QLRenderer().start(args);
	}



}
