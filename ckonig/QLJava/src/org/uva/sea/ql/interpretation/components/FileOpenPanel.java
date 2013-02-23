package org.uva.sea.ql.interpretation.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import org.uva.sea.ql.interpretation.SwingHelper;

public class FileOpenPanel extends JPanel {

    private static final long serialVersionUID = 7761095728347602313L;
    private static JButton buttonOpenFile;
    private static JFileChooser fileChooser;
    private static SwingHelper helper;

    public FileOpenPanel(SwingHelper h) {
        helper = h;
        buttonOpenFile = new JButton("Open File");
        this.add(buttonOpenFile);
        addOpenFileListener(buttonOpenFile);
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new QLFileFilter());
    }

    public final SwingHelper getHelper() {
        return helper;
    }

    private void addOpenFileListener(JButton b) {

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final int returnVal = fileChooser
                        .showOpenDialog(FileOpenPanel.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    final File file = fileChooser.getSelectedFile();
                    helper.openFile(file);
                }
            }
        });
    }

}
