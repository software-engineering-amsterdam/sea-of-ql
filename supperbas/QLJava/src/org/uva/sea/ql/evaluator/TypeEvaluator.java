package org.uva.sea.ql.evaluator;
import org.uva.sea.ql.ast.expression.Value;
import org.uva.sea.ql.ast.expression.value.*;
import org.uva.sea.ql.ast.type.Visitor;


public class TypeEvaluator implements Visitor<Value> {
	@Override
	public Bool visit(org.uva.sea.ql.ast.type.Bool ast) {
		return new Bool(false);
	}

	@Override
	public Str visit(org.uva.sea.ql.ast.type.Str ast) {
		return new Str("");
	}

	@Override
	public Int visit(org.uva.sea.ql.ast.type.Int ast) {
		return new Int(0);
	}

}
