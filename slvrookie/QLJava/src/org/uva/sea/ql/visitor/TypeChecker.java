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
		ExprVisitor.check(ifBody.getExpression(), typeEnv, messages);
		if (!ifBody.getExpression().typeOf(typeEnv).isCompatibleToBoolType()) {
			addError("If expression must be boolean");
		}
		ifBody.getThenBody().accept(this);
	}

	public void visit(Question question) {
		isDeclared(question);
	}

	public void visit(CompQuestion compQuestion) {
		isDeclared(compQuestion);
		ExprVisitor.check(compQuestion.getQuestionExpr(), typeEnv, messages);
		if (!compQuestion.getQuestionExpr().typeOf(typeEnv).isCompatibleTo(compQuestion.getQuestionType())) {
			addError("Incompatible question type and expression");
		}
	}

	public void isDeclared(Question question) {
		if (typeEnv.containsKey(question.getQuestionID().getName())) {
			addError("Question Ident " + question.getQuestionID().getName() + " is already declared");
		} else {
			typeEnv.put(question.getQuestionID().getName(),question.getQuestionType());
		}
	}
}
