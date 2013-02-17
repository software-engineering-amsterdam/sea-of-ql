package org.uva.sea.ql.interpretation.swing;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.common.Evaluatable;
import org.uva.sea.ql.common.ReturnFinder;
import org.uva.sea.ql.common.VisitorException;

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

    public final void eval(SwingRegistry registry) throws VisitorException {
        Expr e = this.ifStatement.getCondition();
        ReturnFinder f = new ReturnFinder(registry.getQuestionsAst());
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
