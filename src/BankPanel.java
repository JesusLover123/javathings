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

public class BankPanel extends JPanel
{
	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	private JPanel jimmers = this;
	
	public BankPanel()
	{
		setBounds(0, 0, 600, 600);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel name = new JLabel("Name: ");
		add(name, gbc);
		JLabel ideposit = new JLabel("Initial Deposit:");
		gbc.gridy++;
		add(ideposit, gbc);
		JLabel acttype = new JLabel("Account Type:");
		gbc.gridy++;
		add(acttype, gbc);
		JTextField namein = new JTextField();
		gbc.gridy = 0;
		gbc.gridx++;
		namein.setPreferredSize(new Dimension(100, 20));
		add(namein, gbc);
		JTextField idepin = new JTextField();
		gbc.gridy++;
		idepin.setPreferredSize(new Dimension(100, 20));
		add(idepin, gbc);
		String[] words = {"Checking", "Savings"};
		JList typein = new JList(words);
		JScrollPane scrOptions = new JScrollPane(typein);
		gbc.gridy++;
		scrOptions.setPreferredSize(new Dimension(70, 40));
		add(scrOptions, gbc);
		
		JLabel prompt = new JLabel("Please input something into each text field and select something from each list.");
		gbc.gridy+=2;
		gbc.gridwidth = 2;
		add(prompt, gbc);
		prompt.setVisible(false);
		gbc.gridy--;
		gbc.gridy--;
		gbc.gridwidth = 1;
		
		JButton submit = new JButton("Submit");
		gbc.gridy++;
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					namein.getText();
					idepin.getText();
					typein.getSelectedValue().equals("");
					if(typein.getSelectedValue().equals("Checking"))
					{
						accounts.add(new CheckingAccount(namein.getText(), Double.parseDouble(idepin.getText()), 0, 0, 0));
					}
					if(typein.getSelectedValue().equals("Savings"))
					{
						accounts.add(new SavingsAccount(namein.getText(), Double.parseDouble(idepin.getText()), 0, 0, 0));
					}
					else
					{
						
					}
				}
				catch(NullPointerException | IllegalArgumentException e1)
				{
					JOptionPane.showMessageDialog(jimmers, "Please input something valid into each text field.");
					return;
				}
			}
			
		});
		add(submit, gbc);
		
		setVisible(true);
	}
	
	public BankAccount getAccountByNum(int x)
	{
		return accounts.get(x);
	}
	
	public ArrayList<BankAccount> getAccountList()
	{
		return accounts;
	}
}
