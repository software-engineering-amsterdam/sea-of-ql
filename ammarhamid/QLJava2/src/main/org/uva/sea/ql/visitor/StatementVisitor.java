package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statement.impl.AssignmentNode;
import org.uva.sea.ql.ast.statement.impl.ComputedNode;
import org.uva.sea.ql.ast.statement.impl.IfNode;

public interface StatementVisitor
{
    void visit(AssignmentNode assignmentNode);

    void visit(ComputedNode computedNode);

    void visit(IfNode ifNode);
}
