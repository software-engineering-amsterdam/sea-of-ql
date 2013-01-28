package org.uva.sea.ql.ast.expressions;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.types.Type;


public class ExprTypeCheckingVisitor implements ExprVisitor<Boolean> {
	
	private Map<String, Type> typeEnvironment;
	private List<String> errorMessages;
	
	public ExprTypeCheckingVisitor(Map<String, Type> typeEnvironment, List<String> errorMessages) {
		this.typeEnvironment = typeEnvironment;
		this.errorMessages = errorMessages;
	}
	
	public List<String> getErrorMessages() {
		return errorMessages;
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
			!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool() &&
			!(lhsType.isCompatibleToString() && rhsType.isCompatibleToString()))) {
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
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt()) &&
			!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool() &&
			!(lhsType.isCompatibleToString() && rhsType.isCompatibleToString()))) {
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
	public Boolean visit(StringLiteral stringLiteral) {
		return true;		
	}
	
	@Override
	public Boolean visit(BooleanLiteral booleanLiteral) {
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

}
