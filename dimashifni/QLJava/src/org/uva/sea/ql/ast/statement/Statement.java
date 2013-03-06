package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.statement.StatementVisitor;

public interface Statement extends ASTNode {
    <T> T accept(StatementVisitor<T> visitor);
}
