package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.values.IntValue;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.form.questiontypes.AbstractQuestionTypeComponent;
import org.uva.sea.ql.form.questiontypes.IntQuestionTypeComponent;

public class IntType extends Type {

	@Override
	public String toString() {
		return "Integer";
	}
	
	@Override
	public Value getDefaultValue() {
		return new IntValue();
	}
	
	@Override
	public AbstractQuestionTypeComponent getAnswerField() {
		return new IntQuestionTypeComponent();
	}
}
