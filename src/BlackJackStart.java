/*BlackJackStar
 *Group
 *JAVA
 */
 
 //awt's
 import java.awt.*;
 import java.awt.event.ActionListener;
 import java.awt.event.ActionEvent;
 //swing's
 import javax.swing.*;


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

	Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 28);
	
	//Button
	JButton pressMe = new JButton("Start");
	
		int bet1 = 0;
 	int bet2 = 0;
	int bet3 = 0;
 	int bet4 = 0;
 	
	int totalCoin1 = 100;
	int totalCoin2 = 100;
	int totalCoin3 = 100;
	int totalCoin4 = 100;	
	
 	//JLabel [] betting = {"Place Your Bets!"};
	String [] betValue = {"5","10","20","30","40","50","All In"}; 
	//combos should not be able to select a value untill the num players is selected.
	JComboBox player1 = new JComboBox(betValue);
	JComboBox player2 = new JComboBox(betValue);
	JComboBox player3 = new JComboBox(betValue);
	JComboBox player4 = new JComboBox(betValue);
	

	
	
	
	
	
	
	public BlackJackStart()
	{
	
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(450,450);
		setVisible(true);
		setLocationRelativeTo(null);
		
	player1.setSelectedIndex(0);
	player1.addActionListener(this);
	
	player2.setSelectedIndex(0);
	player2.addActionListener(this);
	
	player3.setSelectedIndex(0);
	player3.addActionListener(this);
	
	player4.setSelectedIndex(0);
	player4.addActionListener(this);
	

		pressMe.addActionListener(this);
		players.addActionListener(this);
		
		northLbl.setFont(font);
		pressMe.setFont(font);
		players.setFont(font);
		
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
		
		//mainPnl.add(betting);
		// it should say betting then under it should have the 4 drop downs
		mainPnl.add(player1);
		mainPnl.add(player2);
		mainPnl.add(player3);
		mainPnl.add(player4);
	
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == pressMe)
		{
			dispose();
			Blackjack app = new Blackjack((String)players.getSelectedItem());

			
		}
		if(source == player1)
		{
			JComboBox ab = (JComboBox)e.getSource();
			String theBet1 = (String)ab.getSelectedItem();
			switch (theBet1)
			{
				case "5" : bet1 = 5;
					break;
				case "10" : bet1 = 10;
					break;
				case "20" : bet1 = 20;					
					break;
				case "30" : bet1 = 30;
					break;
				case "40" : bet1 = 40;
					break;
				case "50" : bet1 = 50;
					break;
				case "All In" : bet1 = totalCoin1;
					break;
				default: bet1 = 5;
			}
		}		
		if(e.getSource() == player2)
		{
			JComboBox bc = (JComboBox)e.getSource();
			String theBet2 = (String)bc.getSelectedItem();
			switch (theBet2)
			{
				case "5" : bet2 = 5;
					break;
				case "10" : bet2 = 10;
					break;
				case "20" : bet2 = 20;
					break;
				case "30" : bet2 = 30;
					break;
				case "40" : bet2 = 40;
					break;
				case "50" : bet2 = 50;
					break;
				case "All In" : bet2 = totalCoin2;
					break;
				default: bet2 = 5;
			}
		}		
		if(e.getSource() == player3)
		{
			JComboBox cd = (JComboBox)e.getSource();
			String theBet3 = (String)cd.getSelectedItem();
			switch (theBet3)
			{
				case "5" : bet3 = 5;
					break;
				case "10" : bet3 = 10;
					break;
				case "20" : bet3 = 20;
					break;
				case "30" : bet3 = 30;
					break;
				case "40" : bet3 = 40;
					break;
				case "50" : bet3 = 50;
					break;
				case "All In" : bet3 = totalCoin3;
					break;
				default: bet3 = 5;
			}
		}			
		if(e.getSource() == player4)
		{
			JComboBox de = (JComboBox)e.getSource();
			String theBet4 = (String)de.getSelectedItem();
			switch (theBet4)
			{
				case "5" : bet4 = 5;
					break;
				case "10" : bet4 = 10;
					break;
				case "20" : bet4 = 20;
					break;
				case "30" : bet4 = 30;
					break;
				case "40" : bet4 = 40;
					break;
				case "50" : bet4 = 50;
					break;
				case "All In" : bet4 = totalCoin4;
					break;
				default: bet4 = 5;
			}
		}		
	
	}
	
	public static void main(String [] args)
	{
		BlackJackStart myFrame = new BlackJackStart();	
	}//end main method	
}//end class JFramePractice 2 