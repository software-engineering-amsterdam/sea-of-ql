package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.statements.*;

public class PrintVisitor implements IFormVisitor {
	
	public PrintVisitor(){
		;
	}
	
	@Override
	public void visit(IfStatement ifStat){
		for(Statement s : ifStat.getStatements())
			s.accept(this);
		System.out.println("Visiting if " + ifStat.getCondition());
	}

	@Override
	public void visit(Form f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ComputableQuestion q) {
		System.out.println("Visiting " + q.getIdent());
	}

	@Override
	public void visit(AnswerableQuestion q) {
		System.out.println("Visiting " + q.getIdent());
	}
}
