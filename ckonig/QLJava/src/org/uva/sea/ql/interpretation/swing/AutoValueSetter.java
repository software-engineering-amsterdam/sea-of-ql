package org.uva.sea.ql.interpretation.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.interpretation.exception.EmptyInputException;
import org.uva.sea.ql.interpretation.exception.EvaluationException;

public class AutoValueSetter {
    private QuestionPanel questionPanel;
    private SwingRegistry registry;

    public AutoValueSetter(SwingRegistry reg, QuestionPanel panel) {
        this.registry = reg;
        this.questionPanel = panel;
    }

    public final void createListeners() {
        if (this.questionPanel.getQuestion().getType() instanceof Money) {
            final Money m = (Money) this.questionPanel.getQuestion().getType();
            if (m.getExpr() != null) {
                final List<Ident> idents = Ident.getIdents(m.getExpr());
                for (Ident i : idents) {
                    final QuestionPanel qp = this.registry
                            .getQuestionPanelByIdent(i);
                    if (qp.getQuestion().getType() instanceof Money) {
                        addMoneyEvaluationListener(qp);
                    }
                }
            }
        }
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
        if (this.questionPanel.getQuestion().getType() instanceof Money) {
            final JTextField t = (JTextField) this.questionPanel.getInput();
            final Money m = (Money) this.questionPanel.getQuestion().getType();
            if (m.getExpr() != null) {
                t.setEditable(false);
                try {
                    final float result = new MathEvaluator(this.registry, true)
                            .eval(m.getExpr());
                    t.setText(Float.toString(result));
                } catch (EmptyInputException ex) {
                    // no input? no evaluation!
                } catch (EvaluationException ex) {
                    System.out.println("error: " + ex.getMessage());
                }
            }
        }
    }
}
