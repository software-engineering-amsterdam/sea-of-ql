package org.uva.sea.ql.interpretation.swing.visitors;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.NullType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.interpretation.TypeVisitor;
import org.uva.sea.ql.interpretation.exception.EmptyInputException;
import org.uva.sea.ql.interpretation.swing.SwingRegistry;
import org.uva.sea.ql.interpretation.swing.components.QuestionPanel;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UserInputEvaluator {

    public UserInputEvaluator(QuestionPanel q, SwingRegistry reg) {
        q.getQuestion().getType()
                .accept(new UserInputEvaluationVisitor(q, reg));
    }

    private class UserInputEvaluationVisitor implements TypeVisitor {
        public UserInputEvaluationVisitor(QuestionPanel q, SwingRegistry reg) {
            this.questionPanel = q;
            this.registry = reg;
        }

        private QuestionPanel questionPanel;
        private SwingRegistry registry;

        @Override
        public final void visit(BooleanType b) {
            evaluateBoolean();
        }

        @Override
        public final void visit(Money m) {
            evaluateMath();
        }

        @Override
        public final void visit(StrType s) {
            throw new NotImplementedException();
        }

        @Override
        public final void visit(IntType i) {
            evaluateMath();
        }

        @Override
        public void visit(NullType n) {
            throw new NotImplementedException();
        }

        private final void evaluateMath() {
            final JTextField t = (JTextField) this.questionPanel.getInput();
            if (this.questionPanel.getQuestion().getExpr() != null) {
                t.setEditable(false);
                try {
                    final float result = new MathEvaluator(this.registry, true)
                            .eval(this.questionPanel.getQuestion().getExpr());
                    t.setText(Float.toString(result));
                } catch (EmptyInputException ex) {
                    // no input? no evaluation! (no problem)
                } catch (QLException ex) {
                    System.out.println("error: " + ex.getMessage());
                }
            }
        }

        private final void evaluateBoolean() {
            final JCheckBox c = (JCheckBox) this.questionPanel.getInput();
            if (this.questionPanel.getQuestion().getExpr() != null) {
                c.setEnabled(false);
                boolean result = false;
                try {
                    result = new BoolEvaluator(this.registry)
                            .eval(this.questionPanel.getQuestion().getExpr());
                    c.setSelected(result);
                } catch (QLException e) {
                    System.out.println("error: " + e.getMessage());
                }
            }
        }

    }

}
