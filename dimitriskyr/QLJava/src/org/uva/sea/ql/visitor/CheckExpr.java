package org.uva.sea.ql.visitor;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.Add;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.BinaryExpression;
import org.uva.sea.ql.ast.expressions.Div;
import org.uva.sea.ql.ast.expressions.Eq;
import org.uva.sea.ql.ast.expressions.GEq;
import org.uva.sea.ql.ast.expressions.GT;
import org.uva.sea.ql.ast.expressions.LEq;
import org.uva.sea.ql.ast.expressions.LT;
import org.uva.sea.ql.ast.expressions.Mul;
import org.uva.sea.ql.ast.expressions.NEq;
import org.uva.sea.ql.ast.expressions.Neg;
import org.uva.sea.ql.ast.expressions.Not;
import org.uva.sea.ql.ast.expressions.Or;
import org.uva.sea.ql.ast.expressions.Pos;
import org.uva.sea.ql.ast.expressions.Sub;
import org.uva.sea.ql.ast.expressions.UnaryExpression;
import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Money;
import org.uva.sea.ql.ast.values.String_lit;

public class CheckExpr implements ICheckExprVisitor<Boolean> {

	private final Map<String, Type> typeEnv;
	private final List<String> errormessages;

	public CheckExpr(Map<String, Type> tenv, List<String> messages) {
		this.typeEnv = tenv;
		this.errormessages = messages;
	}

	public static boolean check(Expr expr, Map<String, Type> typeEnv,
			List<String> errors) {
		CheckExpr check = new CheckExpr(typeEnv, errors);
		return expr.accept(check);
	}

	public void getErrormessages(String errors) {
		this.errormessages.add(errors);
	}

	@Override
	public Boolean visit(Add add) {
		if (checkBinary(add) == true) {
			if (compatibleToNumericBinary(add) == false) {
				getErrormessages("invalid type for '+' . The operands of the two sides should both be of type Numeric");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(And and) {
		if (checkBinary(and) == true) {
			if (compatibleToBooleanBinary(and) == false) {
				getErrormessages("invalid type for '&&' . The operands of the two sides should both be of type Boolean.");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(Div div) {
		if (checkBinary(div) == true) {
			if (compatibleToNumericBinary(div) == false) {
				getErrormessages("invalid type for '/' . The operands of the two sides should both be of type Numeric.");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(Eq eq) {
		if (checkBinary(eq) == true) {
			Type lhsType = eq.getLhs().typeOf(typeEnv);
			Type rhsType = eq.getRhs().typeOf(typeEnv);
			if (!(lhsType.isCompatibleTo(rhsType))) {
				getErrormessages("invalid type for '=='. The operands of the two sides should both be of the same type.");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(GEq geq) {
		if (checkBinary(geq) == true) {
			if (compatibleToNumericBinary(geq) == false) {
				getErrormessages("invalid type for '>='. The operands of the two sides should both be of type Numeric.");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(GT gt) {
		if (checkBinary(gt) == true) {
			if (compatibleToNumericBinary(gt) == false) {
				getErrormessages("invalid type for '>'. The operands of the two sides should both be of type Numeric.");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(LEq leq) {
		if (checkBinary(leq) == true) {
			if (compatibleToNumericBinary(leq) == false) {
				getErrormessages("invalid type for '<='. The operands of the two sides should both be of type Numeric.");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(LT lt) {
		if (checkBinary(lt) == true) {
			if (compatibleToNumericBinary(lt) == false) {
				getErrormessages("invalid type for '<'. The operands of the two sides should both be of type Numeric.");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(Mul mul) {
		if (checkBinary(mul) == true) {
			if (compatibleToNumericBinary(mul) == false) {
				getErrormessages("invalid type for '*' . The operands of the two sides should both be of type Numeric");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(Neg neg) {
		if (checkUnary(neg) == true) {
			Type valueType = neg.getValue().typeOf(typeEnv);
			if (!(valueType.isCompatibleToNumeric())) {
				getErrormessages("invalid type for '-' . The operand should be of type Numeric");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(NEq neq) {
		if (checkBinary(neq) == true) {
			Type lhsType = neq.getLhs().typeOf(typeEnv);
			Type rhsType = neq.getRhs().typeOf(typeEnv);
			if (!(lhsType.isCompatibleTo(rhsType))) {
				getErrormessages("invalid type for '!='. The operands of the two sides should both be of the same type.");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(Not not) {
		if (checkUnary(not) == true) {
			Type valueType = not.getValue().typeOf(typeEnv);
			if (!(valueType.isCompatibleToBoolean())) {
				getErrormessages("invalid type for '!' . The operand should be of type Boolean");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(Or or) {
		if (checkBinary(or) == true) {
			if (compatibleToBooleanBinary(or) == false) {
				getErrormessages("invalid type for '||' . The operands of the two sides should both be of type Boolean.");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(Pos pos) {
		if (checkUnary(pos) == true) {
			Type valueType = pos.getValue().typeOf(typeEnv);
			if (!(valueType.isCompatibleToNumeric())) {
				getErrormessages("invalid type for '+' . The operand should be of type Numeric.");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(Sub sub) {
		if (checkBinary(sub) == true) {
			if (compatibleToNumericBinary(sub) == false) {
				getErrormessages("invalid type for '-' . The operands of the two sides should both be of type Numeric.");
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(Bool bool) {
		return true;
	}

	@Override
	public Boolean visit(String_lit string_lit) {
		return true;
	}

	@Override
	public Boolean visit(Money money) {
		return true;
	}

	@Override
	public Boolean visit(Ident ident) {
		if (typeEnv.get(ident.getValue()) == null) {
			getErrormessages("Ident " + ident.getValue() + " is not declared.");
		}
		return true;
	}

	@Override
	public Boolean visit(Int integer) {
		return true;
	}

	private boolean checkBinary(BinaryExpression expression) {
		boolean checkLhs = expression.getLhs().accept(this);
		boolean checkRhs = expression.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		return true;
	}

	private boolean checkUnary(UnaryExpression expression) {
		boolean checkValue = expression.getValue().accept(this);
		if (!(checkValue)) {
			return false;
		}
		return true;
	}

	private boolean compatibleToNumericBinary(BinaryExpression expression) {
		Type lhsType = expression.getLhs().typeOf(typeEnv);
		Type rhsType = expression.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			return false;
		}
		return true;
	}

	private boolean compatibleToBooleanBinary(BinaryExpression expression) {
		Type lhsType = expression.getLhs().typeOf(typeEnv);
		Type rhsType = expression.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBoolean() && rhsType
				.isCompatibleToBoolean())) {
			return false;
		}
		return true;
	}

}
