package org.uva.sea.ql.visitor.statement;

import org.uva.sea.ql.ast.statement.*;

public interface StatementVisitor<T> {
    T visit(Assignment node);
    T visit(IfStatement node);
    T visit(ComputedAssignment node);
    T visit(Block node);
    T visit(ObservableStatement node);
}
