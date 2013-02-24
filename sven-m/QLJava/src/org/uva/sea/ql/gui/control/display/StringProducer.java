package org.uva.sea.ql.gui.control.display;

import org.uva.sea.ql.parser.evaluator.result.BoolValue;
import org.uva.sea.ql.parser.evaluator.result.IntValue;
import org.uva.sea.ql.parser.evaluator.result.StrValue;
import org.uva.sea.ql.parser.evaluator.result.UndefinedValue;
import org.uva.sea.ql.parser.evaluator.result.Value;
import org.uva.sea.ql.parser.evaluator.result.ValueVisitor;

public class StringProducer implements ValueVisitor<String> {
	private static StringProducer instance;
	
	private StringProducer() {	}
	
	public static String toString(Value value) {
		if (instance == null) {
			instance = new StringProducer();
		}
		
		return value.accept(instance);
	}
	
	@Override
	public String visit(BoolValue value) {
		return value.getValue() ? "Yes" : "No";
	}

	@Override
	public String visit(IntValue value) {
		return Integer.toString(value.getValue());
	}

	@Override
	public String visit(StrValue value) {
		return value.getValue();
	}

	@Override
	public String visit(UndefinedValue value) {
		return "";
	}

}
