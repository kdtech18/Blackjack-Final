/* Blackjack.java
   Kenton Duprey
   Java Graphics II G
   Mr. Blondin
   12/14/2016
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Blackjack extends JFrame implements ActionListener
	{
		JPanel mainPnl = new JPanel();
		JPanel centerPnl = new JPanel();
		JPanel southPnl = new JPanel();
		JPanel eastPnl = new JPanel();
		
		
		
		GridLayout eastLayout = new GridLayout(3, 1, 1, 1);
		BorderLayout southLayout = new BorderLayout();
		BorderLayout border = new BorderLayout();
		
		JButton hit = new JButton("Hit");
		JButton stand = new JButton("Stand");
		JButton start = new JButton("Start");
		
		int playerNum;
		JLabel player = new JLabel("Player: " + playerNum);
		JLabel dealer = new JLabel("Dealer");
		
		Font dealerLabel = new Font(Font.SANS_SERIF, Font.PLAIN, 28);
		
	public Blackjack()
		{
			super("BlackJack");
			add(mainPnl);
			setVisible(true);
			setSize(500, 500);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			
			eastPnl.setLayout(eastLayout);
			
			hit.setFont(dealerLabel);
			stand.setFont(dealerLabel);
			start.setFont(dealerLabel);
			
			eastPnl.add(hit);
			eastPnl.add(stand);
			eastPnl.add(start);
			
			centerPnl.add(dealer);
			dealer.setFont(dealerLabel);
			
			mainPnl.add(centerPnl, BorderLayout.CENTER);
			mainPnl.add(eastPnl, BorderLayout.EAST);
			mainPnl.add(southPnl, BorderLayout.SOUTH);
			
			validate();
		}
		
	public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			
			hit.addActionListener(this);
			stand.addActionListener(this);
			start.addActionListener(this);
			
			if(source == stand)
			{
				// goes to next player
			}
			if(source == hit)
				{
					// give them another card
					// then add that value to the existing player card value
					// check if win or bust
					// if bust move to next player
					// if win go to next play
					// while bust or win is not true
					
				}
		}
	public boolean checkWin(int cardValue)
		{
			if(cardValue == 21 && !checkBust(cardValue))
				return true;
			else
				return false;
		}
	public boolean checkBust(int cardValue)
		{
			if (cardValue > 21)
				return true;
			else
				return false;
		}
	
	public void addButtonsEast()
		{
		for (int i = 0; i < 4; i++)
			{
				
			}
		}
	public void BenAceMethod()
 		{
			/*
				if (card1 == ace && card2 == faceCard)
	 				Blackjack();
	 		if (card1 == faceCard && card2 == ace)
	 			Blackjack();
			if (card1 = ace && isWin == false)
	 			int sumCard1 = card2 + 1;
	 			int sumCard2 = card2 + 11;
	 			if (sumCard2 >= 21)
	 				trueValue == sumCard2;
	 			else
	 				trueValue = sumCard1;
	 			if (sumCard1 > 21)
	 				Bust();
	 		if(card2 == ace && isWin == false)
	 
	 		*/
		  	}
	public static void main(String[] args)
		{
			Blackjack app = new Blackjack();
			
		}// end main method
		
	}
