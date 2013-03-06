package org.uva.sea.ql.control;

import javax.swing.*;

public class CheckboxControl extends JCheckBox implements Control {
    public CheckboxControl(String literal) {
        super(literal);

    }

    @Override
    public void setValue(String value) {
        setSelected(Boolean.valueOf(value));
    }
}
