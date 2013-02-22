package org.uva.sea.ql.ast.statement;

import java.util.Observable;

public abstract class ObservableStatement extends Observable implements Statement
{
    public abstract void notifyObs();
}
