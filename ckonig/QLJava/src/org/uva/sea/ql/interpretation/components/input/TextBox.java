package org.uva.sea.ql.interpretation.components.input;

import javax.swing.JTextField;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class TextBox extends JTextField implements QLInput {

    private static final long serialVersionUID = 7300289514690839567L;

    public TextBox(int length) {
        super(length);
    }

    @Override
    public final void setInputPossible(boolean val) {
        this.setEditable(val);
    }

    @Override
    public final String getStringValue() {
        return this.getText();
    }

    @Override
    public final boolean getBoolValue() {
        throw new NotImplementedException();
    }

    @Override
    public final void setBoolean(boolean bool) {
        throw new NotImplementedException();
    }

    @Override
    public final void setStringValue(String text) {
        this.setText(text);
    }

}
