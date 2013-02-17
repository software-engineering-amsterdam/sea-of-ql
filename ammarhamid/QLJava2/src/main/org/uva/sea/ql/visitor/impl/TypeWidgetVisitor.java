package org.uva.sea.ql.visitor.impl;

import org.uva.sea.ql.VariableState;
import org.uva.sea.ql.main.QLMainApp;
import org.uva.sea.ql.type.impl.BooleanType;
import org.uva.sea.ql.type.impl.IntegerType;
import org.uva.sea.ql.type.impl.MoneyType;
import org.uva.sea.ql.type.impl.StringType;
import org.uva.sea.ql.value.impl.BooleanValue;
import org.uva.sea.ql.value.impl.StringValue;
import org.uva.sea.ql.visitor.TypeVisitor;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TypeWidgetVisitor implements TypeVisitor
{
    public static final int LENGTH = 10;
    public static final String CONSTRAINTS = "span";
    private final JPanel panel;
    private final VariableState variableState;
    private final String identifier;

    public TypeWidgetVisitor(JPanel panel, String identifier, VariableState variableState)
    {
        this.panel = panel;
        this.variableState = variableState;
        this.identifier = identifier;
    }

    @Override
    public void visit(BooleanType booleanType)
    {
        final JCheckBox checkBox = new JCheckBox("Yes");
        this.panel.add(checkBox, CONSTRAINTS);

        checkBox.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                variableState.add(TypeWidgetVisitor.this.identifier, new BooleanValue(checkBox.isSelected()));
            }
        });
    }

    @Override
    public void visit(StringType stringType)
    {
        final JTextField textField = new JTextField(LENGTH);
        final JTextField textField2 = new JTextField(LENGTH);
        textField2.setVisible(false);
        this.panel.add(textField, CONSTRAINTS);
        final JPanel jPanel = new JPanel();
        this.panel.add(jPanel, CONSTRAINTS);

        // Listen for changes in the text
        textField.getDocument().addDocumentListener(new DocumentListener()
        {
            public void changedUpdate(DocumentEvent e)
            {
//                variableState.add(TypeWidgetVisitor.this.identifier, new StringValue(textField.getText()));
            }

            public void removeUpdate(DocumentEvent e)
            {
                jPanel.remove(textField2);
                textField2.setVisible(false);
                jPanel.revalidate();
                jPanel.repaint();
                QLMainApp.getFrame().pack();
//                variableState.remove(TypeWidgetVisitor.this.identifier);
            }

            public void insertUpdate(DocumentEvent e)
            {
                jPanel.add(textField2);
                textField2.setVisible(true);
                jPanel.revalidate();
                jPanel.repaint();
                QLMainApp.getFrame().pack();
                variableState.add(TypeWidgetVisitor.this.identifier, new StringValue(textField.getText()));
            }

        });
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
