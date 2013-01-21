package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.value.ValueNode;

public interface Node
{
    ValueNode evaluate();
	String toTreeString(String indent);
}
