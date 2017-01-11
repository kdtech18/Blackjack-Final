import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class TestWinBJ extends JFrame implements ActionListener
{
	//put in black jack start
	
	int bet1 = 0;
 	int bet2 = 0;
 	int bet3 = 0;
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
	mainPnl.add(player3);
	mainPnl.add(player4);
	
	JLabel [] betting = {"Place Your Bets!"};


	
	if(playerNum = 2)
	{
		//SET ABLE
		JComboBox player1 = new JComboBox(betValue);
		JComboBox player2 = new JComboBox(betValue);
	}
	
	if(playerNum = 3)
	{
		//SET ABLE
		JComboBox player1 = new JComboBox(betValue);
		JComboBox player2 = new JComboBox(betValue);
		JComboBox player3 = new JComboBox(betValue);
	}
	
	if(playerNum = 4)
	{
		//SET ABLE
		JComboBox player1 = new JComboBox(betValue);
		JComboBox player2 = new JComboBox(betValue);
		JComboBox player3 = new JComboBox(betValue);
		JComboBox player4 = new JComboBox(betValue);
	}
	
	

	
	//have not gone beyond this point 
	// BJStart = setting bet
	//BJEnd = deducting or adding coins and recalling a new deal
	// player cant bet more than they have
	
	/*
	if(dealerValue > 21) 
	{
		dealerBust = true;
	}
	
	
	for (int i = 1; i<numPlayers; i++)
	{
		if(p(i)value<= 21 && dealerBust = false)
		{
			if(p(i)value < dealerValue
			{
				totalCoin(i) = totalCoin(i) - bet(i);
				bet(i) = 0;
			}
			if(p(i)value = dealerValue
			{
				totalCoin(i) = totalCoin(i);
				bet(i) = 0;
			}			
			if(p(i)value > dealerValue)
			{
				totalCoin(i) = totalCoin(i) + bet(i);
				bet(i) = 0;
			}	
			else if(p(i)value > 21)
			{
				totalCoin(i) = totalCoin(i) - bet; 
				bet = 0;	
			}
		}
		if (dealerBust = true && p(i)value <= 21)
		{
			totalCoin(i) = totalCoin(i) + bet
			bet = 0;	
		}
	}*/
}
			
			