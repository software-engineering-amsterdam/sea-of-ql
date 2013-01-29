package org.uva.sea.ql.typechecking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.statements.StatementVisitor;
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
		boolean checkBody = ifThenElse.getBody().accept(this);
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
		return checkQuestion(question);
	}
	
	@Override
	public Boolean visit(ComputedQuestion computedQuestion) {
		boolean isValid = checkQuestion(computedQuestion);
		boolean checkExpression = computedQuestion.getExpression().accept(exprTypeCheckingVisitor);
		if (!checkExpression)
			isValid = false;
		return isValid;
	}
	
	// Adds identifiers to the type environment unless they are already in use.
	private boolean checkQuestion(Question question) {
		Ident identifier = question.getVariable();
		if (typeEnvironment.get(identifier.getName()) != null) {
			errorMessages.add("Identifier " + identifier.getName() + " can only be used once.");
			return false;
		}
		else
			typeEnvironment.put(identifier.getName(), question.getType());
		return true;
	}

}
