package org.uva.sea.ql.interpretation.swing.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import org.uva.sea.ql.interpretation.swing.QLFileFilter;
import org.uva.sea.ql.interpretation.swing.SwingHelper;

public class FileOpenPanel extends JPanel{

    /**
     * 
     */
    private static final long serialVersionUID = 7761095728347602313L;
    private final JButton buttonOpenFile;
    private final JFileChooser fileChooser;
    private final SwingHelper helper;
 
    public FileOpenPanel(SwingHelper h){
        this.helper = h;
        this.buttonOpenFile = new JButton("Open File");
        this.add(this.buttonOpenFile);
        addOpenFileListener(this.buttonOpenFile);
        this.fileChooser = new JFileChooser();
        this.fileChooser.setFileFilter(new QLFileFilter());        
    }
    public final SwingHelper getHelper(){
        return this.helper;
    }
    private void addOpenFileListener(JButton b) {

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                openFile();
            }
        });
    }
    
    private void openFile() {
        final int returnVal = this.fileChooser.showOpenDialog(FileOpenPanel.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            final File file = this.fileChooser.getSelectedFile();
            this.helper.openFile(file);
        }
    }
}
