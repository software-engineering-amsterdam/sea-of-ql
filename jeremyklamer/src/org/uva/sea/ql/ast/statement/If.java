package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.message.Error;
import org.uva.sea.ql.message.Message;

public class If extends Statement{
	
	private final Expr condition; 
	private final List<Statement> ifBody; 
	
	public If(Expr condition, List<Statement> ifBody){
		this.condition = condition;
		this.ifBody = ifBody;
	}

	public Expr getCondition() {
		return condition;
	}

	public List<Statement> getIfBody() {
		return ifBody;
	}

	@Override
	public List<Message> checkType(Map<Ident, Type> typeEnv) {
		ArrayList<Message> errors = new ArrayList<Message>();
		if(!(condition.typeOf(typeEnv).isCompatibleToBool())){
			errors.add(new Error("Condition does not resolve to Bool"));
		}
		
		errors.addAll(condition.checkType(typeEnv));		
		for(Statement statement : ifBody){
			errors.addAll(statement.checkType(typeEnv));
		}
		return errors;
	}
	
	@Override
	public void printSelf(int indentation){
		printIndentation(indentation);
		System.out.println(getSimpleName(this) + ", Condition : " + getSimpleName(this.condition));
		
		for(Statement statement : ifBody){
			statement.printSelf(indentation + 1);
		}
	}
	
}
