package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
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
import org.uva.sea.ql.ast.operative.OperatorBinary;
import org.uva.sea.ql.ast.operative.OperatorUnary;
import org.uva.sea.ql.ast.operative.Or;
import org.uva.sea.ql.ast.operative.Pos;
import org.uva.sea.ql.ast.operative.Sub;
import org.uva.sea.ql.ast.primitive.Int;
import org.uva.sea.ql.ast.primitive.Str;
import org.uva.sea.ql.ast.primitive.Undefined;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.IVisitorExpr;
import org.uva.sea.ql.util.Environment;

public class VisitorExprChecker implements IVisitorExpr<Boolean> {

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
	
	
	private boolean checkType(Expr expr, Type type){
		
		if(!expr.typeOf(environment).isCompatibleTo(type)){
			errors.add(new ErrorExpressionType(expr, type));
			return false;
		}
		
		return true;
	}
	
	
	private boolean checkExpression(Expr expression, Type type){
		
		if(!expression.accept(this))
			return false;
		
		return checkType(expression, type);
	}
	
	
	private boolean checkOperatorBinary(OperatorBinary operator, Type operandType){
		Expr lhs = operator.getLeftHandOperand();
		Expr rhs = operator.getRightHandOperand();
		
		return checkExpression(lhs, operandType) & checkExpression(rhs, operandType);
	}
	
	
	private boolean checkOperatorUnary(OperatorUnary operator, Type operandType){
		Expr op = operator.getOperand();
		return checkExpression(op, operandType);
	}
	
	
	private boolean checkEqual(OperatorBinary operator){
		
		Expr lhs = operator.getLeftHandOperand();
		Expr rhs = operator.getRightHandOperand();
		
		//check mutual compatibility
		return 	checkExpression(lhs, rhs.typeOf(environment)) & 
				checkExpression(rhs, lhs.typeOf(environment));
	}
	
	
	@Override
	public Boolean visit(Ident ident) {
		if(!ident.typeOf(environment).isDefinedType()){
			errors.add(new ErrorIdentifierScope(ident));
			return false;
		}
		
		return true;
	}

	
	public boolean errorsFound(){
		return errors.size() > 0;
	}
	
	
	public List<Error> getErrors(){
		return errors;
	}
	
	@Override
	public Boolean visit(Add operator) {
		return checkOperatorBinary(operator, new Numeric() );
	}


	@Override
	public Boolean visit(And operator) {
		return checkOperatorBinary(operator, new Bool() );
	}


	@Override
	public Boolean visit(Div operator) {
		return checkOperatorBinary(operator, new Numeric() );
	}


	@Override
	public Boolean visit(Eq operator) {
		return checkEqual(operator);
	}


	@Override
	public Boolean visit(GEq operator) {
		return checkOperatorBinary(operator, new Numeric() );
	}


	@Override
	public Boolean visit(GT operator) {
		return checkOperatorBinary(operator, new Numeric() );
	}


	@Override
	public Boolean visit(LEq operator) {
		return checkOperatorBinary(operator, new Numeric() );
	}


	@Override
	public Boolean visit(LT operator) {
		return checkOperatorBinary(operator, new Numeric() );
	}


	@Override
	public Boolean visit(Mul operator) {
		return checkOperatorBinary(operator, new Numeric() );
	}


	@Override
	public Boolean visit(Neg operator) {
		return checkOperatorUnary(operator, new Numeric() );
	}


	@Override
	public Boolean visit(NEq operator) {
		return checkEqual(operator);
	}


	@Override
	public Boolean visit(Not operator) {
		return checkOperatorUnary(operator, new Bool() );
	}


	@Override
	public Boolean visit(Or operator) {
		return checkOperatorBinary(operator, new Bool() );
	}


	@Override
	public Boolean visit(Pos operator) {
		return checkOperatorUnary(operator, new Numeric() );
	}


	@Override
	public Boolean visit(Sub operator) {
		return checkOperatorBinary(operator, new Numeric() );
	}


	@Override
	public Boolean visit(Int ast) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean visit(org.uva.sea.ql.ast.primitive.Bool ast) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean visit(Str ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Undefined ast) {
		// TODO Auto-generated method stub
		return null;
	}

}
