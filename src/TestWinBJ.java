import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class TestWinBJ extends JFrame implements ActionListener
{
	//put in black jack start
	
	int bet1 = 0;
 	int bet2 = 0; 	int bet3 = 0;
 	int bet4 = 0;
 	
 	JLabel [] betting = {"Place Your Bets!"};
	String[] betValue = {"5","10","20","30","40","50","All In"}; 
	//combos should not be able to select a value untill the num players is selected.
	JComboBox player1 = new JComboBox(betValue);
	JComboBox player2 = new JComboBox(betValue);
	JComboBox player3 = new JComboBox(betValue);
	JComboBox player4 = new JComboBox(betValue);
	
	mainPnl.add(betting);
	// it should say betting then under it should have the 4 drop downs
	mainPnl.add(player1);
	mainPnl.add(player2);
	mainPnl.add(player3);	mainPnl.add(player4);
	
	JLabel [] betting = {"Place Your Bets!"};
	
	ComboBox BJBet = new ComboBox();
	centerFrame(BJBet);
	player1.setSelectedIndex(0);
	player1.addActionListener(this);
	
	player2.setSelectedIndex(0);
	player2.addActionListener(this);
	
	player3.setSelectedIndex(0);
	player3.addActionListener(this);
	
	player4.setSelectedIndex(0);
	player4.addActionListener(this);
	
	//in action listener
		if(e.getSourse() == player1)
		{
			JComboBox ab = (JComboBox)e.getSourse();
			String theBet1 = (String)ab.getSelectedItem();
			switch (theBet1)
			{
				case "5" ; bet1 = 5;
					break;
				case "10" ; bet1 = 10;
					break;
				case "20" ; bet1 = 20;					
					break;
				case "30" ; bet1 = 30;
					break;
				case "40" ; bet1 = 40;
					break;
				case "50" ; bet1 = 50;
					break;
				case "all" ; bet1 = totalCoin1;
					break;
				default; bet1 = 5;
			}
		}		
		if(e.getSourse() == player2)
		{
			JComboBox bc = (JComboBox)e.getSourse();
			String theBet2 = (String)bc.getSelectedItem();
			switch (theBet2)
			{
				case "5" ; bet2 = 5;
					break;
				case "10" ; bet2 = 10;
					break;
				case "20" ; bet2 = 20;
					break;
				case "30" ; bet2 = 30;
					break;
				case "40" ; bet2 = 40;
					break;
				case "50" ; bet2 = 50;
					break;
				case "all" ; bet2 = totalCoin1;
					break;
				default; bet2 = 5;
			}
		}		
		if(e.getSourse() == player3)
		{
			JComboBox cd = (JComboBox)e.getSourse();
			String theBet1 = (String)cd.getSelectedItem();
			switch (theBet3)
			{
				case "5" ; bet3 = 5;
					break;
				case "10" ; bet3 = 10;
					break;
				case "20" ; bet3 = 20;
					break;
				case "30" ; bet3 = 30;
					break;
				case "40" ; bet3 = 40;
					break;
				case "50" ; bet3 = 50;
					break;
				case "all" ; bet3 = totalCoin1;
					break;
				default; bet3 = 5;
			}
		}			
		if(e.getSourse() = player4)
		{
			JComboBox de = (JComboBox)e.getSourse();
			String theBet4 = (String)de.getSelectedItem();
			switch (theBet4)
			{
				case "5" ; bet4 = 5;
					break;
				case "10" ; bet4 = 10;
					break;
				case "20" ; bet4 = 20;
					break;
				case "30" ; bet4 = 30;
					break;
				case "40" ; bet4 = 40;
					break;
				case "50" ; bet4 = 50;
					break;
				case "all" ; bet4 = totalCoin1;
					break;
				default; bet4 = 5;
			}
		}		
		
	
	}
	

	
}
			
			
