package org.uva.sea.ql.interpretation.swing;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.interfaces.Returns;
import org.uva.sea.ql.interpretation.exception.EvaluationException;

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

    public final void eval(SwingRegistry registry) throws EvaluationException {
        Expr e = this.ifStatement.getCondition();
        Returns r = (Returns) e;

        if (r.getReturnType(registry.getQuestionsAst()).equals(
                ReturnTypes.BOOLEAN)) {
            final boolean result = new BoolEvaluator(registry)
                    .eval(this.ifStatement.getCondition());
            this.setVisible(result);
        } else {
            throw new RuntimeException(
                    "conditions for if statements must be boolean");
        }
    }
}
