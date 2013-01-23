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
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.*;

public class TypeChecker {

	private Map<Ident, Type> typeEnv = new HashMap<Ident, Type>();
	private final List<String> messages = new ArrayList<String>();
	
	public void addError(String error) {
		this.messages.add(error);
	}
	
	public List<String> getErrorList() {
		return messages;
	}
	
	public void visit(CompQuestion compQuestion) {
		// TODO Auto-generated method stub
		
	}

	public void visit(Form form) {
		for (FormElement element : form.getFormBody()) {
			if (element != null) {
				element.accept(this);
			}
		}
	}

	public void visit(IfBody ifBody) {
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
		if (typeEnv.containsKey(question.getQuestionID().getName())){
			addError("Question is already declared");
		}
		else {
			typeEnv.put(question.getQuestionID(), question.getQuestionType());
		}
		}

}
