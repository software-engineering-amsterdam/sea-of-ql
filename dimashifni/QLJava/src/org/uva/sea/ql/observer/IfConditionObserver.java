package org.uva.sea.ql.observer;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.Value;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 3/3/13
 * Time: 8:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class IfConditionObserver implements Observer {


    private final JFrame frame;
    private final List<Component> ifComponents;
    private final List<Component> elseComponents;
    private final Map<Ident, Value> variables;
    private final Expr expr;

    public IfConditionObserver(JFrame frame, Expr expr, List<Component> ifComponents, List<Component> elseComponents, Map<Ident, Value> variables) {
        this.frame = frame;
        this.expr = expr;
        this.ifComponents = ifComponents;
        this.elseComponents = elseComponents;
        this.variables = variables;
    }

    @Override
    public void update(Observable observable, Object o) {
        BooleanValue result = (BooleanValue)this.expr.evaluate(variables);

        // clearing all states
        clearingAllStates();

        if(result.getValue())
        {
            for (Component ifComponent : ifComponents) {
                ifComponent.setVisible(!ifComponent.isVisible());
            }
        }
        else {
            for (Component elseComponent : elseComponents) {
                elseComponent.setVisible(!elseComponent.isVisible());
            }
        }

        this.frame.pack();
    }

    private void clearingAllStates() {
        for (Component ifComponent : ifComponents) {
            ifComponent.setVisible(false);
        }
        for (Component elseComponent : elseComponents) {
            elseComponent.setVisible(false);
        }
    }
}
