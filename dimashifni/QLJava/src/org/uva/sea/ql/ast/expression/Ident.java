package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionVisitor;

import java.util.Map;

public class Ident extends Expr {

	private final String name;
    private final Type type;

	public Ident(String name, Type type) {
		this.name = name;
        this.type = type;
    }
	
	public String getName() {
		return name;
	}

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public Value evaluate(Map<Ident, Value> variables)
    {
        return variables.get(this);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ident ident = (Ident) o;

        if (name != null ? !name.equals(ident.name) : ident.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
