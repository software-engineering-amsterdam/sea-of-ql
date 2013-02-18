package visitor.evaluator;
import ast.expression.Value;
import ast.expression.value.*;
import ast.type.Visitor;

public class TypeEvaluator implements Visitor<Value> {
	@Override
	public Bool visit(ast.type.Bool ast) {
		return new Bool(false);
	}

	@Override
	public Str visit(ast.type.Str ast) {
		return new Str("");
	}

	@Override
	public Int visit(ast.type.Int ast) {
		return new Int(0);
	}

}
