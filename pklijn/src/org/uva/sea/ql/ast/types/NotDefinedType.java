package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.form.questiontypes.AbstractQuestionTypeComponent;

public class NotDefinedType extends Type {

	@Override
	public String toString() {
		return "<NOT DEFINED>";
	}

	@Override
	public boolean isDefined() {
		return false;
	}
	
	@Override
	public Value getDefaultValue() {
		return null;
	}

	@Override
	public AbstractQuestionTypeComponent getAnswerField() {
		 return null;
	};
}
