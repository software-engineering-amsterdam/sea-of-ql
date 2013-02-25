package org.uva.sea.ql.interpretation.components.content;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.types.AbstractMathType;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.returnfinder.ReturnFinder;
import org.uva.sea.ql.interpretation.SwingRegistry;
import org.uva.sea.ql.interpretation.components.input.QLInput;
import org.uva.sea.ql.interpretation.evaluation.Evaluator;
import org.uva.sea.ql.interpretation.exception.EmptyInputException;
import org.uva.sea.ql.interpretation.listeners.UserInputReader;

public final class QuestionPanel extends JPanel {
    private static final long serialVersionUID = -8537987318519877345L;
    private Question question;
    private QLInput input;
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

    public final StringLiteral getIdentName() {
        return this.question.getIdentName();
    }

    public final Question getQuestion() {
        return this.question;
    }

    public final AbstractType getQuestionType() {
        return this.question.getType();
    }

    public final Expr getCondition() {
        return this.question.getExpr();
    }

    public final QLInput getInput() {
        return this.input;
    }

    public final Object getUserInput() {
        final UserInputReader v = new UserInputReader(this);
        return v.getUserInput();
    }

    public final boolean getBoolValue() {
        return this.input.getBoolValue();
    }

    public final StringLiteral getStringValue() {
        return this.input.getStringValue();
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
        this.add((JComponent) this.input, BorderLayout.LINE_END);
    }

    public boolean hasAutoValue() {
        return this.question.hasAutoValue();
    }

    public void setAutoValue(SwingRegistry registry) throws QLException {
        final Expr e = this.question.getExpr();
        final Class<?> returnType = registry.lookupReturnType(e);
        Evaluator eval = new Evaluator(registry, true);

        if (returnType.equals(BooleanType.class)) {
            final boolean result = eval.evalBool(e);
            this.input.setBoolean(result);
        }

        if (returnType.equals(AbstractMathType.class)) {
            try {
                final float result = eval.evalFloat(e);
                this.input.setStringValue(new StringLiteral(Float
                        .toString(result)));
            } catch (EmptyInputException ex) {
                // no input? no output!
            }
        }

    }

}
