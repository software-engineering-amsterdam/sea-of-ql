package org.uva.sea.ql.widget.impl;

import org.uva.sea.ql.widget.CustomWidget;

import javax.swing.*;

public class CustomJTextField extends JTextField implements CustomWidget
{

    public CustomJTextField(int columns)
    {
        super(columns);
    }

    @Override
    public void setValue(String value)
    {
       setText(value);
    }

}
