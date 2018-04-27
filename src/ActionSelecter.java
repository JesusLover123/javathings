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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ActionSelecter extends JMenuBar
{
	private JMenu[] menus;
	public ActionSelecter()
	{
//		setBounds(0, 0, 100, 600);
//		setLayout(new GridBagLayout());
//		GridBagConstraints gbc = new GridBagConstraints();
		
		menus = new JMenu[3];
		
		
	
		JMenu accMenu = new JMenu("Accounts");
		accMenu.add("Create Account");
		accMenu.add("Remove Account");
		accMenu.add("Get Account Info");
		accMenu.add("Get Accounts Under Name");
		menus[0] = accMenu;
		
		add(menus[0]);
		
		JMenu actMenu = new JMenu("Transactions");
		actMenu.add("Deposit");
		actMenu.add("Withdraw");
		actMenu.add("Transfer");
		menus[1] = actMenu;
		
		add(menus[1]);
		
		JMenu home = new JMenu("Home");
		home.add("Return to Home");
		menus[2] = home;
		add(menus[2]);
	}
	
	public JMenu getMenu(int x)
	{
		return(menus[x]);
	}
	
}
