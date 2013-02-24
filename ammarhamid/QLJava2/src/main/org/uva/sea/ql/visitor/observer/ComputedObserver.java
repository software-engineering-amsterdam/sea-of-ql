package org.uva.sea.ql.visitor.observer;

import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.widget.CustomWidget;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ComputedObserver implements Observer
{
    private final ExprNode exprNode;
    private final Map<IdentifierNode, Value> variables;
    private final CustomWidget customWidget;

    public ComputedObserver(final ExprNode exprNode, final CustomWidget customWidget, final Map<IdentifierNode, Value> variables)
    {
        this.exprNode = exprNode;
        this.variables = variables;
        this.customWidget = customWidget;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        Value value = this.exprNode.evaluate(this.variables);
        this.customWidget.setValue(value.toString());
    }
}
