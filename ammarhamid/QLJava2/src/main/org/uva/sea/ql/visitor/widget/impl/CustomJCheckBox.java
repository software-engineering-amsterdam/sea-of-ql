package org.uva.sea.ql.visitor.widget.impl;

import org.uva.sea.ql.visitor.widget.CustomWidget;

import javax.swing.*;

public class CustomJCheckBox extends JCheckBox implements CustomWidget
{

    public CustomJCheckBox(String text)
    {
        super(text);
    }

    @Override
    public void setValue(String value)
    {
        setSelected(Boolean.valueOf(value));
    }

}
