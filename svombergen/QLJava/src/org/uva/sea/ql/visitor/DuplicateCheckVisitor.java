package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.primaryexpr.Ident;
import org.uva.sea.ql.ast.primaryexpr.Str;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.statements.types.*;

public class DuplicateCheckVisitor extends Visitor {
	
	public DuplicateCheckVisitor() {
		super();
	}
	
	public void visit(ComputableQuestion q) {
		Expr e = q.getExpression();
		
		if ( e != null)
			checkExpr(e);
		
		checkDuplicates(q);
	}
	
	public void visit(AnswerableQuestion q) {
		checkDuplicates(q);
	}
	
	private void checkExpr(Expr e) {
		ExpressionVisitor ev = new ExpressionVisitor(identQuestionMap, errorMsgs, warningMsgs);
		
		e.accept(ev);
	}

	private void checkDuplicates(Question q) {
		Str qString = q.getQuestionString();
		Ident id = q.getIdent();
		Type t = q.getType();
		
		for (Question foreachQuestion : identQuestionMap.values()) {
			if ( foreachQuestion.getQuestionString() == qString ) {
				if (foreachQuestion.getType() == t)
					warningMsgs.add(String.format("Duplicate question: %s",qString));
				else
					errorMsgs.add(String.format("Duplicate question with different types: %s",qString));
			}
		}
		
		if ( identQuestionMap.containsKey(id) )
			errorMsgs.add(String.format("Duplicate Ident: %s", id));
		else
			identQuestionMap.put(id, q);
	}
	
	public void visit(IfStatement ifStat) {
		Expr cond = ifStat.getCondition();
		
		cond.accept(this);
		
		for(Statement s : ifStat.getStatements())
			s.accept(this);
	}
	
	public Messages returnErrorMsgs(){
		return errorMsgs;
	}
	
	public Messages returnWarningMsgs(){
		return warningMsgs;
	}

}
