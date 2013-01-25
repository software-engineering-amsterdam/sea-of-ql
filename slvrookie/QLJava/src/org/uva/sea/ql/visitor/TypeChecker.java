package org.uva.sea.ql.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.CompQuestion;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.FormElement;
import org.uva.sea.ql.ast.IfBody;
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
		for (FormElement element : form.getFormBody()) {
			if (element != null) {
				element.accept(this);
			}
		}
	}

	public void visit(IfBody ifBody) {
		ExprVisitor.check(ifBody.getExpression(), typeEnv, messages);
		if (!ifBody.getExpression().typeOf(typeEnv).isCompatibleToBoolType()) {
			addError("If expression must be boolean");
		}

		for (FormElement element : ifBody.getIfElements()) {
			if (element != null) {
				element.accept(this);
			}
		}
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
		System.out.println(compQuestion.getQuestionExpr().typeOf(typeEnv));
	}

	public void isDeclared(Question question) {
		if (typeEnv.containsKey(question.getQuestionID().getName())) {
			addError("Question Ident " + question.getQuestionID().getName() + " is already declared");
		} else {
			typeEnv.put(question.getQuestionID().getName(),question.getQuestionType());
		}
	}

}
