/*BlackJackEnd
 *GROUP
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
 import javax.swing.BoxLayout;
 
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
	
	public BlackJackEnd(Player players)
	{
	
		
		setSize(450,450);
		setVisible(true);
		setLocationRelativeTo(null);

		pressMe2.addActionListener(this);
		

		//main panel
		add(mainPnl);
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
		mainPnl.add(eastPnl, BorderLayout.EAST);
		
		//west panel
		westPnl.setLayout(new BoxLayout(westPnl, BoxLayout.Y_AXIS));
		westPnl.add(dealer);
		westPnl.add(player1);
		westPnl.add(player2);
		mainPnl.add(westPnl, BorderLayout.WEST);
		
		//center panel
		
		mainPnl.add(centerPnl, BorderLayout.CENTER);
		
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