package org.uva.sea.ql.interpretation.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.interfaces.TypeVisitor;

public class QuestionListenerTypeVisitor implements TypeVisitor{
    private QuestionPanel questionPanel;
    private SwingRegistry registry;
    public QuestionListenerTypeVisitor(QuestionPanel q, SwingRegistry reg){
        this.questionPanel = q;
        this.registry = reg;
    }
    @Override
    public final void visit(BooleanType b) {
        listenToBoolean();
    }

    @Override
    public final void visit(Money m) {
        listenToText();
    }

    @Override
    public final void visit(StrType s) {
        listenToText();        
    }
    
    @Override
    public final void visit(IntType i) {
        listenToText();
    }
    
    private void listenToText(){
        final JTextField t = (JTextField) questionPanel.getInput();
        t.addActionListener(new ActionListener() {

            @Override
            public final void actionPerformed(ActionEvent e) {
                registry.evaluateFunctions();
            }
        });
        t.addKeyListener(new KeyListener() {

            @Override
            public final void keyTyped(KeyEvent arg0) {
                registry.evaluateFunctions();
            }

            @Override
            public final void keyReleased(KeyEvent arg0) {
                registry.evaluateFunctions();

            }

            @Override
            public final void keyPressed(KeyEvent arg0) {
                registry.evaluateFunctions();
            }
        });
    }
    
    private void listenToBoolean(){
        final JCheckBox checkbox = (JCheckBox) questionPanel.getInput();
        checkbox.addActionListener(new ActionListener() {

            @Override
            public final void actionPerformed(ActionEvent e) {
                registry.evaluateFunctions();
            }
        });
    }
}
