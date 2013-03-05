package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.FormElementVisitor;
import org.uva.sea.ql.visitor.IForm;

public class Question extends IForm {
	public final String questionText;
	private List<Declaration> declaration;
	private List<Calculation> calculation;

	public Question(String passquestion) {

		this.questionText = passquestion;
		System.out.println(passquestion + "---------------------");
		declaration = new ArrayList<Declaration>();
		calculation = new ArrayList<Calculation>();
	}

	public void addDeclaration(Declaration d) {
		declaration.add(d);
		System.out.println("declaration Question");
	}

	public void addCalculation(Calculation c) {
		calculation.add(c);
		System.out.println("calcution Question ");
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

	public List<Declaration> getDeclaration() {
		return declaration;
	}

	public void setDeclaration(List<Declaration> declaration) {
		this.declaration = declaration;
	}

	public List<Calculation> getCalculation() {
		return calculation;
	}

	public void setCalculation(List<Calculation> calculation) {
		this.calculation = calculation;
	}

	public String getQuestionText() {
		return questionText;
	}
}
