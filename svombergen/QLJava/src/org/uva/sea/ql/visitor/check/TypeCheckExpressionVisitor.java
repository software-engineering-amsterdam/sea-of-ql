package org.uva.sea.ql.visitor.check;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.binaryexpr.*;
import org.uva.sea.ql.ast.primaryexpr.*;
import org.uva.sea.ql.ast.statements.types.*;
import org.uva.sea.ql.ast.unaryexpr.*;
import org.uva.sea.ql.gui.Environment;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.Messages;

public class TypeCheckExpressionVisitor implements IExpressionVisitor<Boolean> {
	private Environment environment = new Environment();
	private Messages 	errorMsgs, 
						warningMsgs;
	
	public TypeCheckExpressionVisitor() {
		errorMsgs = new Messages("Errors"); 
		warningMsgs = new Messages("Warnings");
	}
	
	public TypeCheckExpressionVisitor(Environment envir, Messages errMsgs, Messages warnMsgs) {
		environment = envir;
		errorMsgs = errMsgs;
		warningMsgs = warnMsgs;
	}
	
	private boolean isBinaryNumeric(BinaryExpr exp) {
		Expr left = exp.getLeft();
		Expr right = exp.getRight();
		
		if ( left.accept(this) && right.accept(this) )
			return 	(left.typeOf(environment).equals(new IntType()) &&
					right.typeOf(environment).equals(new IntType()));
		else
			return false;
	}
	
	private boolean isBinaryBoolean(BinaryExpr exp) {
		Expr left = exp.getLeft();
		Expr right = exp.getRight();
		
		if ( left.accept(this) && right.accept(this) )
			return 	(left.typeOf(environment).equals(new BoolType()) &&
					right.typeOf(environment).equals(new BoolType()));
		else
			return false;
	}
	
	private boolean isBinaryBooleanOrNumeric(BinaryExpr exp) {
		Expr left = exp.getLeft();
		Expr right = exp.getRight();
		
		if ( left.accept(this) && right.accept(this) )
			return 	((left.typeOf(environment).equals(new IntType()) &&
					right.typeOf(environment).equals(new IntType())) ||
					left.typeOf(environment).equals(new BoolType()) &&
					right.typeOf(environment).equals(new BoolType()));
		else
			return false;
	}
	
	public Messages returnErrorMsgs() {
		return errorMsgs;
	}

	public Messages returnWarningMsgs() {
		return warningMsgs;
	}
	
	//Primary Expressions
	@Override
	public Boolean visit(Ident id) {
		if ( !environment.containsKey(id) ) {
			errorMsgs.add(String.format("Undefined variable: %s", id));
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(Int exp) {
		if (!exp.typeOf(environment).equals(new IntType())) {
			errorMsgs.add(String.format("Incorrect Int: %s", exp));;
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Str exp) {
		if (!exp.typeOf(environment).equals(new StrType())) {
			errorMsgs.add(String.format("Incorrect Str: %s", exp));;
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(Bool exp) {
		if (!exp.typeOf(environment).equals(new BoolType())) {
			errorMsgs.add(String.format("Incorrect Bool: %s", exp));;
			return false;
		}
		return true;
	}
	
	//Binary Expressions
	@Override
	public Boolean visit(Add exp) {
		if ( !isBinaryNumeric(exp) ) {
			errorMsgs.add(String.format("Incorrect addition: %s", exp));
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(Div exp) {
		if ( !isBinaryNumeric(exp) ) {
			errorMsgs.add(String.format("Incorrect division: %s", exp));
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(Mul exp) {
		if ( !isBinaryNumeric(exp) ) {
			errorMsgs.add(String.format("Incorrect multiplication: %s", exp));
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(Sub exp) {
		if ( !isBinaryNumeric(exp) ) {
			errorMsgs.add(String.format("Incorrect subtraction: %s", exp));
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(And exp) {
		if ( !isBinaryBoolean(exp) ) {
			errorMsgs.add(String.format("Incorrect And expression: %s", exp));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Or exp) {
		if ( !isBinaryBoolean(exp) ) {
			errorMsgs.add(String.format("Incorrect Or expression: %s", exp));
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(Eq exp) {
		if ( !isBinaryBooleanOrNumeric(exp) ) {
			errorMsgs.add(String.format("Incorrect Eq operation: %s", exp));
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(GEq exp) {
		if ( !isBinaryNumeric(exp) ) {
			errorMsgs.add(String.format("Non-numeric GEq operation: %s", exp));
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(GT exp) {
		if ( !isBinaryNumeric(exp) ) {
			errorMsgs.add(String.format("Non-numeric GT operation: %s", exp));
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(LEq exp) {
		if ( !isBinaryNumeric(exp) ) {
			errorMsgs.add(String.format("Non-numeric LEq operation: %s", exp));
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(LT exp) {
		if ( !isBinaryNumeric(exp) ) {
			errorMsgs.add(String.format("Non-numeric LT operation: %s", exp));
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(NEq exp) {
		if ( !isBinaryBooleanOrNumeric(exp) ) {
			errorMsgs.add(String.format("Incorrect NEq operation: %s", exp));
			return false;
		}
		return true;
	}
	
	//Unary Expressions
	@Override
	public Boolean visit(Neg exp) {
		Expr unExpr = exp.getExpr();
		if (!(unExpr.typeOf(environment) == new IntType())) {
			errorMsgs.add(String.format("Neg expression is not numeric: %s", exp));
			return false;
		}
		return unExpr.accept(this);
	}

	@Override
	public Boolean visit(Pos exp) {
		Expr unExpr = exp.getExpr();
		if (!(unExpr.typeOf(environment) == new IntType())) {
			errorMsgs.add(String.format("Pos expression is not numeric: %s", exp));
			return false;
		}
		return unExpr.accept(this);
	}
	
	@Override
	public Boolean visit(Not exp) {
		Expr unExpr = exp.getExpr();
		if (!(unExpr.typeOf(environment) == new BoolType())) {
			errorMsgs.add(String.format("Not expression is not a boolean: %s", exp));
			return false;
		}
		return unExpr.accept(this);
	}

	
}
