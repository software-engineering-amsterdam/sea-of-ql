package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.StatementVisitor;

public interface Statement extends Node
{
    void accept(StatementVisitor statementVisitor);
}
