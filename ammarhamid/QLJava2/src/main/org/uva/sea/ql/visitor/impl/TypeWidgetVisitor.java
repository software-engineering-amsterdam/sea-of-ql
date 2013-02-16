package org.uva.sea.ql.visitor.impl;

import org.uva.sea.ql.type.impl.BooleanType;
import org.uva.sea.ql.type.impl.IntegerType;
import org.uva.sea.ql.type.impl.MoneyType;
import org.uva.sea.ql.type.impl.StringType;
import org.uva.sea.ql.visitor.TypeVisitor;

import javax.swing.*;

public class TypeWidgetVisitor implements TypeVisitor
{
    public static final int LENGTH = 10;
    public static final String CONSTRAINTS = "span";
    private final JPanel panel;

    public TypeWidgetVisitor(JPanel panel)
    {
        this.panel = panel;
    }

    @Override
    public void visit(BooleanType booleanType)
    {
        this.panel.add(new JCheckBox("Yes"), CONSTRAINTS);
    }

    @Override
    public void visit(StringType stringType)
    {
        this.panel.add(new JTextField(LENGTH), CONSTRAINTS);
    }

    @Override
    public void visit(IntegerType integerType)
    {
        this.panel.add(new JTextField(LENGTH), CONSTRAINTS);
    }

    @Override
    public void visit(MoneyType moneyType)
    {
        this.panel.add(new JTextField(LENGTH), CONSTRAINTS);
    }

    public JPanel getPanel()
    {
        return panel;
    }
}
