package org.uva.sea.ql.ast;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.BoolLiteral;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Int;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.StringLiteral;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.types.Type;

public class ASTVisitor implements IASTVisitor {
	
	private final Map<String, Type> typeEnvironment;
	private final List<String> errors;

	public ASTVisitor(Map<String, Type> typeEnvironment, List<String> errors) {
		
		this.typeEnvironment = typeEnvironment;
		this.errors = errors;
	}
	
	public List<String> getErrors(){
		return errors;
	}
	
	public boolean check(Expr expr, Map <String, Type> typeEnvironment, List<String> errors ) {
		
		ASTVisitor typeChecker = new ASTVisitor(typeEnvironment, errors);
		return expr.accept(typeChecker);
		
	}
	
	protected void addError(String operator) {
		errors.add("The operands of \""+ operator +"\" are not compatible");
	}

	public boolean visit(Add node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check children
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for +
		if (!(leftType.isCompatibleToNumeric() && rightType.isCompatibleToNumeric())) {
			addError("+");
			return false;
		}
	
		return true;
	}

	@Override
	public boolean visit(And node) {
		
		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);
		
		//check children
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);
		
		//check required types for &&
		if (!(leftType.isCompatibleToBool() && rightType.isCompatibleToBool())) {
			addError("&&");
			//for (String error : errors){
				//System.out.println(error);
			//}
			return false;
		}
	
		return true;
		
	}

	@Override
	public boolean visit(Div node) {
		return true;
		
	}

	@Override
	public boolean visit(Eq node) {
		return true;
		
	}

	@Override
	public boolean visit(GEq node) {
		return true;
		
	}

	@Override
	public boolean visit(GT node) {
		return true;
		
	}

	@Override
	public boolean visit(Ident node) {
		return true;
		
	}

	@Override
	public boolean visit(Int node) {
		return true;
		
	}

	@Override
	public boolean visit(LEq node) {
		return true;
		
	}

	@Override
	public boolean visit(LT node) {
		return true;
		
	}

	@Override
	public boolean visit(Mul node) {
		return true;
		
	}

	@Override
	public boolean visit(Neg node) {
		return true;
		
	}

	@Override
	public boolean visit(NEq node) {
		return true;
		
	}

	@Override
	public boolean visit(Not node) {
		return true;
		
	}

	@Override
	public boolean visit(Or node) {
		return true;
		
	}

	@Override
	public boolean visit(Pos node) {
		return true;
		
	}

	@Override
	public boolean visit(Sub node) {
		return true;
		
	}

	@Override
	public boolean visit(BoolLiteral node) {
		return false;
		
	}

	@Override
	public boolean visit(StringLiteral node) {
		return true;
		
	}

}
