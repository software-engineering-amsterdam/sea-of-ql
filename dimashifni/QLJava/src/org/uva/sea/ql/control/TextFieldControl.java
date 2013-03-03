package org.uva.sea.ql.control;

import javax.swing.*;

public class TextFieldControl extends JTextField implements Control {
    public TextFieldControl(int length) {
        super(length);
    }

    @Override
    public void setValue(String value) {
        setText(value);
    }
}
