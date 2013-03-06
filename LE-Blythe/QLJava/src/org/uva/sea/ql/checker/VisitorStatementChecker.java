package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IVisitorStatement;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionAnswerable;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.util.Environment;

public class VisitorStatementChecker implements IVisitorStatement<Boolean> {

	private Environment<Ident, Type> environment;
	private List<Error> errors;
	
	
	public VisitorStatementChecker(){
		environment = new Environment<Ident, Type>();
		errors = new ArrayList<Error>();
	}

	
	public VisitorStatementChecker(Environment<Ident, Type> env, List<Error> errors){
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
		return 	expression.accept(new VisitorExpressionChecker(environment, errors)) 
				&
				checkType(expression, type);
	}
	

	private boolean identifierExists(Ident ident){
		if(environment.contains(ident)){
			errors.add(new ErrorIdentifierExists(ident));
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean visit(Form form) {
		return form.getBlock().accept(this);
	}

	@Override
	public Boolean visit(Block block) {
		
		//create a new instance of the visitor checker which uses a clone 
		//of the current environment. We do this because any identifiers
		//declared within this block must stay within the scope of this block
		VisitorStatementChecker blockVisitor = new VisitorStatementChecker(environment.branchEnvironment(), errors);
		
		boolean result = true;
		
		for(Statement stmt: block.getStatements()){
			result &= stmt.accept(blockVisitor);
		}
		
		return result;
	}
	
	@Override
	public Boolean visit(IfThen branch) {

		Type type = new BoolType();
		
		return 	checkExpression(branch.getIfCondition(), type) &
				branch.getIfBlock().accept(this);
	}
	
	@Override
	public Boolean visit(IfThenElse branch) {
		Type type = new BoolType();
		
		return 	checkExpression(branch.getIfCondition(), type) &
				branch.getIfBlock().accept(this) &
				branch.getElseBlock().accept(this);
	}
	
	@Override
	public Boolean visit(QuestionAnswerable question) {
		
		Ident ident = question.getIdentifier();
		Type type = question.getType();
		
		if(!identifierExists(ident)){
			environment.put(ident, type );
			return true;
		}
	
		return false;
	}
	
	@Override
	public Boolean visit(QuestionComputed question) {
		
		Ident ident = question.getIdentifier();
		Expr val = question.getExpression();
		
		//the type of the declared identifier is inferred from the
		//type of the expression that follows it's definition.
		//i.e. val:integer has type integer
		//i.e. val:a+b has type numeric
		Type typeOfIdent = question.typeOf(environment);
		
		if(!checkExpression(val, typeOfIdent))
			return false;
		
		if(!identifierExists(ident)){
			environment.put(ident, typeOfIdent);
			return true;
		}
		
		return false;
	}
	
	
	public boolean errorsFound(){
		return errors.size() > 0;
	}
	
	
	public List<Error> getErrors(){
		return errors;
	}
	
}
