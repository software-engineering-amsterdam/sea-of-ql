package org.uva.sea.ql.ast;

public class CompositeStatement implements Statement {
    
	private final Iterable<Statement> statements;

    public CompositeStatement(Iterable<Statement> statements) {
        this.statements = statements;
    }

    public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
        return visitor.visit(this, param);
    }

    public Iterable<Statement> getStatements() { return statements; }
}
