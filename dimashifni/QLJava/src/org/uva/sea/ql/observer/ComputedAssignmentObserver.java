package org.uva.sea.ql.observer;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.control.Control;
import org.uva.sea.ql.value.Value;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ComputedAssignmentObserver implements Observer {

    private final Expr expr;
    private final Control control;
    private final Map<Ident, Value> variables;

    public ComputedAssignmentObserver(Expr expr, Control control, Map<Ident, Value> variables) {
        this.expr = expr;
        this.control = control;
        this.variables = variables;
    }

    @Override
    public void update(Observable observable, Object o) {
        Value evaluate = this.expr.evaluate(this.variables);
        this.control.setValue(evaluate.toString());
    }
}
