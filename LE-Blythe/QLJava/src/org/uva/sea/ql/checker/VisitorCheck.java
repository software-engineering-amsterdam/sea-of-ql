package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.OperatorBinary;
import org.uva.sea.ql.ast.OperatorUnary;
import org.uva.sea.ql.ast.Statement;
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
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.Branch;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.errors.Error;
import org.uva.sea.ql.errors.ExpressionTypeError;
import org.uva.sea.ql.errors.IdentifierExistsError;
import org.uva.sea.ql.errors.IdentifierScopeError;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Environment;

public class VisitorCheck implements IVisitor<Void> {

	private Environment environment;
	private List<Error> errors;
	
	
	public VisitorCheck(){
		environment = new Environment();
		errors = new ArrayList<Error>();
	}

	
	public VisitorCheck(Environment env, List<Error> errors){
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
	

	private Void checkBlock(Block block){
		if(block != null)
			block.accept(this);	
		
		return null;
	}
	
	
	private boolean identifierExists(Ident ident){
		if(environment.contains(ident)){
			errors.add(new IdentifierExistsError(ident));
			return true;
		}
		
		return false;
	}

	@Override
	public Void visit(Ident ident) {
		if(!ident.typeOf(environment).isDefinedType()){
			errors.add(new IdentifierScopeError(ident));
		}
		
		return null;
	}

	@Override
	public Void visit(Form form) {
		form.getBlock().accept(this);
		return null;
	}

	@Override
	public Void visit(Block block) {
		
		//create a new instance of the visitor checker which uses a clone 
		//of the current environment. We do this because any identifiers
		//declared within this block must stay within the scope of this block
		VisitorCheck blockVisitor = new VisitorCheck(environment.clone(), errors);
		
		for(Statement stmt: block.getStatements()){
			stmt.accept(blockVisitor);
		}
		
		return null;
	}
	
	@Override
	public Void visit(Branch branch) {

		Type type = new Bool();
		checkExpression(branch.getIfCondition(), type);
		checkBlock(branch.getIfBlock());
		checkBlock(branch.getElseBlock());
		
		return null;
	}
	
	@Override
	public Void visit(Question question) {
		
		Ident ident = question.getIdentifier();
		Expr val = question.getValue();
		
		//the type of the declared identifier is inferred from the
		//type of the expression that follows it's definition.
		//i.e. val:integer has type integer
		//i.e. val:a+b has type numeric
		Type typeOfIdent = question.getValue().typeOf(environment);
		
		
		checkExpression(val, typeOfIdent);
		
		if(!identifierExists(ident))
			environment.add(ident, val);
		
		return null;
	}
	
	
	public boolean errorsFound(){
		return errors.size() > 0;
	}
	
	
	public List<Error> getErrors(){
		return errors;
	}


	/*@Override
	public Void visit(OperatorBinaryBoolean operator) {
		checkOperatorBinary(operator, new Bool() );
		return null;
			
	}


	public Void visit(OperatorBinaryNumeric operator) {
		checkOperatorBinary(operator, new Numeric() );
		return null;
	}


	public Void visit(OperatorBinaryComparative operator) {
		checkOperatorBinary(operator, new Numeric() );
		return null;
	}


	public Void visit(OperatorUnaryBoolean operator) {
		checkOperatorUnary(operator, new Bool() );
		return null;
	}


	public Void visit(OperatorUnaryNumeric operator) {
		checkOperatorUnary(operator, new Numeric() );
		return null;
	}*/
	
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
	
}
