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

public class TypeChecker {

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
			if (element != null) {
				element.accept(this);
			}
		}
	}

	public void visit(IfThen ifBody) {
		isExpressionBoolean(ifBody);
		ifBody.getThenBody().accept(this);
	}
	
	public void visit(IfThenElse ifBody) {
		isExpressionBoolean(ifBody);
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
		if (typeEnv.containsKey(question.getQuestionID().getName())) {
			addError("Question Ident " + question.getQuestionID().getName() + " is already declared");
		} else {
			typeEnv.put(question.getQuestionID().getName(),question.getQuestionType());
		}
	}
	
	public void isExpressionBoolean(IfThen ifBody){
		ExprVisitor.check(ifBody.getExpression(), typeEnv, messages);
		if (!ifBody.getExpression().typeOf(typeEnv).isCompatibleToBoolType()) {
			addError("If expression must be boolean");
		}
	}
	
}
