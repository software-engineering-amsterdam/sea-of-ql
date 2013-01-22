package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Add;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.Div;
import org.uva.sea.ql.ast.expressions.Eq;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.GEq;
import org.uva.sea.ql.ast.expressions.GT;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.Int;
import org.uva.sea.ql.ast.expressions.LEq;
import org.uva.sea.ql.ast.expressions.LT;
import org.uva.sea.ql.ast.expressions.Mul;
import org.uva.sea.ql.ast.expressions.NEq;
import org.uva.sea.ql.ast.expressions.Neg;
import org.uva.sea.ql.ast.expressions.Not;
import org.uva.sea.ql.ast.expressions.Or;
import org.uva.sea.ql.ast.expressions.Pos;
import org.uva.sea.ql.ast.expressions.Sub;
import org.uva.sea.ql.ast.literals.BooleanLiteral;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;

public class ASTNodeTypeCheckingVisitor implements ASTNodeVisitor<Boolean> {
	
	private Map<String, Type> typeEnvironment;
	private List<String> errorMessages;
	
	public ASTNodeTypeCheckingVisitor() {
		typeEnvironment = new HashMap<String, Type>();
		errorMessages = new ArrayList<String>();
	}
	
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	@Override
	public Boolean visit(Form form) {
		boolean checkBlock = form.getBlock().accept(this);
		if (!checkBlock)
			return false;
		return true;		
	}

	@Override
	public Boolean visit(StringLiteral stringLiteral) {
		return true;		
	}

	@Override
	public Boolean visit(BoolType boolType) {
		return true;
	}

	@Override
	public Boolean visit(IntType intType) {
		return true;
	}

	@Override
	public Boolean visit(StringType stringType) {
		return true;
	}

	@Override
	public Boolean visit(Block block) {
		for (Statement statement : block.getStatements()) {
			boolean checkStatement = statement.accept(this);
			if (!checkStatement)
				return false;
		}
		return true;	
	}

	@Override
	public Boolean visit(IfThenElse ifThenElse) {
		boolean checkBody = ifThenElse.getBody().accept(this);
		boolean checkCondition = ifThenElse.getCondition().accept(this);
		if (!(checkBody && checkCondition))
			return false;
		Block elseBody = ifThenElse.getElseBody();
		if (elseBody != null)
			if (!elseBody.accept(this))
				return false;				
		return true;		
	}

	@Override
	public Boolean visit(Question question) {
		Ident identifier = question.getIdentifier();
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
		Ident identifier = computedQuestion.getIdentifier();
		if (typeEnvironment.get(identifier.getName()) != null) {
			errorMessages.add("Identifier " + identifier.getName() + " can only be used once.");
			return false;
		}
		else
			typeEnvironment.put(identifier.getName(), computedQuestion.getType());
		boolean checkExpression = computedQuestion.getExpression().accept(this);
		if (!checkExpression)
			return false;
		return true;
	}

	@Override
	public Boolean visit(Add add) {
		boolean checkLhs = add.getLhs().accept(this);
		boolean checkRhs = add.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = add.getLhs().typeOf(typeEnvironment);
		Type rhsType = add.getRhs().typeOf(typeEnvironment);
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errorMessages.add("Type error: The + sign is used incorrectly.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(And and) {
		boolean checkLhs = and.getLhs().accept(this);
		boolean checkRhs = and.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = and.getLhs().typeOf(typeEnvironment);
		Type rhsType = and.getRhs().typeOf(typeEnvironment);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			errorMessages.add("Type error: The && sign is used incorrectly.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Div div) {
		boolean checkLhs = div.getLhs().accept(this);
		boolean checkRhs = div.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = div.getLhs().typeOf(typeEnvironment);
		Type rhsType = div.getRhs().typeOf(typeEnvironment);
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errorMessages.add("Type error: The / sign is used incorrectly.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Eq eq) {
		boolean checkLhs = eq.getLhs().accept(this);
		boolean checkRhs = eq.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = eq.getLhs().typeOf(typeEnvironment);
		Type rhsType = eq.getRhs().typeOf(typeEnvironment);
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt()) &&
				!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			errorMessages.add("Type error: The == sign is used incorrectly.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GEq gEq) {
		boolean checkLhs = gEq.getLhs().accept(this);
		boolean checkRhs = gEq.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = gEq.getLhs().typeOf(typeEnvironment);
		Type rhsType = gEq.getRhs().typeOf(typeEnvironment);
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errorMessages.add("Type error: The >= sign is used incorrectly.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GT gt) {
		boolean checkLhs = gt.getLhs().accept(this);
		boolean checkRhs = gt.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = gt.getLhs().typeOf(typeEnvironment);
		Type rhsType = gt.getRhs().typeOf(typeEnvironment);
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errorMessages.add("Type error: The > sign is used incorrectly.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Ident ident) {		
		return true;		
	}

	@Override
	public Boolean visit(Int int1) {
		return true;
	}

	@Override
	public Boolean visit(LEq lEq) {
		boolean checkLhs = lEq.getLhs().accept(this);
		boolean checkRhs = lEq.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = lEq.getLhs().typeOf(typeEnvironment);
		Type rhsType = lEq.getRhs().typeOf(typeEnvironment);
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errorMessages.add("Type error: The <= sign is used incorrectly.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(LT lt) {
		boolean checkLhs = lt.getLhs().accept(this);
		boolean checkRhs = lt.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = lt.getLhs().typeOf(typeEnvironment);
		Type rhsType = lt.getRhs().typeOf(typeEnvironment);
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errorMessages.add("Type error: The < sign is used incorrectly.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Mul mul) {
		boolean checkLhs = mul.getLhs().accept(this);
		boolean checkRhs = mul.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = mul.getLhs().typeOf(typeEnvironment);
		Type rhsType = mul.getRhs().typeOf(typeEnvironment);
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errorMessages.add("Type error: The * sign is used incorrectly.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Neg neg) {
		Type type = neg.getLhs().typeOf(typeEnvironment);
		if (!type.isCompatibleToInt()) {
			errorMessages.add("Type error: The - sign is used incorrectly.");
			return false;
		}
		return true;		
	}

	@Override
	public Boolean visit(NEq nEq) {
		boolean checkLhs = nEq.getLhs().accept(this);
		boolean checkRhs = nEq.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = nEq.getLhs().typeOf(typeEnvironment);
		Type rhsType = nEq.getRhs().typeOf(typeEnvironment);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			errorMessages.add("Type error: The != sign is used incorrectly.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Not not) {
		Type type = not.getLhs().typeOf(typeEnvironment);
		if (!type.isCompatibleToBool()) {
			errorMessages.add("Type error: The ! sign is used incorrectly.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Or or) {
		boolean checkLhs = or.getLhs().accept(this);
		boolean checkRhs = or.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = or.getLhs().typeOf(typeEnvironment);
		Type rhsType = or.getRhs().typeOf(typeEnvironment);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			errorMessages.add("Type error: The || sign is used incorrectly.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Pos pos) {
		Type type = pos.getLhs().typeOf(typeEnvironment);
		if (!type.isCompatibleToInt()) {
			errorMessages.add("Type error: The + sign is used incorrectly.");
			return false;
		}
		return true;	
	}

	@Override
	public Boolean visit(Sub sub) {
		boolean checkLhs = sub.getLhs().accept(this);
		boolean checkRhs = sub.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = sub.getLhs().typeOf(typeEnvironment);
		Type rhsType = sub.getRhs().typeOf(typeEnvironment);
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errorMessages.add("Type error: The - sign is used incorrectly.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Expr expr) {
		return true;		
	}

	@Override
	public Boolean visit(BooleanLiteral booleanLiteral) {
		return true;		
	}

	@Override
	public Boolean visit(ErrorType error) {		
		return true;
	}

}
