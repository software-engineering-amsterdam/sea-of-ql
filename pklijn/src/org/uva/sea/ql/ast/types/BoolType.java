package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.form.questiontypes.AbstractQuestionTypeComponent;
import org.uva.sea.ql.form.questiontypes.BoolQuestionTypeComponent;

public class BoolType extends Type {
	
	@Override
	public String toString() {
		return "Boolean";
	}
	
	@Override
	public Value getDefaultValue() {
		return new BoolValue();
	}

	@Override
	public AbstractQuestionTypeComponent getAnswerField() {
		return new BoolQuestionTypeComponent();
	}

}
