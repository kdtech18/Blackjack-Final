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
		
		GridLayout eastLayout = new GridLayout(5, 1, 1, 1);
		BorderLayout southLayout = new BorderLayout();
		BorderLayout border = new BorderLayout();
		
		JButton hit = new JButton("Hit");
		JButton stand = new JButton("Stand");
		JButton fold = new JButton("Fold");
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
			fold.setFont(dealerLabel);
			start.setFont(dealerLabel);
			
			eastPnl.add(hit);
			eastPnl.add(stand);
			eastPnl.add(fold);
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
			
			hit.addActionListener(this);
			stand.addActionListener(this);
			fold.addActionListener(this);
			start.addActionListener(this);
			
			if(source == fold)
			{
				player++;
			}
			if(source == stand)
			{
				for(int i = 1; i < numCards; i++)
				{
					numi = cardi;
					total += numi;
					player++;
				}
			}
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
