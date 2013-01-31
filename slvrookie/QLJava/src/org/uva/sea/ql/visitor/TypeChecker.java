package org.uva.sea.ql.visitor;

import java.util.ArrayList;
import java.util.HashMap;
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

	private Map<String, Type> typeEnv = new HashMap<String, Type>();
	private final List<String> messages = new ArrayList<String>();

	public void addError(String error) {
		this.messages.add(error);
	}

	public List<String> getErrorList() {
		return messages;
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
		ExprVisitor.check(compQuestion.getQuestionExpr(), typeEnv, messages);
		if (!compQuestion.getQuestionExpr().typeOf(typeEnv).isCompatibleTo(compQuestion.getQuestionType())) {
			addError("Incompatible question type and expression");
		}
	}

	public void isIdentDeclared(Question question) {
		if (typeEnv.containsKey(question.getQuestionName().getName())) {
			addError("Question Ident " + question.getQuestionName().getName() + " is already declared");
		} else {
			typeEnv.put(question.getQuestionName().getName(),question.getQuestionType());
		}
	}
	
	public void isConditionBoolean(IfThen ifBody){	
		ExprVisitor.check(ifBody.getCondition(), typeEnv, messages) ;
		if (!ifBody.getCondition().typeOf(typeEnv).isCompatibleToBoolType()) {
			addError("If condition must be boolean");
		}
	}
	
}
