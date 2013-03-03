package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.visitor.statement.StatementVisitor;

import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 3/2/13
 * Time: 11:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class ObservableStatement extends Observable implements Statement {

    public void notifyObs()
    {
        setChanged();
        notifyObservers();
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
