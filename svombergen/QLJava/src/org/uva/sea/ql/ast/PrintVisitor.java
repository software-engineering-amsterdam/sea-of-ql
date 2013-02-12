package org.uva.sea.ql.ast;

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
