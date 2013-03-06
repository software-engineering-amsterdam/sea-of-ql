package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.visitor.statement.StatementVisitor;

import java.util.Observable;

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
