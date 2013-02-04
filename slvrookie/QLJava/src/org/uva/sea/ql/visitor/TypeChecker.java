package org.uva.sea.ql.visitor;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.CompQuestion;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.FormElement;
import org.uva.sea.ql.ast.IfThen;
import org.uva.sea.ql.ast.IfThenElse;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.types.*;

public class TypeChecker implements ITypeChecker {

	private final Map<String, Type> typeEnv;
	private final List<String> errors;
	
	public TypeChecker(Map<String, Type> tenv, List<String> errors) {
		this.typeEnv = tenv;
		this.errors = errors;
	}
	
	public static void check(Form form) {
		Map<String,Type> typeEnv= new LinkedHashMap<String,Type>();
		List<String> error= new ArrayList<String>();
		TypeChecker check = new TypeChecker(typeEnv, error);
		form.accept(check);
		getErrors(error);
	}
	

	public void addError(String error) {
		errors.add(error);
	}

	  private static void getErrors(List<String> errors){
	    	for(String error: errors){
	    		System.out.println(error);
	    	}
	    }

	public void visit(Form form) {
		form.getFormBody().accept(this);
	}
	
	public void visit(Block block) {
		for (FormElement element : block.getBlock()) {
				element.accept(this);
		}
	}

	public void visit(IfThen ifBody) {
		isConditionBoolean(ifBody);
		ifBody.getThenBody().accept(this);
	}
	
	public void visit(IfThenElse ifBody) {
		isConditionBoolean(ifBody);
		ifBody.getThenBody().accept(this);
		ifBody.getElseBody().accept(this);
	}

	public void visit(Question question) {
		isIdentDeclared(question);
	}

	public void visit(CompQuestion compQuestion) {
		isIdentDeclared(compQuestion);
		ExprVisitor.check(compQuestion.getQuestionExpr(), typeEnv, errors);
		if (!compQuestion.getQuestionExpr().typeOf(typeEnv).isCompatibleTo(compQuestion.getQuestionType())) {
			addError("Incompatible type and expression at " + compQuestion.getQuestionName().getName() + ". Expected " + compQuestion.getQuestionType().getClass().getSimpleName() + " but got " + compQuestion.getQuestionExpr().typeOf(typeEnv).getClass().getSimpleName() + ".");
		}
	}

	public void isIdentDeclared(Question question) {
		if (typeEnv.containsKey(question.getQuestionName().getName())) {
			addError("Question Ident: " + question.getQuestionName().getName() + " is already declared.");
		} else {
			typeEnv.put(question.getQuestionName().getName(),question.getQuestionType());
		}
	}
	
	public void isConditionBoolean(IfThen ifBody){	
		ExprVisitor.check(ifBody.getCondition(), typeEnv, errors) ;
		if (!ifBody.getCondition().typeOf(typeEnv).isCompatibleToBoolType()) {
			addError("If condition must be Boolean.");
		}
	}
	
}
