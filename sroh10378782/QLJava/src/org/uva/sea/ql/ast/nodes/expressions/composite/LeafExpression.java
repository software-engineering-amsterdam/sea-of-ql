package org.uva.sea.ql.ast.nodes.expressions.composite;

import org.uva.sea.ql.ast.nodes.expressions.Expr;

/**
 * Leaf (Terminal) Expression Tree Node
 * Represents all Expressions which are the end point in the tree branch. 
 * 
 * @author Sven Rohde <svenrohde.se@gmail.com> / 10378782
 */
public abstract class LeafExpression extends Expr {
	private final String value;
	public LeafExpression(String value){
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeafExpression other = (LeafExpression) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
