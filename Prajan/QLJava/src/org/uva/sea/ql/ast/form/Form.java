package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.FormElementVisitor;
import org.uva.sea.ql.visitor.IForm;

public class Form extends IForm {

	private final String formname;

	private List<Question> question;
	private List<IfConditionalExpr> ifconditionalexpr;

	public Form(String formconstructor) {
		this.formname = formconstructor;
		question = new ArrayList<Question>();
		ifconditionalexpr = new ArrayList<IfConditionalExpr>();

	}

	public void addQuestion(Question q) {

		question.add(q);
		System.out.println("printed Form ");
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	public List<IfConditionalExpr> getIfconditionalexpr() {
		return ifconditionalexpr;
	}

	public void setIfconditionalexpr(List<IfConditionalExpr> ifconditionalexpr) {
		this.ifconditionalexpr = ifconditionalexpr;
	}

	public String getFormname() {
		return formname;
	}

	public void addIfConditionalExpr(IfConditionalExpr ce) {
		ifconditionalexpr.add(ce);
		System.out.println("test of CE Form ");
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T accept(FormElementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
