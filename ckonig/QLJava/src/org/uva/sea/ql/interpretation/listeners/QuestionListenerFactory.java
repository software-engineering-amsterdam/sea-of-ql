package org.uva.sea.ql.interpretation.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.uva.sea.ql.interpretation.SwingRegistry;

public class QuestionListenerFactory extends ListenerFactory {

    private SwingRegistry registry;

    public QuestionListenerFactory(SwingRegistry reg) {
        this.registry = reg;
    }

    @Override
    public ActionListener getActionListener() {
        return new ActionListener() {

            @Override
            public final void actionPerformed(ActionEvent e) {
                registry.updateIfPanelVisibilities();
                registry.updateAutoValues();
            }
        };
    }

    @Override
    public KeyListener getKeyListener() {
        return new KeyListener() {

            @Override
            public final void keyTyped(KeyEvent arg0) {
                registry.updateIfPanelVisibilities();
                registry.updateAutoValues();
            }

            @Override
            public final void keyReleased(KeyEvent arg0) {
                registry.updateIfPanelVisibilities();
                registry.updateAutoValues();

            }

            @Override
            public final void keyPressed(KeyEvent arg0) {
                registry.updateIfPanelVisibilities();
                registry.updateAutoValues();
            }
        };
    }
}
