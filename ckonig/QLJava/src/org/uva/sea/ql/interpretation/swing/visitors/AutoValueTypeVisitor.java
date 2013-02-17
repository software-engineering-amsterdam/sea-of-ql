package org.uva.sea.ql.interpretation.swing.visitors;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.interfaces.TypeVisitor;
import org.uva.sea.ql.interpretation.exception.EmptyInputException;
import org.uva.sea.ql.interpretation.swing.SwingRegistry;
import org.uva.sea.ql.interpretation.swing.components.QuestionPanel;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AutoValueTypeVisitor implements TypeVisitor {
    private QuestionPanel questionPanel;
    private SwingRegistry registry;

    public AutoValueTypeVisitor(QuestionPanel q, SwingRegistry reg) {
        this.questionPanel = q;
        this.registry = reg;
    }

    @Override
    public final void visit(BooleanType b) {
        throw new NotImplementedException();
    }

    @Override
    public final void visit(Money m) {
        final JTextField t = (JTextField) this.questionPanel.getInput();
        if (m.getExpr() != null) {
            t.setEditable(false);
            try {
                final float result = new MathEvaluationVisitor(this.registry,
                        true).eval(m.getExpr());
                t.setText(Float.toString(result));
            } catch (EmptyInputException ex) {
                // no input? no evaluation!
            } catch (QLException ex) {
                System.out.println("error: " + ex.getMessage());
            }
        }
    }

    @Override
    public final void visit(StrType s) {
        throw new NotImplementedException();
    }

    @Override
    public final void visit(IntType i) {
        throw new NotImplementedException();
    }

}
