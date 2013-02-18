package org.uva.sea.ql.variable;

import org.uva.sea.ql.value.Value;

import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;

public class VariableState extends Observable
{
    private static Map<String, Value> variableMap = new TreeMap<>();

    public void add(final String variableName, final Value value)
    {
        variableMap.put(variableName, value);
        setChanged();
        notifyObservers();
    }

    public void remove(final String variableName)
    {
        variableMap.remove(variableName);
        setChanged();
        notifyObservers();
    }

    public static Map<String, Value> getVariableMap()
    {
        return variableMap;
    }

}