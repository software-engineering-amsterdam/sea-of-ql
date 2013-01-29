package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.value.ValueNode;

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
    private Map<String, ValueNode> variablesMap;

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

    public void assign(final String variableName, final ValueNode valueNode)
    {
        if(resolve(variableName) != null)
        {
            // there is already such a variable, re-assign it
            this.reAssign(variableName, valueNode);
        }
        else
        {
            // a newly declared variable
            this.variablesMap.put(variableName, valueNode);
        }
    }

    public VariableScope copy()
    {
        // This is used in case functions are recursively called.
        final VariableScope variableScope = new VariableScope();
        variableScope.variablesMap = new TreeMap<>(this.variablesMap);
        return variableScope;
    }

    public boolean isGlobalScope()
    {
        return this.parent == null;
    }

    public VariableScope getParent()
    {
        return this.parent;
    }

    public void reAssign(final String variableName, final ValueNode valueNode)
    {
        if(this.variablesMap.containsKey(variableName))
        {
            // the variable is declared in this scope
            this.variablesMap.put(variableName, valueNode);
        }
        else if(parent != null)
        {
            // the variable was not declared in this scope, so let the parent scope re-assign it
            this.parent.reAssign(variableName, valueNode);
        }
    }

    public ValueNode resolve(final String variableName)
    {
        final ValueNode valueNode = this.variablesMap.get(variableName);
        if(valueNode != null)
        {
            // the variable resides in this scope
            return valueNode;
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
