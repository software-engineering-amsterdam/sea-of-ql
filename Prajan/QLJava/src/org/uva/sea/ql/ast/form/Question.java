package org.uva.sea.ql.ast.form;

import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.FormElementVisitor;
import org.uva.sea.ql.visitor.IForm;

public class Question implements IForm {
	public final String questionText;
	private Declaration declaration;
	private Calculation calculation;

	public Question(String passquestion) {
		this.questionText = passquestion;

	}

	public void addDeclaration(Declaration d) {
		declaration = d;
	}

	public void addCalculation(Calculation c) {
		calculation = c;
	}

	public Declaration getDeclaration() {
		return declaration;
	}

	public void setDeclaration(Declaration declaration) {
		this.declaration = declaration;
	}

	public Calculation getCalculation() {
		return calculation;
	}

	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}

	public String getQuestionText() {
		return questionText;
	}

	public boolean isDeclaration() {
		return declaration != null;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return null;
	}

	@Override
	public <T> T accept(FormElementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
