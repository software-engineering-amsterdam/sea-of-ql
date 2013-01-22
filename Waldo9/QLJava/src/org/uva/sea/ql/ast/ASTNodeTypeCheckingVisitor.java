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
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Eq eq) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(GEq gEq) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(GT gt) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Ident ident) {		
		return true;		
	}

	@Override
	public Boolean visit(Int int1) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(LEq lEq) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(LT lt) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Mul mul) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Neg neg) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(NEq nEq) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Not not) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Or or) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Pos pos) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Sub sub) {
		return true;
		// TODO Auto-generated method stub
		
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
