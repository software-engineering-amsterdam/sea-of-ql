package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statement.AssignmentNode;
import org.uva.sea.ql.ast.statement.BlockNode;
import org.uva.sea.ql.ast.statement.IfNode;

public interface StatementVisitor
{
    void visit(AssignmentNode assignmentNode);
    void visit(BlockNode blockNode);
    void visit(IfNode ifNode);
}
