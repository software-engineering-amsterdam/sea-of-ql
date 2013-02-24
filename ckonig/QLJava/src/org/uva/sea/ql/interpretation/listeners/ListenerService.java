package org.uva.sea.ql.interpretation.listeners;

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
import org.uva.sea.ql.common.TypeVisitor;
import org.uva.sea.ql.common.identfinder.IdentFinder;
import org.uva.sea.ql.interpretation.SwingRegistry;
import org.uva.sea.ql.interpretation.components.content.QuestionPanel;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public final class ListenerService {
    private ListenerService() {

    }

    public static void createListeners(QuestionPanel questionPanel,
            SwingRegistry registry) {
        new ListenerService().create(questionPanel, registry);
    }

    private void create(QuestionPanel qp, SwingRegistry reg) {
        qp.getQuestion().getType().accept(new ListenerFactoryVisitor(qp, reg));
    }

    private class ListenerFactoryVisitor implements TypeVisitor {
        private QuestionPanel questionPanel;
        private SwingRegistry registry;

        private AbstractHelper helper;

        public ListenerFactoryVisitor(QuestionPanel qp, SwingRegistry reg) {
            this.questionPanel = qp;
            this.registry = reg;
        }

        private void tryToAddListeners() {
            this.helper.addListeners(this.questionPanel);
            if (this.questionPanel.getQuestion().getExpr() != null) {
                final IdentFinder finder = new IdentFinder(
                        (TreeNode) this.questionPanel.getQuestion().getExpr());
                final List<Ident> idents = finder.getIdents();
                for (Ident i : idents) {
                    final QuestionPanel qp = this.registry
                            .getQuestionPanelByIdent(i);
                    this.helper.addListeners(qp);
                }
            }
        }

        @Override
        public final void visit(BooleanType b) {
            this.helper = new BooleanHelper();
            this.tryToAddListeners();
        }

        @Override
        public final void visit(Money m) {
            this.helper = new MathHelper();
            this.tryToAddListeners();
        }

        @Override
        public final void visit(StrType s) {
            if (this.questionPanel.hasAutoValue()) {
                throw new NotImplementedException();
            }
        }

        @Override
        public final void visit(IntType i) {
            this.helper = new MathHelper();
            this.tryToAddListeners();
        }

        @Override
        public final void visit(NullType n) {
            // do nothing
        }

        private abstract class AbstractHelper {
            abstract void addListeners(QuestionPanel panel);
        }

        private class BooleanHelper extends AbstractHelper {
            public BooleanHelper() {

            }

            @Override
            void addListeners(QuestionPanel panel) {
                final ListenerFactory factory = new QuestionListenerFactory(
                        registry);
                final JCheckBox c = (JCheckBox) panel.getInput();
                c.addActionListener(factory.getActionListener());
                c.addKeyListener(factory.getKeyListener());
            }
        }

        private class MathHelper extends AbstractHelper {
            public MathHelper() {

            }

            @Override
            void addListeners(QuestionPanel panel) {
                final ListenerFactory factory = new QuestionListenerFactory(
                        registry);
                final JTextField t = (JTextField) panel.getInput();
                t.addActionListener(factory.getActionListener());
                t.addKeyListener(factory.getKeyListener());
            }

        }

    }

}
