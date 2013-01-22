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
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;

public class ASTNodeTypeCheckingVisitor implements ASTNodeVisitor<Boolean> {
	
	private Map<Ident, Type> typeEnvironment;
	private List<String> errorMessages;
	
	public ASTNodeTypeCheckingVisitor() {
		typeEnvironment = new HashMap<Ident, Type>();
		errorMessages = new ArrayList<String>();
	}
	
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	@Override
	public Boolean visit(Form form) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(StringLiteral stringLiteral) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(BoolType boolType) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(IntType intType) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(StringType stringType) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Block block) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(IfThenElse ifThenElse) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Question question) {
		Ident identifier = question.getIdentifier();
		boolean checkIdentifier = identifier.accept(this);
		if (checkIdentifier) {
			typeEnvironment.put(identifier, question.getType());
			return true;
		}
		else
			errorMessages.add("Identifier " + identifier + "can only be used once.");
		return false;
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
		return true;
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(BooleanLiteral booleanLiteral) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(ErrorType error) {		
		return true;
		// TODO Auto-generated method stub
	}

}
