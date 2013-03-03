package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.statement.StatementVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 3/3/13
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComputedAssignment extends ObservableStatement {
    private final Ident ident;
    private final String question;
    private final Expr expr;

    public ComputedAssignment(Ident ident, String question, Expr expr) {
        this.ident = ident;
        this.question = question;
        this.expr = expr;
    }

    public Ident getIdent() {
        return ident;
    }

    public String getQuestion() {
        return question;
    }

    public Type getType() {
        return ident.getType();
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
