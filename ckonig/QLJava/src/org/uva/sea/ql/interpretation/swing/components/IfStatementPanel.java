package org.uva.sea.ql.interpretation.swing.components;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Evaluatable;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.ReturnFinder;
import org.uva.sea.ql.common.ReturnTypes;
import org.uva.sea.ql.interpretation.swing.SwingRegistry;
import org.uva.sea.ql.interpretation.swing.visitors.BoolEvaluationVisitor;

public class IfStatementPanel extends JPanel {
    private static final long serialVersionUID = -365544076190441356L;
    private IfStatement ifStatement;

    public IfStatementPanel(IfStatement i) {
        this.ifStatement = i;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public final IfStatement getIfStatement() {
        return this.ifStatement;
    }

    public final void eval(SwingRegistry registry) throws QLException {

        final Expr e = this.ifStatement.getCondition();
        final ReturnFinder f = new ReturnFinder(registry.getQuestionsAst());
        ((Evaluatable) e).accept(f);
        if (f.getResult().equals(ReturnTypes.BOOLEAN)) {

            final boolean result = new BoolEvaluationVisitor(registry)
                    .eval(this.ifStatement.getCondition());
            this.setVisible(result);

        } else {
            throw new RuntimeException(
                    "conditions for if statements must be boolean");
        }
    }
}
