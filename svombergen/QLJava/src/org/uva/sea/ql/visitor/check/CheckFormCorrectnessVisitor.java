package org.uva.sea.ql.visitor.check;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.primaryexpr.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.statements.types.*;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.IFormVisitor;
import org.uva.sea.ql.visitor.Messages;

public class CheckFormCorrectnessVisitor implements IFormVisitor {
	private Map<Ident,Question> identQuestionMap;
	private Messages 	errorMsgs, 
						warningMsgs;
	
	public CheckFormCorrectnessVisitor() {
		identQuestionMap = new HashMap<Ident, Question>();
		errorMsgs = new Messages("Errors"); 
		warningMsgs = new Messages("Warnings");
	}
	
	private void checkExpr(Expr e) {
		IExpressionVisitor ev = new TypeCheckExpressionVisitor(identQuestionMap, errorMsgs, warningMsgs);
		
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
	
	public Messages returnErrorMsgs() {
		return errorMsgs;
	}

	public Messages returnWarningMsgs() {
		return warningMsgs;
	}
	
	@Override
	public void visit(ComputableQuestion q) {
		Expr e = q.getExpression();
		
		if ( e != null)
			checkExpr(e);
		else
			errorMsgs.add(String.format("No condition in Question: %s", q));
		
		checkDuplicates(q);
	}
	
	@Override
	public void visit(AnswerableQuestion q) {
		checkDuplicates(q);
	}
	
	@Override
	public void visit(IfStatement ifStat) {
		Expr cond = ifStat.getCondition();
		IExpressionVisitor iev = new TypeCheckExpressionVisitor(identQuestionMap, errorMsgs, warningMsgs);
		cond.accept(iev);
		
		for(Statement s : ifStat.getStatements())
			s.accept(this);
	}

	@Override
	public void visit(Form f) {
		for(Statement s : f.getStatements())
			s.accept(this);
	}
}
