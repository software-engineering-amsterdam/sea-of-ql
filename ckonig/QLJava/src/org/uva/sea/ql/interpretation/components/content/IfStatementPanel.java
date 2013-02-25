package org.uva.sea.ql.interpretation.components.content;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.interpretation.SwingRegistry;
import org.uva.sea.ql.interpretation.evaluation.Evaluator;

public class IfStatementPanel extends JPanel {
    private static final long serialVersionUID = -365544076190441356L;
    private IfStatement ifStatement;

    public IfStatementPanel(IfStatement i) {
        this.ifStatement = i;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public final void updateVisibility(SwingRegistry registry)
            throws QLException {
        final Expr e = this.ifStatement.getCondition();
        final boolean result = new Evaluator(registry, false).evalBool(e);
        this.setVisible(result);
    }
}
