package org.uva.sea.ql.ast.visitor;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.ComputedQuestion;
import org.uva.sea.ql.ast.stat.Form;
import org.uva.sea.ql.ast.stat.FormUnit;
import org.uva.sea.ql.ast.stat.IfStatement;
import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.ast.types.Type;

public class CheckStat implements VisitorStatements<Boolean> {

	private final Map<Ident, Type> typeEnv;
	private final List<String> messages;
	
	private CheckStat(Map<Ident, Type> tenv, List<String> messages) {
		this.typeEnv = tenv;
		this.messages = messages;
	}
	
	public void addError(String errors) {
		this.messages.add(errors);
	}
	
	@Override
	public Boolean visit(Form form) {
		return form.getBody().accept(this);
	}
	
	@Override
	public Boolean visit(ComputedQuestion computedQuestion) {
		boolean returnValue = true;
		String name = computedQuestion.getName().getName();
		Expr expression = computedQuestion.getExpression();
		Type type = computedQuestion.getType();
		
		if(typeEnv.get(name)!= null){
			messages.add("Ident" + name + "is already declared");
			returnValue = false;
		}else{
			typeEnv.put(computedQuestion.getName(), type);
		}
		
		returnValue = (CheckExpr.check(expression,typeEnv,messages)) && returnValue;
		returnValue = (expression.typeOf(typeEnv).isCompatibleTo(type)) && returnValue;
		
		return returnValue;
	}
	
	@Override
	public Boolean visit(Question question) {
		boolean returnValue = true;
		String name = question.getName().getName();
		Type type = question.getType();		
		
		if(typeEnv.get(name)!= null){
			messages.add("Ident" + name + "is already declared");
			returnValue = false;
		}else{
			typeEnv.put(question.getName(), type);
		}
		
		return returnValue;
	}
	
	@Override
	public Boolean visit(IfStatement ifStatement) {
		boolean returnValue = true;
		Expr condition = ifStatement.getCondition();
		
		returnValue = CheckExpr.check(condition,typeEnv,messages);
		if (!condition.typeOf(typeEnv).isCompatibleToTypeBool()){
			messages.add("The condition must be boolean.");
			returnValue = false;
		}
		returnValue = (ifStatement.getIfBody().accept(this)) && returnValue;
		returnValue = (ifStatement.getElseBody().accept(this)) && returnValue;
		
		return returnValue;
	}
	
	@Override
	public Boolean visit(Block block) {
		boolean returnValue = true;
		
		for (FormUnit formUnit: block.getBody()) {
			returnValue = formUnit.accept(this) && returnValue;
		}
		
		return returnValue;
	}
	
}