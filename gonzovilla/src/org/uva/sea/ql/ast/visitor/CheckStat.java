package org.uva.sea.ql.ast.visitor;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.ComputedQuestion;
import org.uva.sea.ql.ast.stat.Form;
import org.uva.sea.ql.ast.stat.FormUnit;
import org.uva.sea.ql.ast.stat.IfElseStatement;
import org.uva.sea.ql.ast.stat.IfStatement;
import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.ast.types.Type;

public class CheckStat implements VisitorStatements<Boolean> {

	private final Map<String, Type> typeEnv;
	private final List<String> messages;
	private CheckExpr checkExpr;
	
	public CheckStat(Map<String, Type> tenv, List<String> messages) {
		this.typeEnv = tenv;
		this.messages = messages;
		checkExpr = new CheckExpr(tenv, messages);
	}
	
	public void addError(String errors) {
		this.messages.add(errors);
	}
	
	public Boolean check(Form form, Map<String, Type> typeEnv, List<String> messages) {
		CheckStat check = new CheckStat(typeEnv, messages);
		return form.accept(check);
	}
	
	@Override
	public Boolean visit(Form form) {
		Boolean returnValue = form.getBody().accept(this);
		printErrMsg();
		return returnValue;
	}
	
	@Override
	public Boolean visit(ComputedQuestion computedQuestion) {
		boolean returnValue = true;
		Ident ident = computedQuestion.getName();
		Expr expression = computedQuestion.getExpression();
		Type type = computedQuestion.getType();
		
		if(typeEnv.get(ident.getName())!= null){
			messages.add("Ident" + ident.getName() + "is already declared");
			returnValue = false;
		}else{
			typeEnv.put(ident.getName(), type);
		}
		
		returnValue = checkExpr.check(expression,typeEnv,messages) && returnValue;
		if(!expression.typeOf(typeEnv).isCompatibleTo(type)){
			messages.add("Expression type problem in the computed question " + ident.getName());
			returnValue = false;
		}
		return returnValue;
	}
	
	@Override
	public Boolean visit(Question question) {
		boolean returnValue = true;
		Ident ident = question.getName();
		Type type = question.getType();		
		
		if(typeEnv.get(ident.getName())!= null){
			messages.add("Ident" + ident.getName() + "is already declared");
			returnValue = false;
		}else{
			typeEnv.put(ident.getName(), type);
		}
		return returnValue;
	}
	
	@Override
	public Boolean visit(IfStatement ifStatement) {
		boolean returnValue = true;
		Expr condition = ifStatement.getCondition();
		
		checkExpr.check(condition,typeEnv,messages);
		if (!condition.typeOf(typeEnv).isCompatibleToTypeBool()){
			messages.add("The condition must be boolean (If).");
			returnValue = false;
		}
		returnValue = (ifStatement.getBody().accept(this)) && returnValue;
		return returnValue;
	}
	
	@Override
	public Boolean visit(IfElseStatement ifElseStatement) {
		boolean returnValue = true;
		Expr condition = ifElseStatement.getCondition();
		
		checkExpr.check(condition,typeEnv,messages);
		if (!condition.typeOf(typeEnv).isCompatibleToTypeBool()){
			messages.add("The condition must be boolean (IfElse).");
			returnValue = false;
		}
		returnValue = (ifElseStatement.getIfBody().accept(this)) && returnValue;
		returnValue = (ifElseStatement.getElseBody().accept(this)) && returnValue;
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

	public void printErrMsg(){
		for(String s : messages){
			System.out.println(s);
		}
	}
	
}