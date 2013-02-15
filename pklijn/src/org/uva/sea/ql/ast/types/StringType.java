package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.values.StringValue;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.form.questiontypes.AbstractQuestionTypeComponent;
import org.uva.sea.ql.form.questiontypes.StringQuestionTypeComponent;

public class StringType extends Type {
	
	@Override
	public String toString() {
		return "String";
	}
	
	@Override
	public Value getDefaultValue() {
		return new StringValue();
	}

	@Override
	public AbstractQuestionTypeComponent getAnswerField() {
		return new StringQuestionTypeComponent();
	}

}
