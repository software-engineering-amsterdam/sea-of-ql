package org.uva.sea.ql.ast;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stmnt.Body;
import org.uva.sea.ql.ast.stmnt.ComputedQuestion;
import org.uva.sea.ql.ast.stmnt.Form;
import org.uva.sea.ql.ast.stmnt.IfStatement;
import org.uva.sea.ql.ast.stmnt.Question;
import org.uva.sea.ql.ast.stmnt.Statement;
import org.uva.sea.ql.ast.types.Type;

public class StatementChecker implements IStatementChecker {
	
	private final Map<String, Type> typeEnvironment;
	private List<String> errors;
	
	public StatementChecker(Map<String, Type> typeEnvironment, List<String> errors) {
		
			this.typeEnvironment = typeEnvironment;
			this.errors = errors;
	}
	
	public boolean check(Form form, Map <String, Type> typeEnvironment, List<String> errors) {
		
		StatementChecker stmntChecker = new StatementChecker(typeEnvironment, errors);
		
		return form.accept(stmntChecker);
		
	}
	
	@Override
	public boolean visit(Form form) {
		
		Ident id = form.getID();
		boolean checkBody = form.getBody().accept(this);
		
		if(!checkBody) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean visit(Question question) {
		
		Ident qID = question.getID();
			
		if (typeEnvironment.containsKey(qID.getName())) {
			errors.add("Duplicate questionID : " + qID.getName());
			//System.out.println("miltos");
			return false;
		}
		else {
			typeEnvironment.put(qID.getName(), question.getType());
		}
		
		return true;
	}

	@Override
	public boolean visit(ComputedQuestion computedQuestion) {
		
		Ident qID = computedQuestion.getID();
		Expr expr = computedQuestion.getExpr(); 
				
		if (typeEnvironment.containsKey(qID.getName())) {
			errors.add("Duplicate questionID : " + qID.getName());
			return false;
		}
		else {
			typeEnvironment.put(qID.getName(), computedQuestion.getType());
		}
		
		boolean checkExpr = ExprTypeChecker.check(expr, typeEnvironment, errors);
		
		if (!checkExpr) {
			errors.add("ERROR");
			return false;
		}
		
		return true;
	}

	@Override
	public boolean visit(IfStatement ifStatement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Body body) {
		
		List<Statement> statements = body.getStatements();
		boolean checkStatement = true;
		
		for (Statement statement : statements) {
			checkStatement = statement.accept(this);
			if(!checkStatement) {
				return false;
			}
		}
		
		return true;
	}

	
}

	