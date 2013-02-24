package org.uva.sea.ql.variable;

import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
import org.uva.sea.ql.ast.statement.ObservableStatement;
import org.uva.sea.ql.value.Value;

import java.util.*;

public class VariableState
{
    private final Map<IdentifierNode, Value> variables;
    private final Map<IdentifierNode, Collection<ObservableStatement>> observables;

    public VariableState(final Map<IdentifierNode, Value> variables)
    {
        this.variables = variables;
        this.observables = new HashMap<>();
    }

    public void put(final IdentifierNode identifierNode, final Value value)
    {
        variables.put(identifierNode, value);
        notifyObservers(identifierNode);
    }

    private void notifyObservers(IdentifierNode identifierNode)
    {
        Collection<ObservableStatement> observableStatements = observables.get(identifierNode);
        if(observableStatements != null)
        {
            for(final ObservableStatement observableStatement : observableStatements)
            {
                observableStatement.notifyObs();
            }
        }
    }

    public Map<IdentifierNode, Value> getVariables()
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

}