package org.uva.sea.ql;

import org.uva.sea.ql.value.Value;

import java.util.Map;
import java.util.TreeMap;

/**
 * VariableScope is used to control variable access and visibility
 * <p/>
 * Author: ammar.hamid
 * Date: 1/20/13 10:03 PM
 */
public class VariableScope
{
    private VariableScope parent;
    private Map<String, Value> variablesMap;

    public VariableScope()
    {
        // only for the global scope, the parent is null
        this(null);
    }

    public VariableScope(final VariableScope parent)
    {
        this.parent = parent;
        this.variablesMap = new TreeMap<>();
    }

    public void assign(final String variableName, final Value value)
    {
        if(resolve(variableName) != null)
        {
            // there is already such a variable, re-assign it
            this.reAssign(variableName, value);
        }
        else
        {
            // a newly declared variable
            this.variablesMap.put(variableName, value);
        }
    }

    public boolean isGlobalScope()
    {
        return this.parent == null;
    }

    public VariableScope getParent()
    {
        return this.parent;
    }

    public void reAssign(final String variableName, final Value value)
    {
        if(this.variablesMap.containsKey(variableName))
        {
            // the variable is declared in this scope
            this.variablesMap.put(variableName, value);
        }
        else if(parent != null)
        {
            // the variable was not declared in this scope, so let the parent scope re-assign it
            this.parent.reAssign(variableName, value);
        }
    }

    public Value resolve(final String variableName)
    {
        final Value value = this.variablesMap.get(variableName);
        if(value != null)
        {
            // the variable resides in this scope
            return value;
        }
        else if(!isGlobalScope())
        {
            return parent.resolve(variableName);
        }
        else
        {
            // unknown variable
            return null;
        }
    }

}
