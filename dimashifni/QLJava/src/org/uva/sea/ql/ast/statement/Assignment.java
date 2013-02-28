package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.statement.StatementVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/27/13
 * Time: 11:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Assignment implements Statement {
    private final Ident ident;
    private final String question;
    private final Type type;

    public Assignment(Ident ident, String question, Type type) {
        this.ident = ident;
        this.question = question;
        this.type = type;
    }

    public Ident getIdent() {
        return ident;
    }

    public String getQuestion() {
        return question;
    }

    public Type getType() {
        return type;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}