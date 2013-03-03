package org.uva.sea.ql.control;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 3/3/13
 * Time: 9:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TextFieldControl extends JTextField implements Control {
    public TextFieldControl(int length) {
        super(length);
    }

    @Override
    public void setValue(String value) {
        setText(value);
    }
}
