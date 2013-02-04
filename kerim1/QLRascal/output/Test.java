import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Box1HouseOwning extends JFrame implements ChangeListener, FocusListener {
	private JCheckBox hasSoldHouse = new JCheckBox();
	private JCheckBox hasBoughtHouse = new JCheckBox();
	private JCheckBox hasMaintLoan = new JCheckBox();
	private SpinnerNumberModel valueResidueModel = new SpinnerNumberModel();
	private JSpinner valueResidue = new JSpinner(valueResidueModel);
	private SpinnerNumberModel sellingPriceModel = new SpinnerNumberModel();
	private JSpinner sellingPrice = new JSpinner(sellingPriceModel);
	private SpinnerNumberModel privateDebtModel = new SpinnerNumberModel();
	private JSpinner privateDebt = new JSpinner(privateDebtModel);
	private JPanel if7 = new JPanel();
	
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
		
		hasSoldHouse.addChangeListener(this);
		
		JPanel hasSoldHousePanel = new JPanel();
		hasSoldHousePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		hasSoldHousePanel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel hasSoldHouseLabel = new JLabel("Did you sell a house in 2010?");
		hasSoldHouseLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		hasSoldHousePanel.add(hasSoldHouseLabel);
		hasSoldHousePanel.add(hasSoldHouse);
		content.add(hasSoldHousePanel);
		
		hasBoughtHouse.addChangeListener(this);
		
		JPanel hasBoughtHousePanel = new JPanel();
		hasBoughtHousePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		hasBoughtHousePanel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel hasBoughtHouseLabel = new JLabel("Did you by a house in 2010?");
		hasBoughtHouseLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		hasBoughtHousePanel.add(hasBoughtHouseLabel);
		hasBoughtHousePanel.add(hasBoughtHouse);
		content.add(hasBoughtHousePanel);
		
		hasMaintLoan.addChangeListener(this);
		
		JPanel hasMaintLoanPanel = new JPanel();
		hasMaintLoanPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		hasMaintLoanPanel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel hasMaintLoanLabel = new JLabel("Did you enter a loan for maintenance/reconstruction?");
		hasMaintLoanLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		hasMaintLoanPanel.add(hasMaintLoanLabel);
		hasMaintLoanPanel.add(hasMaintLoan);
		content.add(hasMaintLoanPanel);
		
		valueResidue.addChangeListener(this);
		
		JPanel valueResiduePanel = new JPanel();
		valueResiduePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		valueResiduePanel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel valueResidueLabel = new JLabel("Value residue:");
		valueResidueLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		valueResiduePanel.add(valueResidueLabel);
		valueResiduePanel.add(valueResidue);
		content.add(valueResiduePanel);
		
		valueResidue.setEnabled(false);
		
		if7.setLayout(new BoxLayout(if7, BoxLayout.Y_AXIS));
		content.add(if7);
		
		sellingPrice.addChangeListener(this);
		
		JPanel sellingPricePanel = new JPanel();
		sellingPricePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		sellingPricePanel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel sellingPriceLabel = new JLabel("Price the house was sold for:");
		sellingPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		sellingPricePanel.add(sellingPriceLabel);
		sellingPricePanel.add(sellingPrice);
		if7.add(sellingPricePanel);
		
		privateDebt.addChangeListener(this);
		
		JPanel privateDebtPanel = new JPanel();
		privateDebtPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		privateDebtPanel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel privateDebtLabel = new JLabel("Private debts for the sold house:");
		privateDebtLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		privateDebtPanel.add(privateDebtLabel);
		privateDebtPanel.add(privateDebt);
		if7.add(privateDebtPanel);
			
		pack();
		
		formStateChanged();
	}
	
	public void stateChanged(ChangeEvent e) {
		formStateChanged();
	}
	
	public void focusGained(FocusEvent e) { }
	
	public void focusLost(FocusEvent e) {
		if (!e.isTemporary()) {
			formStateChanged();
		}
	}
	
	private void formStateChanged() {
		valueResidueModel.setValue(new Integer(sellingPriceModel.getNumber().intValue() - privateDebtModel.getNumber().intValue()).intValue());
		if7.setVisible(false);
		if (new Boolean(hasSoldHouse.isSelected()).booleanValue()) {
			if7.setVisible(true);
		}
		
	}
}