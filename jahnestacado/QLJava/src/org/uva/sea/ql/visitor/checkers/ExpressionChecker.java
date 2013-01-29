package org.uva.sea.ql.visitor.checkers;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.Unary;
import org.uva.sea.ql.ast.expr.values.BoolLit;
import org.uva.sea.ql.ast.expr.values.Decimal;
import org.uva.sea.ql.ast.expr.values.Int;
import org.uva.sea.ql.ast.expr.values.StringLit;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;




public class ExpressionChecker implements IExprVisitor {
	private final Map<String, Type> declaredVar;
	private final List<String> errorReport;
	

	public ExpressionChecker(Map<String, Type> declaredVar, List<String> errorReport) {
		this.declaredVar = declaredVar;
		this.errorReport = errorReport;
	}

	public static boolean check(Expr expr, Map<String, Type> declaredVar,List<String> errorReport) {
		ExpressionChecker check = new ExpressionChecker(declaredVar, errorReport);
		return expr.accept(check);
	}
	
	private void addError(String message) {
		errorReport.add(message);
	}


	@Override
	public boolean visit(Ident node) {
		return true;
	}
	
//** Binary Exprs	
	@Override
	public boolean visit(Mul node) {
		if(!checkBranches(node)) return false;
		if(!checkVarNames(node)) return false;
		if(!checkBinaryExpr(node, "*")) return false;
		return true;

	}
	
	@Override
	public boolean visit(Sub node) {
		if(!checkBranches(node)) return false;
		if(!checkVarNames(node)) return false;
		if(!checkBinaryExpr(node, "-")) return false;
		return true;

	}
	
	@Override
	public boolean visit(Add node) {
		if(!checkBranches(node)) return false;
		if(!checkVarNames(node)) return false;
		if(!checkBinaryExpr(node, "+")) return false;
		return true;
	}

	
	@Override
	public boolean visit(Div node) {
		if(!checkBranches(node)) return false;
		if(!checkVarNames(node)) return false;
		if(!checkBinaryExpr(node, "/")) return false;
		return true;

	}
	
	//** Logical Exprs	
	@Override
	public boolean visit(And node) {
		if(!checkBranches(node)) return false;
		if(!checkVarNames(node)) return false;
		if(!checkLogicalExpr(node, "&&")) return false;
        return true;

	}

	@Override
	public boolean visit(Or node) {
		if(!checkBranches(node)) return false;
		if(!checkVarNames(node)) return false;
		if(!checkLogicalExpr(node, "||")) return false;
        return true;


	}

	//** Comparison Exprs
	@Override
	public boolean visit(Eq node) {
		if(!checkBranches(node)) return false;
		if(!checkVarNames(node)) return false;
		if(!checkComparisonExpr(node, "==")) return false;
        return true;

	}

	@Override
	public boolean visit(GEq node) {
		if(!checkBranches(node)) return false;
		if(!checkVarNames(node)) return false;
		if(!checkComparisonExpr(node, ">=")) return false;
		return true;


	}

	@Override
	public boolean visit(GT node) {
		if(!checkBranches(node)) return false;
		if(!checkVarNames(node)) return false;
		if(!checkComparisonExpr(node, ">")) return false;
		return true;
	}

	
	@Override
	public boolean visit(LEq node) {
		if(!checkBranches(node)) return false;
		if(!checkVarNames(node)) return false;
		if(!checkComparisonExpr(node, "<=")) return false;
		return true;

	}

	@Override
	public boolean visit(LT node) {
		if(!checkBranches(node)) return false;
		if(!checkVarNames(node)) return false;
		if(!checkComparisonExpr(node, ">")) return false;
		return true;

	}
	

	
	//** Unary Exprs
	@Override
	public boolean visit(Neg node) {
		if(!checkOperand(node)) return false;
		if(!checkVarName(node)) return false;
		if(!isNumericOperand(node,"-")) return false;
		return true;

	}

	@Override
	public boolean visit(NEq node) {
		if(!checkBranches(node)) return false;
		if(!checkVarNames(node)) return false;
		if(!checkComparisonExpr(node, "!=")) return false;
		return true;


	}

	@Override
	public boolean visit(Not node) {
		if(!checkOperand(node)) return false;
		if(!checkVarName(node)) return false;
		if(!isBoolOperand(node,"!")) return false;
		return true;

	}

	

	@Override
	public boolean visit(Pos node) {
		if(!checkOperand(node)) return false;
		if(!checkVarName(node)) return false;
		if(!isNumericOperand(node,"+")) return false;
		return true;

	}

    //** Literal Exprs
	@Override
	public boolean visit(Int node) {
		return true;

	}

	@Override
	public boolean visit(BoolLit node) {
		return true;
	}

	@Override
	public boolean visit(Decimal node) {
		return true;

	}

	@Override
	public boolean visit(StringLit node) {
		return true;

	}
	

	
	//** Exprs Type checks
	private boolean isUndefined(Type ident, Expr node) {
		if (ident.isCompatibleToUndefinedType()) {
			Ident id = (Ident) node;
			addError("Variable '" + id.getName() + "' is undefined.");
			return true;
		}
		return false;
	}
	
	
	private boolean checkBranches(Binary node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);
		if (!(leftExpr && rightExpr)) {
			return false;
		}

		return true;
	}
	
	
	private boolean checkOperand(Unary node) {
		if (!node.getLeftExpr().accept(this)) {
			return false;
		}

		return true;
	}
	
	
	private boolean checkVarNames(Binary node) {
		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);
		if (isUndefined(leftExprType, node.getLeftExpr())
				|| isUndefined(rightExprType, node.getRightExpr())) {
			return false;
		}
		return true;

	}
	
	private boolean checkVarName(Unary node) {
		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		if (isUndefined(leftExprType, node.getLeftExpr())) {
			return false;
		}
		return true;

	}
	
	
	private boolean checkBinaryExpr(Binary node,String symbol){
		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);
		Type declaredType=getQuestionsType();
		if (!(leftExprType.isCompatibleToType(rightExprType) && rightExprType.isCompatibleToType(declaredType))) {
		addError("Invalid type for '"+symbol+"'. Both operands must be of the same Numeric type("+declaredType.getClass().getSimpleName()+")");
			return false;
		}
		return true;
		
	}
	
	
	private boolean checkLogicalExpr(Binary node,String symbol){
		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);
		if (!(leftExprType.isCompatibleToBoolType() && rightExprType.isCompatibleToBoolType())) {
			errorReport.add("Invalid type for '"+symbol+"'. Both operands must be of the Boolean type");
			return false;
		}
		return true;
		
	}
	
	
	private boolean isNumericOperand(Unary node,String symbol){
		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type declaredType=getQuestionsType();
        if (!leftExprType.isCompatibleToType(declaredType)) {
			errorReport.add("Invalid type for '"+symbol+"'. Right operand must be of the Numeric type("+declaredType.getClass().getSimpleName()+")");
			return false;
		}
		return true;
		
	}
	
	
	private boolean isBoolOperand(Unary node,String symbol){
		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);

        if (!leftExprType.isCompatibleToBoolType()) {
			errorReport.add("Invalid type for '"+symbol+"'. Right operand must be of the Boolean type");
			return false;
		}
		return true;
		
	}
	
	
	private boolean checkComparisonExpr(Binary node,String symbol){
		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);
		if (!(leftExprType.isCompatibleToType(rightExprType))) {
			errorReport.add("Invalid type for '"+symbol+"'. Both operands must be of the same type");
			return false;
		}
		return true;
		
	}
	
	//** Returns the Type of last declared Variable 
	private Type getQuestionsType() {
		Collection<Type> typeList = declaredVar.values();
		int lastIndex = typeList.size() - 1;
		Type declaredType = (Type) typeList.toArray()[lastIndex];
		return declaredType;
	}

}
