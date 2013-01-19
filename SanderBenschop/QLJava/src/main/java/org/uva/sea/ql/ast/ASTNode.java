package org.uva.sea.ql.ast;

import org.uva.sea.ql.parser.visitor.ASTNodeVisitor;

import java.util.List;

public interface ASTNode {

    void accept(ASTNodeVisitor visitor);
}
