package org.uva.sea.ql.variable;

import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
import org.uva.sea.ql.ast.statement.ObservableStatement;
import org.uva.sea.ql.value.Value;

import java.util.*;

public class VariableState
{
    private static Map<IdentifierNode, Value> variables = new HashMap<>();
    private final Map<IdentifierNode, Collection<ObservableStatement>> observables;

    public VariableState()
    {
        this.observables = new HashMap<>();
    }

    public void put(final IdentifierNode identifierNode, final Value value)
    {
        variables.put(identifierNode, value);
        notifyObservers(identifierNode);
    }

    public void remove(final IdentifierNode identifierNode)
    {
        variables.remove(identifierNode);
        notifyObservers(identifierNode);
    }

    private void notifyObservers(IdentifierNode identifierNode)
    {
        // TODO check for NPE
        Collection<ObservableStatement> observableStatements = observables.get(identifierNode);
        for(final ObservableStatement observableStatement : observableStatements)
        {
            observableStatement.notifyObs();
        }
    }

    // TODO remove static (global) access
    public static Map<IdentifierNode, Value> getVariables()
    {
        return variables;
    }

    public void putObservable(final IdentifierNode identifierNode, final ObservableStatement observableStatement)
    {
        Collection<ObservableStatement> observableStatements = this.observables.get(identifierNode);
        if(observableStatements == null)
        {
            observableStatements = new ArrayList<>();
        }
        observableStatements.add(observableStatement);
        this.observables.put(identifierNode, observableStatements);
    }

    public void addObserver(final IdentifierNode identifierNode, final Observer observer)
    {
        final Collection<ObservableStatement> observableStatements = this.observables.get(identifierNode);
        for(final ObservableStatement observableStatement : observableStatements)
        {
            observableStatement.addObserver(observer);
        }
    }

    public Map<IdentifierNode, Collection<ObservableStatement>> getObservables()
    {
        return observables;
    }
}