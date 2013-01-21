package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.eval.value.Value;

public interface ITypeVisitor {
	Value<?> visit( Bool node, Context context );
	Value<?> visit( Int node, Context context );
	Value<?> visit( Str node, Context context );
	Value<?> visit( Money node, Context context );
	Value<?> visit( Number node, Context context );
}
