package org.uva.sea.ql.interfaces;

import org.uva.sea.ql.util.Stack;

public interface IVisitable {

	void accept(IVisitor visitor, Stack stack) throws Exception;
}
