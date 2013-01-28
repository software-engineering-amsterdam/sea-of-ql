package org.uva.sea.ql.visitor.checkers;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
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

	
	private boolean isUndefined(Type ident,Expr node){
		if(ident.isCompatibleToUndefinedType()) {
			Ident id=(Ident) node;
			addError("Variable '"+id.getName()+"' is undefined.");
			return true;
		}
		return false;
	}
	
	@Override
	public boolean visit(Sub node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType.isCompatibleToNumericType())) {
			addError("Invalid type for '-'. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}
	
	@Override
	public boolean visit(Add node) {
		Expr leftExpr = node.getLeftExpr();
		Expr rightExpr = node.getRightExpr();
		
		boolean visitLeft = leftExpr.accept(this);
		boolean visitRight =rightExpr.accept(this);

		if (!(visitLeft && visitRight)) {
			return false;
		}

		Type leftExprType = leftExpr.isOfType(declaredVar);
		Type rightExprType = rightExpr.isOfType(declaredVar);
		
		if(isUndefined(leftExprType,leftExpr) || isUndefined(rightExprType,rightExpr)){
			return false;
		}
          
		Type declaredType=getQuestionsType();
          
          
		if (!(leftExprType.isCompatibleToType(rightExprType) && rightExprType.isCompatibleToType(declaredType))) {
		addError("Invalid type for '+'. Both operands must be of the same Numeric type("+declaredType.getClass().getSimpleName()+")");
			return false;
		}

		return true;
	}

	@Override
	public boolean visit(And node) {

		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToBoolType() && rightExprType.isCompatibleToBoolType())) {
			errorReport.add("Invalid type for '&&'. Both operands must be of the Boolean type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Div node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType
				.isCompatibleToNumericType())) {
			errorReport.add("Invalid type for '/'. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Eq node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToType(rightExprType))) {
			errorReport.add("Invalid type for '=='. Both operands must be of the same type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(GEq node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType
				.isCompatibleToNumericType())) {
			errorReport.add("Invalid type for '>='. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(GT node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType
				.isCompatibleToNumericType())) {
			errorReport.add("Invalid type for '>'. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Ident node) {
		return true;
	}

	@Override
	public boolean visit(LEq node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType
				.isCompatibleToNumericType())) {
			errorReport.add("Invalid type for '<='. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(LT node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType
				.isCompatibleToNumericType())) {
			errorReport.add("Invalid type for '>'. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Mul node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType
				.isCompatibleToNumericType())) {
			errorReport.add("Invalid type for '*'. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Neg node) {
		boolean leftExpr = node.getLeftExpr().accept(this);

		if (!leftExpr) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);

		if (!leftExprType.isCompatibleToNumericType()) {
			errorReport.add("Invalid type for '-'. Right operand must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(NEq node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.getClass() == rightExprType.getClass())) {
			errorReport.add("Invalid type for '!='. Both operands must be of the same type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Not node) {
		boolean leftExpr = node.getLeftExpr().accept(this);

		if (!leftExpr) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);

		if (!leftExprType.isCompatibleToBoolType()) {
			errorReport.add("Invalid type for '!'. Right operand must be of the Boolean type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Or node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToBoolType() && rightExprType.isCompatibleToBoolType())) {
			errorReport.add("Invalid type for '||'. Both operands must be of the Boolean type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Pos node) {
		boolean leftExpr = node.getLeftExpr().accept(this);

		if (!leftExpr) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);

		if (!leftExprType.isCompatibleToNumericType()) {
			errorReport.add("Invalid type for '+'. Right operand must be of the Numeric type");
			return false;
		}

		return true;

	}

	

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

	private void addError(String message){
	    	errorReport.add(message);
	    }

	private Type getQuestionsType(){
		 int mapSize=declaredVar.size();
        Collection<Type> typeList=declaredVar.values();
        Type declaredType=(Type) typeList.toArray()[mapSize-1];
        return declaredType;
	}
	

	
	
}
