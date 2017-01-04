/*BlackJackStar
 *Group
 *JAVA
 */
 
 //awt's
 import java.awt.Color;
 import java.awt.BorderLayout;
 import java.awt.event.ActionListener;
 import java.awt.event.ActionEvent;
 //swing's
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.JButton;
 import javax.swing.JLabel;
 import javax.swing.JComboBox;
 

public class BlackJackStart extends JFrame implements ActionListener
{
	BorderLayout border = new BorderLayout(5,5);
	//Pannels
	JPanel mainPnl = new JPanel();
	JPanel northPnl = new JPanel();
	JPanel southPnl = new JPanel();
	JPanel eastPnl = new JPanel();
	JPanel westPnl = new JPanel();
	JPanel centerPnl = new JPanel();
	//Title
	JLabel northLbl = new JLabel("Welcome to Black Jack");
	//Drop Down
	String[] playersArr = {"2","3","4"};
	JComboBox players = new JComboBox(playersArr);

	//Button
	JButton pressMe = new JButton("Start");
	
	public BlackJackStart()
	{
	
		
		setSize(450,450);
		setVisible(true);
		setLocationRelativeTo(null);
		
		//main panel
		add(mainPnl);
		mainPnl.setLayout(border);
		
		// north panel
		northPnl.add(northLbl);
		mainPnl.add(northPnl, BorderLayout.NORTH);
		
		//southPnl.add(southLbl);
		southPnl.add(pressMe);
		mainPnl.add(southPnl, BorderLayout.SOUTH);
		
		//east panel
		mainPnl.add(eastPnl, BorderLayout.EAST);
		
		//west panel
		mainPnl.add(westPnl, BorderLayout.WEST);
		
		//center panel
		centerPnl.add(players);
		mainPnl.add(centerPnl, BorderLayout.CENTER);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == pressMe)
		{
			Blackjack start = new Blackjack();
			pressMe.addActionListener(this);	
			
		}
	
	
	
	}
	
	public static void main(String [] args)
	{
		BlackJackStart myFrame = new BlackJackStart();	
	}//end main method	
}//end class JFramePractice 2 