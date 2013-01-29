package org.uva.sea.ql.ast.expressions;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.types.Type;


public class ExprTypeCheckingVisitor implements ExprVisitor<Boolean> {
	
	private Map<String, Type> typeEnvironment;
	private List<String> errorMessages;
	
	enum Compatibility { Int, Bool, All };
	
	public ExprTypeCheckingVisitor(Map<String, Type> typeEnvironment, List<String> errorMessages) {
		this.typeEnvironment = typeEnvironment;
		this.errorMessages = errorMessages;
	}
	
	private void addTypeError(String symbol) {
		errorMessages.add("Type error: The " + symbol + " symbol is used incorrectly.");
	}
	
	private boolean checkBinaryExpr(Binary expr, String symbol, Compatibility compatibility) {
		boolean checkLhs = expr.getLhs().accept(this);
		boolean checkRhs = expr.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}		
		Type lhsType = expr.getLhs().typeOf(typeEnvironment);
		Type rhsType = expr.getRhs().typeOf(typeEnvironment);
		switch (compatibility) {
			case Int: {
				if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
					addTypeError(symbol);
					return false;
				}
				break;
			}
			case Bool: {
				if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
					addTypeError(symbol);
					return false;
				}
				break;
			}
			case All: {
				if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt()) && 
					!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool() && 
					!(lhsType.isCompatibleToString() && rhsType.isCompatibleToString()))) {
					addTypeError(symbol);
					return false;
				}
				break;
			}
		}
		return true;
	}

	@Override
	public Boolean visit(Add add) {
		return checkBinaryExpr(add, "+", Compatibility.Int);
	}

	@Override
	public Boolean visit(And and) {
		return checkBinaryExpr(and, "&&", Compatibility.Bool);
	}

	@Override
	public Boolean visit(Div div) {
		return checkBinaryExpr(div, "/", Compatibility.Int);
	}

	@Override
	public Boolean visit(Eq eq) {
		return checkBinaryExpr(eq, "==", Compatibility.All);
	}

	@Override
	public Boolean visit(GEq gEq) {
		return checkBinaryExpr(gEq, ">=", Compatibility.Int);
	}

	@Override
	public Boolean visit(GT gt) {
		return checkBinaryExpr(gt, ">", Compatibility.Int);
	}	

	@Override
	public Boolean visit(LEq lEq) {
		return checkBinaryExpr(lEq, "<=", Compatibility.Int);
	}

	@Override
	public Boolean visit(LT lt) {
		return checkBinaryExpr(lt, "<", Compatibility.Int);
	}

	@Override
	public Boolean visit(Mul mul) {
		return checkBinaryExpr(mul, "*", Compatibility.Int);
	}	

	@Override
	public Boolean visit(NEq nEq) {
		return checkBinaryExpr(nEq, "!=", Compatibility.All);
	}
	
	@Override
	public Boolean visit(Or or) {
		return checkBinaryExpr(or, "||", Compatibility.Bool);
	}
	
	@Override
	public Boolean visit(Sub sub) {
		return checkBinaryExpr(sub, "-", Compatibility.Int);
	}
	
	private boolean checkUnaryExpr(Binary expr, String symbol, Compatibility compatibility) {
		Type type = expr.getLhs().typeOf(typeEnvironment);
		if (compatibility == Compatibility.Int) {
			if (!type.isCompatibleToInt()) {
				addTypeError(symbol);
				return false;
			}
		}
		if (compatibility == Compatibility.Bool) {
			if (!type.isCompatibleToBool()) {
				addTypeError(symbol);
				return false;
			}
		}
		return true;	
	}
	
	@Override
	public Boolean visit(Neg neg) {
		return checkUnaryExpr(neg, "-", Compatibility.Int);	
	}	

	@Override
	public Boolean visit(Not not) {
		return checkUnaryExpr(not, "!", Compatibility.Bool);
	}	

	@Override
	public Boolean visit(Pos pos) {
		return checkUnaryExpr(pos, "+", Compatibility.Int);	
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
