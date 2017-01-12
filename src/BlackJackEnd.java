import java.awt.*;
import java.awt.event.ActionListener;
/*BlackJackEnd
  *GROUP
  */


		  //awt's
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
		 //swing's
import javax.swing.*;

public class BlackJackEnd extends JFrame implements ActionListener
  {
		  		BorderLayout border = new BorderLayout(5,5);
		 	//Pannels
		 	JPanel mainPnl = new JPanel();
		 	JPanel northPnl = new JPanel();
		 	JPanel southPnl = new JPanel();
		 	JPanel eastPnl = new JPanel();
		 	JPanel westPnl = new JPanel();
		 	JPanel centerPnl = new JPanel();
		 	//Lbl's
		 	JLabel dealer = new JLabel("Dealer");
		 	JLabel player1 = new JLabel("Player 1");
		 	JLabel player2 = new JLabel("Player 2");
		 	JLabel player3 = new JLabel("Player 3");
		 	JLabel player4 = new JLabel("Player 4");
		 	JLabel titleP = new JLabel("Players");
		 	JLabel titleCV = new JLabel("Card Value");
		 	JLabel stats = new JLabel("Stats");

		 	//Space Lbl's
		 	JLabel space1 = new JLabel("          ");
		 	JLabel space2 = new JLabel("          ");//a
	  		JLabel space3 = new JLabel("          ");
		 	JLabel space4 = new JLabel("          ");//a
		 	JLabel space5 = new JLabel("          ");
		 	JLabel space6 = new JLabel("          ");//a
		 	JLabel space7 = new JLabel("          ");
		 	JLabel space8 = new JLabel("          ");
	  		JLabel space9 = new JLabel("          ");




		 	//Button
		 	JButton pressMe2 = new JButton("Restart");

	public BlackJackEnd(Player players, Dealer dealer1)
	{
			//JLabels
		JLabel player1Value = new JLabel(players.player1Val + "");
		JLabel player2Value = new JLabel(players.player2Val + "");
		JLabel player3Value = new JLabel(players.player3Val +"");
		JLabel player4Value = new JLabel(players.player4Val +"");
		JLabel dealerValue = new JLabel (dealer1.cardValue +"");
		JLabel win = new JLabel("Winner");
		JLabel tie = new JLabel("Tie");
		JLabel loss = new JLabel("Loser");

			add(mainPnl);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setSize(450,450);
			setVisible(true);
			setLocationRelativeTo(null);

			pressMe2.addActionListener(this);


			//main panel
			//add(mainPnl);
			mainPnl.setLayout(border);

			// north panel
			northPnl.add(titleP);
			northPnl.add(space1);
			northPnl.add(space2);
			northPnl.add(space3);

			northPnl.add(titleCV);
			northPnl.add(space4);
			northPnl.add(space5);
			northPnl.add(space6);

			northPnl.add(stats);
			northPnl.add(space7);
			northPnl.add(space8);
			northPnl.add(space9);

			mainPnl.add(northPnl, BorderLayout.NORTH);
			//southPnl.add(southLbl);
			southPnl.add(pressMe2);
			mainPnl.add(southPnl, BorderLayout.SOUTH);

			//east panel
			eastPnl.setLayout(new BoxLayout(eastPnl, BoxLayout.Y_AXIS));
			if(players.player1Val > dealer1.cardValue && players.player1Val < 22)
			{
				eastPnl.add(win);
			}
			else if(players.player1Val == dealer1.cardValue)
			{
				eastPnl.add(tie);
			}
			else if(players.player1Val < dealer1.cardValue || players.player1Val > 21)
			{
				eastPnl.add(loss);
			}
			if(players.player2Val > dealer1.cardValue && players.player2Val < 22)
			{
				eastPnl.add(win);
			}
			else if(players.player2Val == dealer1.cardValue)
			{
				eastPnl.add(tie);
			}
			else if(players.player2Val < dealer1.cardValue || players.player2Val > 21)
			{
				eastPnl.add(loss);
			}
			if(players.playerNumber.equals("3"))
			{
				if(players.player3Val > dealer1.cardValue && players.player3Val < 22)
				{
					eastPnl.add(win);
				}
				else if(players.player3Val == dealer1.cardValue)
				{
					eastPnl.add(tie);
				}
				else if(players.player3Val < dealer1.cardValue || players.player3Val > 21)
				{
					eastPnl.add(loss);
				}
			}
			else if(players.playerNumber.equals("4"))
			{
				if(players.player3Val > dealer1.cardValue && players.player3Val < 22)
				{
					eastPnl.add(win);
				}
				else if(players.player3Val == dealer1.cardValue)
				{
					eastPnl.add(tie);
				}
				else if(players.player3Val < dealer1.cardValue || players.player3Val > 21)
				{
					eastPnl.add(loss);
				}
				if(players.player4Val > dealer1.cardValue && players.player4Val < 22)
				{
					eastPnl.add(win);
				}
				else if(players.player4Val == dealer1.cardValue)
				{
					eastPnl.add(tie);
				}
				else if(players.player4Val < dealer1.cardValue || players.player4Val > 21)
				{
					eastPnl.add(loss);
				}
			}


			mainPnl.add(eastPnl, BorderLayout.EAST);
			//west panel
			westPnl.setLayout(new BoxLayout(westPnl, BoxLayout.Y_AXIS));
			westPnl.add(dealer);
			westPnl.add(player1);
			westPnl.add(player2);
			if(players.playerNumber.equals("3"))
			{
				westPnl.add(player3);
			}
			else if(players.playerNumber.equals("4"))
			{
				westPnl.add(player3);
				westPnl.add(player4);
			}
			mainPnl.add(westPnl, BorderLayout.WEST);

			//center panel
			centerPnl.setLayout(new BoxLayout(centerPnl, BoxLayout.Y_AXIS));
			centerPnl.add(dealerValue);
			centerPnl.add(player1Value);
			centerPnl.add(player2Value);
			if(players.playerNumber.equals("3")) {
				centerPnl.add(player3Value);
			}
			else if(players.playerNumber.equals("4")) {
				centerPnl.add(player3Value);
				centerPnl.add(player4Value);
			}
			mainPnl.add(centerPnl, BorderLayout.CENTER);

		validate();
	}
		 public void actionPerformed(ActionEvent e)
		 {
				Object source = e.getSource();
				if(source == pressMe2)
				{
					dispose();
					BlackJackStart end = new BlackJackStart();



				}
		 }
  }//end class
