package org.uva.sea.ql.interpretation.swing.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TopPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 270484964302085412L;

    private final JButton buttonGenerate;
    private final FileOpenPanel fileOpenPanel;

    public TopPanel(LeftPanel l, CenterPanel c) {
        this.buttonGenerate = new JButton("Generate HTML");
        this.buttonGenerate.setEnabled(false);
        this.add(this.buttonGenerate);
        this.addGenerateListener(this.buttonGenerate);
        this.setSize(Sizes.WINDOW_WIDTH, Sizes.TOP_HEIGHT);
        final JTextArea log = l.getLog();
        this.fileOpenPanel = new FileOpenPanel(this.buttonGenerate, log, c);
        this.add(this.fileOpenPanel);
    }

    private void addGenerateListener(JButton b) {
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                generate();
            }
        });
    }

    private void generate() {
        this.fileOpenPanel.getHelper().generateHtml();
    }

}
