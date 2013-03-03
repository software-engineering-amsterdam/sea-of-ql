package org.uva.sea.ql.control;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 3/3/13
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class CheckboxControl extends JCheckBox implements Control {
    public CheckboxControl(String literal) {
        super(literal);

    }

    @Override
    public void setValue(String value) {
        setSelected(Boolean.valueOf(value));
    }
}
