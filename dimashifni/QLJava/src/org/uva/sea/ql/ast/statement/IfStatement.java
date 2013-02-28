package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.visitor.statement.StatementVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/27/13
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class IfStatement implements Statement {

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
