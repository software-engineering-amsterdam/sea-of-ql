package org.uva.sea.ql.ast.statements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.ExprTypeCheckingVisitor;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;

public class StatementTypeCheckingVisitor implements StatementVisitor<Boolean> {
	
	private Map<String, Type> typeEnvironment;
	private List<String> errorMessages;
	private ExprTypeCheckingVisitor exprTypeCheckingVisitor;
	
	public StatementTypeCheckingVisitor() {
		typeEnvironment = new HashMap<String, Type>();
		errorMessages = new ArrayList<String>();
		exprTypeCheckingVisitor = new ExprTypeCheckingVisitor(typeEnvironment, errorMessages);
	}
	
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	@Override
	public Boolean visit(Block block) {
		boolean isValid = true;
		for (Statement statement : block.getStatements()) {
			boolean checkStatement = statement.accept(this);
			if (!checkStatement)
				isValid = false;
		}
		return isValid;	
	}

	@Override
	public Boolean visit(IfThenElse ifThenElse) {
		boolean isValid = true;
		boolean checkBody = ifThenElse.getBody().accept(this);
		Expr condition = ifThenElse.getCondition();
		boolean checkCondition = condition.accept(exprTypeCheckingVisitor);
		if (!checkCondition)
			isValid = false;
		if (!condition.typeOf(typeEnvironment).isCompatibleToBool()) {
			if (isValid) {
				errorMessages.add("The condition of an if statement has to be a boolean.");
				isValid = false;
			}
		}
		if (!checkBody)
			isValid = false;
		Block elseBody = ifThenElse.getElseBody();
		if (elseBody != null)
			if (!elseBody.accept(this))
				isValid = false;				
		return isValid;		
	}

	@Override
	public Boolean visit(Question question) {
		Ident identifier = question.getVariable();
		if (typeEnvironment.get(identifier.getName()) != null) {
			errorMessages.add("Identifier " + identifier.getName() + " can only be used once.");
			return false;
		}
		else
			typeEnvironment.put(identifier.getName(), question.getType());
		return true;
	}
	
	@Override
	public Boolean visit(ComputedQuestion computedQuestion) {
		boolean isValid = true;
		Ident identifier = computedQuestion.getVariable();
		if (typeEnvironment.get(identifier.getName()) != null) {
			errorMessages.add("Identifier " + identifier.getName() + " can only be used once.");
			isValid = false;
		}
		else
			typeEnvironment.put(identifier.getName(), computedQuestion.getType());
		boolean checkExpression = computedQuestion.getExpression().accept(exprTypeCheckingVisitor);
		if (!checkExpression)
			isValid = false;
		return isValid;
	}

}
