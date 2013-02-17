package org.uva.sea.ql.interpretation.swing.visitors;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.interfaces.TypeVisitor;

public class SwingInputTypeVisitor implements TypeVisitor {

    private final static int LENGTH = 10;
    private JComponent input;

    public SwingInputTypeVisitor() {

    }

    public final JComponent getInput() {
        return this.input;
    }

    @Override
    public final void visit(BooleanType b) {
        this.input = new JCheckBox();
    }

    @Override
    public final void visit(Money m) {
        this.input = new JTextField(LENGTH);
        if (m.getExpr() != null) {
            ((JTextField) this.input).setEditable(false);
        }
    }

    @Override
    public final void visit(StrType s) {
        this.input = new JTextField(LENGTH);
    }

    @Override
    public final void visit(IntType i) {
        this.input = new JTextField(LENGTH);
    }

}
