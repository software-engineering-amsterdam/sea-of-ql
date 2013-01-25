<<<<<<< HEAD
package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNode;

public abstract class Type implements ASTNode {
	
}
=======
package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.expressions.ASTNode;

public abstract class Type implements ASTNode {
	
	@Override
	public boolean equals(Object obj) {
		return (obj.getClass() == this.getClass());
	}
}
>>>>>>> 483057f28359ecac2b999d94a928c0aaf01d2a6e
