import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class BankFrame extends JFrame
{
	static BankPanel myPanel;
	static HomeScreen home;
	static JPanel current;
	static CreateAccountPane currAcctPanel;
	static AccountInfoPanel actInfoPanel;
	static AccountNumPanel actNumPanel;
	static DepositPanel depPanel;
	static WithdrawPanel witPanel;
	static TransferPanel transPanel;
	
	public BankFrame()
	{
		setBounds(300, 300, 800, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy--;
		ActionSelecter menuMaker = new ActionSelecter();
		setJMenuBar(menuMaker);
		
		home = new HomeScreen();
		add(home);
		home.setVisible(true);
		
		current = home;
		
		
		
		myPanel = new BankPanel();
		add(myPanel);
		myPanel.setVisible(false);
		currAcctPanel = new CreateAccountPane(myPanel);
		add(currAcctPanel);
		currAcctPanel.setVisible(false);
		actInfoPanel = new AccountInfoPanel(myPanel);
		add(actInfoPanel);
		actInfoPanel.setVisible(false);
		actNumPanel = new AccountNumPanel(myPanel);
		add(actNumPanel);
		actNumPanel.setVisible(false);
		depPanel = new DepositPanel(myPanel);
		add(depPanel);
		depPanel.setVisible(false);
		witPanel = new WithdrawPanel(myPanel);
		add(witPanel);
		witPanel.setVisible(false);
		transPanel = new TransferPanel(myPanel);
		add(transPanel);
		transPanel.setVisible(false);
		
		menuMaker.getMenu(0).getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{  
				current.setVisible(false);
				myPanel.setVisible(true);
				current = myPanel;
			}
		});
		menuMaker.getMenu(0).getItem(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				current.setVisible(false);
				currAcctPanel.setVisible(true);
				current = currAcctPanel;
			}
		});
		menuMaker.getMenu(0).getItem(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				current.setVisible(false);
				actInfoPanel.setVisible(true);
				current = actInfoPanel;
			}
		});
		menuMaker.getMenu(0).getItem(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				current.setVisible(false);
				actNumPanel.setVisible(true);
				current = actNumPanel;
			}
		});
		menuMaker.getMenu(1).getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				current.setVisible(false);
				depPanel.setVisible(true);
				current = depPanel;
			}
		});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		menuMaker.getMenu(1).getItem(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				current.setVisible(false);
				witPanel.setVisible(true);
				current = witPanel;
			}
		});
		menuMaker.getMenu(1).getItem(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				current.setVisible(false);
				transPanel.setVisible(true);
				current = transPanel;
			}
		});
		menuMaker.getMenu(2).getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				current.setVisible(false);
				home.setVisible(true);
				current = home;
			}
		});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}
	
	
	
	public static void main(String[] args)
	{
		new BankFrame();
		
	}
	
//	CardLayout cl = new CardLayout();
//	JPanel overall = new JPanel();
//	overall.setLayout(cl);
//	JPanel panel1 = new JPanel();
//	panel1.add(new JLabel("panel1"));
	
}
