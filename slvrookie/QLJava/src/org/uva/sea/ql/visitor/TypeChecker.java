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
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
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
	Expr boolCondition = ifBody.getExpression();
		
	ExprVisitor.check(boolCondition, typeEnv, messages);
	if (!boolCondition.typeOf(typeEnv).isCompatibleToBoolType()) {
		addError("If expression must be boolean");
	}
		
		for (FormElement element : ifBody.getIfElements()) {
			if (element != null) {
				element.accept(this);
			}
		}
	} 

	public void visit(Question question) {
		if (typeEnv.containsKey(question.getQuestionID().getName())){
			addError("Question identifier is already declared");
		}
		else {
			typeEnv.put(question.getQuestionID().getName(), question.getQuestionType());
		}
	}
	
	public void visit(CompQuestion compQuestion) {
		if (typeEnv.containsKey(compQuestion.getQuestionID().getName())){
			addError("Question identifier is already declared");
		}
		else {

			typeEnv.put(compQuestion.getQuestionID().getName(), compQuestion.getQuestionType());
		}
		ExprVisitor.check(compQuestion.getQuestionExpr(), typeEnv, messages);
		if (!compQuestion.getQuestionExpr().typeOf(typeEnv).isCompatibleTo(compQuestion.getQuestionType()))
		{
			addError("Incompatible question type and expression");
			
		}
		
	}

}
