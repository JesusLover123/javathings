import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DepositPanel extends JPanel
{
	private JPanel jimmers = this;
	
	public DepositPanel(BankPanel gg)
	{
		setBounds(0, 0, 600, 600);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel accnum = new JLabel("Account Number: ");
		add(accnum, gbc);
		JLabel amtdeposit = new JLabel("Amount to Deposit: ");
		gbc.gridy++;
		add(amtdeposit, gbc);
		JTextField accnumin = new JTextField();
		gbc.gridy = 0;
		gbc.gridx++;
		add(accnumin, gbc);
		accnumin.setPreferredSize(new Dimension(100, 20));
		JTextField depmonin = new JTextField();
		gbc.gridx = 1;
		gbc.gridy++;
		add(depmonin, gbc);
		depmonin.setPreferredSize(new Dimension(100, 20));
		
		JLabel prompt = new JLabel("Please input something into each text field.");
		gbc.gridy+=2;
		add(prompt, gbc);
		prompt.setVisible(false);
		gbc.gridy--;
		gbc.gridy--;
		
		JButton submit = new JButton("Submit");
		gbc.gridy++;
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					accnumin.getText();
					depmonin.getText();
					for(int i = 0; i < gg.getAccountList().size(); i++)
					{
						if(gg.getAccountList().get(i).getAccountNumber() == Integer.parseInt(accnumin.getText()))
						{
							gg.getAccountList().get(i).deposit(Double.parseDouble(depmonin.getText()));
						}
					}
				}
				catch(java.lang.NullPointerException | IllegalArgumentException e1)
				{
					JOptionPane.showMessageDialog(jimmers, "Please input something valid into each text field.");
					return;
				}
			}
			
		});
		add(submit, gbc);
		
		setVisible(true);
	}
}
