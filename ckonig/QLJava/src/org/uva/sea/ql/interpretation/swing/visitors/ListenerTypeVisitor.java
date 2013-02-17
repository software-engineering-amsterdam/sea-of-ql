package org.uva.sea.ql.interpretation.swing.visitors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JTextField;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.IdentFinder;
import org.uva.sea.ql.common.interfaces.TypeVisitor;
import org.uva.sea.ql.interpretation.swing.SwingRegistry;
import org.uva.sea.ql.interpretation.swing.components.QuestionPanel;

public class ListenerTypeVisitor implements TypeVisitor {

    private QuestionPanel questionPanel;
    private SwingRegistry registry;

    public ListenerTypeVisitor(QuestionPanel qp, SwingRegistry reg) {
        this.questionPanel = qp;
        this.registry = reg;
    }

    @Override
    public void visit(BooleanType b) {

    }

    @Override
    public final void visit(Money m) {
        if (m.getExpr() != null) {
            final IdentFinder finder = new IdentFinder();
            ((TreeNode) m.getExpr()).accept(finder);
            final List<Ident> idents = finder.getIdents();
            for (Ident i : idents) {
                final QuestionPanel qp = this.registry
                        .getQuestionPanelByIdent(i);
                addMoneyEvaluationListener(qp);
            }
        }
    }

    @Override
    public void visit(StrType s) {

    }

    @Override
    public void visit(IntType i) {

    }

    private final void addMoneyEvaluationListener(QuestionPanel qp) {
        final JTextField t = (JTextField) qp.getInput();
        t.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateMoneyValue();
            }
        });
        t.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                evaluateMoneyValue();

            }

            @Override
            public void keyReleased(KeyEvent e) {
                evaluateMoneyValue();

            }

            @Override
            public void keyPressed(KeyEvent e) {
                evaluateMoneyValue();

            }
        });
    }

    private void evaluateMoneyValue() {
        final AutoValueTypeVisitor v = new AutoValueTypeVisitor(this.questionPanel,
                this.registry);
        this.questionPanel.getQuestion().getType().accept(v);
    }

}
