package org.uva.sea.ql.ast;

import org.jpatterns.gof.CompositePattern;
import org.jpatterns.gof.VisitorPattern.Element;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

@CompositePattern
@Element
public interface ASTNode {

	void accept(ASTNodeVisitor visitor);
}
