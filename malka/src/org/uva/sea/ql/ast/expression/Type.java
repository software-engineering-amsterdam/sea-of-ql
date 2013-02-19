package org.uva.sea.ql.ast.expression;


/*
import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.bool.BooleanVariable;
import org.uva.sea.ql.ast.expression.integer.IntegerVariable;
import org.uva.sea.ql.ast.expression.string.StringVariable;
import org.uva.sea.ql.ast.expression.variable.Variable;
*/

public interface Type {
	public Variable getVariable(Identifier id);
}
