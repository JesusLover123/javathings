import javax.swing.JPanel;
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

public class AccountInfoPanel extends JPanel
{
	private JPanel jimmers = this;
	
	public AccountInfoPanel(BankPanel gg)
	{
		setBounds(0, 0, 600, 600);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel name = new JLabel("Account Number of Account to Be Checked: ");
		add(name, gbc);
		JTextField namein = new JTextField();
		gbc.gridy = 0;
		gbc.gridx++;
		namein.setPreferredSize(new Dimension(100, 20));
		add(namein, gbc);
		JLabel holderName = new JLabel("Account Name: ");
		gbc.gridy++;
		gbc.gridx--;
		add(holderName, gbc);
		JLabel actType = new JLabel("Account Type: ");
		gbc.gridy++;
		add(actType, gbc);
		JLabel bal = new JLabel("Account Balance: ");
		gbc.gridy++;
		add(bal, gbc);
		
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
					namein.getText();
					for(int i = 0; i < gg.getAccountList().size(); i++)
					{
						if(gg.getAccountList().get(i).getAccountNumber() == Integer.parseInt(namein.getText()))
						{
							holderName.setText("Account Name: " + gg.getAccountList().get(i).getName());
							actType.setText("Account Type: " + gg.getAccountList().get(i).getClass());
							bal.setText("Account Balance: " + gg.getAccountList().get(i).getBalance());
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
