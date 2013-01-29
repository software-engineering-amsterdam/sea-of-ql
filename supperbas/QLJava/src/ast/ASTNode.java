package ast;

import java.util.Map;

import ast.types.Ident;
import ast.types.Type;
import ast.visitors.Visitor;

public interface ASTNode {

	public abstract Type typeOf(Map<Ident, Type> typeEnv);

	public abstract <T> T accept(Visitor<T> visitor);
}
