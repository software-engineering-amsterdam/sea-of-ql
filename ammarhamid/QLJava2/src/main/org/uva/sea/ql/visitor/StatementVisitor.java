package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statement.impl.AssignmentNode;
import org.uva.sea.ql.ast.statement.impl.BlockNode;
import org.uva.sea.ql.ast.statement.impl.IfNode;

public interface StatementVisitor
{
    void visit(AssignmentNode assignmentNode);
    void visit(BlockNode blockNode);
    void visit(IfNode ifNode);
}
