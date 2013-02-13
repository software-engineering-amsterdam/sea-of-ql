package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.OperatorBinary;
import org.uva.sea.ql.ast.OperatorUnary;
import org.uva.sea.ql.ast.operative.Add;
import org.uva.sea.ql.ast.operative.And;
import org.uva.sea.ql.ast.operative.Div;
import org.uva.sea.ql.ast.operative.Eq;
import org.uva.sea.ql.ast.operative.GEq;
import org.uva.sea.ql.ast.operative.GT;
import org.uva.sea.ql.ast.operative.LEq;
import org.uva.sea.ql.ast.operative.LT;
import org.uva.sea.ql.ast.operative.Mul;
import org.uva.sea.ql.ast.operative.NEq;
import org.uva.sea.ql.ast.operative.Neg;
import org.uva.sea.ql.ast.operative.Not;
import org.uva.sea.ql.ast.operative.Or;
import org.uva.sea.ql.ast.operative.Pos;
import org.uva.sea.ql.ast.operative.Sub;
import org.uva.sea.ql.ast.primitive.Int;
import org.uva.sea.ql.ast.primitive.Str;
import org.uva.sea.ql.ast.primitive.Undefined;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.checker.errors.Error;
import org.uva.sea.ql.checker.errors.ExpressionTypeError;
import org.uva.sea.ql.checker.errors.IdentifierScopeError;
import org.uva.sea.ql.interfaces.IVisitorExpr;
import org.uva.sea.ql.util.Environment;

public class VisitorExprChecker implements IVisitorExpr<Void> {

	private Environment environment;
	private List<Error> errors;
	
	
	public VisitorExprChecker(){
		environment = new Environment();
		errors = new ArrayList<Error>();
	}

	
	public VisitorExprChecker(Environment env, List<Error> errors){
		this.environment = env;
		this.errors = errors;
	}
	
	
	private Void checkType(Expr expr, Type type){
		
		if(!expr.typeOf(environment).isCompatibleTo(type)){
			errors.add(new ExpressionTypeError(expr, type));
		}
		
		return null;
	}
	
	
	private Void checkExpression(Expr expression, Type type){
		expression.accept(this);
		checkType(expression, type);
		return null;
	}
	
	
	private Void checkOperatorBinary(OperatorBinary operator, Type operandType){
		Expr lhs = operator.getLeftHandOperand();
		Expr rhs = operator.getRightHandOperand();
		
		checkExpression(lhs, operandType);
		checkExpression(rhs, operandType);
		return null;
	}
	
	
	private Void checkOperatorUnary(OperatorUnary operator, Type operandType){
		Expr op = operator.getOperand();
		checkExpression(op, operandType);
		return null;
	}
	
	
	@Override
	public Void visit(Ident ident) {
		if(!ident.typeOf(environment).isDefinedType()){
			errors.add(new IdentifierScopeError(ident));
		}
		
		return null;
	}

	
	public boolean errorsFound(){
		return errors.size() > 0;
	}
	
	
	public List<Error> getErrors(){
		return errors;
	}
	
	@Override
	public Void visit(Add operator) {
		checkOperatorBinary(operator, new Numeric() );
		return null;
	}


	@Override
	public Void visit(And operator) {
		checkOperatorBinary(operator, new Bool() );
		return null;
	}


	@Override
	public Void visit(Div operator) {
		checkOperatorBinary(operator, new Numeric() );
		return null;
	}


	@Override
	public Void visit(Eq operator) {
		checkOperatorBinary(operator, new Numeric() );
		return null;
	}


	@Override
	public Void visit(GEq operator) {
		checkOperatorBinary(operator, new Numeric() );
		return null;
	}


	@Override
	public Void visit(GT operator) {
		checkOperatorBinary(operator, new Numeric() );
		return null;
	}


	@Override
	public Void visit(LEq operator) {
		checkOperatorBinary(operator, new Numeric() );
		return null;
	}


	@Override
	public Void visit(LT operator) {
		checkOperatorBinary(operator, new Numeric() );
		return null;
	}


	@Override
	public Void visit(Mul operator) {
		checkOperatorBinary(operator, new Numeric() );
		return null;
	}


	@Override
	public Void visit(Neg operator) {
		checkOperatorUnary(operator, new Numeric() );
		return null;
	}


	@Override
	public Void visit(NEq operator) {
		checkOperatorBinary(operator, new Numeric() );
		return null;
	}


	@Override
	public Void visit(Not operator) {
		checkOperatorUnary(operator, new Bool() );
		return null;
	}


	@Override
	public Void visit(Or operator) {
		checkOperatorBinary(operator, new Bool() );
		return null;
	}


	@Override
	public Void visit(Pos operator) {
		checkOperatorUnary(operator, new Numeric() );
		return null;
	}


	@Override
	public Void visit(Sub operator) {
		checkOperatorBinary(operator, new Numeric() );
		return null;
	}


	@Override
	public Void visit(Int ast) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Void visit(org.uva.sea.ql.ast.primitive.Bool ast) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Void visit(Str ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Undefined ast) {
		// TODO Auto-generated method stub
		return null;
	}

}
