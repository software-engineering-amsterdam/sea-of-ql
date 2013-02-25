package org.uva.sea.ql.interpretation.listeners;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

 abstract class AbstractListenerFactory {
    public abstract ActionListener getActionListener();
    public abstract KeyListener getKeyListener();
}
