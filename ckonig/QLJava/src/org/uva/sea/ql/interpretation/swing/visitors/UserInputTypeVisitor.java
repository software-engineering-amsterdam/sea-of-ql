package org.uva.sea.ql.interpretation.swing.visitors;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.interpretation.TypeVisitor;
import org.uva.sea.ql.interpretation.swing.components.QuestionPanel;

public class UserInputTypeVisitor implements TypeVisitor {
    private final QuestionPanel questionPanel;
    private Object ret;

    public UserInputTypeVisitor(QuestionPanel qp) {
        this.questionPanel = qp;
    }

    @Override
    public final void visit(BooleanType b) {
        this.ret = ((JCheckBox) this.questionPanel.getInput()).isSelected();
    }

    @Override
    public final void visit(Money m) {
        this.ret = ((JTextField) this.questionPanel.getInput()).getText();
    }

    @Override
    public final void visit(StrType s) {
        this.ret = ((JTextField) this.questionPanel.getInput()).getText();
    }

    @Override
    public final void visit(IntType i) {
        this.ret = ((JTextField) this.questionPanel.getInput()).getText();
    }

    public final Object getResult() {
        return this.ret;
    }

}
