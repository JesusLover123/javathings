import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class HomeScreen extends JPanel
{
	public HomeScreen()
	{
		setBounds(0, 0, 600, 600);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel welcome = new JLabel("Welcome to Tony Wang's Chinese Banking!");
		BufferedImage loganpaul = null;
		try
		{
			loganpaul = ImageIO.read(new File("maxresdefault.jpg"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		JLabel paul = new JLabel(new ImageIcon(loganpaul));
		paul.setPreferredSize(new Dimension(600, 400));
		gbc.gridy++;
		add(paul, gbc);
		add(welcome);
	}
}
