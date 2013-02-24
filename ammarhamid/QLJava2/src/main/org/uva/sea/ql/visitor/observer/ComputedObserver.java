package org.uva.sea.ql.visitor.observer;

import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.value.impl.MoneyValue;

import javax.swing.*;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ComputedObserver implements Observer
{
    private final ExprNode exprNode;
    private final Map<IdentifierNode, Value> variables;
    private final JTextField jTextField;

    public ComputedObserver(final ExprNode exprNode, final JTextField component, final Map<IdentifierNode, Value> variables)
    {
        this.exprNode = exprNode;
        this.variables = variables;
        // TODO make it also work for other component
        this.jTextField = component;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        System.out.println(" UPDATE CALCULATION ");
        Value evaluate = this.exprNode.evaluate(this.variables);
        // TODO make it also work for other value
        this.jTextField.setText(((MoneyValue)evaluate).getValue().toEngineeringString());

        // TODO also propagate the change ??
    }
}
