package org.uva.sea.ql.ast.exp;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.NaturalVisitor;

public class Identifier extends Expression<Expression<?>> {

	private final String name;

	/**
	 * 
	 * @param name
	 *            (not null)
	 */
	public Identifier(final String name) {
		this.name = name;
		state.assertNotNull(this.name, "Identifier.name");
	}

	public String getName() {
		return name;
	}

	@Override
	public <T> T accept(final NaturalVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return Nature.TEXTUAL;
	}

	@Override
	public Expression<?> accept(final ExpressionVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Identifier [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Identifier other = (Identifier) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
