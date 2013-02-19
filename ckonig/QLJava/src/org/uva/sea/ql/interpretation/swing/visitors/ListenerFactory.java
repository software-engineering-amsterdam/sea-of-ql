package org.uva.sea.ql.interpretation.swing.visitors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.NullType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.ReturnFinder;
import org.uva.sea.ql.interpretation.IdentFinder;
import org.uva.sea.ql.interpretation.TypeVisitor;
import org.uva.sea.ql.interpretation.swing.SwingRegistry;
import org.uva.sea.ql.interpretation.swing.components.QuestionPanel;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ListenerFactory implements TypeVisitor {
    private abstract class Helper {
        abstract void addListeners(QuestionPanel panel);
    }

    private class BooleanHelper extends Helper {

        @Override
        void addListeners(QuestionPanel panel) {
            addBooleanEvaluationListener(panel);
        }

    }

    private class MathHelper extends Helper {

        @Override
        void addListeners(QuestionPanel panel) {
            addMoneyEvaluationListener(panel);
        }

    }

    private QuestionPanel questionPanel;
    private SwingRegistry registry;
    private Helper helper;

    public ListenerFactory(QuestionPanel qp, SwingRegistry reg) {
        this.questionPanel = qp;
        this.registry = reg;
    }

    @Override
    public void visit(BooleanType b) {
        this.helper = new BooleanHelper();
        tryToAddListeners();
    }

    @Override
    public final void visit(Money m) {
        this.helper = new MathHelper();
        tryToAddListeners();
    }

    @Override
    public void visit(StrType s) {
        if (this.questionPanel.getQuestion().getExpr() != null) {
            throw new NotImplementedException();
        }
    }

    @Override
    public void visit(IntType i) {
        if (this.questionPanel.getQuestion().getExpr() != null) {
            throw new NotImplementedException();
        }
    }

    private void tryToAddListeners() {
        if (this.questionPanel.getQuestion().getExpr() != null) {
            final IdentFinder finder = new IdentFinder((TreeNode) this.questionPanel.getQuestion().getExpr());
            final List<Ident> idents = finder.getIdents();
            for (Ident i : idents) {
                final QuestionPanel qp = this.registry
                        .getQuestionPanelByIdent(i);
                this.helper.addListeners(qp);
            }
        }
    }

    private final void addBooleanEvaluationListener(QuestionPanel qp) {
        final JCheckBox c = (JCheckBox) qp.getInput();
        c.addActionListener(getActionListener());
        c.addKeyListener(getKeyListener());
    }

    private final KeyListener getKeyListener() {
        return new KeyListener() {

            @Override
            public void keyTyped(KeyEvent arg0) {
                evaluateAutoValues();
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                evaluateAutoValues();
            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                evaluateAutoValues();
            }
        };
    }

    private final ActionListener getActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                evaluateAutoValues();
            }
        };
    }

    private final void addMoneyEvaluationListener(QuestionPanel qp) {
        final JTextField t = (JTextField) qp.getInput();
        t.addActionListener(getActionListener());
        t.addKeyListener(getKeyListener());
    }

    private void evaluateAutoValues() {
        new UserInputEvaluator(this.questionPanel, this.registry);
    }

    @Override
    public void visit(NullType n) {
        // TODO Auto-generated method stub
    }

}
