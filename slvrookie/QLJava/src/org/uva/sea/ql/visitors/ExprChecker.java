package org.uva.sea.ql.visitors;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.binary.*;
import org.uva.sea.ql.ast.expr.unary.*;
import org.uva.sea.ql.ast.expr.value.*;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitors.interfaces.IExprVisitor;

public class ExprChecker implements IExprVisitor<Boolean> {
	
	private final Map<String, Type> typeEnv;
	private final List<String> errors;
	
	private ExprChecker(Map<String, Type> tenv, List<String> errors) {
		this.typeEnv = tenv;
		this.errors = errors;
	}
	
	public static boolean check(Expr expr, Map<String, Type> typeEnv, List<String> errs) {
		ExprChecker check = new ExprChecker(typeEnv, errs);
		return expr.accept(check);
	}
	
	public void addError(String error) {
		this.errors.add(error);
	}

	@Override
	public Boolean visit(Ident node) {
		if(typeEnv.get(node.getName()) == null)	{
			addError("Ident " + node.getName() + " is not declared.");
		}
		return true;
	}
	
	@Override
	public Boolean visit(Add node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "+");
		areBothSidesCompatibleToNumeric(node,"+");	
		return true;
	}

	@Override
	public Boolean visit(And node) {
		checkSubtrees(node);
		areBothSidesCompatibleToBoolean(node, "&&");
		return true;
	}

	@Override
	public Boolean visit(Div node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "/");
		areBothSidesCompatibleToNumeric(node,"/");
		return true;
	}
	
	@Override
	public Boolean visit(Eq node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "==");
		return true;
	}

	@Override
	public Boolean visit(GEq node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, ">=");
		areBothSidesCompatibleToNumeric(node,">=");
		return true;
	}

	@Override
	public Boolean visit(GT node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, ">");
		areBothSidesCompatibleToNumeric(node,">");
		return true;
	}

	@Override
	public Boolean visit(LEq node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "<=");
		areBothSidesCompatibleToNumeric(node,"<=");
		return true;
	}

	@Override
	public Boolean visit(LT node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "<");
		areBothSidesCompatibleToNumeric(node,"<");
		return true;
	}

	@Override
	public Boolean visit(Mul node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "*");
		areBothSidesCompatibleToNumeric(node,"*");
		return true;
	}

	@Override
	public Boolean visit(Neg node) {
		checkArgument(node);
		isArgumentNumeric(node, "-");
		return true;
	}

	@Override
	public Boolean visit(NEq node) {
		checkSubtrees(node);		
		areBothSidesCompatible(node, "!=");
		return true;
	}

	@Override
	public Boolean visit(Not node) {
		checkArgument(node);
		isArgumentBoolean(node, "!");
		return true;
	}

	@Override
	public Boolean visit(Or node) {
		checkSubtrees(node);
		areBothSidesCompatibleToBoolean(node, "||");
		return true;
	}

	@Override
	public Boolean visit(Pos node) {
		checkArgument(node);
		isArgumentNumeric(node, "+");
		return true;
	}

	@Override
	public Boolean visit(Sub node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "-");
		areBothSidesCompatibleToNumeric(node,"-");
		return true;
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(MoneyLiteral node) { 
		return true;
	}

	@Override
	public Boolean visit(StringLiteral node) {
		return true;
	}
	
	@Override
	public Boolean visit(IntLiteral node) {
		return true;
	}
	
	private boolean checkSubtrees(BinaryExpr node) {
		if (!(node.getLhs().accept(this) && node.getRhs().accept(this))){
			return false;
		}
		return true;	
	}
	
	private boolean checkArgument(UnaryExpr node) {
		if (!node.getArg().accept(this)){
			return false;
		}
		return true;
	}
	
	private boolean isArgumentNumeric(UnaryExpr node, String operator) {
		if(!node.getArg().typeOf(typeEnv).isCompatibleToNumeric()) {
			addError("Invalid type for unary " + operator + ". Expected NumericType but got " + node.getArg().typeOf(typeEnv).getClass().getSimpleName() + ".");
			return false;
		}
		return true;
	}
	
	private boolean isArgumentBoolean(UnaryExpr node, String operator) {
		if(!node.getArg().typeOf(typeEnv).isCompatibleToBoolType()) {
			addError("Invalid type for unary " + operator + ". Expected BoolType but got " + node.getArg().typeOf(typeEnv).getClass().getSimpleName() + ".");
			return false;
		}
		return true;
	}
	
	private boolean areBothSidesCompatible(BinaryExpr node, String operator) {
		if (!(node.getLhs().typeOf(typeEnv).isCompatibleTo(node.getRhs().typeOf(typeEnv)))) { 
			addError("Both arguments must have the same type for binary " + operator + ". Got " + node.getLhs().typeOf(typeEnv).getClass().getSimpleName() + " " + operator + " " + node.getRhs().typeOf(typeEnv).getClass().getSimpleName() + ".");
			return false;
		}
		return true;
	}
	
	private boolean areBothSidesCompatibleToNumeric(BinaryExpr node, String operator ) {
		if (!(node.getLhs().typeOf(typeEnv).isCompatibleToNumeric() && node.getRhs().typeOf(typeEnv).isCompatibleToNumeric())) { 
			addError("Invalid types for binary " + operator + ". BoolTypes are not allowed for this operator.");
			return false;
		}
		return true;
	}
	
	private boolean areBothSidesCompatibleToBoolean(BinaryExpr node, String operator ) {
		if (!(node.getLhs().typeOf(typeEnv).isCompatibleToBoolType() && node.getRhs().typeOf(typeEnv).isCompatibleToBoolType())) {
			addError("Invalid types for binary " + operator + ". Numeric Types are not allowed for this operator.");
			return false;
		}
		return true;
	}

}