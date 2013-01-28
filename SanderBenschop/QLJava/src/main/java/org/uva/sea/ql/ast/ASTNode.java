package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

public interface ASTNode {

    void accept(ASTNodeVisitor visitor);
}
