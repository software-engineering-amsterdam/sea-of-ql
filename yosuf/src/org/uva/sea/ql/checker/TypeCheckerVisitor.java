package org.uva.sea.ql.checker;

import org.uva.sea.ql.ast.exp.ExpressionVisitor;
import org.uva.sea.ql.ast.type.DataTypeVisitor;

public interface TypeCheckerVisitor<T> extends ExpressionVisitor<T>, DataTypeVisitor<T> {

}
