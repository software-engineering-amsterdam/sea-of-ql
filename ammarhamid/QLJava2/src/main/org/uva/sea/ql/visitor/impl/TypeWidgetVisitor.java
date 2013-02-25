package org.uva.sea.ql.visitor.impl;

import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
import org.uva.sea.ql.type.impl.BooleanType;
import org.uva.sea.ql.type.impl.IntegerType;
import org.uva.sea.ql.type.impl.MoneyType;
import org.uva.sea.ql.type.impl.StringType;
import org.uva.sea.ql.value.impl.BooleanValue;
import org.uva.sea.ql.value.impl.IntegerValue;
import org.uva.sea.ql.value.impl.MoneyValue;
import org.uva.sea.ql.value.impl.StringValue;
import org.uva.sea.ql.variable.VariableState;
import org.uva.sea.ql.visitor.TypeVisitor;
import org.uva.sea.ql.visitor.widget.CustomWidget;
import org.uva.sea.ql.visitor.widget.impl.CustomJCheckBox;
import org.uva.sea.ql.visitor.widget.impl.CustomJTextField;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;

public class TypeWidgetVisitor implements TypeVisitor<CustomWidget>
{
    public static final int LENGTH = 10;
    public static final String MESSAGE = "Please enter a number!";
    public static final String TITLE = "Error Message";

    private final JPanel panel;
    private final VariableState variableState;
    private final IdentifierNode identifierNode;
    private final boolean editable;

    public TypeWidgetVisitor(JPanel panel, IdentifierNode identifierNode, VariableState variableState, final boolean editable)
    {
        this.panel = panel;
        this.variableState = variableState;
        this.identifierNode = identifierNode;
        this.editable = editable;
    }

    public TypeWidgetVisitor(JPanel panel, IdentifierNode identifierNode, VariableState variableState)
    {
        this(panel, identifierNode, variableState, true);
    }

    @Override
    public CustomWidget visit(BooleanType booleanType)
    {
        final CustomJCheckBox customJCheckBox = new CustomJCheckBox("Yes");
        customJCheckBox.setEnabled(this.editable);
        customJCheckBox.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                variableState.put(TypeWidgetVisitor.this.identifierNode, new BooleanValue(customJCheckBox.isSelected()));
            }
        });
        this.panel.add(customJCheckBox);

        return customJCheckBox;
    }

    @Override
    public CustomWidget visit(StringType stringType)
    {
        final CustomJTextField customJTextField = new CustomJTextField(LENGTH);
        customJTextField.setEditable(this.editable);
        customJTextField.getDocument().addDocumentListener(new DocumentListener()
        {
            public void changedUpdate(DocumentEvent e)
            {
                update();
            }

            public void removeUpdate(DocumentEvent e)
            {
                update();
            }

            public void insertUpdate(DocumentEvent e)
            {
                update();
            }

            public void update()
            {
                variableState.put(TypeWidgetVisitor.this.identifierNode, new StringValue(customJTextField.getText()));
            }
        });
        this.panel.add(customJTextField);

        return customJTextField;
    }

    @Override
    public CustomWidget visit(IntegerType integerType)
    {
        final CustomJTextField customJTextField = new CustomJTextField(LENGTH);
        customJTextField.setEditable(this.editable);
        customJTextField.getDocument().addDocumentListener(new DocumentListener()
        {
            public void changedUpdate(DocumentEvent e)
            {
                update();
            }

            public void removeUpdate(DocumentEvent e)
            {
                update();
            }

            public void insertUpdate(DocumentEvent e)
            {
                update();
            }

            public void update()
            {
                final String text = customJTextField.getText();
                Integer value = 0;
                try
                {
                    if(!text.isEmpty())
                    {
                        value = Integer.valueOf(text);
                    }
                }
                catch(NumberFormatException nfe)
                {
                    JOptionPane.showMessageDialog(panel, MESSAGE, TITLE, JOptionPane.ERROR_MESSAGE);
                }

                variableState.put(TypeWidgetVisitor.this.identifierNode, new IntegerValue(value));
            }
        });
        this.panel.add(customJTextField);

        return customJTextField;
    }

    @Override
    public CustomWidget visit(MoneyType moneyType)
    {
        final CustomJTextField customJTextField = new CustomJTextField(LENGTH);
        customJTextField.setEditable(this.editable);
        customJTextField.getDocument().addDocumentListener(new DocumentListener()
        {
            public void changedUpdate(DocumentEvent e)
            {
                update();
            }

            public void removeUpdate(DocumentEvent e)
            {
                update();
            }

            public void insertUpdate(DocumentEvent e)
            {
                update();
            }

            public void update()
            {
                final String text = customJTextField.getText();
                BigDecimal value = new BigDecimal(0.0);
                try
                {
                    if(!text.isEmpty())
                    {
                        value = new BigDecimal(Double.valueOf(text));
                    }
                }
                catch(NumberFormatException nfe)
                {
                    JOptionPane.showMessageDialog(panel, MESSAGE, TITLE, JOptionPane.ERROR_MESSAGE);
                }

                variableState.put(TypeWidgetVisitor.this.identifierNode, new MoneyValue(value));
            }
        });
        this.panel.add(customJTextField);

        return customJTextField;
    }

}
