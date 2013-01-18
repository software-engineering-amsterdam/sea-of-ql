package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.type.Type;

/**
 * Type node visitor.
 */
public interface ITypeVisitor {
	/**
	 * Visit a type node.
	 * 
	 * @param node
	 */
	void visit( Type node );
}
