package org.uva.sea.ql;

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
import org.uva.sea.ql.ast.expr.values.BoolLiteral;
import org.uva.sea.ql.ast.expr.values.Int;
import org.uva.sea.ql.ast.expr.values.StringLiteral;
import org.uva.sea.ql.ast.types.Type;

public class ExprTypeChecker implements IExprVisitor<Boolean> {
	
	private final Map<String, Type> typeEnvironment;
	//private final List<String> errors;
	private final List<QLError> errors;
	
	public ExprTypeChecker(Map<String, Type> typeEnvironment, List<QLError> errors) {
		
		this.typeEnvironment = typeEnvironment;
		this.errors = errors;
	}
	
	public List<QLError> getErrors(){
		return errors;
	}
	
	public static boolean check(Expr expr, Map <String, Type> typeEnvironment, List<QLError> errors ) {
		
		ExprTypeChecker typeChecker = new ExprTypeChecker(typeEnvironment, errors);
		return expr.accept(typeChecker);
		
	}
	
	private void addError(String operator) {
		//errors.add("The operands of \""+ operator +"\" are not compatible");
		errors.add(new QLError("The operands of \""+ operator +"\" are not compatible"));
	}

	@Override
	public Boolean visit(Add node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check sub-trees
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for +
		if (!(leftType.isCompatibleToNumeric() && rightType.isCompatibleToNumeric())) {
			addError("+");
			//System.out.println("add type");
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(And node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check sub-trees
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for &&
		if (!(leftType.isCompatibleToBool() && rightType.isCompatibleToBool())) {
			addError("&&");
			//System.out.println("and type");
			return false;
		}
	
		return true;
		
	}

	@Override
	public Boolean visit(Div node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check sub-trees
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for /
		if (!(leftType.isCompatibleToNumeric() && rightType.isCompatibleToNumeric())) {
			addError("/");
			return false;
		}
	
		return true;
		
	}

	@Override
	public Boolean visit(Eq node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check sub-trees
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for ==
		if (!(leftType.isCompatibleToNumeric() && rightType.isCompatibleToNumeric())) {
			addError("==");
			return false;
		}
	
		return true;
		
	}

	@Override
	public Boolean visit(GEq node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check sub-trees
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for >=
		if (!(leftType.isCompatibleToNumeric() && rightType.isCompatibleToNumeric())) {
			addError(">=");
			return false;
		}
	
		return true;
		
	}

	@Override
	public Boolean visit(GT node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check sub-trees
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for >
		if (!(leftType.isCompatibleToNumeric() && rightType.isCompatibleToNumeric())) {
			addError(">");
			return false;
		}
	
		return true;
		
	}

	@Override
	public Boolean visit(Ident node) {
		
		if(node.isOfType(typeEnvironment).isCompatibleToUndefined()) {
			errors.add(new QLError("Variable " +node.getName()+ " is undefined "));
			return false;
		}
		
		return true;
		
	}

	@Override
	public Boolean visit(Int node) {
		return true;
		
	}

	@Override
	public Boolean visit(LEq node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check sub-trees
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for <=
		if (!(leftType.isCompatibleToNumeric() && rightType.isCompatibleToNumeric())) {
			addError("<=");
			return false;
		}
	
		return true;
		
	}

	@Override
	public Boolean visit(LT node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check sub-trees
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for <
		if (!(leftType.isCompatibleToNumeric() && rightType.isCompatibleToNumeric())) {
			
			addError("<");
			return false;
		}
	
		return true;
		
	}

	@Override
	public Boolean visit(Mul node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check sub-trees
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for *
		if (!(leftType.isCompatibleToNumeric() && rightType.isCompatibleToNumeric())) {
			
			addError("*");
			return false;
		}
	
		return true;
		
	}

	@Override
	public Boolean visit(Neg node) {
		
		Type arg = node.getArg().isOfType(typeEnvironment);
		
		if (!(arg.isCompatibleToNumeric())) {
			
			addError("-");
			return false;
		}
		
		return true;
		
	}

	@Override
	public Boolean visit(NEq node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check sub-trees
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for !=
		if (!(leftType.isCompatibleToNumeric() && rightType.isCompatibleToNumeric())) {
			addError("!=");
			return false;
		}
	
		return true;
		
	}

	@Override
	public Boolean visit(Not node) {
		
		Type arg = node.getArg().isOfType(typeEnvironment);
		
		if (!(arg.isCompatibleToBool())) {
			
			addError("!");
			return false;
		}
		
		return true;
		
	}

	@Override
	public Boolean visit(Or node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check sub-trees
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for ||
		if (!(leftType.isCompatibleToBool() && rightType.isCompatibleToBool())) {
			addError("||");
			return false;
		}
	
		return true;
		
	}

	@Override
	public Boolean visit(Pos node) {
		
		Type arg = node.getArg().isOfType(typeEnvironment);
		
		if (!(arg.isCompatibleToNumeric())) {
			
			addError("+");
			return false;
		}
		
		return true;
		
	}

	@Override
	public Boolean visit(Sub node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check sub-trees
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for -
		if (!(leftType.isCompatibleToNumeric() && rightType.isCompatibleToNumeric())) {
			addError("-");
			return false;
		}
	
		return true;
		
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		return true;
		
	}

	@Override
	public Boolean visit(StringLiteral node) {
		return true;
		
	}

}
