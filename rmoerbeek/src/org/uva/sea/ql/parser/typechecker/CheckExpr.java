package org.uva.sea.ql.parser.typechecker;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.visitors.ExpressionVisitor;


public class CheckExpr implements ExpressionVisitor<Boolean> {
	
	private final Map<Ident, Type> typeEnv;
	private final List<String> messages;
	
	public CheckExpr(Map<Ident, Type> tenv, List<String> messages) {
		this.typeEnv = tenv;
		this.messages = messages;
	}
	
	public static boolean check(Expr expr, Map<Ident, Type> typeEnv, List<String> errs) {
		CheckExpr check = new CheckExpr(typeEnv, errs);
		return expr.accept(check);
	}
	
	@Override
	public Boolean visit(Add ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			messages.add(ast.toString() + ": " + lhsType + " and/or " + rhsType + "invalid type for +");
			return false;
		}
		
		return true;
	}
	
	@Override
	public Boolean visit(And ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToBool()
				&& rhsType.isCompatibleToBool())) {
			messages.add(ast.toString() + ": " + lhsType + " and/or " + rhsType + "invalid type for &&");
			return false;
		}
		
		return true;
	}
	
	@Override
	public Boolean visit(Bool ast) {
	
		return true;
	}
	
	@Override
	public Boolean visit(Div ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			messages.add(ast.toString() + ": " + lhsType + " and/or " + rhsType + "invalid type for /");
			return false;
		}
		
		return true;
	}
	
	@Override
	public Boolean visit(Eq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleTo(rhsType)
				&& rhsType.isCompatibleTo(lhsType))) {
			messages.add(ast.toString() + ": " + lhsType + " and/or " + rhsType + "invalid type for ==");
			return false;
		}
		
		return true;
	}
	
	@Override
	public Boolean visit(GT ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			messages.add(ast.toString() + ": " + lhsType + " and/or " + rhsType + "invalid type for >");
			return false;
		}
		
		return true;
	}
	
	@Override
	public Boolean visit(GEq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			messages.add(ast.toString() + ": " + lhsType + " and/or " + rhsType + "invalid type for >=");
			return false;
		}
		
		return true;
	}
	
	@Override
	public Boolean visit(Ident ast) {
		return true;
	}
	
	@Override
	public Boolean visit(Int ast) {
		return true;
	}
	
	@Override
	public Boolean visit(LEq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			messages.add(ast.toString() + ": " + lhsType + " and/or " + rhsType + "invalid type for =<");			
			return false;
		}
		
		return true;
	}
	
	@Override
	public Boolean visit(LT ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			messages.add(ast.toString() + ": " + lhsType + " and/or " + rhsType + "invalid type for <");
			return false;
		}
		
		return true;
	}
	
	@Override
	public Boolean visit(Mul ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			messages.add(ast.toString() + ": " + lhsType + " and/or " + rhsType + "invalid type for *");
			return false;
		}
		
		return true;
	}
	
	@Override
	public Boolean visit(Neg ast) {
		return true;
	}
	
	@Override
	public Boolean visit(NEq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			messages.add(ast.toString() + ": " + lhsType + " and/or " + rhsType + "invalid type for neg");
			return false;
		}
		
		return true;
	}
	
	@Override
	public Boolean visit(Not ast) {
		return true;
	}
	
	@Override
	public Boolean visit(Or ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToBool()
				&& rhsType.isCompatibleToBool())) {
			messages.add(ast.toString() + ": " + lhsType + " and/or " + rhsType + "invalid type for ||");
			return false;
		}
		
		return true;
	}
	
	@Override
	public Boolean visit(Pos ast) {
		return true;
	}
	
	@Override
	public Boolean visit(Str ast) {
		return true;
	}

	@Override
	public Boolean visit(Sub ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);

		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			messages.add(ast.toString() + ": " + lhsType + " and/or " + rhsType + " invalid type for -");
			return false;
		}
		
		return true;
	}
}