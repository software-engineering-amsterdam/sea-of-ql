package org.uva.sea.ql.swing;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;


public class Renderer extends JFrame{
	List<JPanel> questionList;
	
	public Renderer(List<JPanel> questionList){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(700, 600));
        JPanel content=new JPanel();
        content.setLayout((new MigLayout(
        		"",
        		// Layout Constraints
        		"[center]", // Column constraints with default align
        		"[]")));
        
        for(JPanel question:questionList){
        	content.add(question,"wrap");
        }
        
        JPanel n2=new JPanel();
        n2.add(content);
		this.add(n2);
		this.setVisible(true);
		
	}

}
