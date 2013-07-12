package org.uva.sea.ql.visitor.check;

import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.primaryexpr.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.statements.types.*;
import org.uva.sea.ql.gui.Environment;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.IFormVisitor;
import org.uva.sea.ql.visitor.Messages;

public class CheckFormCorrectnessVisitor implements IFormVisitor<Boolean> {
	private Environment environment;
	private Messages 	errorMsgs, 
						warningMsgs;
	
	public CheckFormCorrectnessVisitor() {
		environment = new Environment();
		errorMsgs = new Messages("Errors"); 
		warningMsgs = new Messages("Warnings");
	}
	
	private boolean checkExpr(Expr e) {
		IExpressionVisitor<Boolean> ev = new TypeCheckExpressionVisitor(environment, errorMsgs, warningMsgs);
		
		return e.accept(ev);
	}
	
	public Environment getFormEnvironment() {
		return environment;
	}

	private boolean checkDuplicates(Question q) {
		Str qString = q.getQuestionString();
		Ident id = q.getIdent();
		Type t = q.getType();
		
		for (Question foreachQuestion : environment.values()) {
			if ( foreachQuestion.getQuestionString().equals(qString) ) {
				if (foreachQuestion.getType() == t)
					warningMsgs.add(String.format("Duplicate question: %s",qString));
				else
					errorMsgs.add(String.format("Duplicate question with different types: %s",qString));
				
				return false;
			}
		}
		
		if ( environment.containsKey(id) ) {
			errorMsgs.add(String.format("Duplicate Ident: %s", id));
			return false;
		}
		else {
			environment.put(id, q);
			return true;
		}
	}
	
	public Messages returnErrorMsgs() {
		return errorMsgs;
	}

	public Messages returnWarningMsgs() {
		return warningMsgs;
	}
	
	@Override
	public Boolean visit(ComputableQuestion q) {
		Expr e = q.getExpression();
		
		if (e == null) {
			errorMsgs.add(String.format("No condition in Question: %s", q));
			return false;
		}
		
		return checkExpr(e) && checkDuplicates(q);
	}
	
	@Override
	public Boolean visit(AnswerableQuestion q) {
		return checkDuplicates(q);
	}
	
	@Override
	public Boolean visit(IfStatement ifStat) {
		Expr cond = ifStat.getCondition();
		IExpressionVisitor<Boolean> iev = new TypeCheckExpressionVisitor(environment, errorMsgs, warningMsgs);
		
		return cond.accept(iev) && visitStatements(ifStat.getStatements());
	}

	@Override
	public Boolean visit(Form f) {
		return visitStatements(f.getStatements());
	}
	
	public boolean visitStatements(List<Statement> statements) {
		for(Statement s : statements) {
			if (!s.accept(this))
				return false;
		}
		return true;
	}
}
