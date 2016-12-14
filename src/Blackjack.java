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
		
		
		
	public Blackjack()
		{
			super("BlackJack");
			add(mainPnl);
			setVisible(true);
			setSize(500, 500);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			eastPnl.setLayout(eastLayout);
			eastPnl.add(hit);
			eastPnl.add(stand);
			eastPnl.add(fold);
			eastPnl.add(start);
			
			mainPnl.add(eastPnl, BorderLayout.EAST);
			
			
			validate();
		}
		
	public void actionPerformed(ActionEvent e)
		{
			
		}
	
	public void addButtonsEast()
		{
		for (int i = 0; i < 4; i++)
			{
				
			}
		}
	public static void main(String[] args)
		{
			Blackjack app = new Blackjack();
		}// end main method
	
	}
