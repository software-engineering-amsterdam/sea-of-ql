import java.awt.*;
import javax.swing.*;

public class Box1HouseOwning extends JFrame {
	private JCheckBox hasSoldHouse = new JCheckBox();
	private JCheckBox hasBoughtHouse = new JCheckBox();
	private JCheckBox hasMaintLoan = new JCheckBox();
	private SpinnerNumberModel valueResidueModel = new SpinnerNumberModel();
	private JSpinner valueResidue = new JSpinner(valueResidueModel);
	private SpinnerNumberModel sellingPriceModel = new SpinnerNumberModel();
	private JSpinner sellingPrice = new JSpinner(sellingPriceModel);
	private SpinnerNumberModel privateDebtModel = new SpinnerNumberModel();
	private JSpinner privateDebt = new JSpinner(privateDebtModel);
	private JTextField nameHouse = new JTextField();
	private JPanel if8 = new JPanel();
	private JPanel else8 = new JPanel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
	      		new Box1HouseOwning().setVisible(true);
			}
		});
	}
	
	private Box1HouseOwning() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("QL: Box1HouseOwning");
		setAlwaysOnTop(true);
		setLocationByPlatform(true);
		
		JPanel content = new JPanel();
		content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		getContentPane().add(content, BorderLayout.CENTER);
		
		JPanel hasSoldHousePanel = new JPanel();
		hasSoldHousePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		hasSoldHousePanel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel hasSoldHouseLabel = new JLabel("Did you sell a house in 2010?");
		hasSoldHouseLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		hasSoldHousePanel.add(hasSoldHouseLabel);
		hasSoldHousePanel.add(hasSoldHouse);
		content.add(hasSoldHousePanel);
		  	
		JPanel hasBoughtHousePanel = new JPanel();
		hasBoughtHousePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		hasBoughtHousePanel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel hasBoughtHouseLabel = new JLabel("Did you by a house in 2010?");
		hasBoughtHouseLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		hasBoughtHousePanel.add(hasBoughtHouseLabel);
		hasBoughtHousePanel.add(hasBoughtHouse);
		content.add(hasBoughtHousePanel);
		  	
		JPanel hasMaintLoanPanel = new JPanel();
		hasMaintLoanPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		hasMaintLoanPanel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel hasMaintLoanLabel = new JLabel("Did you enter a loan for maintenance/reconstruction?");
		hasMaintLoanLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		hasMaintLoanPanel.add(hasMaintLoanLabel);
		hasMaintLoanPanel.add(hasMaintLoan);
		content.add(hasMaintLoanPanel);
		  	
		JPanel valueResiduePanel = new JPanel();
		valueResiduePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		valueResiduePanel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel valueResidueLabel = new JLabel("Value residue:");
		valueResidueLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		valueResiduePanel.add(valueResidueLabel);
		valueResiduePanel.add(valueResidue);
		content.add(valueResiduePanel);
		  	
		valueResidue.setEnabled(false);
			
		if8.setLayout(new BoxLayout(if8, BoxLayout.Y_AXIS));
		content.add(if8);
			
		JPanel sellingPricePanel = new JPanel();
		sellingPricePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		sellingPricePanel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel sellingPriceLabel = new JLabel("Price the house was sold for:");
		sellingPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		sellingPricePanel.add(sellingPriceLabel);
		sellingPricePanel.add(sellingPrice);
		if8.add(sellingPricePanel);
		  	
		JPanel privateDebtPanel = new JPanel();
		privateDebtPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		privateDebtPanel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel privateDebtLabel = new JLabel("Private debts for the sold house:");
		privateDebtLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		privateDebtPanel.add(privateDebtLabel);
		privateDebtPanel.add(privateDebt);
		if8.add(privateDebtPanel);
		  	
		else8.setLayout(new BoxLayout(else8, BoxLayout.Y_AXIS));
		content.add(else8);
			
		JPanel nameHousePanel = new JPanel();
		nameHousePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		nameHousePanel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel nameHouseLabel = new JLabel("Name of the house:");
		nameHouseLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		nameHousePanel.add(nameHouseLabel);
		nameHousePanel.add(nameHouse);
		else8.add(nameHousePanel);
		  		
		pack();
	}
}