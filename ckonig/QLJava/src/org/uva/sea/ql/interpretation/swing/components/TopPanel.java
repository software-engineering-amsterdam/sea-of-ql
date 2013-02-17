package org.uva.sea.ql.interpretation.swing.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.uva.sea.ql.interpretation.swing.QLFileFilter;
import org.uva.sea.ql.interpretation.swing.SwingHelper;

public class TopPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 270484964302085412L;

    private JButton buttonOpenFile;
    private JButton buttonGenerate;
    private final JFileChooser fileChooser;
    private JTextArea log;
    private JPanel center;

    private SwingHelper helper;

    public TopPanel(SwingHelper h, JTextArea l, JPanel c) {
        this.helper = h;
        this.log = l;
        this.center = c;
        this.buttonOpenFile = new JButton("Open File");
        this.buttonGenerate = new JButton("Generate HTML");
        this.buttonGenerate.setEnabled(false);
        this.fileChooser = new JFileChooser();
        this.fileChooser.setFileFilter(new QLFileFilter());
        this.add(this.buttonOpenFile);
        this.add(this.buttonGenerate);
        addOpenFileListener(this.buttonOpenFile);
        addGenerateListener(this.buttonGenerate);
    }

    private void addOpenFileListener(JButton b) {

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                openFile();
            }
        });
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
        this.helper.generateHtml();
    }

    private void openFile() {
        final int returnVal = this.fileChooser.showOpenDialog(TopPanel.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            final File file = this.fileChooser.getSelectedFile();
            this.helper = new SwingHelper(this.log, this.buttonGenerate, this.center);
            this.helper.openFile(file);
        }
    }

}
