package org.uva.sea.ql.interpretation.components.content;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Expression;
import org.uva.sea.ql.ast.types.AbstractMathType;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.returnfinder.ReturnFinder;
import org.uva.sea.ql.interpretation.SwingRegistry;
import org.uva.sea.ql.interpretation.evaluation.Evaluator;
import org.uva.sea.ql.interpretation.exception.EmptyInputException;
import org.uva.sea.ql.interpretation.listeners.UserInputReader;

public final class QuestionPanel extends JPanel {
    private static final long serialVersionUID = -8537987318519877345L;
    private Question question;
    private JComponent input;
    private boolean invalid;
    private Color original;

    public QuestionPanel(Question q) {
        this.invalid = false;
        this.question = q;
        this.setLayout(new BorderLayout());
        this.add(new JLabel(this.question.getContent().getValue()),
                BorderLayout.LINE_START);
        createInputElement();
        this.original = this.getBackground();
    }

    public final String getIdentName() {
        return this.question.getIdentName();
    }

    public final Question getQuestion() {
        return this.question;
    }

    public final JComponent getInput() {
        return this.input;
    }

    public final Object getUserInput() {
        final UserInputReader v = new UserInputReader(this);
        return v.getUserInput();
    }

    public final boolean getBoolValue() {
        return ((AbstractButton) this.input).getModel().isSelected();
    }

    public final String getStringValue() {
        final JTextField t = (JTextField) this.input;
        return t.getText();
    }

    public final void setValid(boolean val) {
        this.invalid = !val;
        if (val) {
            this.setBackground(this.original);
        } else {
            this.setBackground(Color.red);
        }
        this.repaint();
    }

    public final boolean isValidInput() {
        return !this.invalid;
    }

    private void createInputElement() {
        this.input = SwingInputComponentFactory.getInputComponent(this);
        this.add(this.input, BorderLayout.LINE_END);
    }

    public boolean hasAutoValue() {
        return this.question.getExpr() != null;
    }

    public void setAutoValue(SwingRegistry registry) throws QLException {
        final Expr e = this.question.getExpr();
        final ReturnFinder f = new ReturnFinder(registry.getQuestionsAst(),
                (Expression) e);
        if (f.getResult().equals(BooleanType.class)) {
            final boolean result = new Evaluator(registry, true).evalBool(e);
            ((JCheckBox) this.input).setSelected(result);
            return;
        }
        if (f.getResult().equals(AbstractMathType.class)) {
            try {
                final float result = new Evaluator(registry, true).evalFloat(e);
                ((JTextField) this.input).setText(Float.toString(result));
            } catch (EmptyInputException ex) {
                // no input? no output!
            }
            return;
        }
        throw new RuntimeException(
                "conditions for if statements must be boolean");

    }

}
