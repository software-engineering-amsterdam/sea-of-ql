package org.uva.sea.ql.swing;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;


public class Renderer {
	private static List<JPanel> questionList;
	private static JPanel content;
	private  static JFrame frame;
	
	public Renderer(List<JPanel> questionList){
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(700, 600));
		this.questionList=questionList;
		content=new JPanel();
        setPanel();
		
		
		
	}
	
	public static void setPanel(){
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
	        frame.add(containerPanel);
			frame.setVisible(true);
	}
	
	public static void refresh(List<JPanel> questionList){
		    content.removeAll();
	        
	        for(JPanel question:questionList){
	        	content.add(question,"wrap");
	        }
	        
	        JPanel containerPanel=new JPanel();
	        containerPanel.add(content);
	        frame.add(containerPanel);
			frame.setVisible(true);
			frame.validate();
	}
	
	
	
	public static JFrame getFrame(){
		
		return frame;
	}
	
  

}
