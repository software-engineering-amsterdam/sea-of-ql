package org.uva.sea.ql.swing;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;


public class Renderer extends JFrame{
	private static List<JPanel> questionList;
	private final JPanel content;
	
	public Renderer(List<JPanel> questionList){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(700, 600));
		this.questionList=questionList;
        content=new JPanel();
        content.setLayout((new MigLayout(
        		"",
        		// Layout Constraints
        		"[center]", // Column constraints with default align
        		"[]")));
        
        for(JPanel question:questionList){
        	content.add(question,"wrap");
        }
        
        JPanel containerPanel=new JPanel();
        containerPanel.add(content);
		this.add(containerPanel);
		this.setVisible(true);
		
	}
	
  

}
