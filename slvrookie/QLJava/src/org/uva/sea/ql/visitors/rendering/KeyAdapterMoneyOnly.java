package org.uva.sea.ql.visitors.rendering;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.text.JTextComponent;

public class KeyAdapterMoneyOnly extends KeyAdapter {

	 /*
     * Regular expression which defines the allowed characters.
     */
    private String allowedRegex = "([^1-9][^0-9]\\.?)" ; 

    public void keyReleased(KeyEvent e) {
        String curText = ((JTextComponent) e.getSource()).getText();
        curText = curText.replaceAll(allowedRegex, "");
        ((JTextComponent) e.getSource()).setText(curText);
    }
}
