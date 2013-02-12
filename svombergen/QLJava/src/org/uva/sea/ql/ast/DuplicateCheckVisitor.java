package org.uva.sea.ql.ast;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.types.*;

public class DuplicateCheckVisitor extends Visitor {
	protected Map<Ident,Question> identQuestionMap = new HashMap<Ident, Question>();
	protected Messages 	errorMsgs = new Messages("Errors"), 
						warningMsgs = new Messages("Warnings");
	
	public void visit(Question q) {
		Expr e = q.getType().getExpr();
		
		if ( e != null)
			checkExpr(e);
		
		checkDuplicates(q);
	}
	
	private void checkExpr(Expr e) {
		e.accept(this);
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
