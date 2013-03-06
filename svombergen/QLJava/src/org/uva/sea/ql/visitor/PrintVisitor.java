package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statements.IfStatement;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.statements.Statement;

public class PrintVisitor extends Visitor {
	
	public PrintVisitor(){
		;
	}
	
	@Override
	public void visit(Question q){
		System.out.println("Visiting " + q.getIdent());
	}
	
	@Override
	public void visit(IfStatement ifStat){
		for(Statement s : ifStat.getStatements())
			s.accept(this);
		System.out.println("Visiting if " + ifStat.getCondition());
	}
}
