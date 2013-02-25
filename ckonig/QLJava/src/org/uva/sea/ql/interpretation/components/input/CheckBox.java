package org.uva.sea.ql.interpretation.components.input;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ast.literals.StringLiteral;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CheckBox extends JCheckBox implements QLInput {

    private static final long serialVersionUID = -6920327118032336371L;

    public CheckBox() {

    }

    @Override
    public final void setInputPossible(boolean val) {
        this.setEnabled(val);
    }

    @Override
    public final StringLiteral getStringValue() {
        throw new NotImplementedException();
    }

    @Override
    public final boolean getBoolValue() {
        return this.getModel().isSelected();
    }

    @Override
    public final void setBoolean(boolean bool) {
        this.setSelected(bool);
    }

    @Override
    public final void setStringValue(StringLiteral text) {
        throw new NotImplementedException();
    }

}
