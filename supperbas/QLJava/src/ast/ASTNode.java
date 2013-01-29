package ast;

import java.util.Map;

import ast.type.Ident;
import ast.type.Type;
import ast.visitor.Visitor;

public interface ASTNode {

	public abstract Type typeOf(Map<Ident, Type> typeEnv);

	public abstract <T> T accept(Visitor<T> visitor);
}
